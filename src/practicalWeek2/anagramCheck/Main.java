package practicalWeek2.anagramCheck;

public class Main {

	static boolean anagramCheck(String a, String b) {
		//Set to lowercase in case capitals are used
		a = a.toLowerCase();
		b = b.toLowerCase();
		
		//Remove spaces
		a = a.replace(" ", "");
		b = b.replace(" ", "");
		
		//Length check
		if (a.length() != b.length())
			return false;
		
		//Loop through a, removing a's characters from b
		for (char c : a.toCharArray()) {
			
			int index;
			//Get the index of the current character in b
			if ((index = (int) b.indexOf(c)) != -1) {
				//Remove the current character from b
				b = b.substring(0,index) + b.substring(index+1);
			}
			else {
				return false;
			}
		}
		
		return true;
	}
	
	static void anagramCheckDebug(String a, String b) {
		if (anagramCheck(a, b)) {
			System.out.println(a + " is an anagram of " + b); 
		}
		else {
			System.out.println(a + " is not an anagram of " + b);
		}
	}
	
	public static void main(String[] args) {
		anagramCheckDebug("cat", "atc");
		anagramCheckDebug("cat", "atd");
		anagramCheckDebug("meat", "tea");
	}

}
