drop table if exists buss_opportunity ;



#创建关联商机表
CREATE table buss_opportunity (
	id INT AUTO_INCREMENT PRIMARY KEY COMMENT '自增Id',
	bussop_name varchar(255) COMMENT '商机名称',
	client_name varchar(255) COMMENT '客户名称',
	market_manager_name varchar(255) COMMENT '市场负责人名字',
	bussop_status enum('初步接洽','发现商机','完美把握') COMMENT '商机阶段',
	amount decimal(15,2) COMMENT '金额(元)'
)COMMENT = '创建关联商机表';