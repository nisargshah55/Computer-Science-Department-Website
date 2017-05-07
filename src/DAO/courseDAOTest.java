package DAO;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import DAO.courseDAO;

public class courseDAOTest {
	static String username;
	static String pass;
	static courseDAO sc;
	@BeforeClass
	public static void setUp() throws Exception {
		// TODO Auto-generated method stub
		//All set up activity goes here. e.g. setup db connections etc.
		sc = new courseDAO();
		username = "nisarg";
		pass="shah";
	}

	@Test
	public void testCourse() {
	int ok=	sc.course(pass, pass);
		Assert.assertEquals(1,ok);
		
	}

	@Test
	public void testCoursereg() {
		boolean ok=	sc.coursereg(pass);
		Assert.assertEquals(true,ok);
	}

	/*@Test
	public void testViewcourse() {
		fail("Not yet implemented");
	}*/

	@Test
	public void testDelete() {
		boolean ok=	sc.delete(pass);
		Assert.assertEquals(false,ok);
	}

	@Test
	public void testSelect() {
		boolean ok=	sc.select(pass,pass,pass,pass);
		Assert.assertEquals(false,ok);
	}

	@Test
	public void testCheckfac() {
		boolean ok=	sc.checkfac(pass,pass,pass);
		Assert.assertEquals(true,ok);
	}

}
