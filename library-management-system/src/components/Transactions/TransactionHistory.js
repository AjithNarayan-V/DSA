import { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import './TransactionHistory.css';

const TransactionHistory = ({ transactions, books, members, onReturn }) => {
  const navigate = useNavigate();
  const [filterStatus, setFilterStatus] = useState('all');
  const [searchTerm, setSearchTerm] = useState('');

  const getTransactionStatus = (transaction) => {
    if (transaction.returnDate) return 'returned';
    const isOverdue = new Date(transaction.dueDate) < new Date();
    return isOverdue ? 'overdue' : 'issued';
  };

  const filteredTransactions = transactions.filter(transaction => {
    const status = getTransactionStatus(transaction);
    const matchesFilter = filterStatus === 'all' || status === filterStatus;
    
    const book = books.find(b => b.id === transaction.bookId);
    const member = members.find(m => m.id === transaction.memberId);
    const matchesSearch = book?.title.toLowerCase().includes(searchTerm.toLowerCase()) ||
                         member?.name.toLowerCase().includes(searchTerm.toLowerCase());
    
    return matchesFilter && matchesSearch;
  });

  const handleReturn = (transactionId) => {
    if (window.confirm('Confirm book return?')) {
      onReturn(transactionId);
    }
  };

  return (
    <div className="transaction-history">
      <div className="list-header">
        <h2>Transaction History</h2>
        <button className="btn-primary" onClick={() => navigate('/transactions/issue')}>
          + Issue Book
        </button>
      </div>

      <div className="filters">
        <input
          type="text"
          placeholder="Search by book title or member name..."
          value={searchTerm}
          onChange={(e) => setSearchTerm(e.target.value)}
          className="search-input"
        />
        <select
          value={filterStatus}
          onChange={(e) => setFilterStatus(e.target.value)}
          className="filter-select"
        >
          <option value="all">All Transactions</option>
          <option value="issued">Currently Issued</option>
          <option value="overdue">Overdue</option>
          <option value="returned">Returned</option>
        </select>
      </div>

      {filteredTransactions.length === 0 ? (
        <div className="no-data">
          <p>No transactions found.</p>
        </div>
      ) : (
        <div className="transactions-table-container">
          <table className="transactions-table">
            <thead>
              <tr>
                <th>Transaction ID</th>
                <th>Member</th>
                <th>Book</th>
                <th>Issue Date</th>
                <th>Due Date</th>
                <th>Return Date</th>
                <th>Status</th>
                <th>Actions</th>
              </tr>
            </thead>
            <tbody>
              {filteredTransactions.map(transaction => {
                const book = books.find(b => b.id === transaction.bookId);
                const member = members.find(m => m.id === transaction.memberId);
                const status = getTransactionStatus(transaction);
                
                return (
                  <tr key={transaction.id}>
                    <td>#{transaction.id}</td>
                    <td>{member?.name || 'Unknown'}</td>
                    <td>{book?.title || 'Unknown'}</td>
                    <td>{new Date(transaction.issueDate).toLocaleDateString()}</td>
                    <td>{new Date(transaction.dueDate).toLocaleDateString()}</td>
                    <td>
                      {transaction.returnDate 
                        ? new Date(transaction.returnDate).toLocaleDateString() 
                        : '-'}
                    </td>
                    <td>
                      <span className={`status ${status}`}>
                        {status === 'returned' ? 'Returned' : 
                         status === 'overdue' ? 'Overdue' : 'Issued'}
                      </span>
                    </td>
                    <td>
                      {!transaction.returnDate && (
                        <button
                          className="btn-return"
                          onClick={() => handleReturn(transaction.id)}
                        >
                          Return
                        </button>
                      )}
                    </td>
                  </tr>
                );
              })}
            </tbody>
          </table>
        </div>
      )}
    </div>
  );
};

export default TransactionHistory;
