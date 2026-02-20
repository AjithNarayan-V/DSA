import { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import './IssueBook.css';

const IssueBook = ({ books, members, onIssue }) => {
  const navigate = useNavigate();
  const [formData, setFormData] = useState({
    bookId: '',
    memberId: '',
    issueDate: new Date().toISOString().split('T')[0],
    dueDate: ''
  });
  const [errors, setErrors] = useState({});

  // Calculate due date (14 days from issue date)
  const calculateDueDate = (issueDate) => {
    const date = new Date(issueDate);
    date.setDate(date.getDate() + 14);
    return date.toISOString().split('T')[0];
  };

  const handleChange = (e) => {
    const { name, value } = e.target;
    let newFormData = { ...formData, [name]: value };
    
    if (name === 'issueDate') {
      newFormData.dueDate = calculateDueDate(value);
    }
    
    setFormData(newFormData);
    if (errors[name]) {
      setErrors(prev => ({ ...prev, [name]: '' }));
    }
  };

  const validate = () => {
    const newErrors = {};

    if (!formData.bookId) {
      newErrors.bookId = 'Please select a book';
    } else {
      const book = books.find(b => b.id === parseInt(formData.bookId));
      if (!book || !book.available) {
        newErrors.bookId = 'Selected book is not available';
      }
    }

    if (!formData.memberId) {
      newErrors.memberId = 'Please select a member';
    } else {
      const member = members.find(m => m.id === parseInt(formData.memberId));
      if (!member || !member.active) {
        newErrors.memberId = 'Selected member is not active';
      }
    }

    if (!formData.issueDate) {
      newErrors.issueDate = 'Issue date is required';
    }

    setErrors(newErrors);
    return Object.keys(newErrors).length === 0;
  };

  const handleSubmit = (e) => {
    e.preventDefault();

    if (!validate()) {
      return;
    }

    onIssue({
      bookId: parseInt(formData.bookId),
      memberId: parseInt(formData.memberId),
      issueDate: formData.issueDate,
      dueDate: formData.dueDate
    });

    navigate('/transactions');
  };

  const availableBooks = books.filter(book => book.available);
  const activeMembers = members.filter(member => member.active);

  return (
    <div className="issue-book-container">
      <div className="form-header">
        <h2>Issue Book</h2>
        <button className="btn-back" onClick={() => navigate('/transactions')}>
          ← Back to Transactions
        </button>
      </div>

      <form onSubmit={handleSubmit} className="issue-form">
        <div className="form-group">
          <label htmlFor="bookId">Select Book *</label>
          <select
            id="bookId"
            name="bookId"
            value={formData.bookId}
            onChange={handleChange}
            className={errors.bookId ? 'error' : ''}
          >
            <option value="">-- Select a Book --</option>
            {availableBooks.map(book => (
              <option key={book.id} value={book.id}>
                {book.title} - {book.author} (ISBN: {book.isbn})
              </option>
            ))}
          </select>
          {errors.bookId && <span className="error-message">{errors.bookId}</span>}
        </div>

        <div className="form-group">
          <label htmlFor="memberId">Select Member *</label>
          <select
            id="memberId"
            name="memberId"
            value={formData.memberId}
            onChange={handleChange}
            className={errors.memberId ? 'error' : ''}
          >
            <option value="">-- Select a Member --</option>
            {activeMembers.map(member => (
              <option key={member.id} value={member.id}>
                {member.name} ({member.memberId})
              </option>
            ))}
          </select>
          {errors.memberId && <span className="error-message">{errors.memberId}</span>}
        </div>

        <div className="form-row">
          <div className="form-group">
            <label htmlFor="issueDate">Issue Date *</label>
            <input
              type="date"
              id="issueDate"
              name="issueDate"
              value={formData.issueDate}
              onChange={handleChange}
              className={errors.issueDate ? 'error' : ''}
            />
            {errors.issueDate && <span className="error-message">{errors.issueDate}</span>}
          </div>

          <div className="form-group">
            <label htmlFor="dueDate">Due Date</label>
            <input
              type="date"
              id="dueDate"
              name="dueDate"
              value={formData.dueDate}
              readOnly
              disabled
            />
            <small>Automatically set to 14 days from issue date</small>
          </div>
        </div>

        <div className="form-actions">
          <button type="button" className="btn-cancel" onClick={() => navigate('/transactions')}>
            Cancel
          </button>
          <button type="submit" className="btn-submit">
            Issue Book
          </button>
        </div>
      </form>
    </div>
  );
};

export default IssueBook;
