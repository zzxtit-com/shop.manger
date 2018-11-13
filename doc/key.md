web工程怎么发布到服务器中：
	将WebContent目录复制到 webapps下，然后将WebContent文件名称修改为工程名
session:用户与服务器之间的会话，
		sessinoID:唯一的，32位16进制数字组成
		void session.setAttribute(key, value);
		Object value = session.getAttribute(key);
		void session.removeAttribute(key);
相对路径

绝对路径


电商信息管理：
	后台：
		1、用户（电商网站维护人员）
		2、商品信息维护
		3、处理订单(订单退单、发货、完毕)
		4、商品信息的上下架
		5、商品类别信息维护
		6、网站用户信息管理（拉黑功能）
	
	前台：
		1、首页
		2、商品列表页
		3、商品搜索页
		4、商品详情页
		5、个人主页
		6、购物车管理
		7、提交订单
		8、收货地址管理
		9、用户注册（个人信息维护）
		10、用户登录
		
		
		
数据表设计：
	用户信息：
		create table sys_user (
  user_id 			int(11) 		not null auto_increment    comment '用户ID',
  login_name 		varchar(30) 	not null 				   comment '登录账号',
  user_name 		varchar(30) 	not null 				   comment '用户昵称',
  user_type 		varchar(2) 	    default '00' 		       comment '用户类型（00系统用户）',
  email  			varchar(50) 	default '' 				   comment '用户邮箱',
  phonenumber  		varchar(11) 	default '' 				   comment '手机号码',
  sex  		        char(1) 	    default '0' 			   comment '用户性别（0男 1女 2未知）',

  password 			varchar(50) 	default '' 				   comment '密码',
  status 			char(1) 		default '0' 			   comment '帐号状态（0正常 1停用）',
  del_flag			char(1) 		default '0' 			   comment '删除标志（0代表存在 2代表删除）',
  remark 		    varchar(500) 	default '' 				   comment '备注',
  primary key (user_id)
) 