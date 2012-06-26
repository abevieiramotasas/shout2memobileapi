package com.abe.API.model;

import java.util.List;

public class IslandWrapper {
	private WrapperGambiarra islands;

	private IslandWrapper() {
		this.islands = new WrapperGambiarra();
	}

	public void setIslands(List<IslandIn> islands) {
		this.islands.setIslands(islands);
	}

	public List<IslandIn> getIslands() {
		return islands.getIslands();
	}

	private class WrapperGambiarra {
		private List<IslandIn> islands;

		public void setIslands(List<IslandIn> islands) {
			this.islands = islands;
		}

		public List<IslandIn> getIslands() {
			return islands;
		}
	}

}
