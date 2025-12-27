import React, { useEffect, useState } from 'react';
import { api } from '../services/api';

const Dashboard = () => {
    const [employees, setEmployees] = useState([]);

    useEffect(() => {
        api.get('/employees') // assuming backend endpoint /employees
            .then(res => setEmployees(res.data))
            .catch(err => console.log(err));
    }, []);

    return (
        <div className="p-4">
            <h1 className="text-2xl font-bold mb-4">Payroll Dashboard</h1>
            <table className="table-auto w-full border">
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>Salary</th>
                        <th>Status</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    {employees.map(emp => (
                        <tr key={emp.id}>
                            <td>{emp.name}</td>
                            <td>{emp.salary}</td>
                            <td>{emp.status}</td>
                            <td>
                                {emp.status === 'PENDING' && (
                                    <button 
                                        className="bg-green-500 text-white px-2 py-1 rounded"
                                        onClick={() => api.post(`/payroll/approve/${emp.id}`)}
                                    >Approve</button>
                                )}
                            </td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    );
}

export default Dashboard;
