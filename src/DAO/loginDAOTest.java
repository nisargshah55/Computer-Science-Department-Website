package DAO;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class loginDAOTest {
	static String username;
	static String pass;
	static loginDAO sc;
	@BeforeClass
	public static void setUp() throws Exception {
		// TODO Auto-generated method stub
		//All set up activity goes here. e.g. setup db connections etc.
		sc = new loginDAO();
		username = "nisarg";
		pass="shah";
	}


	@Test
	public void testLogin() {
		int ok=	sc.login(pass,username,pass,username,pass);
		Assert.assertEquals(1,ok);
	}

	@Test
	public void testLoginstudent() {
		int ok=	sc.loginstudent(pass,username,pass,username,pass,username,username,username);
		Assert.assertEquals(1,ok);
	}

	@Test
	public void testSearchreg() {
		boolean ok=	sc.searchreg(pass);
		Assert.assertEquals(true,ok);
	}

	@Test
	public void testSearchlogin() {
		boolean ok=	sc.searchlogin(pass,pass,pass);
		Assert.assertEquals(false,ok);
	}

	@Test
	public void testSearchrole() {
		boolean ok=	sc.searchrole(pass);
		Assert.assertEquals(true,ok);
	}

}
