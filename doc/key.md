web������ô�������������У�
	��WebContentĿ¼���Ƶ� webapps�£�Ȼ��WebContent�ļ������޸�Ϊ������
session:�û��������֮��ĻỰ��
		sessinoID:Ψһ�ģ�32λ16�����������
		void session.setAttribute(key, value);
		Object value = session.getAttribute(key);
		void session.removeAttribute(key);
���·��

����·��


������Ϣ����
	��̨��
		1���û���������վά����Ա��
		2����Ʒ��Ϣά��
		3��������(�����˵������������)
		4����Ʒ��Ϣ�����¼�
		5����Ʒ�����Ϣά��
		6����վ�û���Ϣ�������ڹ��ܣ�
	
	ǰ̨��
		1����ҳ
		2����Ʒ�б�ҳ
		3����Ʒ����ҳ
		4����Ʒ����ҳ
		5��������ҳ
		6�����ﳵ����
		7���ύ����
		8���ջ���ַ����
		9���û�ע�ᣨ������Ϣά����
		10���û���¼
		
		
		
���ݱ���ƣ�
	�û���Ϣ��
		create table sys_user (
  user_id 			int(11) 		not null auto_increment    comment '�û�ID',
  login_name 		varchar(30) 	not null 				   comment '��¼�˺�',
  user_name 		varchar(30) 	not null 				   comment '�û��ǳ�',
  user_type 		varchar(2) 	    default '00' 		       comment '�û����ͣ�00ϵͳ�û���',
  email  			varchar(50) 	default '' 				   comment '�û�����',
  phonenumber  		varchar(11) 	default '' 				   comment '�ֻ�����',
  sex  		        char(1) 	    default '0' 			   comment '�û��Ա�0�� 1Ů 2δ֪��',

  password 			varchar(50) 	default '' 				   comment '����',
  status 			char(1) 		default '0' 			   comment '�ʺ�״̬��0���� 1ͣ�ã�',
  del_flag			char(1) 		default '0' 			   comment 'ɾ����־��0������� 2����ɾ����',
  remark 		    varchar(500) 	default '' 				   comment '��ע',
  primary key (user_id)
) 