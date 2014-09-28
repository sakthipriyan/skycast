package com.sakthipriyan.skycast;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TelevisionTest {
	
	private Television television;

	@Before
	public void setUp() throws Exception {
		Set<Integer> blockedChannels = new HashSet<Integer>();
		blockedChannels.add(21);
		blockedChannels.add(31);
		blockedChannels.add(41);
		television = new Television(20, 300, blockedChannels);
	}

	@Test
	public void testGetMinChannel() {
		Assert.assertEquals(20, television.getMinChannel());
	}

	@Test
	public void testGetMaxChannel() {
		Assert.assertEquals(300, television.getMaxChannel());
	}

	@Test
	public void testGetBlockedChannels() {
		Assert.assertEquals(3, television.getBlockedChannels().size());
	}

	@Test
	public void testGetPreviousChannel() {
		television.setChannel(22);
		television.setChannel(23);
		Assert.assertEquals(22, television.getPreviousChannel());
	}

	@Test
	public void testSetChannel() {
		television.setChannel(32);
		Assert.assertEquals(32, television.getCurrentChannel());
	}
	
	@Test
	public void testSetChannelAgain() {
		television.setChannel(32);
		television.setChannel(33);
		television.setChannel(33);
		Assert.assertEquals(33, television.getCurrentChannel());
		Assert.assertEquals(32, television.getCurrentChannel());
	}
	
		

	@Test
	public void testIsBlocked() {
		Assert.assertTrue(television.isBlocked(31));
	}

}
