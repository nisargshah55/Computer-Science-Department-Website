package DAO;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class alumniDAOTest {
	static String username;
	static String pass;
	static alumniDAO sc;
	@BeforeClass
	public static void setUp() throws Exception {
		// TODO Auto-generated method stub
		//All set up activity goes here. e.g. setup db connections etc.
		sc = new alumniDAO();
		username = "nisarg";
		pass="shah";
	}

	@Test
	public void testPost() {
		boolean ok=	sc.post(pass,username,pass,username);
		Assert.assertEquals(false,ok);
	}

	@Test
	public void testDelete() {
		boolean ok=	sc.delete(pass);
		Assert.assertEquals(false,ok);
	}

}
