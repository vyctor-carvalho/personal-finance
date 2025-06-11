CREATE TYPE account_type_enum as ENUM ('CURRENT', 'SAVINGS', 'SALARY');

CREATE TABLE "account" (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    bank_name VARCHAR(30) NOT NULL,
    initial_balance DECIMAL(10, 4) NOT NULL,
    account_type account_type_enum DEFAULT 'CURRENT',
    customer_id UUID NOT NULL,
    CONSTRAINT fk_account_customer
        FOREIGN KEY (customer_id)
        REFERENCES "customer" (id)
        ON DELETE CASCADE
);