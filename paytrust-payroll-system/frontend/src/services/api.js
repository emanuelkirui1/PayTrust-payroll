const API_URL = "http://localhost:8080/api";

export const api = async (endpoint, method="GET", body=null) => {
  const token = localStorage.getItem("token");
  const headers = {
    "Content-Type": "application/json",
    Authorization: token ? `Bearer ${token}` : ""
  };

  const res = await fetch(API_URL + endpoint, {
    method,
    headers,
    body: body ? JSON.stringify(body) : null
  });

  if (!res.ok) throw new Error("API error");
  return res.json();
};
