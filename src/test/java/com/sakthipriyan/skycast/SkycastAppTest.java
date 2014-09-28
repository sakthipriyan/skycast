package com.sakthipriyan.skycast;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SkycastAppTest {

	private SkycastApp app;
	
	@Before
	public void setUp() throws Exception {
		app = new SkycastApp();
	}

	@Test
	public void testProcessString() {
		int count = app.process("1 20", "2 18 19", "5 15 14 17 1 17");
		Assert.assertEquals(7, count);
		
		count = app.process("103 108", "1 104", "5 105 106 107 103 105");
		Assert.assertEquals(8, count);
		
		count = app.process("1 100", "4 78 79 80 3", "8 10 13 13 100 99 98 77 81");
		Assert.assertEquals(12, count);
		
		count = app.process("1 200", "0", "4 1 100 1 101");
		Assert.assertEquals(7, count);
	}
	
	@Test
	public void testProcess(){
		Set<Integer> blockedSet = new HashSet<Integer>();
		blockedSet.add(18);
		blockedSet.add(19);
		List<Integer> channelList = new ArrayList<Integer>();
		channelList.add(15);
		channelList.add(14);
		channelList.add(17);
		channelList.add(1);
		channelList.add(17);
		int count = app.process(1, 20, blockedSet, channelList);
		Assert.assertEquals(7, count);
	}

}