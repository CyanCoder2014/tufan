INSERT IGNORE INTO `users`
(`id`, `username`, `name`, `email`, `password`, `state`, `created_on`) VALUES
(1, 'admin', null, null, null, 1, null);

INSERT IGNORE INTO `users`
(`id`, `username`, `name`, `email`, `password`, `state`, `created_on`) VALUES
(2, 'maghsoud', 'mohamad maghsoud', 'msmaghsoud@ut.ac.ir', null, 1, null);



INSERT IGNORE INTO `machines`
(`id`, `name`, `title`, `note`, `state`, `created_on`) VALUES
(1, 't-130mm', 'توپ ۱۳۰ م.م', null, null, null);

INSERT IGNORE INTO `machine_types`
(`id`, `machine_id`, `name`, `state`, `created_on`) VALUES
(1, 1, 'خرج کامل', null, null);


INSERT IGNORE INTO `machine_details`
(`id`, `machine_types_id`, `distance`, `deg_mil`, `deg_bar`, `deg_bar_b`, `top`,          `cor_dir`, `cor_dir_w`, `cor_dis_w`, `cor_dis_p`, `cor_dis_air_tem`, `cor_dis_s`, `cor_dis_tem`, `cor_dis_wg`, `cor_dis_mil`,              `dis_deg`, `b`, `deg`, `land_deg`, `speed`, `flight_time`, `err_dis`, `err_h`, `err_dir`, `state`, `created_on`) VALUES
(1, 1 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,1 , null, 1, null, null, null, null, null),
(2, 1 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,1 , null, 1, null, null, null, null, null);