INSERT IGNORE INTO tasks (
    id, user_id, activity_id, type, title, status,
    reward_points, reward_label,
    config_duration_seconds, config_claim_delay_seconds, config_jump_url
) VALUES
('task-browse-1', 'user-demo', 'activity-demo', 'BROWSE_JUMP_COUNTDOWN', '浏览跳转页任务', 'AVAILABLE', 15, '15 pts', 10, NULL, 'https://example.com/promo'),
('task-browse-2', 'user-demo', 'activity-demo', 'BROWSE_JUMP_COUNTDOWN', '页面预览任务', 'AVAILABLE', 20, '20 pts', 12, NULL, 'https://example.com/guide'),
('task-bubble-1', 'user-demo', 'activity-demo', 'BUBBLE_SCROLL_COUNTDOWN', '下滑浏览任务', 'AVAILABLE', 10, '10 pts', 8, NULL, NULL),
('task-order-1', 'user-demo', 'activity-demo', 'DIVERSION_ORDER', '导流下单任务', 'AVAILABLE', 30, '30 pts', NULL, NULL, NULL),
('task-claim-1', 'user-demo', 'activity-demo', 'DELAYED_CLAIM', '30分钟领取任务', 'AVAILABLE', 40, '40 pts', NULL, 1800, NULL);
