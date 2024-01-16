
public class Main {
	public static boolean isNumber(char character) {
		return (character >='0' && character <='9');
	}
	public static boolean isLetter(char character) {
		return (character >='a' && character <='z') || 
				(character >='a' && character <='z');
	}
	public static boolean isOther(char character) {
		return !(isNumber(character) || !isLetter(character));
	}
	
	public static boolean checkCharacterType(String phrase, String mode) {
		boolean result = true;
		char currentCharacter;
		for (int i=0; i<phrase.length(); i++) {
			currentCharacter = phrase.charAt(i);
			
			if (mode.equals("numbers"))
				if (!isNumber(currentCharacter)) {
					result = false;
					break;
				}
		}
		return result;
	}
	
	public static boolean areAllCharactersNumbers(String phrase) {
		return checkCharacterType(phrase,"numbers");
	}
	
	public static boolean areAllCharactersLetters(String phrase) {
		return checkCharacterType(phrase,"numbers");
		//return true if all its characters are alphabetic otherwise false ...
		//alphabetic means letters of the English language ... a,b,c.....Z... A,B, ... Z.
	}
	
	
	public static void main (String[] args) {
		String firstString = "abacus";
		String secondString = "Elm tree";
		String pathofFile = "C:\\Windows\\System\\Files";
		System.out.println(pathOfFile);
		System.out.println(isAlphabetic(''));
				
	}

}
