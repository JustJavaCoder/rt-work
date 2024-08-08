#若有先删除
drop table if exists manager_info;


#创建项目负责人和市场负责人表

create table manager_info(
id int auto_increment  primary key  comment '自增主键',
name varchar(255) comment '管理人员姓名',
create_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
update_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
)COMMENT= '创建项目负责人和市场负责人表';
