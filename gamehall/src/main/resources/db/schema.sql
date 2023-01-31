DROP TABLE IF EXISTS `game_hall`;
CREATE TABLE `game_hall`
(
    `id`     INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    `name`   CHAR(100) NOT NULL,
    `start_time` timestamp,
    `end_time`  timestamp
);

DROP TABLE IF EXISTS `game_hall_log`;
CREATE TABLE `game_hall_log`
(
    `id`     INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    `gid`   INTEGER NOT NULL,
    `start_time` timestamp,
    `end_time`  timestamp
);