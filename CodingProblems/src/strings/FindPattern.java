package strings;

import java.util.Arrays;
import java.util.Comparator;

public class FindPattern {
	
	//input string > "AAAAABBBCDAAB"
	//pattern -> "AA"
	//determine all the occurrences of p in a string 

	public static void main(String[] args) {
		String str = "AAAABBBCDAAB";
		System.out.println(str.length());
		String pattern = "AA";
		//System.out.println(str.substring(0,4));
		//System.out.println(pattern.length());
		int j =pattern.length();
		int count = 0;
		for(int i = 0; i < str.length()-1; i++) {
			String sub = str.substring(i,j++);
			//System.out.println(sub);
			if(pattern.equals(sub)) {
				System.out.println(sub);
			}
		}
		
		System.out.println(count);
	}
}
