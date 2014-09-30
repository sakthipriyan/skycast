package com.sakthipriyan.skycast;

import java.util.Set;

/**
 * Holds  information of minimum/maximum channel number.
 * Also holds set of channels blocked.
 * Has methods to find up and down channels.
 * @author sakthipriyan
 *
 */
public class Television {
	
	private final int minChannel;
	private final int maxChannel;
	private final Set<Integer> blockedChannels;
	private int previousChannel;
	private int currentChannel;

	public Television(int minChannel, int maxChannel,
			Set<Integer> blockedChannels) {
		super();
		this.minChannel = minChannel;
		this.maxChannel = maxChannel;
		this.blockedChannels = blockedChannels;
		this.previousChannel = -1;
		this.currentChannel = -1;
	}

	public int getMinChannel() {
		return minChannel;
	}

	public int getMaxChannel() {
		return maxChannel;
	}

	public Set<Integer> getBlockedChannels() {
		return blockedChannels;
	}

	public int getPreviousChannel() {
		return previousChannel;
	}

	public int getCurrentChannel() {
		return currentChannel;
	}

	public void setChannel(int channel) {
		/* 
		 * Change pervious/current channel
		 * Only if the new channel is different
		 * from the current channel.
		 */
		if(channel != currentChannel){
			previousChannel = currentChannel;
			currentChannel = channel;	
		}
		
	}
	
	public boolean isBlocked(int channel){
		return blockedChannels.contains(channel);
	}
	
	/**
	 * Gives the next up channel based on the 
	 * max and min channels and set of blocked 
	 * channels. After max channel next channel
	 * is set to min channel.
	 * @param channel for which next up has to 
	 * be determined.
	 * @return next up channel from the given 
	 * input.
	 */
	public int getUpChannel(int channel) {
		channel++;
		if (channel > maxChannel) {
			channel = minChannel;
		}
		while (isBlocked(channel)) {
			channel++;
			if (channel > maxChannel) {
				channel = minChannel;
			}
		}
		return channel;
	}
	
	/**
	 * Gives the next down channel based on the 
	 * max and min channels and set of blocked 
	 * channels. After min channel next channel
	 * is set to max channel.
	 * @param channel for which next down has to 
	 * be determined.
	 * @return next down channel from the given 
	 * input.
	 */
	public int getDownChannel(int channel){
		channel--;
		if (channel < minChannel) {
			channel = maxChannel;
		}
		while (isBlocked(channel)) {
			channel--;
			if (channel < minChannel) {
				channel = maxChannel;
			}
		}
		return channel;
	}

}