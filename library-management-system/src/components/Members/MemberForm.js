import { useEffect, useState } from 'react';
import { useNavigate, useParams } from 'react-router-dom';
import './MemberForm.css';

const MemberForm = ({ members, onAdd, onUpdate }) => {
  const navigate = useNavigate();
  const { id } = useParams();
  const isEditMode = Boolean(id);

  const [formData, setFormData] = useState({
    memberId: '',
    name: '',
    email: '',
    phone: '',
    address: '',
    active: true
  });

  const [errors, setErrors] = useState({});

  useEffect(() => {
    if (isEditMode) {
      const member = members.find(m => m.id === parseInt(id));
      if (member) {
        setFormData(member);
      }
    } else {
      // Generate member ID for new members
      const newMemberId = `MEM${String(members.length + 1).padStart(4, '0')}`;
      setFormData(prev => ({ ...prev, memberId: newMemberId }));
    }
  }, [id, members, isEditMode]);

  const handleChange = (e) => {
    const { name, value, type, checked } = e.target;
    setFormData(prev => ({
      ...prev,
      [name]: type === 'checkbox' ? checked : value
    }));
    // Clear error for this field
    if (errors[name]) {
      setErrors(prev => ({ ...prev, [name]: '' }));
    }
  };

  const validate = () => {
    const newErrors = {};

    if (!formData.name.trim()) {
      newErrors.name = 'Name is required';
    }

    if (!formData.email.trim()) {
      newErrors.email = 'Email is required';
    } else if (!/^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(formData.email)) {
      newErrors.email = 'Invalid email format';
    }

    if (!formData.phone.trim()) {
      newErrors.phone = 'Phone is required';
    } else if (!/^[0-9]{10}$/.test(formData.phone.replace(/[\s-]/g, ''))) {
      newErrors.phone = 'Phone must be 10 digits';
    }

    if (!formData.address.trim()) {
      newErrors.address = 'Address is required';
    }

    setErrors(newErrors);
    return Object.keys(newErrors).length === 0;
  };

  const handleSubmit = (e) => {
    e.preventDefault();

    if (!validate()) {
      return;
    }

    const memberData = {
      ...formData,
      joinDate: formData.joinDate || new Date().toISOString()
    };

    if (isEditMode) {
      onUpdate({ ...memberData, id: parseInt(id) });
    } else {
      onAdd(memberData);
    }

    navigate('/members');
  };

  return (
    <div className="member-form-container">
      <div className="form-header">
        <h2>{isEditMode ? 'Edit Member' : 'Add New Member'}</h2>
        <button className="btn-back" onClick={() => navigate('/members')}>
          ← Back to Members
        </button>
      </div>

      <form onSubmit={handleSubmit} className="member-form">
        <div className="form-grid">
          <div className="form-group">
            <label htmlFor="memberId">Member ID</label>
            <input
              type="text"
              id="memberId"
              name="memberId"
              value={formData.memberId}
              readOnly
              disabled
            />
          </div>

          <div className="form-group">
            <label htmlFor="name">Full Name *</label>
            <input
              type="text"
              id="name"
              name="name"
              value={formData.name}
              onChange={handleChange}
              className={errors.name ? 'error' : ''}
            />
            {errors.name && <span className="error-message">{errors.name}</span>}
          </div>

          <div className="form-group">
            <label htmlFor="email">Email *</label>
            <input
              type="email"
              id="email"
              name="email"
              value={formData.email}
              onChange={handleChange}
              className={errors.email ? 'error' : ''}
            />
            {errors.email && <span className="error-message">{errors.email}</span>}
          </div>

          <div className="form-group">
            <label htmlFor="phone">Phone *</label>
            <input
              type="tel"
              id="phone"
              name="phone"
              value={formData.phone}
              onChange={handleChange}
              className={errors.phone ? 'error' : ''}
              placeholder="1234567890"
            />
            {errors.phone && <span className="error-message">{errors.phone}</span>}
          </div>
        </div>

        <div className="form-group full-width">
          <label htmlFor="address">Address *</label>
          <textarea
            id="address"
            name="address"
            value={formData.address}
            onChange={handleChange}
            className={errors.address ? 'error' : ''}
            rows="3"
          />
          {errors.address && <span className="error-message">{errors.address}</span>}
        </div>

        <div className="form-group checkbox-group">
          <label>
            <input
              type="checkbox"
              name="active"
              checked={formData.active}
              onChange={handleChange}
            />
            <span>Active Member</span>
          </label>
        </div>

        <div className="form-actions">
          <button type="button" className="btn-cancel" onClick={() => navigate('/members')}>
            Cancel
          </button>
          <button type="submit" className="btn-submit">
            {isEditMode ? 'Update Member' : 'Add Member'}
          </button>
        </div>
      </form>
    </div>
  );
};

export default MemberForm;
