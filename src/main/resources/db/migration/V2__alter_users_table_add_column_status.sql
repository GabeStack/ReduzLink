ALTER TABLE users ADD COLUMN status BOOLEAN;

UPDATE users SET status = TRUE;
