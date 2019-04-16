package dq_jdbc_final;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import dq_jdbc_final.phonebook;
import dq_jdbc_final.DAOaction;

public class view {
		private static final String context=" "
				+"��ӭ����dq�ĵ绰��"+"\n"+
				"��������"+"\n"+
				"[ADD]����һλ��ϵ����Ϣ\n"+
				"[Delete]ɾ��һλ��ϵ����Ϣ\n"+
				"[QUERY]��ѯ������ϵ�˵���Ϣ\n"+
				"[UPDATE]�޸�һλ��ϵ����Ϣ\n"+
				"[EXIT]�˳�\n";
		private static final String OPERATION_ADD="ADD";
		private static final String OPERATION_UPDATE="UPDATE";
		private static final String OPERATION_DELETE="DELETE";
		private static final String OPERATION_QUERY="QUERY";
		private static final String OPERATION_EXIT="EXIT";
		public static void main(String[] args) {
			System.out.println(context);
			Scanner s = new Scanner(System.in);
			DAOaction daoaction = new DAOaction();
			Integer step=1;
			String previous=null;
			phonebook pb = null;
			while(s.hasNext()) {
				String in = s.next();
				
				if("ADD".equals(in.toUpperCase())||OPERATION_ADD.equals(previous)) {
					previous=OPERATION_ADD;
					if(step==1) {
						
						System.out.println("������Ҫ���ӵ�����(name)��\n");		
					}else if(step==2) {
						pb = new phonebook();
						pb.setName(in);
						
						System.out.println("������Ҫ���ӵ��Ա�(sex)��\n");
					}else if(step==3){
						try {
							pb.setSex(in);
							System.out.println("������Ҫ���ӵ��ֻ���(phonenumber)��\n");
						} catch (Exception e) {
							// TODO Auto-generated catch block
							step=2;
							System.out.println("������Ҫ���ӵ��Ա�(sex)��\n");
						}
					}else {
						pb.setNumber(in);
						try {
							daoaction.add(pb);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							System.out.println("����ʧ��!\n");
						}
						System.out.println("�����ɹ�!\n");
						step=1;
						previous=null;
					}
					if(OPERATION_ADD.equals(previous)) {
						step++;
					}
	
	
				}
				else if("UPDATE".equals(in.toUpperCase())||OPERATION_UPDATE.equals(previous)) {
					previous=OPERATION_UPDATE;

					if(step==1) {
						System.out.println("������Ҫ�޸���ϵ�˵�����:\n");	
					}else if(step==2) {
						
						try {
							pb = daoaction.get(in);
							if(pb==null) {
								System.out.println("��ѯ��ϵ����Ϣʧ�ܣ�\n");
								System.out.println("���ٴ�����Ҫ�޸���ϵ�˵�����:\n");
								step=1;
							}else {
								System.out.println("��ѯ��ϵ����Ϣ�ɹ���\n");
								System.out.println("������Ҫ�޸ĵ���ϵ�˵��Ա�(������޸ĸ�ֵ��������N)\n");
								
							}
							} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}			
					}else if(step==3) {
//						if(-1!=Integer.valueOf(in))
						if(!"N".equals(in)){
						pb.setSex(in);
						}
						System.out.println("������Ҫ�޸ĵ���ϵ�˵��ֻ����룺(������޸ĸ�ֵ��������N)\n");
					}else {
//						if(-1!=Integer.valueOf(in))
						if(!"N".equals(in)){
						pb.setNumber(in);
						}
						try {
							daoaction.update(pb);
							System.out.println("�޸ĳɹ�!\n");
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							System.out.println("�޸�ʧ��!\n");
						}
					
						step=1;
						previous=null;
					}
					if(OPERATION_UPDATE.equals(previous)) {
						step++;
					}
				}
				else if("DELETE".equals(in.toUpperCase())||OPERATION_DELETE.equals(previous)) {
					previous=OPERATION_DELETE;
					if(step==1) {
						System.out.println("������Ҫɾ����ϵ�˵�����:\n");
					}else if(step==2) {
						try {
							
							daoaction.delete(in);
							System.out.println("ɾ���ɹ�");
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							System.out.println("ɾ��ʧ��");
						}
						step=1;
						previous=null;
					}
					if(OPERATION_DELETE.equals(previous)) {
						step++;
					}
					
				}else if("QUERY".equals(in.toUpperCase())||OPERATION_QUERY.equals(previous)) {
					previous=OPERATION_DELETE;
					
					try {
						System.out.println("��ѯ�������:\n");
						List<phonebook> list = daoaction.query();
						for(phonebook pb1:list) {
							System.out.println("������"+pb1.getName()+",�Ա�"+pb1.getSex()+",�ֻ��ţ�"+pb1.getNumber());
							
						}
						System.out.println("��ѯ���");
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else if("EXIT".equals(in.toUpperCase())||OPERATION_EXIT.equals(previous)) {
					System.out.println("���ѳɹ��˳�dq�绰����\n");
					break;
				}
					
			}
		}
		
}
