package application;

public class Person extends Name {
	
	// variables
	private String gender;
	private String firstName;
	private String lastName;
	private String fullName;
	
	// syllable arrays for generating the endings of names
	private String[] femEndings = {	"ia", "yeh", "ai", "on"};
	private String[] mascEndings = {	"ed", "urs", "ve", "us"};
	private String[] familyEndings = {	"toem", "selm", "veder", "durn",
										"kroef", "icht", "ildrum", "its", 
										"yets", "ved"};
	
	// constructor
	public Person(int genderInput, int nationInput) {
		setNation(nationInput);
		setGender(genderInput);
		setFirstName(genderInput, nationInput);
		setLastName(nationInput);
		setFullName(nationInput, getFirstName(), getLastName());
		toString();
	}

	// setters
	
	// converts input to String for output
	private void setGender(int genderInput) {
		if (genderInput == 0) {
			gender = "Male";
		} else if (genderInput == 1) {
			gender = "Female";
		}
	}
	
	// creates first name
	private void setFirstName(int genderInput, int nationInput) {
		firstName = "";
		int sylCount = randomSylCount(nationInput);
				
		// determines which set of syllables from superclass to use
		// based upon which nation was selected
		if (nationInput == WATER) {
			syllables = waterSyls;
		} else if (nationInput == EARTH) {
			syllables = earthSyls;
		} else if (nationInput == FIRE) {
			syllables = fireSyls;
		} else if (nationInput == AIR) {
			syllables = airSyls;
		}
		
		
		// first determines if user selected male
		if (genderInput == 0) {
			for (int i = 0; i < sylCount; i++) {
				
				// if on last syllable, use masculine name ending
				if (i == (sylCount - 1)) {
					int random = (int) (Math.random() * mascEndings.length);
					firstName += mascEndings[random];
				} else {
					int random = (int) (Math.random() * syllables.length);
					firstName += syllables[random];
				}
			}
			
		// if user selected female
		} else if (genderInput == 1) {
			for (int i = 0; i < sylCount; i++) {
				
				// if on last syllable, use feminine name ending
				if (i == (sylCount - 1)) {
					int random = (int) (Math.random() * femEndings.length);
					firstName += femEndings[random];
				} else {
					int random = (int) (Math.random() * syllables.length);
					firstName += syllables[random];
				}
			}
		}

		// capitalizes first letter of the name
		firstName = firstName.substring(0, 1).toUpperCase()	+ firstName.substring(1);
	}
	
	// creates last name
	private void setLastName(int nationInput) {
		lastName = "";
		int sylCount = randomSylCount(nationInput);
		
		// determines which set of syllables from superclass to use
		// based upon which nation was selected
		if (nationInput == WATER) {
			syllables = waterSyls;
		} else if (nationInput == EARTH) {
			syllables = earthSyls;
		} else if (nationInput == FIRE) {
			syllables = fireSyls;
		} else if (nationInput == AIR) {
			syllables = airSyls;
		}
		
		// changes last syllable 
		for (int i = 0; i < sylCount; i++) {
		
			// if on last syllable, use family ending
			if (i == (sylCount)) {
				int random = (int) (Math.random() * familyEndings.length);
				lastName += familyEndings[random];
			} else {
				int random = (int) (Math.random() * syllables.length);
				lastName += syllables[random];
			}
		}
		
		// capitalizes first letter of name
		lastName = lastName.substring(0, 1).toUpperCase()	+ lastName.substring(1);
	}
	
	// sets the first name and family name order based upon nation
	private void setFullName(int nationInput, String firstName, String lastName) {
		
		// some nations change the order between the first and last names
		if (nationInput == WATER || nationInput == FIRE || nationInput == AIR) {
			fullName = firstName + " " + lastName;
		} else if (nationInput == EARTH) {
			fullName = lastName + " " + firstName;
		}
	}
	
	// getters
	private String getGender() {
		return gender;
	}
	
	private String getFirstName() {
		return firstName;
	}
	
	private String getLastName() {
		return lastName;
	}
	
	private String getFullName() {
		return fullName;
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
		String outputString = 	"Name: " + getFullName() + "\n" +
								"Gender: " + getGender() + "\n" +
								"Nation: " + getNation();
		return outputString;
	}
}
