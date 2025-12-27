import { useEffect,useState } from "react";
import { api } from "../services/api";
import PayrollTable from "../components/PayrollTable";

export default function Accountant(){
  const [payrolls,setPayrolls]=useState([]);
  const companyId=localStorage.getItem("companyId");

  const pay=id=>api(`/accountant/pay/${id}`,"POST").then(load);
  const load=()=>api(`/accountant/${companyId}`).then(setPayrolls);

  useEffect(load,[]);

  return (
    <>
      <h2>Accountant Portal</h2>
      <PayrollTable payrolls={payrolls} pay={pay} refresh={load}/>
    </>
  );
}
