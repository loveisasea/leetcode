import core.Util;

public class Sqrtx {
//	public int mySqrt(int x) { 
//		
//	}
	
	//超時
	public int mySqrt(int x) { 
		int val = 0;
		int offset = x ; 
		int[] tmp = new int[]{-1,-1};		
		do{  
			long n =  (long)val * val;
			if (n == x) {
				return val;
			}  
			offset = offset / 2;
			if(offset==0){
				offset = 1;
			} 
			
			if(n>x){
				val = val - offset;
			}
			else{				
				val = val + offset;
			} 
			if(val==tmp[0]){
				while((long)val*val>n){
					val--;
				} 
				return val; 
			}
			else{
				tmp[0]=tmp[1];
				tmp[1] = val;
			}
		}while(true); 
	}
	
	public static void main(String[] args){
		Sqrtx ins = new Sqrtx();
		int input = 0;
		
		input = 0;
		Util.printInput(input);
		Util.printResult(ins.mySqrt(input), 0);
		
		input = 1;
		Util.printInput(input);
		Util.printResult(ins.mySqrt(input), 1);
		
		input = 2;
		Util.printInput(input);
		Util.printResult(ins.mySqrt(input), 1);
		
		input = 4;
		Util.printInput(input);
		Util.printResult(ins.mySqrt(input), 2);
		
		input = 8;
		Util.printInput(input);
		Util.printResult(ins.mySqrt(input), 2);
		
		input = 9;
		Util.printInput(input);
		Util.printResult(ins.mySqrt(input), 3);
		
		input = 16;
		Util.printInput(input);
		Util.printResult(ins.mySqrt(input), 4);
		
		input = 25;
		Util.printInput(input);
		Util.printResult(ins.mySqrt(input), 5);
		
		input = 36;
		Util.printInput(input);
		Util.printResult(ins.mySqrt(input), 6);
		
		
		input = 2147483647;
		Util.printInput(input);
		Util.printResult(ins.mySqrt(input), -1);
		
	}
}
