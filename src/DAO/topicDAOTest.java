package DAO;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class topicDAOTest {
	static String username;
	static String pass;
	static topicDAO sc;
	@BeforeClass
	public static void setUp() throws Exception {
		// TODO Auto-generated method stub
		//All set up activity goes here. e.g. setup db connections etc.
		sc = new topicDAO();
		username = "nisarg";
		pass="shah";
}

	@Test
	public void testTopic() {
		int ok=	sc.topic(pass);
		Assert.assertEquals(0,ok);
	}

	@Test
	public void testCheckcontent() {
		boolean ok=	sc.topicreg(pass);
		Assert.assertEquals(true,ok);
	}

	@Test
	public void testHashtagfeed() {
		boolean ok=	sc.topicreg(pass);
		Assert.assertEquals(true,ok);
	}

	@Test
	public void testDelete() {
		boolean ok=	sc.delete(pass);
		Assert.assertEquals(false,ok);
	}

	@Test
	public void testTopicreg() {
		boolean ok=	sc.topicreg(pass);
		Assert.assertEquals(true,ok);
	}

}
