DROP DATABASE v2ex;
CREATE DATABASE IF NOT EXISTS v2ex;
USE v2ex;

DROP TABLE IF EXISTS `nodes`;
CREATE TABLE `nodes` (
    `node_id` BIGINT NOT NULL,
    `nodename` VARCHAR (20),
    `title` VARCHAR (200),
    `avatar` VARCHAR (100),
    `url` VARCHAR (100),
    `topics` BIGINT COMMENT '该主题下的帖子总数量',
    PRIMARY KEY (`node_id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;

DROP TABLE IF EXISTS `members`;
CREATE TABLE `members` (
    `member_id` BIGINT NOT NULL,
    `username` VARCHAR (30),
    `avatar` VARCHAR (100),
    `url` VARCHAR (100),
    `created` BIGINT,
    PRIMARY KEY (`member_id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;

DROP TABLE IF EXISTS `topics`;
CREATE TABLE `topics` (
    `topic_id` BIGINT NOT NULL,
    `title` VARCHAR (120),
    `content` VARCHAR (20000),
    `member_id` BIGINT,
    `node_id` BIGINT,
    `created_at` BIGINT,
    `last_modified` BIGINT,
    `replies` INT COMMENT '回复数',
    PRIMARY KEY (`topic_id`)
    -- CONSTRAINT fk_topics_memberId FOREIGN KEY (member_id) REFERENCES members(member_id),
    -- CONSTRAINT fk_topics_nodeId FOREIGN KEY (node_id) REFERENCES  nodes(node_id)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;

DROP TABLE IF EXISTS `replies`;
CREATE TABLE `replies` (
    `reply_id` BIGINT NOT NULL,
    `content` VARCHAR (20000),
    `member_id` BIGINT,
    `topic_id` BIGINT,
    `created_at` BIGINT,
    `last_modified` BIGINT,
    `thanks` INT COMMENT '被赞数',
    PRIMARY KEY (`reply_id`)
    -- CONSTRAINT fk_replies_memberId FOREIGN KEY (member_id) REFERENCES members(member_id),
    -- CONSTRAINT fk_replies_topicID FOREIGN KEY (topic_id) REFERENCES topics(topic_id)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;
