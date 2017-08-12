package controller.modelo.test;

import org.junit.Assert;
import org.junit.Test;

import controller.modelo.Controller;

public class ControleRemotoTest {

	@Test
	public void test() {
		Controller controller1 = new Controller("..P...O.....");
		Controller controller2 = new Controller(".P....");
		Controller controller3 = new Controller("...P.P...P..");
		Controller controller4 = new Controller("P..O..");
		Controller controller5 = new Controller("P..P...PO...");
		Controller controller6 = new Controller("P...O.O.P...P..");

		Assert.assertEquals("001234321000", controller1.execute());
		Assert.assertEquals("012345", controller2.execute());
		Assert.assertEquals("000122222345", controller3.execute());
		Assert.assertEquals("123210", controller4.execute());
		Assert.assertEquals("123333343210", controller5.execute());
		Assert.assertEquals("123432344444555", controller6.execute());
	}
}
