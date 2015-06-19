import core.Util;


public class ValidPalindrome {
	public boolean isPalindrome(String s) {
		if (s == null || s.length() <= 1) {
			return true;
		}
		int i1, i2;
		i1 = 0;
		i2 = s.length() - 1;
		char c1,c2;
		while (true) {
			while (true) {
				if (i1 >= i2) {
					return true;
				}
				c1 = s.charAt(i1);
				if (c1 >= 'a' & c1 <= 'z') {
					break;
				}
				else if (c1 >= 48 & c1 <= 57) {
					break;
				}
				else if (c1 >= 'A' & c1 <= 'Z') {
					c1 = (char) (c1 + 32);
					break;
				}
				else {
					i1++;
				}
			}
			while (true) {
				if (i1 >= i2) {
					return true;
				}
				c2 = s.charAt(i2);
				if (c2 >= 'a' & c2 <= 'z') {
					break;
				}
				else if (c2 >= 48 & c2 <= 57) {
					break;
				}
				else if (c2 >= 'A' & c2 <= 'Z') {
					c2 = (char) (c2 + 32);
					break;
				}
				else {
					i2--;
				}
			}
			if (c1 != c2) {
				return false;
			}
			i1++;
			i2--;
		}
	}
	
	public static void main(String[] args){
		ValidPalindrome ins = new ValidPalindrome();
		String input =null;
		
		input = "a";
		Util.printInput(input);
		Util.printResult(ins.isPalindrome(input), true);
		
		input = "aa";
		Util.printInput(input);
		Util.printResult(ins.isPalindrome(input), true);
		
		input = "ab";
		Util.printInput(input);
		Util.printResult(ins.isPalindrome(input), false);
		
		input = "aA";
		Util.printInput(input);
		Util.printResult(ins.isPalindrome(input), true);
		
		input = "abb&A";
		Util.printInput(input);
		Util.printResult(ins.isPalindrome(input), true);
		
		input = "abcdefgh*ijkl&mnopqrstuvwxyz ZYXWVUTSRQPONMLKJ&IHGFEDC^BA";
		Util.printInput(input);
		Util.printResult(ins.isPalindrome(input), true);
		
		input = "1a2";
		Util.printInput(input);
		Util.printResult(ins.isPalindrome(input), false);
				
	}
}
