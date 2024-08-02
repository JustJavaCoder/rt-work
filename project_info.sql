#先删除表
DROP TABLE IF EXISTS project_info;


#创建项目基本信息表
CREATE TABLE project_info (
    id INT AUTO_INCREMENT PRIMARY KEY COMMENT '自增主键',
    project_name VARCHAR(255) NOT NULL COMMENT '项目名称',
    project_amount DECIMAL(15, 2) NOT NULL COMMENT '项目金额',
    project_source int NOT NULL COMMENT '项目来源',
    project_type char NOT NULL COMMENT '项目类型',
    project_level VARCHAR(50) NOT NULL COMMENT '项目级别',
    project_initiation_date DATE NOT NULL COMMENT '立项日期',
    planned_acceptance_date DATE NOT NULL COMMENT '计划验收日期',
    planned_completion_date DATE NOT NULL COMMENT '计划结项日期',
    project_leader VARCHAR(255) NOT NULL COMMENT '项目负责人',
    department VARCHAR(255) NOT NULL COMMENT '所属部门',
    market_leader VARCHAR(255) NOT NULL COMMENT '市场负责人',
    expense_or_capital ENUM('费用化', '资本化') NOT NULL COMMENT '费用化/资本化类型',
    connect_buss_opportunity varchar(255) not null comment '关联商机',
    win_bid_id  int not null comment '中标编号',
    project_summary TEXT COMMENT '项目概述',
    project_attachment VARCHAR(255) COMMENT '项目附件',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
) COMMENT='项目表，包含项目的基本信息、时间信息、负责人信息、财务信息和项目附件等';
