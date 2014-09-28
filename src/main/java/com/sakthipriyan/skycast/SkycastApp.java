package com.sakthipriyan.skycast;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.sakthipriyan.skycast.models.Button;

public class SkycastApp {

	public static void main(String[] args) {
		// TODO read all 3 input fields
		// TODO verify all 3 input fields
		// TODO construct inputs

		int minChannel = 1;
		int maxChannel = 20;
		Set<Integer> blockedChannels = new HashSet<Integer>();
		List<Integer> channels = new ArrayList<Integer>(10);

		Television tv = new Television(minChannel, maxChannel, blockedChannels);
		ButtonPressOptimizer optimizer = new ButtonPressOptimizer(tv);
		int count = 0;
		for (Integer channel : channels) {
			Button[] buttons = optimizer.optimize(channel);
			count += buttons.length;
		}
		System.out.println("No of button press required:" + count);
	}

}
