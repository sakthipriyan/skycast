package com.sakthipriyan.skycast;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.sakthipriyan.skycast.models.Button;

/**
 * This is the main class to run the
 * program to give out the results.
 * @author sakthipriyan
 *
 */
public class SkycastApp {

	/**
	 * Invoked from the command line.
	 * @param args - arguments to the program <br>
	 * args[0] - min and max channel as space
	 * separated strings. Eg. "1 20" <br>
	 * args[1] - space separated list of blocked channels.
	 * Eg. "2 4 7 8 9" <br>
	 * args[2] - list of channels to be viewed in that order
	 * Eg "3 5 6 10"
	 */
	public static void main(String[] args) {
		//Create an instance and do teh processing
		SkycastApp skycastApp = new SkycastApp();
		int count = skycastApp.process(args[0], args[1], args[2]);

		//Display the required output
		System.out.println("No of button press required => " + count);
	}
	
	/**
	 * Accepts space separated list for all arguments 
	 * and returns the computed number of minimum 
	 * button press required. 
	 * @param channelLimits
	 * @param blockedChannels
	 * @param viewChannels
	 * @return number of minimum button press required. 
	 */
	public int process(String channelLimits, String blockedChannels, String viewChannels){
		//Split the input strings into array using space delimiter.
		String[] limits = channelLimits.split("\\s+");
		String[] blockedArray = blockedChannels.split("\\s+");
		String[] viewArray = viewChannels.split("\\s+");
		
		int minChannel = Integer.parseInt(limits[0]);
		int maxChannel = Integer.parseInt(limits[1]);
		
		//Create blocked set from the blockedArray
		Set<Integer> blockedSet = new HashSet<Integer>(40);
		for(int i=1;i<blockedArray.length;i++){
			blockedSet.add(Integer.parseInt(blockedArray[i]));
		}
		
		//Create channelList from teh viewArray
		List<Integer> channelList = new ArrayList<Integer>(50);
		for(int i=1;i<viewArray.length;i++){
			channelList.add(Integer.parseInt(viewArray[i]));
		}
		
		//Pass the data generated from the input to actual processor. 
		return process(minChannel, maxChannel, blockedSet, channelList);
	}
	
	/**
	 * Accept the input as standard java primitives/objects
	 * And process them to generate minimum number of press required.
	 * @param minChannel
	 * @param maxChannel
	 * @param blocked
	 * @param viewOrder
	 * @return number of minimum button press required. 
	 */
	public int process(int minChannel, int maxChannel, Set<Integer> blocked, List<Integer> viewOrder){
		
		//Create Television object to hold info related to it.
		Television tv = new Television(minChannel, maxChannel, blocked);
		
		//Create ButtonPressOptimizer with the above Television object.
		ButtonPressOptimizer optimizer = new ButtonPressOptimizer(tv);
		//Initialize the count
		int count = 0;
		
		/*
		 * Iterate each channel in the list and find the
		 * combination of keys need to be pressed and sum 
		 * them using the count variable.  
		 */
		for (Integer channel : viewOrder) {
			Button[] buttons = optimizer.optimize(channel);
			
			//Following for is not required if we don't need to print
			//buttons to be pressed.
			for(Button button: buttons){
				System.out.print(button + " ");	
			}
			System.out.println("=> " + channel);
			
			//Update the count and set new channel in the tv.
			count += buttons.length;
			tv.setChannel(channel);
			
		}
		return count;
	}
}