CREATE TABLE IF NOT EXISTS users (
                                     id SERIAL PRIMARY KEY,
                                     first_name VARCHAR(100),
    second_name VARCHAR(100),
    phone VARCHAR(20),
    email VARCHAR(100)
    );