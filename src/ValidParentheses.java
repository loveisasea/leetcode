import java.util.Stack;

import core.Util;

public class ValidParentheses {
	public boolean isValid(String s) { 
		if(s==null || s.length()==0){
			return true;
		}
		else if(s.length()%2==1){
			return false;
		} 
		Stack<Integer> stack = new Stack<Integer>(); 
		for(int i=0;i<s.length();i++){
			char ch = s.charAt(i);
			switch(ch){
			case '[':
			case '{':
			case '(':    
				stack.push(  (int) ch);
				break;
			case ']':
			case '}':
			case ')':
				if(stack.size()==0){
					return false;
				}
				Integer int2 = stack.pop();
				if(int2 +1 == ch || int2+2==ch){
					break;
				}
				else{
					return false;
				}
			}  
		}
		return stack.size()==0;
	}

	public static void main(String[] args) {
		ValidParentheses ins = new ValidParentheses();
		String input=null;
		
//		input = "([)]";
//		Util.printInput(input);
//		Util.printResult(ins.isValid(input), false);
		
		input = "[]";
		Util.printInput(input);
		Util.printResult(ins.isValid(input), true);
		
		input = "[";
		Util.printInput(input);
		Util.printResult(ins.isValid(input), false);
		
		input = "{[()]}";
		Util.printInput(input);
		Util.printResult(ins.isValid(input), true);
		
		input = "{[()]}{[({[()]})]}";
		Util.printInput(input);
		Util.printResult(ins.isValid(input), true);
		
		input = "{[()]{}";
		Util.printInput(input);
		Util.printResult(ins.isValid(input), false);
		
		input = "{[()]}}{}";
		Util.printInput(input);
		Util.printResult(ins.isValid(input), false);
		
		input = "{[()}{}";
		Util.printInput(input);
		Util.printResult(ins.isValid(input), false);
		
		input = "[({(())}[()])]";
		Util.printInput(input);
		Util.printResult(ins.isValid(input), true);
		
	}
	
//	public boolean isValid(String s) { 
//		int step=0 ,i=0,count =0; 
//		while(true){
//			if(i>=s.length()){
//				if(step==0 && count==0){
//					return true;
//				}
//				else{
//					return false;
//				}
//			}
//			char ch = s.charAt(i);
//			switch(ch){
//			case '[':
//			case '{':
//			case '(':
//				if(step==0){
//					count++;
//				}
//				else if(count>=step){
//					return false;
//				}
//				break;
//			case ']':
//			case '}':
//			case ')':
//				if(count>0 && step==0){
//					step=0; 
//				}				
//				step++;
//				if(step>count){
//					return false;
//				}
//				int i2 = i-step*2+1;
//				if(i2<0){
//					return false;
//				}
//				char ch2 = s.charAt(i2);
//				if((ch==')' && ch2 !='(') ||
//				(ch==']' && ch2 !='[') ||
//				(ch=='}' && ch2 !='{') ){
//					return false;
//				} 
//				if(step==count){
//					step=0;
//					count=0;
//				}
//				break;
//			} 
//			i++;
//		}
//	}
}
