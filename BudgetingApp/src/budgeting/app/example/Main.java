package budgeting.app.example;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {

	public static void main(String[] args) {

		Session session = HibernateUtil.getSession().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();

//			Set<Course> courses = new HashSet<Course>();
//			courses.add(new Course("Maths"));
//			courses.add(new Course("Computer Science"));
//
//			Student student1 = new Student("Eswar", courses);
//			Student student2 = new Student("Joe", courses);
//			session.save(student1);
//			session.save(student2);
			
			Stock stock = new Stock();
			stock.setStockCode("7052");
			stock.setStockName("PADINI");

			Category category1 = new Category("CONSUMER", "CONSUMER COMPANY");
			//new category, need save to get the id first
			session.save(category1);

			StockCategory stockCategory = new StockCategory();
			stockCategory.setStock(stock);
			stockCategory.setCategory(category1);
			stockCategory.setCreatedDate(new Date()); //extra column
			stockCategory.setCreatedBy("system"); //extra column

			stock.getStockCategories().add(stockCategory);

			session.save(stock);

			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

	}
}