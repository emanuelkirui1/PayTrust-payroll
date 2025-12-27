import React from 'react';
import { BrowserRouter as Router, Routes, Route, Link } from 'react-router-dom';
import Dashboard from './pages/Dashboard';
import HRApproval from './pages/HRApproval';
import AccountantApproval from './pages/AccountantApproval';

function App() {
  return (
    <Router>
      <div className="p-4">
        <nav className="mb-4">
          <Link className="mr-4" to="/">Dashboard</Link>
          <Link className="mr-4" to="/hr">HR Approvals</Link>
          <Link className="mr-4" to="/accountant">Accountant Approvals</Link>
        </nav>
        <Routes>
          <Route path="/" element={<Dashboard />} />
          <Route path="/hr" element={<HRApproval />} />
          <Route path="/accountant" element={<AccountantApproval />} />
        </Routes>
      </div>
    </Router>
  );
}

export default App;
