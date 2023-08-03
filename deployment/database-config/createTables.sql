SET NAMES 'utf8';
SET CHARACTER SET utf8;

mysqli_set_charset($this->connect,'utf8');

CREATE TABLE if not exists `users` (
    id INT(11) NOT NULL AUTO_INCREMENT,
    username varchar(255) NOT NULL,
    name varchar(255) NULL DEFAULT NULL,
    email varchar(255) NULL DEFAULT NULL,
    password varchar(255) NULL DEFAULT NULL,

    state INT(11) UNSIGNED NULL DEFAULT NULL,
    created_on timestamp NULL DEFAULT NULL,
    CONSTRAINT id PRIMARY KEY (id)
) DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


CREATE TABLE if not exists `operations` (
    id INT(11) NOT NULL AUTO_INCREMENT,
    name varchar(255) NOT NULL,
    map_name varchar(255) NULL DEFAULT NULL,
    map_url varchar(255) NULL DEFAULT NULL,
    note varchar(255) NULL DEFAULT NULL,

    state INT(11) UNSIGNED NULL DEFAULT NULL,
    created_on timestamp NULL DEFAULT NULL,
    CONSTRAINT id PRIMARY KEY (id)
) DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


CREATE TABLE if not exists `fire_loads` (
    id INT(11) NOT NULL AUTO_INCREMENT,
    operation_id INT(11) UNSIGNED NOT NULL,

    name varchar(255) NOT NULL,
    originX varchar(255) NULL DEFAULT NULL,
    originY varchar(255) NULL DEFAULT NULL,
    targetX varchar(255) NULL DEFAULT NULL,
    targetY varchar(255) NULL DEFAULT NULL,
    machine_id INT(11) UNSIGNED NULL DEFAULT NULL,
    machine_name varchar(255) NULL DEFAULT NULL,
    machine_type varchar(255) NULL DEFAULT NULL,

    state INT(11) UNSIGNED NULL DEFAULT NULL,
    created_on timestamp NULL DEFAULT NULL,
    CONSTRAINT id PRIMARY KEY (id)
) DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


CREATE TABLE if not exists `machines` (
    id INT(11) NOT NULL AUTO_INCREMENT,
    name varchar(255) NULL DEFAULT NULL,
    title varchar(255) NULL DEFAULT NULL,
    note varchar(255) NULL DEFAULT NULL,

    state INT(11) UNSIGNED NULL DEFAULT NULL,
    created_on timestamp NULL DEFAULT NULL,
    CONSTRAINT id PRIMARY KEY (id)
) DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


CREATE TABLE if not exists `machine_types` (
    id INT(11) NOT NULL AUTO_INCREMENT,
    machine_id INT(11) UNSIGNED NOT NULL,

    name varchar(255) NULL DEFAULT NULL,

    state INT(11) UNSIGNED NULL DEFAULT NULL,
    created_on timestamp NULL DEFAULT NULL,
    CONSTRAINT id PRIMARY KEY (id)
) DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


CREATE TABLE if not exists `machine_details` (
    id INT(11) NOT NULL AUTO_INCREMENT,
    machine_types_id INT(11) UNSIGNED NOT NULL,

    distance INT(11) UNSIGNED NOT NULL,

    deg_mil DOUBLE NULL DEFAULT NULL,
    deg_bar DOUBLE NULL DEFAULT NULL,
    deg_bar_b DOUBLE UNSIGNED NULL DEFAULT NULL,

    top INT(11) UNSIGNED NULL DEFAULT NULL,

    cor_dir INT(11) NULL DEFAULT NULL,
    cor_dir_w INT(11) NULL DEFAULT NULL,

    cor_dis_w INT(11) NULL DEFAULT NULL,

    cor_dis_p INT(11) NULL DEFAULT NULL,
    cor_dis_air_tem INT(11) NULL DEFAULT NULL,
    cor_dis_s INT(11) NULL DEFAULT NULL,
    cor_dis_tem INT(11) NULL DEFAULT NULL,
    cor_dis_wg INT(11) NULL DEFAULT NULL,

    cor_dis_mil INT(11) NULL DEFAULT NULL,

    dis_deg INT(11) UNSIGNED NULL DEFAULT NULL,
    b INT(11) UNSIGNED NULL DEFAULT NULL,
    deg INT(11) UNSIGNED NULL DEFAULT NULL,
    land_deg DOUBLE NULL DEFAULT NULL,
    speed INT(11) UNSIGNED NULL DEFAULT NULL,
    flight_time INT(11) UNSIGNED NULL DEFAULT NULL,
    err_dis INT(11) UNSIGNED NULL DEFAULT NULL,
    err_h INT(11) UNSIGNED NULL DEFAULT NULL,
    err_dir DOUBLE NULL DEFAULT NULL,

    state INT(11) UNSIGNED NULL DEFAULT NULL,
    created_on timestamp NULL DEFAULT NULL,
    CONSTRAINT id PRIMARY KEY (id)
) DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;



ALTER TABLE `fire_loads`
  ADD KEY if not exists `fire_loads_operation_id_index` (`operation_id`),
  ADD KEY if not exists `fire_loads_machine_id_index` (`machine_id`);


ALTER TABLE `machine_types`
  ADD KEY if not exists `machine_details_machine_id_index` (`machine_id`);


ALTER TABLE `machine_details`
  ADD KEY if not exists `machine_details_machine_types_id_index` (`machine_types_id`);


  