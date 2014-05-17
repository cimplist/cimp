package com.cimplist.cip.epms.web;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;

public class KpiControllerUtilTest {

	@Test
	public void testConcat() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsComment() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetIdFromParamName() {
		Long id = KpiControllerUtil.getIdFromParamName("item.comments.8");
		assertEquals(id.longValue(), new Long(8).longValue());
	}

}
