CREATE TABLE tasks (
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
