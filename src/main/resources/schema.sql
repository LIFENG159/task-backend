CREATE TABLE IF NOT EXISTS tasks (
    id VARCHAR(64) PRIMARY KEY,
    user_id VARCHAR(64) NULL,
    activity_id VARCHAR(64) NULL,
    type VARCHAR(64) NOT NULL,
    title VARCHAR(128) NULL,
    status VARCHAR(64) NOT NULL,
    reward_points INT NULL,
    reward_coupon_id VARCHAR(64) NULL,
    reward_label VARCHAR(64) NULL,
    config_duration_seconds INT NULL,
    config_claim_delay_seconds INT NULL,
    config_jump_url VARCHAR(255) NULL,
    config_bubble_id VARCHAR(64) NULL,
    config_order_channel VARCHAR(64) NULL,
    progress_remaining_seconds INT NULL,
    progress_started_at BIGINT NULL
);

CREATE TABLE IF NOT EXISTS ai_conversations (
    id VARCHAR(64) PRIMARY KEY,
    user_id VARCHAR(64) NULL,
    title VARCHAR(128) NULL,
    created_at BIGINT NOT NULL,
    updated_at BIGINT NOT NULL
);

CREATE TABLE IF NOT EXISTS ai_messages (
    id VARCHAR(64) PRIMARY KEY,
    conversation_id VARCHAR(64) NOT NULL,
    role VARCHAR(32) NOT NULL,
    content TEXT NOT NULL,
    created_at BIGINT NOT NULL
);
