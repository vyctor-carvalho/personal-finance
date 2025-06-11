-- V6__insert_initial_data.sql

DO $$
DECLARE
    admin_uuid UUID := '79e696f7-2c4c-4fdf-beee-991ff3716554';
BEGIN
    INSERT INTO "customer" (
        id,
        name,
        email,
        password,
        user_type,
        user_state
    ) VALUES (
        admin_uuid,
        'Admin User',
        'admin@financas.com',
        '$2a$10$HASHED_ADMIN_PASSWORD_HERE',
        'ADMIN',
        'ACTIVE'
    );

    INSERT INTO "category" (name, type, customer_id) VALUES
    ('Salário', 'REVENUE', NULL),
    ('Investimentos', 'REVENUE', NULL),
    ('Outras Receitas', 'REVENUE', NULL),
    ('Alimentação', 'EXPENSE', NULL),
    ('Moradia', 'EXPENSE', NULL),
    ('Transporte', 'EXPENSE', NULL),
    ('Saúde', 'EXPENSE', NULL),
    ('Educação', 'EXPENSE', NULL),
    ('Lazer', 'EXPENSE', NULL),
    ('Contas', 'EXPENSE', NULL),
    ('Compras', 'EXPENSE', NULL),
    ('Outras Despesas', 'EXPENSE', NULL);

END $$;