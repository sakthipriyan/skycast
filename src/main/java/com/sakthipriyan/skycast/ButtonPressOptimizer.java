package com.sakthipriyan.skycast;

import com.sakthipriyan.skycast.models.Button;

public class ButtonPressOptimizer {
	
	private Television tv;
	private ButtonGenerator buttonGenerator;

	public ButtonPressOptimizer(Television tv) {
		this.tv = tv;
		this.buttonGenerator = new ButtonGenerator();
	}

	public Button[] optimize(int nextChannel) {

		if (tv.getCurrentChannel() == nextChannel) {
			return new Button[0];
		}

		if (tv.getPreviousChannel() == nextChannel) {
			return buttonGenerator.getButtonsWithBack();
		}

		if (nextChannel < 10) {
			return buttonGenerator.getButtonsUptoNine(nextChannel);
		}

		return getButtons(nextChannel);
	}

	private Button[] getButtons(int nextChannel) {

		String nextChannelString = String.valueOf(nextChannel);
		int keyLength = nextChannelString.length();
		Button[] numericButtons = new Button[keyLength];

		int nextUpChannel = nextChannel;
		int nextDownChannel = nextChannel;

		for (int i = 0; i < keyLength; i++) {
			nextUpChannel = tv.getUpChannel(nextUpChannel);
			nextDownChannel = tv.getDownChannel(nextDownChannel);
			if (nextUpChannel == tv.getCurrentChannel()) {
				return buttonGenerator.getButtons(Button.DOWN, i+1);
			}
			if (nextDownChannel == tv.getCurrentChannel()) {
				return buttonGenerator.getButtons(Button.UP, i+1);
			}
			if (i < keyLength - 1) {
				if (nextUpChannel == tv.getPreviousChannel()) {
					return buttonGenerator.getButtonsWithBack(Button.DOWN, i+1);
				}
				if (nextDownChannel == tv.getPreviousChannel()) {
					return buttonGenerator.getButtonsWithBack(Button.UP, i+1);
				}
			}

			// Generate numeric buttons
			int number = Integer.parseInt(nextChannelString.substring(i, i + 1));
			numericButtons[i] = Button.get(number);
		}

		return numericButtons;
	}

	

}
