package com.sakthipriyan.skycast;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.sakthipriyan.skycast.models.Button;

public class ButtonGeneratorTest {
	
	private ButtonGenerator generator;

	@Before
	public void setUp() throws Exception {
		generator = new ButtonGenerator();
	}

	@Test
	public void testGetButtonsForUp() {
		Button[] buttons = generator.getButtons(Button.UP, 3);
		assertEquals(3, buttons.length);
		assertEquals(buttons[0], Button.UP);
		assertEquals(buttons[1], Button.UP);
		assertEquals(buttons[2], Button.UP);
	}

	@Test
	public void testGetButtonsForDown() {
		Button[] buttons = generator.getButtons(Button.DOWN, 2);
		assertEquals(2, buttons.length);
		assertEquals(buttons[0], Button.DOWN);
		assertEquals(buttons[1], Button.DOWN);
	}
	
	@Test
	public void testGetButtonsWithBackForUp() {
		Button[] buttons = generator.getButtonsWithBack(Button.UP, 2);
		assertEquals(3, buttons.length);
		assertEquals(buttons[0], Button.BACK);
		assertEquals(buttons[1], Button.UP);
		assertEquals(buttons[2], Button.UP);
	}
	
	@Test
	public void testGetButtonsWithBackForDown() {
		Button[] buttons = generator.getButtonsWithBack(Button.DOWN, 3);
		assertEquals(4, buttons.length);
		assertEquals(buttons[0], Button.BACK);
		assertEquals(buttons[1], Button.DOWN);
		assertEquals(buttons[2], Button.DOWN);
		assertEquals(buttons[3], Button.DOWN);
	}

}