package dq_jdbc_final;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import dq_jdbc_final.phonebook;
import dq_jdbc_final.DAOaction;

public class view {
		private static final String context=" "
				+"欢迎来到dq的电话本"+"\n"+
				"功能如下"+"\n"+
				"[ADD]增加一位联系人信息\n"+
				"[Delete]删除一位联系人信息\n"+
				"[QUERY]查询所有联系人的信息\n"+
				"[UPDATE]修改一位联系人信息\n"+
				"[EXIT]退出\n";
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
						
						System.out.println("请输入要增加的姓名(name)：\n");		
					}else if(step==2) {
						pb = new phonebook();
						pb.setName(in);
						
						System.out.println("请输入要增加的性别(sex)：\n");
					}else if(step==3){
						try {
							pb.setSex(in);
							System.out.println("请输入要增加的手机号(phonenumber)：\n");
						} catch (Exception e) {
							// TODO Auto-generated catch block
							step=2;
							System.out.println("请输入要增加的性别(sex)：\n");
						}
					}else {
						pb.setNumber(in);
						try {
							daoaction.add(pb);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							System.out.println("新增失败!\n");
						}
						System.out.println("新增成功!\n");
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
						System.out.println("请输入要修改联系人的姓名:\n");	
					}else if(step==2) {
						
						try {
							pb = daoaction.get(in);
							if(pb==null) {
								System.out.println("查询联系人信息失败！\n");
								System.out.println("请再次输入要修改联系人的姓名:\n");
								step=1;
							}else {
								System.out.println("查询联系人信息成功！\n");
								System.out.println("请输入要修改的联系人的性别：(如果不修改该值，请输入N)\n");
								
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
						System.out.println("请输入要修改的联系人的手机号码：(如果不修改该值，请输入N)\n");
					}else {
//						if(-1!=Integer.valueOf(in))
						if(!"N".equals(in)){
						pb.setNumber(in);
						}
						try {
							daoaction.update(pb);
							System.out.println("修改成功!\n");
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							System.out.println("修改失败!\n");
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
						System.out.println("请输入要删除联系人的姓名:\n");
					}else if(step==2) {
						try {
							
							daoaction.delete(in);
							System.out.println("删除成功");
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							System.out.println("删除失败");
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
						System.out.println("查询结果如下:\n");
						List<phonebook> list = daoaction.query();
						for(phonebook pb1:list) {
							System.out.println("姓名："+pb1.getName()+",性别："+pb1.getSex()+",手机号："+pb1.getNumber());
							
						}
						System.out.println("查询完毕");
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else if("EXIT".equals(in.toUpperCase())||OPERATION_EXIT.equals(previous)) {
					System.out.println("您已成功退出dq电话本！\n");
					break;
				}
					
			}
		}
		
}
