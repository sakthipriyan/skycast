package com.sakthipriyan.skycast;

import java.util.Set;

public class Television {
	
	private int minChannel;
	private int maxChannel;
	private Set<Integer> blockedChannels;
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
		if(channel != currentChannel){
			previousChannel = currentChannel;
			currentChannel = channel;	
		}
		
	}
	
	public boolean isBlocked(int channel){
		return blockedChannels.contains(channel);
	}

}