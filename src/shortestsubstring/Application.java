package shortestsubstring;

import java.util.Scanner;

public class Application {

	private static Scanner scanner;

	public static void main(String[] args) {
		
		scanner = new Scanner(System.in);	
		String input = scanner.nextLine();	
		String substring = shortestSubstring(input);
		System.out.println(substring.length());		
	}

	private static String shortestSubstring(String input) {
		int distinctCharacters = countDistinctCharacters(input);
		int testLength = distinctCharacters;
		boolean found = false;
		String testSubstring = input;
		
		while (!found && testLength<input.length()) {
			for (int start = 0; start+testLength <= input.length(); start++) {
				testSubstring = input.substring(start, start+testLength);
				int distinctCharactersInSubstring = countDistinctCharacters(testSubstring);
				if (distinctCharactersInSubstring == distinctCharacters) {
					found = true;
					break;
				}
			}
			testLength++;
		}
		return testSubstring;
	}

	private static int countDistinctCharacters(String input) {
		int distinctCharsCount = 0;
		
		for (int i = 0; i < input.length(); i++) {
			boolean hasMoreOfThisLetter = false;
			
			for (int j = i; j < input.length(); j++) {
				if (j != i && input.charAt(j) == input.charAt(i)) {
					hasMoreOfThisLetter = true;
				}
			}
			
			if (!hasMoreOfThisLetter) {
				distinctCharsCount++;
			}			
		}
		return distinctCharsCount;
	}
}
