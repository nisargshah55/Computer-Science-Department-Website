package DAO;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class examDAOTest {
	static String username;
	static String pass;
	static examDAO sc;
	@BeforeClass
	public static void setUp() throws Exception {
		// TODO Auto-generated method stub
		//All set up activity goes here. e.g. setup db connections etc.
		sc = new examDAO();
		username = "nisarg";
		pass="shah";
}


	@Test
	public void testExam() {
		int ok=	sc.exam(username, username, username);
		Assert.assertEquals(1,ok);
	}
	
	
	@Test
	public void testDelete() {
		boolean ok=	sc.delete(pass);
		Assert.assertEquals(true,ok);
	}

	@Test
	public void testExamreg() {
		boolean ok=	sc.examreg(pass);
		Assert.assertEquals(false,ok);
	}

}
	
