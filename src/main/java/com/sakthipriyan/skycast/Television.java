package com.sakthipriyan.skycast;

import java.util.Set;

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
		if(channel != currentChannel){
			previousChannel = currentChannel;
			currentChannel = channel;	
		}
		
	}
	
	public int getUpChannel(int channel) {
		channel++;
		if (channel > maxChannel) {
			channel = minChannel;
		}
		while (blockedChannels.contains(channel)) {
			channel++;
			if (channel > maxChannel) {
				channel = minChannel;
			}
		}
		return channel;
	}
	
	public int getDownChannel(int channel){
		channel--;
		if (channel < minChannel) {
			channel = maxChannel;
		}
		while (blockedChannels.contains(channel)) {
			channel--;
			if (channel < minChannel) {
				channel = maxChannel;
			}
		}
		return channel;
	}

}