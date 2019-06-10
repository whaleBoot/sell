-- auto-generated definition
create table product_info
(
  product_id          varchar(32)                         not null
    primary key,
  product_name        varchar(64)                         not null
  comment '商品名称',
  product_price       decimal(8, 2)                       not null
  comment '单价',
  product_stock       int                                 not null
  comment '库存',
  product_description varchar(64)                         null
  comment '描述',
  product_icon        varchar(512)                        null
  comment '小图',
  product_status      tinyint(3) default '0'              null
  comment '商品状态,0正常1下架',
  category_type       int                                 not null
  comment '类目编号',
  create_time         timestamp default CURRENT_TIMESTAMP not null
  comment '创建时间',
  update_time         timestamp default CURRENT_TIMESTAMP not null
  on update CURRENT_TIMESTAMP
  comment '修改时间'
);



-- auto-generated definition
create table product_category
(
  category_id   int auto_increment
    primary key,
  category_name varchar(64)                         not null
  comment '类目名字',
  category_type int                                 not null
  comment '类目编号',
  create_time   timestamp default CURRENT_TIMESTAMP not null
  comment '创建时间',
  update_time   timestamp default CURRENT_TIMESTAMP not null
  on update CURRENT_TIMESTAMP
  comment '修改时间',
  constraint category_type
  unique (category_type)
);


-- auto-generated definition
create table order_master
(
  order_id      varchar(32)                         not null
    primary key,
  buyer_name    varchar(32)                         not null
  comment '买家名字',
  buyer_phone   varchar(32)                         not null
  comment '买家电话',
  buyer_address varchar(128)                        not null
  comment '买家地址',
  buyer_openid  varchar(64)                         not null
  comment '买家微信openid',
  order_amount  decimal(8, 2)                       not null
  comment '订单总金额',
  order_status  tinyint(3) default '0'              not null
  comment '订单状态, 默认为新下单',
  pay_status    tinyint(3) default '0'              not null
  comment '支付状态, 默认未支付',
  create_time   timestamp default CURRENT_TIMESTAMP not null
  comment '创建时间',
  update_time   timestamp default CURRENT_TIMESTAMP not null
  on update CURRENT_TIMESTAMP
  comment '修改时间'
);

create index idx_buyer_openid
  on order_master (buyer_openid);


-- auto-generated definition
create table order_detail
(
  detail_id        varchar(32)                         not null
    primary key,
  order_id         varchar(32)                         not null,
  product_id       varchar(32)                         not null,
  product_name     varchar(64)                         not null
  comment '商品名称',
  product_price    decimal(8, 2)                       not null
  comment '当前价格,单位分',
  product_quantity int                                 not null
  comment '数量',
  product_icon     varchar(512)                        null
  comment '小图',
  create_time      timestamp default CURRENT_TIMESTAMP not null
  comment '创建时间',
  update_time      timestamp default CURRENT_TIMESTAMP not null
  on update CURRENT_TIMESTAMP
  comment '修改时间'
);

create index idx_order_id
  on order_detail (order_id);



-- auto-generated definition
create table seller_info
(
  id          varchar(32)                         not null
    primary key,
  username    varchar(32)                         not null,
  password    varchar(64)                         not null,
  openid      varchar(64)                         not null
  comment '微信openid',
  create_time timestamp default CURRENT_TIMESTAMP not null
  comment '创建时间',
  update_time timestamp default CURRENT_TIMESTAMP not null
  on update CURRENT_TIMESTAMP
  comment '修改时间'
)
  comment '卖家信息表';

