CREATE TYPE category_type_enum AS ENUM ('REVENUE', 'EXPENSE');

CREATE TABLE "category" (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name VARCHAR(20) NOT NULL,
    type category_type_enum NOT NULL,
    customer_id UUID,
    CONSTRAINT fk_category_customer
        FOREIGN KEY (customer_id)
        REFERENCES "customer" (id)
        ON DELETE CASCADE
);