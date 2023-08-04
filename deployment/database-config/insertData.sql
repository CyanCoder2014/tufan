SET NAMES 'utf8';
SET CHARACTER SET utf8;

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
(`id`, `machine_types_id`, `distance`, `deg_mil`    , `deg_bar`, `deg_bar_b`, `top`,    `cor_dir`,      `cor_dir_w`, `cor_dis_w`, `cor_dis_p`, `cor_dis_air_tem`, `cor_dis_s`, `cor_dis_tem`, `cor_dis_wg`, `cor_dis_mil`,              `dis_deg`, `b`, `deg`, `land_deg`, `speed`, `flight_time`, `err_dis`, `err_h`, `err_dir`, `state`, `created_on`) VALUES
(null, 1 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 , null, 0, null, null, null, null, null),
(null, 1 ,200 ,1 ,null ,null ,null ,0,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null , null, 0.2, null, null, null, null, null),
(null, 1 ,400 ,2 ,null ,null ,null ,0,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null , null, null, null, null, null, null, null),
(null, 1 ,600 ,3 ,null ,null ,null ,0,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null , null, null, null, null, null, null, null),
(null, 1 ,800 ,4 ,null ,null ,null ,0,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null , null, null, null, null, null, null, null),
(null, 1 ,1000 ,6 ,null ,null ,null ,0,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null , null, null, null, null, null, null, null),
(null, 1 ,1200 ,7 ,null ,null ,null ,0,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null , null, null, null, null, null, null, null),
(null, 1 ,1400 ,8 ,null ,null ,null ,0,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null , null, null, null, null, null, null, null),
(null, 1 ,1600 ,9 ,null ,null ,null ,0,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null , null, null, null, null, null, null, null),
(null, 1 ,1800 ,11 ,null ,null ,null ,0,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null , null, null, null, null, null, null, null),
(null, 1 ,2000 ,12 ,null ,null ,null ,0,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null , null, null, null, null, null, null, null),
(null, 1 ,2200 ,13 ,null ,null ,null ,0,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null , null, null, null, null, null, null, null),
(null, 1 ,2400 ,14 ,null ,null ,null ,0,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null , null, null, null, null, null, null, null),
(null, 1 ,2600 ,16 ,null ,null ,null ,0,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null , null, null, null, null, null, null, null),
(null, 1 ,2800 ,17 ,null ,null ,null ,0,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null , null, null, null, null, null, null, null),
(null, 1 ,3000 ,18 ,null ,null ,null ,0,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null , null, null, null, null, null, null, null),
(null, 1 ,3200 ,20 ,null ,null ,null ,0,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null , null, null, null, null, null, null, null),
(null, 1 ,3400 ,21 ,null ,null ,null ,0,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null , null, null, null, null, null, null, null),
(null, 1 ,3600 ,23 ,null ,null ,null ,0,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null , null, null, null, null, null, null, null),
(null, 1 ,3800 ,24 ,null ,null ,null ,1,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null , null, null, null, null, null, null, null),
(null, 1 ,4000 ,26 ,null ,null ,null ,1,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null , null, null, null, null, null, null, null),
(null, 1 ,4200 ,27 ,null ,null ,null ,1,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null , null, null, null, null, null, null, null),
(null, 1 ,4400 ,29 ,null ,null ,null ,1,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null , null, null, null, null, null, null, null),
(null, 1 ,4600 ,30 ,null ,null ,null ,1,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null , null, null, null, null, null, null, null),
(null, 1 ,4800 ,32 ,null ,null ,null ,1,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null , null, null, null, null, null, null, null),
(null, 1 ,5000 ,33 ,null ,null ,null ,1,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null , null, null, null, null, null, null, null),
(null, 1 ,5200 ,35 ,null ,null ,null ,1,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null , null, null, null, null, null, null, null),
(null, 1 ,5400 ,37 ,null ,null ,null ,1,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null , null, null, null, null, null, null, null),
(null, 1 ,5600 ,38 ,null ,null ,null ,1,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null , null, null, null, null, null, null, null),
(null, 1 ,5800 ,40 ,null ,null ,null ,1,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null , null, null, null, null, null, null, null),
(null, 1 ,6000 ,42 ,null ,null ,null ,1,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null , null, null, null, null, null, null, null),
(null, 1 ,6200 ,44 ,null ,null ,null ,1,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null , null, null, null, null, null, null, null),
(null, 1 ,6400 ,46 ,null ,null ,null ,1,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null , null, null, null, null, null, null, null),
(null, 1 ,6600 ,48 ,null ,null ,null ,1,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null , null, null, null, null, null, null, null),
(null, 1 ,6800 ,49 ,null ,null ,null ,1,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null , null, null, null, null, null, null, null),
(null, 1 ,7000 ,51 ,null ,null ,null ,1,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null , null, null, null, null, null, null, null),
(null, 1 ,7200 ,53 ,null ,null ,null ,1,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null , null, null, null, null, null, null, null),
(null, 1 ,7400 ,55 ,null ,null ,null ,1,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null , null, null, null, null, null, null, null),
(null, 1 ,7600 ,58 ,null ,null ,null ,1,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null , null, null, null, null, null, null, null),
(null, 1 ,7800 ,60 ,null ,null ,null ,1,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null , null, null, null, null, null, null, null),
(null, 1 ,8000 ,62 ,null ,null ,null ,2,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null , null, null, null, null, null, null, null),
(null, 1 ,8200 ,64 ,null ,null ,null ,2,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null , null, null, null, null, null, null, null),
(null, 1 ,8400 ,66 ,null ,null ,null ,2,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null , null, null, null, null, null, null, null),
(null, 1 ,8600 ,69 ,null ,null ,null ,2,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null , null, null, null, null, null, null, null),
(null, 1 ,8800 ,71 ,null ,null ,null ,2,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null , null, null, null, null, null, null, null),
(null, 1 ,9000 ,73 ,null ,null ,null ,2,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null , null, null, null, null, null, null, null),
(null, 1 ,9200 ,76 ,null ,null ,null ,2,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null , null, null, null, null, null, null, null),
(null, 1 ,9400 ,78 ,null ,null ,null ,2,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null , null, null, null, null, null, null, null),
(null, 1 ,9600 ,71 ,null ,null ,null ,2,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null , null, null, null, null, null, null, null),
(null, 1 ,9800 ,84 ,null ,null ,null ,2,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null , null, null, null, null, null, null, null),
(null, 1 ,10000 ,86 ,null ,null ,null ,2,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null , null, null, null, null, null, null, null),
(null, 1 ,10200 ,89 ,null ,null ,null ,2,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null , null, null, null, null, null, null, null),
(null, 1 ,10400 ,92 ,null ,null ,null ,2,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null , null, null, null, null, null, null, null),
(null, 1 ,10600 ,95 ,null ,null ,null ,2,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null , null, null, null, null, null, null, null),
(null, 1 ,10800 ,98 ,null ,null ,null ,2,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null , null, null, null, null, null, null, null),
(null, 1 ,11000 ,101 ,null ,null ,null ,2,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null , null, null, null, null, null, null, null),
(null, 1 ,11200 ,104 ,null ,null ,null ,2,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null , null, null, null, null, null, null, null),
(null, 1 ,11400 ,107 ,null ,null ,null ,2,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null , null, null, null, null, null, null, null),
(null, 1 ,11600 ,110 ,null ,null ,null ,3,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null , null, null, null, null, null, null, null),
(null, 1 ,11800 ,113 ,null ,null ,null ,3,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null , null, null, null, null, null, null, null),
(null, 1 ,12000 ,116 ,null ,null ,null ,3,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null , null, null, null, null, null, null, null),
(null, 1 ,12200 ,120 ,null ,null ,null ,3,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null , null, null, null, null, null, null, null),
(null, 1 ,12400 ,123 ,null ,null ,null ,3,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null , null, null, null, null, null, null, null),
(null, 1 ,12600 ,126 ,null ,null ,null ,3,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null , null, null, null, null, null, null, null),
(null, 1 ,12800 ,130 ,null ,null ,null ,3,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null , null, null, null, null, null, null, null),
(null, 1 ,13000 ,133 ,null ,null ,null ,3,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null , null, null, null, null, null, null, null),
(null, 1 ,13200 ,137 ,null ,null ,null ,3,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null , null, null, null, null, null, null, null),
(null, 1 ,13400 ,141 ,null ,null ,null ,3,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null , null, null, null, null, null, null, null),
(null, 1 ,13600 ,145 ,null ,null ,null ,4,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null , null, null, null, null, null, null, null),
(null, 1 ,13800 ,150 ,null ,null ,null ,4,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null , null, null, null, null, null, null, null),
(null, 1 ,14000 ,154 ,null ,null ,null ,4,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null , null, null, null, null, null, null, null),
(null, 1 ,14200 ,159 ,null ,null ,null ,4,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null , null, null, null, null, null, null, null),
(null, 1 ,14400 ,163 ,null ,null ,null ,4,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null , null, null, null, null, null, null, null),
(null, 1 ,14600 ,168 ,null ,null ,null ,4,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null , null, null, null, null, null, null, null),
(null, 1 ,14800 ,173 ,null ,null ,null ,4,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null , null, null, null, null, null, null, null),
(null, 1 ,15000 ,178 ,null ,null ,null ,4,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null , null, null, null, null, null, null, null),
(null, 1 ,15200 ,183 ,null ,null ,null ,5,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null , null, null, null, null, null, null, null),
(null, 1 ,15400 ,188 ,null ,null ,null ,5,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null , null, null, null, null, null, null, null),
(null, 1 ,15600 ,193 ,null ,null ,null ,5,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null , null, null, null, null, null, null, null),
(null, 1 ,15800 ,198 ,null ,null ,null ,5,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null , null, null, null, null, null, null, null),
(null, 1 ,16000 ,203 ,null ,null ,null ,5,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null , null, null, null, null, null, null, null),
(null, 1 ,16200 ,209 ,null ,null ,null ,5,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null , null, null, null, null, null, null, null),
(null, 1 ,16400 ,214 ,null ,null ,null ,5,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null , null, null, null, null, null, null, null),
(null, 1 ,16600 ,220 ,null ,null ,null ,5,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null , null, null, null, null, null, null, null),
(null, 1 ,16800 ,225 ,null ,null ,null ,5,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null , null, null, null, null, null, null, null),
(null, 1 ,17000 ,231 ,null ,null ,null ,5,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null , null, null, null, null, null, null, null),
(null, 1 ,17200 ,237 ,null ,null ,null ,5,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null , null, null, null, null, null, null, null),
(null, 1 ,17400 ,243 ,null ,null ,null ,5,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null , null, null, null, null, null, null, null),
(null, 1 ,17600 ,249 ,null ,null ,null ,5,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null , null, null, null, null, null, null, null),
(null, 1 ,17800 ,255 ,null ,null ,null ,6,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null , null, null, null, null, null, null, null),
(null, 1 ,18000 ,261 ,null ,null ,null ,6,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null , null, null, null, null, null, null, null),
(null, 1 ,18200 ,268 ,null ,null ,null ,6,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null , null, null, null, null, null, null, null),
(null, 1 ,18400 ,274 ,null ,null ,null ,6,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null , null, null, null, null, null, null, null),
(null, 1 ,18600 ,281 ,null ,null ,null ,7,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null , null, null, null, null, null, null, null),
(null, 1 ,18800 ,287 ,null ,null ,null ,7,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null , null, null, null, null, null, null, null),
(null, 1 ,19000 ,294 ,null ,null ,null ,7,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null , null, null, null, null, null, null, null),
(null, 1 ,19200 ,301 ,null ,null ,null ,7,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null , null, null, null, null, null, null, null),
(null, 1 ,19400 ,309 ,null ,null ,null ,7,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null , null, null, null, null, null, null, null),
(null, 1 ,19600 ,316 ,null ,null ,null ,7,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null , null, null, null, null, null, null, null),
(null, 1 ,19800 ,323 ,null ,null ,null ,8,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null , null, null, null, null, null, null, null),
(null, 1 ,20000 ,331 ,null ,null ,null ,8,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null , null, null, null, null, null, null, null),
(null, 1 ,20200 ,338 ,null ,null ,null ,8,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null , null, null, null, null, null, null, null),
(null, 1 ,20400 ,346 ,null ,null ,null ,9,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null , null, null, null, null, null, null, null),
(null, 1 ,20600 ,354 ,null ,null ,null ,9,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null , null, null, null, null, null, null, null),
(null, 1 ,20800 ,362 ,null ,null ,null ,9,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null , null, null, null, null, null, null, null),
(null, 1 ,21000 ,370 ,null ,null ,null ,9,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null , null, null, null, null, null, null, null),
(null, 1 ,21200 ,379 ,null ,null ,null ,10,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null , null, null, null, null, null, null, null),
(null, 1 ,21400 ,387 ,null ,null ,null ,10,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null , null, null, null, null, null, null, null),
(null, 1 ,21600 ,396 ,null ,null ,null ,10,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null , null, null, null, null, null, null, null),
(null, 1 ,21800 ,404 ,null ,null ,null ,11,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null , null, null, null, null, null, null, null),
(null, 1 ,22000 ,413 ,null ,null ,null ,11,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null , null, null, null, null, null, null, null),
(null, 1 ,22200 ,422 ,null ,null ,null ,11,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null , null, null, null, null, null, null, null),
(null, 1 ,22400 ,431 ,null ,null ,null ,11,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null , null, null, null, null, null, null, null),
(null, 1 ,22600 ,441 ,null ,null ,null ,12,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null , null, null, null, null, null, null, null),
(null, 1 ,22800 ,450 ,null ,null ,null ,12,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null , null, null, null, null, null, null, null),
(null, 1 ,23000 ,460 ,null ,null ,null ,13,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null , null, null, null, null, null, null, null),
(null, 1 ,23200 ,470 ,null ,null ,null ,13,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null , null, null, null, null, null, null, null),
(null, 1 ,23400 ,480 ,null ,null ,null ,13,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null , null, null, null, null, null, null, null),
(null, 1 ,23600 ,490 ,null ,null ,null ,13,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null , null, null, null, null, null, null, null),
(null, 1 ,23800 ,500 ,null ,null ,null ,14,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null , null, null, null, null, null, null, null),
(null, 1 ,24000 ,511 ,null ,null ,null ,14,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null , null, null, null, null, null, null, null),
(null, 1 ,24200 ,521 ,null ,null ,null ,14,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null , null, null, null, null, null, null, null),
(null, 1 ,24400 ,532 ,null ,null ,null ,14,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null , null, null, null, null, null, null, null),
(null, 1 ,24600 ,544 ,null ,null ,null ,14,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null , null, null, null, null, null, null, null),
(null, 1 ,24800 ,555 ,null ,null ,null ,15,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null , null, null, null, null, null, null, null),
(null, 1 ,25000 ,567 ,null ,null ,null ,15,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null , null, null, null, null, null, null, null),
(null, 1 ,25200 ,579 ,null ,null ,null ,16,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null , null, null, null, null, null, null, null),
(null, 1 ,25400 ,592 ,null ,null ,null ,16,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null , null, null, null, null, null, null, null),
(null, 1 ,25600 ,605 ,null ,null ,null ,17,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null , null, null, null, null, null, null, null),
(null, 1 ,25800 ,618 ,null ,null ,null ,18,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null , null, null, null, null, null, null, null),
(null, 1 ,26000 ,633 ,null ,null ,null ,18,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null , null, null, null, null, null, null, null),
(null, 1 ,26200 ,648 ,null ,null ,null ,19,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null , null, null, null, null, null, null, null),
(null, 1 ,26400 ,664 ,null ,null ,null ,19,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null , null, null, null, null, null, null, null),
(null, 1 ,26600 ,682 ,null ,null ,null ,20,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null , null, null, null, null, null, null, null),
(null, 1 ,26800 ,702 ,null ,null ,null ,21,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null , null, null, null, null, null, null, null),
(null, 1 ,27000 ,727 ,null ,null ,null ,23,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null , null, null, null, null, null, null, null),
(null, 1 ,27200 ,758 ,null ,null ,null ,24,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null , null, null, null, null, null, null, null),
(null, 1 ,27400 ,803 ,null ,null ,null ,26,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null , null, null, null, null, null, null, null),
(null, 1 ,27490 ,833 ,null ,null ,null ,28,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null , null, null, null, null, null, null, null),
(null, 1 ,27600 ,null ,null ,null ,null ,null,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null , null, null, null, null, null, null, null),
(null, 1 ,30000 ,null ,null ,null ,null ,null,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null ,null , null, null, null, null, null, null, null);