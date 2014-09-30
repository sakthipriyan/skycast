package com.sakthipriyan.skycast;

import com.sakthipriyan.skycast.models.Button;

/**
 * This class is used to find the optimized minimum 
 * key press required for the given Television for the 
 * next channel in the list. 
 * @author sakthipriyan
 */
public class ButtonPressOptimizer {
	
	private Television tv;
	private ButtonGenerator buttonGenerator;

	public ButtonPressOptimizer(Television tv) {
		this.tv = tv;
		this.buttonGenerator = new ButtonGenerator();
	}

	/**
	 * This is core logic that enables to find the
	 * next sequence of minimum buttons required to be
	 * pressed to go to next channel in the list.
	 * @param nextChannel - next channel to be viewed.
	 * @return Button[] - sequence of buttons to be pressed.
	 * It will be empty in case no button press is required.
	 */
	public Button[] optimize(int nextChannel) {

		//If next channel same as current channel,
		//return empty array, as nothing need to be
		//pressed
		if (tv.getCurrentChannel() == nextChannel) {
			return new Button[0];
		}

		//If next is previous, then back has to be
		//pressed.
		if (tv.getPreviousChannel() == nextChannel) {
			return buttonGenerator.getButtonsWithBack(null,0);
		}

		//If channel is less than 10, return that button.
		if (nextChannel < 10) {
			return buttonGenerator.getButtonsUptoNine(nextChannel);
		}

		//In other cases find out minimum number of button press required.
		return getButtons(nextChannel);
	}

	/**
	 * This method enables user to find the minimum sequence of buttons
	 * to be pressed.
	 * @param nextChannel - next channel need to be viewed. 
	 * @return Button[] - array of buttons to be pressed.
	 */
	private Button[] getButtons(int nextChannel) {

		//Generate button array that can be used if those
		//buttons(0-9) need to be pressed directly.
		String nextChannelString = String.valueOf(nextChannel);
		int keyLength = nextChannelString.length();
		Button[] numericButtons = new Button[keyLength];
		
		/* Core logic
		 * Start from the next channel,
		 * 1. Find if it can be reached from current channel in keyLength-1 steps.
		 * If yes return that number of up or down presses required.
		 * 2. Find if it can be reached from previous channel in keyLength-2 steps.
		 * If yes return that number of up or down presses required after the 
		 * first back button.
		 * 3. If 1 and 2 cannot be achieved, then return individual buttons.
		 */
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