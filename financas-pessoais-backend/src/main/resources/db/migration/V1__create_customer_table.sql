CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TYPE user_type_enum as ENUM ('ADMIN', 'PREMIUM', 'USER');
CREATE TYPE user_state_enum as ENUM('ACTIVE', 'INACTIVE', 'BLOCKED');

CREATE TABLE "customer" (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name VARCHAR(45) NOT NULL,
    email VARCHAR(90) UNIQUE NOT NULL,
    password VARCHAR(80) NOT NULL,
    register_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    user_type user_type_enum DEFAULT 'USER',
    user_state user_state_enum DEFAULT 'ACTIVE'
);