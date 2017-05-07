package DAO;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class infoDAOTest {
	
	static String username;
	static String pass;
	static infoDAO sc;
	@BeforeClass
	public static void setUp() throws Exception {
		// TODO Auto-generated method stub
		//All set up activity goes here. e.g. setup db connections etc.
		sc = new infoDAO();
		username = "nisarg";
		pass="shah";
	}

	@Test
	public void testCourse() {
		boolean ok=	sc.course(pass,username,pass,username,pass);
		Assert.assertEquals(false,ok);
	}

}
