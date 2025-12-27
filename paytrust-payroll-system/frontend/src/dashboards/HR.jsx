import { useEffect,useState } from "react";
import { api } from "../services/api";
import PayrollTable from "../components/PayrollTable";

export default function HR(){
  const [payrolls,setPayrolls]=useState([]);
  const companyId=localStorage.getItem("companyId");

  const approve=id=>api(`/hr/approve/${id}`,"POST").then(load);
  const load=()=>api(`/hr/${companyId}`).then(setPayrolls);

  useEffect(load,[]);

  return (
    <>
      <h2>HR Portal</h2>
      <PayrollTable payrolls={payrolls} approve={approve} refresh={load}/>
    </>
  );
}
