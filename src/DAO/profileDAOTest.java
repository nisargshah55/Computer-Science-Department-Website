package DAO;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class profileDAOTest {
	static String username;
	static String pass;
	static profileDAO sc;
	@BeforeClass
	public static void setUp() throws Exception {
		// TODO Auto-generated method stub
		//All set up activity goes here. e.g. setup db connections etc.
		sc = new profileDAO();
		username = "nisarg";
		pass="shah";
	}

	@Test
	public void testProfile() {
		int ok=	sc.editprofile(pass,username,pass);
		Assert.assertEquals(0,ok);
	}

	@Test
	public void testEditprofile() {
		int ok=	sc.editprofile(pass,username,pass);
		Assert.assertEquals(0,ok);
	}

}
