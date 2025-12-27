import { useState } from "react";
import { api } from "../services/api";

export default function Login({ onLogin }) {
  const [username,setUsername]=useState("");
  const [password,setPassword]=useState("");
  const [role,setRole]=useState("COMPANY_ADMIN");

  const login = async () => {
    const res = await api("/auth/login","POST",{username,password,role});
    localStorage.setItem("token",res.token);
    localStorage.setItem("role",res.role);
    localStorage.setItem("companyId",res.companyId);
    onLogin(res.role);
  };

  return (
    <div>
      <h2>Login</h2>
      <select onChange={e=>setRole(e.target.value)}>
        <option value="SUPER_ADMIN">SuperAdmin</option>
        <option value="COMPANY_ADMIN">Company Admin</option>
        <option value="HR">HR</option>
        <option value="ACCOUNTANT">Accountant</option>
      </select>
      <input placeholder="Username" onChange={e=>setUsername(e.target.value)} />
      <input type="password" placeholder="Password" onChange={e=>setPassword(e.target.value)} />
      <button onClick={login}>Login</button>
    </div>
  );
}
