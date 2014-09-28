package com.sakthipriyan.skycast;

import static org.junit.Assert.fail;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import com.sakthipriyan.skycast.models.Button;

public class ButtonPressOptimizerTest {

	@Test
	public void testOptimizeWithNoBlockedChannels() {
		Set<Integer> blockedChannels = new HashSet<Integer>();
		Television tv = new Television(1,20,blockedChannels);
		ButtonPressOptimizer optimizer = new ButtonPressOptimizer(tv);
		Button[] buttons1 =  optimizer.optimize(2);
		Assert.assertSame(buttons1.length, 1);
/*		 
		List<Integer> channels = new ArrayList<Integer>(10);
		channels.add(2);
		channels.add(4);
		channels.add(5);
		channels.add(9);
		channels.add(13);
*/		
		fail("Not yet implemented");
	}

}