CREATE TABLE company (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255),
    active_subscription BOOLEAN,
    plan VARCHAR(50)
);

CREATE TABLE users (
    id BIGSERIAL PRIMARY KEY,
    username VARCHAR(255),
    password VARCHAR(255),
    role VARCHAR(50),
    company_id BIGINT REFERENCES company(id)
);
