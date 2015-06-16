import core.Util; 
public class RomanToInteger {
	public int romanToInt(String s) {
		char[] chars = s.toCharArray();
		if(chars.length==0){
			return 0;
		}
		int ret = 0; 
		int next =  this.romanCharToInt(chars[0]);
		int length = chars.length;
		for (int i = 0; i < length-1; i++) {
			int curr=next;
			next = this.romanCharToInt(chars[i+1]);
			if(curr>=next){
				ret +=curr;
			}
			else{
				ret -=curr;
			} 
		}
		return ret+next;
	}

	public int romanCharToInt(char c) {
		switch (c) {
		case 'I':
			return 1;
		case 'V':
			return 5;
		case 'X':
			return 10;
		case 'L':
			return 50;
		case 'C':
			return 100;
		case 'D':
			return 500;
		case 'M':
			return 1000;
		default:
			return 0;
		}
	}

	public static void main(String[] args) {
		RomanToInteger ins = new RomanToInteger();
		String input = "IV";
		Util.printInput(input);
		Util.printResult( ins.romanToInt(input), 5);  
	}
}
