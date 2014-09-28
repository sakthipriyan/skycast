package com.sakthipriyan.skycast;

import com.sakthipriyan.skycast.models.Button;

public class ButtonGenerator {
	public Button[] getButtons(Button button, int count) {
		Button[] buttons = new Button[count];
		for (int i = 0; i < count; i++) {
			buttons[i] = button;
		}
		return buttons;
	}

	public Button[] getButtonsWithBack(Button button, int count) {
		count++;
		Button[] buttons = new Button[count];
		buttons[0] = Button.BACK;
		for (int i = 1; i < count; i++) {
			buttons[i] = button;
		}
		return buttons;
	}
	
	public Button[] getButtonsUptoNine(int nextChannel){
		Button[] buttons = new Button[1];
		buttons[0] = Button.get(nextChannel);
		return buttons;
	}
	
	public Button[] getButtonsWithBack(){
		Button[] buttons = new Button[1];
		buttons[0] = Button.BACK;
		return buttons;
	}
}