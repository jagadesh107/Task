package com.stock;

import java.util.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class Solution {
	private static int kw;
	private static String na;
	public static void main(String[] args) {
	Item ob=new Item();
	SessionFactory sf= new Configuration().configure().buildSessionFactory();
	Session session= sf.openSession();
	int c=1;
	while(c==1) {
		System.out.println("********************************BASIC THREAD OPERATION****************************");
		System.out.println("1.INSERT\n2.UPDATE\n3.DELETE\n4.VIEW");
		System.out.println("ENTER YOUR CHOICE:");
		Scanner 
		obj=new Scanner(System.in);
		int choice= obj.nextInt();
		if(choice==1) {
			System.out.println("ENTER THE PRODUCT NAME:");
			String name=obj.next();
			System.out.println("ENTER THE QUANTITY:");
			int quantity=obj.nextInt();
			Item ob1=new Item();
			ob1.setName(name);
			ob1.setQuantity(quantity);
			session.beginTransaction();
			session.save(ob1);
			session.getTransaction().commit();
			}
		else if(choice==2) {
			System.out.println("ENTER THE PRODUCT ID:");
			int k= obj.nextInt();
			System.out.println("WHAT  YOU  WANT  TO  UPDATE 1.NAME 2.QUANTITY");
			int choi=obj.nextInt();
			if(choi==1) {
				System.out.println("ENTER THE PRODUCT NAME:");
				String nas= obj.next();
				session.beginTransaction();
				Query query=session.createQuery("update   items set name=:na where Id=:k");
				query.setParameter("na",nas);  
				query.setParameter("k",k);  
				query.executeUpdate();
				session.getTransaction().commit();
				}
			else{
				System.out.println("ENTER THE PRODUCT QUANTITY:");
				int nas= obj.nextInt();
				session.beginTransaction();
				Query query=session.createQuery("update   items set quantity=:na where Id=:k");
				query.setParameter("na",nas);  
				query.setParameter("k",k);  
				query.executeUpdate();
				session.getTransaction().commit();
				}
			}
		else if(choice==3) {
			System.out.println("ENTER THE PRODUCT Id:");
			int a= obj.nextInt();
			session.beginTransaction();
			Query query=session.createQuery("delete   from   items where Id="+"'a'");
			query.executeUpdate();
			session.getTransaction().commit();
			}
		else if(choice==4) {
			session.beginTransaction();
			Query query=session.createQuery("from items");
			List<Item>  it=query.getResultList();
			for(Item each:it){
				System.out.println(each.getId()+" "+each.getName()+" "+each.getQuantity());
				}
			session.getTransaction().commit();
			}
		System.out.println("ENTER 1 TO CONTINUE:");
		c=obj.nextInt();
		}
	session.close();
	}
}