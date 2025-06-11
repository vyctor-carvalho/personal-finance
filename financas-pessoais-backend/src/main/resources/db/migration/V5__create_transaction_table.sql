CREATE TABLE "transaction" (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    description VARCHAR(100),
    value DECIMAL(10, 4) NOT NULL,
    date TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    account_id UUID NOT NULL,
    category_id UUID NOT NULL,
    customer_id UUID NOT NULL,
    CONSTRAINT fk_transaction_account
        FOREIGN KEY (account_id)
        REFERENCES "account" (id)
        ON DELETE CASCADE,
    CONSTRAINT fk_transaction_category
        FOREIGN KEY (category_id)
        REFERENCES "category" (id)
        ON DELETE RESTRICT,
    CONSTRAINT fk_transaction_customer
        FOREIGN KEY (customer_id)
        REFERENCES "customer" (id)
        ON DELETE CASCADE
);