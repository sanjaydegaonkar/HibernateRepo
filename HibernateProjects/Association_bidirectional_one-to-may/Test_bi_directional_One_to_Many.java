import util.HibernateUtil;
import org.hibernate.*;
import java.util.*;
public class Test_bi_directional_One_to_Many {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Item it = new Item("Think Pad","IBM Think Pad");
		Bid bid1 = new Bid();
		Bid bid2 = new Bid();
		Set<Bid> bids = new HashSet<Bid>();
		bids.add(bid1);
		bids.add(bid2);
		it.setBids(bids);
		
		Session session= HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		//session.lock(it,null);
		session.save(it);
		session.save(bid1);
		session.save(bid2);
		
		//Item item = (Item)(session.get(Item.class, new Long(3)));
		//System.out.println("DEBUG : Got Item"+item);
		tx.commit();
		

	}

}
