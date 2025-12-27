import { useState } from "react";
import { api } from "../services/api";

export default function PayrollTable({ payrolls, refresh, editable, approve, pay }) {
  const [edit,setEdit]=useState(null);
  const [form,setForm]=useState({});

  const calcNet = () => {
    const daily=form.basicSalary/30||0;
    return (
      (form.basicSalary||0) +
      (form.allowances||0) -
      (form.deductions||0) -
      daily*(form.unpaidLeaveDays||0)
    ).toFixed(2);
  };

  const save = async (id) => {
    await api(`/company/payrolls/${id}`,"PUT",{...form,netPay:calcNet()});
    setEdit(null);
    refresh();
  };

  return (
    <table border="1">
      <thead>
        <tr>
          <th>Employee</th><th>Basic</th><th>Allow</th><th>Deduct</th>
          <th>Paid</th><th>Unpaid</th><th>Net</th><th>Actions</th>
        </tr>
      </thead>
      <tbody>
        {payrolls.map(p=>(
          <tr key={p.id}>
            <td>{p.employee.firstName}</td>
            {edit===p.id?(
              <>
                <td><input onChange={e=>setForm({...form,basicSalary:+e.target.value})} /></td>
                <td><input onChange={e=>setForm({...form,allowances:+e.target.value})} /></td>
                <td><input onChange={e=>setForm({...form,deductions:+e.target.value})} /></td>
                <td><input onChange={e=>setForm({...form,paidLeaveDays:+e.target.value})} /></td>
                <td><input onChange={e=>setForm({...form,unpaidLeaveDays:+e.target.value})} /></td>
                <td>{calcNet()}</td>
                <td><button onClick={()=>save(p.id)}>Save</button></td>
              </>
            ):(
              <>
                <td>{p.basicSalary}</td>
                <td>{p.allowances}</td>
                <td>{p.deductions}</td>
                <td>{p.paidLeaveDays}</td>
                <td>{p.unpaidLeaveDays}</td>
                <td>{p.netPay}</td>
                <td>
                  {editable && <button onClick={()=>{setEdit(p.id);setForm(p)}}>Edit</button>}
                  {approve && <button onClick={()=>approve(p.id)}>Approve</button>}
                  {pay && <button onClick={()=>pay(p.id)}>Pay</button>}
                </td>
              </>
            )}
          </tr>
        ))}
      </tbody>
    </table>
  );
}
