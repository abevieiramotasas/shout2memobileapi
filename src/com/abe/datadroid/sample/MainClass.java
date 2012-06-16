package com.abe.datadroid.sample;

import java.util.List;

import com.abe.API.Shout2Me;
import com.abe.API.model.IslandIn;

public class MainClass {

	public static void main(String[] args) {

		List<IslandIn> islands = null;
		try {
			Double longitude = 10.12;
			Double latitude = 20.23;
			Double distance = 1000000.0;
			Integer max_results = 20;
			islands = Shout2Me.getIslands(longitude, latitude, distance,
					max_results);
		} catch (Exception e) {

		}
		for (IslandIn i : islands) {
			System.out.println(i);
		}
	}

}
