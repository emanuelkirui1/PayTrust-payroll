import { useState } from "react";
import Login from "./auth/Login";
import CompanyAdmin from "./dashboards/CompanyAdmin";
import HR from "./dashboards/HR";
import Accountant from "./dashboards/Accountant";

export default function App(){
  const [role,setRole]=useState(localStorage.getItem("role"));

  if(!role) return <Login onLogin={setRole} />;

  if(role==="COMPANY_ADMIN") return <CompanyAdmin />;
  if(role==="HR") return <HR />;
  if(role==="ACCOUNTANT") return <Accountant />;

  return <h2>SuperAdmin Dashboard</h2>;
}
