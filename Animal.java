package application;

//import java.io.FileNotFoundException;
//import java.util.Scanner;

public class Animal extends Name {
	
	// class variables
	private String habitat;
	private String[] habitats = {	"Desert", "Forest", 
									"Freshwater", "Grassland", 
									"Saltwater", "Tundra"};
	
	private String diet;
	private String[] diets = {"Herbivore", "Carnivore", "Omnivore"};
	
	private String animalName;
	
//	private String animalPath = "name/animal/";
	
	public Animal(int nationInput, int habitatInput, int dietInput) {
		setNation(nationInput);
		setHabitat(habitatInput);
		setDiet(dietInput);
		setName(nationInput, habitatInput, dietInput);
		toString();
	}
	
	
	// setters
	private void setHabitat(int habitatInput) {
		habitat = habitats[habitatInput];
	}
	
	private void setDiet(int dietInput) {
		diet = diets[dietInput];
	}
	
	private void setName(int nationInput, int habitatInput, int dietInput) {
		animalName = "";
		int sylCount = randomSylCount(nationInput);
		
		if (nationInput == WATER) {
			syllables = waterSyls;
		} else if (nationInput == EARTH) {
			syllables = earthSyls;
		} else if (nationInput == FIRE) {
			syllables = fireSyls;
		} else if (nationInput == AIR) {
			syllables = airSyls;
		}
		
		for (int i = 0; i < sylCount; i++) {
			int random = (int) (Math.random() * syllables.length);
			animalName += syllables[random];
		}
		
		// capitalize first letter
		animalName = animalName.substring(0, 1).toUpperCase() + animalName.substring(1);
	}
	
	
	// getters
	private String getHabitat() {
		return habitat;
	}
	
	private String getDiet() {
		return diet;
	}
	
	private String getName() {
		return animalName;
	}
	
	// abstract methods 
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
								"Habitat: " + getHabitat() + "\n" + 
								"Diet: " + getDiet();
		return outputString;
	}
}


	
	// Below is some unnecessary code I decided against implementing
	// but I did not want to delete it, since I may use it in the future.
/*
 	@Override
	protected void accessFile() throws FileNotFoundException {
		String nationString = getNation();
		
		String filePath = animalPath + nationString + ".txt";
		System.out.println(filePath);
		
		
		// fills syllables array with string values from text file line by line
		Scanner input = new Scanner(filePath);
		int i = 0;
		while (input.hasNext()) {
			syllables[i] = input.next();
			System.out.println(syllables[i]);
			i++;
		}
		input.close();
	}
*/
