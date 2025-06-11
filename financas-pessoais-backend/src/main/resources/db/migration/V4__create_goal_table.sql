CREATE TABLE "goal" (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    title VARCHAR(40) NOT NULL,
    description VARCHAR(100),
    goal_value DECIMAL(10, 4) NOT NULL,
    current_value DECIMAL(10, 4) NOT NULL,
    due_date TIMESTAMP NOT NULL,
    customer_id UUID NOT NULL,
    CONSTRAINT fk_goal_customer
        FOREIGN KEY (customer_id)
        REFERENCES "customer" (id)
        ON DELETE CASCADE
);
