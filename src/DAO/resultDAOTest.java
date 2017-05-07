package DAO;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class resultDAOTest {
	static String username;
	static String pass;
	static resultDAO sc;
	@BeforeClass
	public static void setUp() throws Exception {
		// TODO Auto-generated method stub
		//All set up activity goes here. e.g. setup db connections etc.
		sc = new resultDAO();
		username = "nisarg";
		pass="shah";
}

	@Test
	public void testResult() {
		boolean ok=	sc.result(pass,pass,pass,pass);
		Assert.assertEquals(true,ok);
	}

	@Test
	public void testDelete() {
		boolean ok=	sc.delete(pass);
		Assert.assertEquals(true,ok);
	}

	@Test
	public void testResultreg() {
		boolean ok=	sc.resultreg(pass,pass);
		Assert.assertEquals(false,ok);
	}

}
