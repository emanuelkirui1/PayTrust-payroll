CREATE TABLE users (
  id SERIAL PRIMARY KEY,
  username VARCHAR(50) UNIQUE NOT NULL,
  password VARCHAR(255) NOT NULL,
  role VARCHAR(20) NOT NULL
);

CREATE TABLE employees (
  id SERIAL PRIMARY KEY,
  first_name VARCHAR(50),
  last_name VARCHAR(50),
  email VARCHAR(100),
  phone VARCHAR(20),
  position VARCHAR(50)
);

CREATE TABLE payrolls (
  id SERIAL PRIMARY KEY,
  employee_id INT REFERENCES employees(id),
  gross_salary DECIMAL(10,2),
  net_salary DECIMAL(10,2),
  pay_period VARCHAR(20)
);

CREATE TABLE allowances (
  id SERIAL PRIMARY KEY,
  payroll_id INT REFERENCES payrolls(id),
  type VARCHAR(50),
  amount DECIMAL(10,2)
);

CREATE TABLE deductions (
  id SERIAL PRIMARY KEY,
  payroll_id INT REFERENCES payrolls(id),
  type VARCHAR(50),
  amount DECIMAL(10,2)
);

CREATE TABLE payslips (
  id SERIAL PRIMARY KEY,
  payroll_id INT REFERENCES payrolls(id),
  file_path VARCHAR(255)
);

CREATE TABLE audit_logs (
  id SERIAL PRIMARY KEY,
  user_id INT REFERENCES users(id),
  action VARCHAR(255),
  timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
