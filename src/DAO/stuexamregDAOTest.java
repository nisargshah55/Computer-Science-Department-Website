package DAO;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class stuexamregDAOTest {
	static String username;
	static String pass;
	static stuexamregDAO sc;
	@BeforeClass
	public static void setUp() throws Exception {
		// TODO Auto-generated method stub
		//All set up activity goes here. e.g. setup db connections etc.
		sc = new stuexamregDAO();
		username = "nisarg";
		pass="shah";
}

	@Test
	public void testExamreg() {
		boolean ok=	sc.examreg(pass, username,pass);
		Assert.assertEquals(true,ok);
		
	}
	@Test
		public void testCheckexam() {
			boolean ok=	sc.checkexam(pass, username);
			Assert.assertEquals(false,ok);
		}	
			

}
