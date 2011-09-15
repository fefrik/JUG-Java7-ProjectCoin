package com.tieto.examples;

import org.junit.Test;

import com.tieto.examples.db.RowSetFactoryDemo;

public class RowSetFactoryTest {

	@Test
	public void testRowSet()  {
		RowSetFactoryDemo demo = new RowSetFactoryDemo();
		demo.testJdbcRowSet();
	}

}
