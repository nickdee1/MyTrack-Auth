CREATE EXTENSION pgcrypto;

CREATE TABLE users(
	id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
	username VARCHAR(32),
	password VARCHAR(512)
);

CREATE TABLE refresh_tokens(
	refresh_token VARCHAR(128) PRIMARY KEY,
	date_issued timestamp,
	user_id UUID,
	CONSTRAINT fk_user FOREIGN KEY(user_id) REFERENCES users(id) ON DELETE CASCADE
);

CREATE TABLE access_tokens(
	access_token VARCHAR(128) PRIMARY KEY,
	date_issued timestamp,
	refresh_token VARCHAR(128),
	user_id UUID,
	CONSTRAINT fk_refresh FOREIGN KEY(refresh_token) REFERENCES refresh_tokens(refresh_token) ON DELETE CASCADE,
	CONSTRAINT fk_user FOREIGN KEY(user_id) REFERENCES users(id) ON DELETE CASCADE
)
