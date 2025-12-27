import React, { useEffect, useState } from 'react';
import { api } from '../services/api';

const HRApproval = () => {
    const [requests, setRequests] = useState([]);

    useEffect(() => {
        api.get('/payroll/hr-approvals')
            .then(res => setRequests(res.data))
            .catch(err => console.log(err));
    }, []);

    const approve = (id) => {
        api.post(`/payroll/hr-approve/${id}`)
            .then(() => setRequests(requests.filter(r => r.id !== id)))
            .catch(err => console.log(err));
    }

    return (
        <div className="p-4">
            <h1 className="text-2xl font-bold mb-4">HR Approvals</h1>
            {requests.map(r => (
                <div key={r.id} className="mb-2">
                    <span>{r.employeeName} - {r.salary} KES</span>
                    <button className="ml-2 bg-green-500 text-white px-2 rounded" onClick={() => approve(r.id)}>Approve</button>
                </div>
            ))}
        </div>
    );
}

export default HRApproval;
