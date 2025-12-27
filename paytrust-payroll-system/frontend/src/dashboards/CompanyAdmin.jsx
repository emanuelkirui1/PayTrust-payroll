import { useEffect,useState } from "react";
import { api } from "../services/api";
import PayrollTable from "../components/PayrollTable";

export default function CompanyAdmin(){
  const [payrolls,setPayrolls]=useState([]);
  const companyId=localStorage.getItem("companyId");

  const load=()=>api(`/company/payrolls/${companyId}`).then(setPayrolls);

  useEffect(load,[]);

  return (
    <>
      <h2>Company Admin</h2>
      <PayrollTable payrolls={payrolls} refresh={load} editable />
    </>
  );
}
