package com.sakthipriyan.skycast.models;

import java.util.Set;

public class Television {
	private int minChannel;
	private int maxChannel;
	private Set<Integer> blockedChannels;

	public Television(int minChannel, int maxChannel,
			Set<Integer> blockedChannels) {
		super();
		this.minChannel = minChannel;
		this.maxChannel = maxChannel;
		this.blockedChannels = blockedChannels;
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

}