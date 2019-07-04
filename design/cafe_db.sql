-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- 생성 시간: 19-07-04 00:33
-- 서버 버전: 5.7.23
-- PHP 버전: 7.1.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- 데이터베이스: `cafe_db`
--

-- --------------------------------------------------------

--
-- 테이블 구조 `tbm_filter`
--

CREATE TABLE `tbm_filter` (
  `id` int(11) NOT NULL,
  `fi_num` varchar(45) NOT NULL,
  `fi_mood` varchar(45) NOT NULL,
  `fi_combination` tinyint(4) DEFAULT NULL,
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 테이블 구조 `tb_activity`
--

CREATE TABLE `tb_activity` (
  `ac_id` int(11) NOT NULL,
  `com_id` int(11) NOT NULL,
  `rp_id` int(11) NOT NULL,
  `ac_subject` varchar(45) NOT NULL,
  `ac_object` varchar(45) NOT NULL,
  `ac_created_at` datetime DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 테이블 구조 `tb_ceo`
--

CREATE TABLE `tb_ceo` (
  `ceo_id` int(11) NOT NULL,
  `ceo_email` varchar(45) NOT NULL,
  `ceo_password` varchar(45) NOT NULL,
  `ceo_birth` datetime NOT NULL,
  `ceo_phone` varchar(45) NOT NULL,
  `ceo_license` varchar(45) DEFAULT NULL,
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 테이블 구조 `tb_community`
--

CREATE TABLE `tb_community` (
  `com_id` int(11) NOT NULL,
  `st_id` int(11) NOT NULL,
  `id` int(11) NOT NULL,
  `com_img` varchar(512) NOT NULL,
  `com_content` varchar(512) NOT NULL,
  `com_tag` varchar(45) DEFAULT NULL,
  `com_created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 테이블 구조 `tb_good`
--

CREATE TABLE `tb_good` (
  `id` int(11) NOT NULL,
  `com_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 테이블 구조 `tb_inform`
--

CREATE TABLE `tb_inform` (
  `in_id` int(11) NOT NULL,
  `in_title` varchar(45) NOT NULL,
  `in_content` longtext NOT NULL,
  `in_created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 테이블 구조 `tb_member`
--

CREATE TABLE `tb_member` (
  `id` int(11) NOT NULL,
  `email_id` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `birth` date NOT NULL,
  `phone` varchar(45) NOT NULL,
  `point` int(11) DEFAULT '1000',
  `following` varchar(512) DEFAULT NULL,
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 테이블의 덤프 데이터 `tb_member`
--

INSERT INTO `tb_member` (`id`, `email_id`, `password`, `birth`, `phone`, `point`, `following`, `created_at`, `updated_at`) VALUES
(1, 'skadlfwlgusz@naver.com', '1234', '2001-01-11', '01087892942', 1000, '0', '2019-07-03 18:52:54', '2019-07-03 18:52:54'),
(2, 'wool@naver.com', '1212', '1999-01-11', '01012345454', 1000, '0', '2019-07-03 18:54:28', '2019-07-03 18:54:28');

-- --------------------------------------------------------

--
-- 테이블 구조 `tb_menu`
--

CREATE TABLE `tb_menu` (
  `me_id` int(11) NOT NULL,
  `st_id` int(11) NOT NULL,
  `me_name` varchar(45) NOT NULL,
  `me_price` int(11) NOT NULL,
  `me_img` varchar(512) NOT NULL,
  `me_temper` tinyint(4) NOT NULL,
  `me_shot` tinyint(4) NOT NULL,
  `me_whip` tinyint(4) NOT NULL,
  `me_syrup` tinyint(4) NOT NULL,
  `me_create_at` datetime DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 테이블 구조 `tb_order`
--

CREATE TABLE `tb_order` (
  `or_id` int(11) NOT NULL,
  `me_id` varchar(20) NOT NULL,
  `id` int(11) NOT NULL,
  `st_name` varchar(45) NOT NULL,
  `or_sumprice` int(11) NOT NULL,
  `or_quntity` int(11) NOT NULL,
  `or_situation` varchar(45) NOT NULL,
  `or_temper` int(11) NOT NULL,
  `or_cup` int(11) NOT NULL,
  `or_shot` int(11) NOT NULL,
  `or_whip` int(11) NOT NULL,
  `or_syrup` int(11) NOT NULL,
  `or_createdAt` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 테이블 구조 `tb_reply`
--

CREATE TABLE `tb_reply` (
  `rp_id` int(11) NOT NULL,
  `id` int(11) NOT NULL,
  `com_id` int(11) NOT NULL,
  `rp_content` varchar(512) NOT NULL,
  `rp_depth` int(11) NOT NULL,
  `rp_sort` int(11) NOT NULL,
  `rp_created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 테이블 구조 `tb_review`
--

CREATE TABLE `tb_review` (
  `rv_id` int(11) NOT NULL,
  `id` int(11) NOT NULL,
  `st_id` int(11) NOT NULL,
  `rv_content` varchar(100) NOT NULL,
  `rv_star` int(11) NOT NULL,
  `rv_created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 테이블 구조 `tb_store`
--

CREATE TABLE `tb_store` (
  `st_id` int(11) NOT NULL,
  `ceo_id` int(11) DEFAULT NULL,
  `st_name` varchar(45) NOT NULL,
  `st_pic` varchar(512) NOT NULL,
  `st_inform` varchar(128) NOT NULL,
  `st_place` varchar(512) NOT NULL,
  `st_latlng` varchar(128) NOT NULL,
  `st_post` text NOT NULL,
  `st_mood` int(11) DEFAULT NULL,
  `st_zone` varchar(256) DEFAULT NULL,
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 테이블 구조 `tb_tag`
--

CREATE TABLE `tb_tag` (
  `tag_id` int(11) NOT NULL,
  `tag_content` varchar(45) NOT NULL,
  `tag_count` int(11) NOT NULL,
  `tag_created_at` datetime DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 덤프된 테이블의 인덱스
--

--
-- 테이블의 인덱스 `tbm_filter`
--
ALTER TABLE `tbm_filter`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `fi_num_UNIQUE` (`fi_num`);

--
-- 테이블의 인덱스 `tb_activity`
--
ALTER TABLE `tb_activity`
  ADD PRIMARY KEY (`ac_id`);

--
-- 테이블의 인덱스 `tb_ceo`
--
ALTER TABLE `tb_ceo`
  ADD PRIMARY KEY (`ceo_id`),
  ADD UNIQUE KEY `ceo_email_UNIQUE` (`ceo_email`);

--
-- 테이블의 인덱스 `tb_community`
--
ALTER TABLE `tb_community`
  ADD PRIMARY KEY (`com_id`);

--
-- 테이블의 인덱스 `tb_inform`
--
ALTER TABLE `tb_inform`
  ADD PRIMARY KEY (`in_id`);

--
-- 테이블의 인덱스 `tb_member`
--
ALTER TABLE `tb_member`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email_id_UNIQUE` (`email_id`);

--
-- 테이블의 인덱스 `tb_menu`
--
ALTER TABLE `tb_menu`
  ADD PRIMARY KEY (`me_id`);

--
-- 테이블의 인덱스 `tb_order`
--
ALTER TABLE `tb_order`
  ADD PRIMARY KEY (`or_id`);

--
-- 테이블의 인덱스 `tb_reply`
--
ALTER TABLE `tb_reply`
  ADD PRIMARY KEY (`rp_id`);

--
-- 테이블의 인덱스 `tb_review`
--
ALTER TABLE `tb_review`
  ADD PRIMARY KEY (`rv_id`);

--
-- 테이블의 인덱스 `tb_store`
--
ALTER TABLE `tb_store`
  ADD PRIMARY KEY (`st_id`);

--
-- 테이블의 인덱스 `tb_tag`
--
ALTER TABLE `tb_tag`
  ADD PRIMARY KEY (`tag_id`);

--
-- 덤프된 테이블의 AUTO_INCREMENT
--

--
-- 테이블의 AUTO_INCREMENT `tbm_filter`
--
ALTER TABLE `tbm_filter`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- 테이블의 AUTO_INCREMENT `tb_ceo`
--
ALTER TABLE `tb_ceo`
  MODIFY `ceo_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- 테이블의 AUTO_INCREMENT `tb_member`
--
ALTER TABLE `tb_member`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- 테이블의 AUTO_INCREMENT `tb_store`
--
ALTER TABLE `tb_store`
  MODIFY `st_id` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
