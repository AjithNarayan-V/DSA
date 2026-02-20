import { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import './MemberList.css';

const MemberList = ({ members, onDelete }) => {
  const navigate = useNavigate();
  const [searchTerm, setSearchTerm] = useState('');

  const filteredMembers = members.filter(member => {
    const search = searchTerm.toLowerCase();
    return member.name.toLowerCase().includes(search) ||
           member.email.toLowerCase().includes(search) ||
           member.memberId.toLowerCase().includes(search);
  });

  return (
    <div className="member-list">
      <div className="list-header">
        <h2>Members</h2>
        <button className="btn-primary" onClick={() => navigate('/members/add')}>
          + Add New Member
        </button>
      </div>

      <div className="filters">
        <input
          type="text"
          placeholder="Search by name, email, or member ID..."
          value={searchTerm}
          onChange={(e) => setSearchTerm(e.target.value)}
          className="search-input"
        />
      </div>

      {filteredMembers.length === 0 ? (
        <div className="no-data">
          <p>No members found. Add your first member!</p>
        </div>
      ) : (
        <div className="members-table-container">
          <table className="members-table">
            <thead>
              <tr>
                <th>Member ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Phone</th>
                <th>Join Date</th>
                <th>Status</th>
                <th>Actions</th>
              </tr>
            </thead>
            <tbody>
              {filteredMembers.map(member => (
                <tr key={member.id}>
                  <td>{member.memberId}</td>
                  <td>{member.name}</td>
                  <td>{member.email}</td>
                  <td>{member.phone}</td>
                  <td>{new Date(member.joinDate).toLocaleDateString()}</td>
                  <td>
                    <span className={`status ${member.active ? 'active' : 'inactive'}`}>
                      {member.active ? 'Active' : 'Inactive'}
                    </span>
                  </td>
                  <td>
                    <div className="action-buttons">
                      <button
                        className="btn-edit"
                        onClick={() => navigate(`/members/edit/${member.id}`)}
                      >
                        Edit
                      </button>
                      <button
                        className="btn-delete"
                        onClick={() => {
                          if (window.confirm('Are you sure you want to delete this member?')) {
                            onDelete(member.id);
                          }
                        }}
                      >
                        Delete
                      </button>
                    </div>
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      )}
    </div>
  );
};

export default MemberList;
