package DAO;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class postannDAOTest {
	static String username;
	static String pass;
	static postannDAO sc;
	@BeforeClass
	public static void setUp() throws Exception {
		// TODO Auto-generated method stub
		//All set up activity goes here. e.g. setup db connections etc.
		sc = new postannDAO();
		username = "nisarg";
		pass="shah";
	}

	@Test
	public void testPostjob() throws SQLException {
		boolean ok=	sc.postjob(pass,username,pass,username,pass,username);
		Assert.assertEquals(false,ok);
	}
	
	@Test
	public void testPostann() throws SQLException {
		boolean ok=	sc.postann(pass,username,pass,username);
		Assert.assertEquals(false,ok);
	}

}
