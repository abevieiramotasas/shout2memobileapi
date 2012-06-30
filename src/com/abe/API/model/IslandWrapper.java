package com.abe.API.model;

import java.util.List;

public class IslandWrapper {
	private List<IslandIn> islands;

	public void setIslands(List<IslandIn> islands) {
		this.islands = islands;
	}

	public List<IslandIn> getIslands() {
		return islands;
	}

}
