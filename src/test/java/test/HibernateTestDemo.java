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
	 * SQLQuery对象
	 * 返回为对象的形式
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
			//1、创建SQLQuery对象
			SQLQuery sqlquery = session.createSQLQuery("select * from t_user");
			//设置：返回list中每个部分是对象的形式
			sqlquery.addEntity(User.class);
			//调用SQLQuery对象里的方法得到结果
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
	 * SQLQuery对象
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
			//1、创建SQLQuery对象
			SQLQuery sqlquery = session.createSQLQuery("select * from t_user");
			//调用SQLQuery对象里的方法得到结果
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
	 * Criteria对象
	 * Hql语句写法
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
			//1、创建Criteria对象
			Criteria criteria = session.createCriteria(User.class);
			//调用Criteria对象里的方法得到结果
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
	 * Query对象
	 * Hql语句写法
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
			//1、创建query对象
			 Query query = session.createQuery("from User");
			//调用query对象里的方法得到结果
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
