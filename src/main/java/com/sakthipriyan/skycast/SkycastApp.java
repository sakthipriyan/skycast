package com.sakthipriyan.skycast;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.sakthipriyan.skycast.models.Button;

public class SkycastApp {

	public static void main(String[] args) {
		String channelLimits = "1 100";
		String blockedChannels = "4 78 79 80 3";
		String viewChannels = "8 10 13 13 100 99 98 77 81";
		SkycastApp skycastApp = new SkycastApp();
		int count = skycastApp.process(channelLimits, blockedChannels, viewChannels);
		System.out.println("No of button press required => " + count);
	}
	
	public int process(String channelLimits, String blockedChannels, String viewChannels){
		String[] limits = channelLimits.split("\\s+");
		String[] blockedArray = blockedChannels.split("\\s+");
		String[] viewArray = viewChannels.split("\\s+");
		
		int minChannel = Integer.parseInt(limits[0]);
		int maxChannel = Integer.parseInt(limits[1]);
		
		Set<Integer> blockedSet = new HashSet<Integer>(40);
		for(int i=1;i<blockedArray.length;i++){
			blockedSet.add(Integer.parseInt(blockedArray[i]));
		}
		
		List<Integer> channelList = new ArrayList<Integer>(50);
		for(int i=1;i<viewArray.length;i++){
			channelList.add(Integer.parseInt(viewArray[i]));
		}
		return process(minChannel, maxChannel, blockedSet, channelList);
	}
	
	public int process(int minChannel, int maxChannel, Set<Integer> blocked, List<Integer> viewOrder){
		Television tv = new Television(minChannel, maxChannel, blocked);
		ButtonPressOptimizer optimizer = new ButtonPressOptimizer(tv);
		int count = 0;
		for (Integer channel : viewOrder) {
			Button[] buttons = optimizer.optimize(channel);
			for(Button button: buttons){
				System.out.print(button + " ");	
			}
			count += buttons.length;
			tv.setChannel(channel);
			System.out.println("=> " + channel);
		}
		return count;
	}
}