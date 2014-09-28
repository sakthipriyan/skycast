package com.sakthipriyan.skycast;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import com.sakthipriyan.skycast.models.Button;

public class ButtonPressOptimizerTest {

	@Test
	public void testOptimizeWithNoBlockedChannels() {
		Set<Integer> blockedChannels = new HashSet<Integer>();
		blockedChannels.add(10);
		blockedChannels.add(1);
		blockedChannels.add(2);
		blockedChannels.add(20);
		Television tv = new Television(1,20,blockedChannels);
		ButtonPressOptimizer optimizer = new ButtonPressOptimizer(tv);
		Button[] buttons =  optimizer.optimize(3);
		for(Button button: buttons){
			System.out.println(button);	
		}
		tv.setChannel(9);
		buttons =  optimizer.optimize(11);
		for(Button button: buttons){
			System.out.print(button + " ");	
		}
		Assert.assertSame(buttons.length, 1);
/*		 
		List<Integer> channels = new ArrayList<Integer>(10);
		channels.add(2);
		channels.add(4);
		channels.add(5);
		channels.add(9);
		channels.add(13);
*/		
		//fail("Not yet implemented");
	}

}