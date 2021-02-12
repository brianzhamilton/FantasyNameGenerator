package application;

// import java.io.FileNotFoundException;

public abstract class Name {
	protected String nation;

	// syllable arrays for generating names
	protected String[] waterSyls = {
			"wis", "toem", "al", "ia", "shi", "she", 
			"sha", "he", "sa", "tse", "ssho", "shta", 
			"sis", "ash", "ez", "rosh", "em", "us", 
			"un", "if", "fen", "its", "uts", "ets", 
			"ats", "ir", "ur", "er", "ar", "uf", "ef", 
			"af"
	};
	protected String[] earthSyls = {
			"mor", "drem", "ad", "elan", "an", "ai",
			"id", "ern", "elm", "grod", "vrim", "ond",
			"iln", "idh", "edh", "im", "un", "en", "ir",
			"iv", "ev", "ver", "in", "em", "idz", "udz",
			"edz", "adz", "pid", "mud", "ded", "nad",
			"pig", "pug", "peg", "nang", "pim", "dum",
			"pem", "dam", "min", "mun", "nen", "ban",
			"ing", "ung", "eng", "ang", "av", "pez",
			"ij", "uj", "ej", "aj", "ed", "gen"
	};
	protected String[] fireSyls = {
			"ktak", "chto", "tek", "ka", "ve", "ef",
			"or", "kin", "kel", "tar", "ak", "is", "us", 
			"es", "as", "iz", "uz", "ez", "eks", "ash", 
			"ar", "et", "tet", "ta", "at", "chu", "itch", 
			"atch", "kurs", "pi", "tsa", "if", "uf", 
			"ef", "af", "ith", "ih", "uh", "peh", "pah",
			"uts", "ut", "tsa", "tse",
	};
	protected String[] airSyls = {
			"iw", "uw", "ew", "aw", "shi", "wu", "phe", 
			"ya", "ship", "hep", "dap", "pit", "put", 
			"yet", "phat", "pem", "if", "uf", "ef", "af", 
			"ith", "uth", "eth", "ath", "pil", "ul", 
			"pel", "al" 
	};
	protected String[] syllables = {};
	
	// constants
	protected int WATER = 0;
	protected int EARTH = 1;
	protected int FIRE = 2;
	protected int AIR = 3;
	
	
	// setter
	protected void setNation(int nationIndex) {	
		if (nationIndex == WATER) {
			nation = "Water";
		} else if (nationIndex == EARTH) {
			nation = "Earth";
		} else if (nationIndex == FIRE) {
			nation = "Fire";
		} else if (nationIndex == AIR) {
			nation = "Air";
		}
	}
	
	
	// getter
	protected String getNation() {
		return nation;
	}
	
	
	// abstract classes that are further defined in subclasses
	protected abstract int randomSylCount(int nationInput);
	
	public abstract String toString();

	//	protected abstract void accessFile() throws FileNotFoundException;
}
