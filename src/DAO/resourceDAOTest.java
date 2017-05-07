package DAO;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class resourceDAOTest {
	static String username;
	static String pass;
	static resourceDAO sc;
	@BeforeClass
	public static void setUp() throws Exception {
		// TODO Auto-generated method stub
		//All set up activity goes here. e.g. setup db connections etc.
		sc = new resourceDAO();
		username = "nisarg";
		pass="shah";
}

	@Test
	public void testCreateres() {
		boolean ok=	sc.createres(username, pass, pass);
		Assert.assertEquals(false,ok);
	}

	@Test
	public void testSelectres() {
		boolean ok=	sc.createres(pass, username,pass);
		Assert.assertEquals(false,ok);
	}

	@Test
	public void testReserve() {
		boolean ok=	sc.reserve(username, pass, username, pass);
		Assert.assertEquals(false,ok);
	}

	@Test
	public void testCheckreservation() {
		boolean ok=	sc.checkreservation(username, username, pass);
		Assert.assertEquals(false,ok);
	}

	@Test
	public void testDelete() {
		boolean ok=	sc.delete(username);
		Assert.assertEquals(false,ok);
	}

}
