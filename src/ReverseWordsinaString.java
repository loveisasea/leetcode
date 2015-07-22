import core.Util;

/*
 Given an input string, reverse the string word by word.

 For example,
 Given s = "the sky is blue",
 return "blue is sky the".

 Update (2015-02-12):
 For C programmers: Try to solve it in-place in O(1) space.

 click to show clarification.

 Clarification:
 What constitutes a word?
 A sequence of non-space characters constitutes a word.
 Could the input string contain leading or trailing spaces?
 Yes. However, your reversed string should not contain leading or trailing spaces.
 How about multiple spaces between two words?
 Reduce them to a single space in the reversed string.
 */

public class ReverseWordsinaString {
	public String reverseWords(String s) {
		String s1 = s.trim();
		if(s1.length()==0){
			return s1;
		}
		//reverse in whole string
		char[] chars = s1.toCharArray();
		int halflen = chars.length / 2;
		for (int i = 0; i < halflen; i++) {
			char tmp = chars[i];
			chars[i] = chars[chars.length - i - 1];
			chars[chars.length - i - 1] = tmp;
		}
		
		//reverse again for each word
		int i1 = 0;
		int i2 = -1;
		boolean loopend = false;
		while (true) { 
			i1 = i2 + 1;
			while(true){
				if(i1>=chars.length){
					loopend=true;
					break;
				}
				if(chars[i1]!=' '){
					break;
				}
				i1++;
			} 
			if(loopend){
				break;
			}
			i2 = i1 + 1;
			while(true){
				if(i2>=chars.length){
					break;
				}
				if(chars[i2]==' '){
					break;
				}
				i2++;
			} 
			int tend = i1 + (i2 - i1) / 2;
			for (int i = i1; i < tend; i++) {
				char tmp = chars[i];
				chars[i] = chars[i2 - 1 + i1 - i];
				chars[i2 - 1 + i1 - i] = tmp;
			}
		}
		
		//remove repeat white space 
		int i = 0;
		int inew  = 0;
		char prev = chars[0];
		boolean space = false;
		while(i<chars.length){
			if(!space){
				if(chars[i] == ' '){
					space=true;
				}
				chars[inew++] = chars[i++];  
			} 
			else{
				if(chars[i] == ' '){
					i++;
				}else{
					space= false;
					chars[inew++] = chars[i++];  
				}
			}
		}
		return String.valueOf(chars,0,inew);
	}

	public static void main(String[] args) {
		ReverseWordsinaString ins = new ReverseWordsinaString();
		String input = "hi doggy man  how2 old are you";
		Util.printResult(ins.reverseWords(input), "you are old how2 man doggy hi");
	}
}
