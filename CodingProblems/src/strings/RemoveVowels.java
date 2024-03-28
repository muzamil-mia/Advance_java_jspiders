package strings;

public class RemoveVowels {

	public static void main(String[] args) {
		String str = "computer science students";
		String newStr = "";
//		for(int i = 0; i < str.length(); i++) {
//			char ch = str.charAt(i);
//			if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
//				continue;
//			}else {
//				newStr = newStr + ch;
//			}
//		}
//		System.out.println(newStr);
		
		//using regular expression
		System.out.println(str.replaceAll("[aeiouAEIOU]", ""));
	}

}
