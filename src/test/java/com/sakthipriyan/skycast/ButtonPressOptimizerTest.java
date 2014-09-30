package com.sakthipriyan.skycast;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.sakthipriyan.skycast.models.Button;

public class ButtonPressOptimizerTest {

	private Television tv;
	private ButtonPressOptimizer optimizer;

	@Before
	public void setUp() throws Exception {
		Set<Integer> blockedChannels = new HashSet<Integer>();

		blockedChannels.add(1);
		blockedChannels.add(2);
		blockedChannels.add(10);
		blockedChannels.add(14);
		blockedChannels.add(20);
		tv = new Television(1, 20, blockedChannels);
		optimizer = new ButtonPressOptimizer(tv);
	}

	//TODO - better to have separate test methods, if required.
	@Test
	public void testOptimizeForAllCases() {

		// Find buttons for channel 9
		Button[] buttons = optimizer.optimize(9);
		Assert.assertSame(buttons.length, 1);
		Assert.assertSame(buttons[0], Button.NINE);
		tv.setChannel(9);

		// Find buttons for channel 13
		buttons = optimizer.optimize(13);
		Assert.assertSame(buttons.length, 2);
		Assert.assertSame(buttons[0], Button.ONE);
		Assert.assertSame(buttons[1], Button.THREE);
		tv.setChannel(13);

		// Find buttons for channel 3
		buttons = optimizer.optimize(3);
		Assert.assertSame(buttons.length, 1);
		Assert.assertSame(buttons[0], Button.THREE);
		tv.setChannel(3);

		// Find buttons for channel 13
		buttons = optimizer.optimize(13);
		Assert.assertSame(buttons.length, 1);
		Assert.assertSame(buttons[0], Button.BACK);
		tv.setChannel(13);

		// Find buttons for channel 15
		buttons = optimizer.optimize(15);
		Assert.assertSame(buttons.length, 1);
		Assert.assertSame(buttons[0], Button.UP);
		tv.setChannel(15);
		
		// Find buttons for channel 3
		buttons = optimizer.optimize(3);
		Assert.assertSame(buttons.length, 1);
		Assert.assertSame(buttons[0], Button.THREE);
		tv.setChannel(3);
		
		// Find buttons for channel 19
		buttons = optimizer.optimize(19);
		Assert.assertSame(buttons.length, 1);
		Assert.assertSame(buttons[0], Button.DOWN);
		tv.setChannel(19);
	}

}