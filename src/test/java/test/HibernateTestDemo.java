package test;
import java.util.Arrays;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.internal.SQLQueryImpl;
import org.hibernate.query.Query;
import org.junit.Test;

import Utils.HibernateUtils;

import com.itcast.entity.User;

public class HibernateTestDemo {
	/**
	 * SQLQuery����
	 * ����Ϊ�������ʽ
	 */
	@Test
	public void testSQLQuery1(){
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction trans = null;
		try {
			 sessionFactory = HibernateUtils.getSessionFactory();
			 session = sessionFactory.openSession();
			 trans = session.beginTransaction();
			//1������SQLQuery����
			SQLQuery sqlquery = session.createSQLQuery("select * from t_user");
			//���ã�����list��ÿ�������Ƕ������ʽ
			sqlquery.addEntity(User.class);
			//����SQLQuery������ķ����õ����
			@SuppressWarnings("deprecation")
			List<User> list = sqlquery.list();
			for(User user : list){
				System.out.println(user);
			}
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		}finally{
			session.close();
			sessionFactory.close();
		}
	}
	/**
	 * SQLQuery����
	 */
	@Test
	public void testSQLQuery(){
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction trans = null;
		try {
			 sessionFactory = HibernateUtils.getSessionFactory();
			 session = sessionFactory.openSession();
			 trans = session.beginTransaction();
			//1������SQLQuery����
			SQLQuery sqlquery = session.createSQLQuery("select * from t_user");
			//����SQLQuery������ķ����õ����
			@SuppressWarnings("deprecation")
			List<Object[]> list = sqlquery.list();
			for(Object[] obj : list){
				System.out.println(Arrays.toString(obj));
			}
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		}finally{
			session.close();
			sessionFactory.close();
		}
	}
	/**
	 * Criteria����
	 * Hql���д��
	 */
	@Test
	public void testCriteriaHql(){
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction trans = null;
		try {
			 sessionFactory = HibernateUtils.getSessionFactory();
			 session = sessionFactory.openSession();
			 trans = session.beginTransaction();
			//1������Criteria����
			Criteria criteria = session.createCriteria(User.class);
			//����Criteria������ķ����õ����
			List<User> list = criteria.list();
			for(User user : list){
				System.out.println(user);
			}
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		}finally{
			session.close();
			sessionFactory.close();
		}
	}
	/**
	 * Query����
	 * Hql���д��
	 */
	@Test
	public void testQueryHql(){
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction trans = null;
		try {
			 sessionFactory = HibernateUtils.getSessionFactory();
			 session = sessionFactory.openSession();
			 trans = session.beginTransaction();
			//1������query����
			 Query query = session.createQuery("from User");
			//����query������ķ����õ����
			 List<User> list = query.list();
			 for (User user : list) {
				System.out.println(user);
			}
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		}finally{
			session.close();
			sessionFactory.close();
		}
	}
}
