import { Link } from 'react-router-dom';
import './Header.css';

const Header = () => {
  return (
    <header className="header">
      <div className="header-content">
        <div className="logo">
          <h1>📚 Library Management System</h1>
        </div>
        <nav className="nav">
          <Link to="/" className="nav-link">Dashboard</Link>
          <Link to="/books" className="nav-link">Books</Link>
          <Link to="/members" className="nav-link">Members</Link>
          <Link to="/transactions" className="nav-link">Transactions</Link>
        </nav>
      </div>
    </header>
  );
};

export default Header;
