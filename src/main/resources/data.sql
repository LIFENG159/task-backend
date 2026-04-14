INSERT IGNORE INTO tasks (
    id, user_id, activity_id, type, title, status,
    reward_points, reward_label,
    config_duration_seconds, config_claim_delay_seconds
) VALUES
('task-1', 'user-demo', 'activity-demo', 'BROWSE_JUMP_COUNTDOWN', '浏览跳转页', 'AVAILABLE', 20, '20 pts', 10, NULL),
('task-2', 'user-demo', 'activity-demo', 'BUBBLE_SCROLL_COUNTDOWN', '气泡下滑', 'AVAILABLE', 15, '15 pts', 10, NULL),
('task-3', 'user-demo', 'activity-demo', 'DIVERSION_ORDER', '导流下单', 'AVAILABLE', 30, '30 pts', NULL, NULL),
('task-4', 'user-demo', 'activity-demo', 'DELAYED_CLAIM', '倒计时领取', 'AVAILABLE', 40, '40 pts', NULL, 1800);
