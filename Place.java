package application;

public class Place extends Name {
	
	// class variables
	private String region;
	private String[] regions = {	"North", "South",
									"East", "West"};
	
	private String climate;
	private String[] climates = {"Dry", "Humid"};
	
	private String terrain;
	private String[] terrains = {	"Desert", "Forest",
									"Freshwater", "Grassland",
									"Saltwater", "Tundra"};
	private String placeName;
	
	// constructor
	public Place(int nationInput, int regionInput, int climateInput, int terrainInput) {
		setNation(nationInput);
		setRegion(regionInput);
		setClimate(climateInput);
		setTerrain(terrainInput);
		setName(nationInput, regionInput, climateInput, terrainInput);
		toString();
	}
	
	// setters
	private void setRegion(int regionInput) {
		region = regions[regionInput];
	}
	
	private void setClimate(int climateInput) {
		climate = climates[climateInput];
	}
	
	private void setTerrain(int terrainInput) {
		terrain = terrains[terrainInput];
	}
	
	// creates place name
	private void setName(int nationInput, int regionInput, int climateInput, int terrainInput) {
		placeName = "";
		int sylCount = randomSylCount(nationInput);
		
		
		// determines which array of syllables from superclass to use
		// based upon nation
		if (nationInput == WATER) {
			syllables = waterSyls;
		} else if (nationInput == EARTH) {
			syllables = earthSyls;
		} else if (nationInput == FIRE) {
			syllables = fireSyls;
		} else if (nationInput == AIR) {
			syllables = airSyls;
		}
		
		// randomly chooses and joins them together
		for (int i = 0; i < sylCount; i++) {
			int random = (int) (Math.random() * syllables.length);
			placeName += syllables[random];
		}
		
		// capitalizes first letter of name
		placeName = placeName.substring(0, 1).toUpperCase() + placeName.substring(1);
	}
	
	// getters
	private String getRegion() {
		return region;
	}
	
	private String getClimate() {
		return climate;
	}
	
	private String getTerrain() {
		return terrain;
	}
	
	private String getName() {
		return placeName;
	}

	@Override
	protected int randomSylCount(int nationInput) {
		int sylCount = 0;
		
		// random number out of a hundred
		int random = (int) (Math.random() * 100 + 1);
		
		// Different nations have different averages for how many syllables are in a name
		// the random integer out of a hundred determines what number of syllables the name has,
		// based upon percentages of syllable counts between nations
		
		// if nation is "Water"
		if (nationInput == WATER) {
			
			// randomly generated name has 10% chance of being one syllable
			if (random > 0 && random <= 10) {
				sylCount = 1;
				
			// randomly generated name has 30% chance of being two syllables
			} else if (random > 10 && random <= 40) {
				sylCount = 2;
				
			// randomly generated name has 60% chance of being three syllables
			} else if (random > 40 && random <= 100) {
				sylCount = 3;
			}
			
		// if nation is "Earth"
		} else if (nationInput == EARTH) {
			
			// 35% chance of one syllable
			if (random > 0 && random <= 35) {
				sylCount = 1;
			
			// 55% chance of two syllables
			} else if (random > 35 && random <= 90) {
				sylCount = 2;
				
			// 10% chance of three syllables
			} else if (random > 90 && random <= 100) {
				sylCount = 3;
			}
		
		// if nation is "Fire"
		} else if (nationInput == FIRE) {
			
			// 30% chance of one syllable
			if (random > 0 && random <= 30) {
				sylCount = 1;
			
			// 40% chance of two syllables
			} else if (random > 30 && random <= 70) {
				sylCount = 2;
				
			// 30% chance of three syllables
			} else if (random > 70 && random <= 100) {
				sylCount = 3;
			}
			
		// if nation is "Air"
		} else if (nationInput == AIR) {
			
			// 20% chance of one syllable
			if (random > 0 && random <= 20) {
				sylCount = 1;
			
			// 30% chance of two syllables
			} else if (random > 20 && random <= 50) {
				sylCount = 2;
				
			// 50% chance of three syllables
			} else if (random > 50 && random <= 100) {
				sylCount = 3;
			}
			
		}
		
		return sylCount;
	}

	@Override
	public String toString() {
		String outputString = 	"Name: " + getName() + "\n" + 
								"Nation: " + getNation() + "\n" + 
								"Region: " + getRegion() + "\n" + 
								"Climate: " + getClimate() + "\n" +
								"Terrain: " + getTerrain();
		return outputString;
	}
}
