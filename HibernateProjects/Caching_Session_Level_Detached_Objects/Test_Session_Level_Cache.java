import util.HibernateUtil;
import org.hibernate.*;

public class Test_Session_Level_Cache {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       PersistentClass object1 = new PersistentClass();
       object1.setSomething("Objhect1");
       SessionFactory factory = HibernateUtil.getSessionFactory(); 
       Session session = factory.openSession();
       
       Transaction tx = session.beginTransaction();
       session.save(object1);
       
       tx.commit();
      // session.close();
      // session = factory.openSession();
      // session = factory.getCurrentSession();
       tx = session.beginTransaction();
       //make object1 persistent again
       session.refresh(object1);
       //PersistentClass object0 = session.get(PersistentClass.class, newLong(1));
       PersistentClass object4 = (PersistentClass)session.get(PersistentClass.class, new Long(1));
       if(object4==object1)
           System.out.println("This is SAME !!!");
       else {
    	   System.out.println("They are DIFFERENT !!!");
       tx.commit();
       
       
	}

}
}
