import core.Util;

public class FactorialTrailingZeroes {
	public int trailingZeroes(int n) { 
		int cnt = n/5;
		int ret=0;
		for(int i=1;i<=cnt;i=i*5){
			ret = ret + (cnt -i)/i+1; 
		} 
		return  ret;
	}
	
	public static void main(String[] args) {
		FactorialTrailingZeroes ins = new FactorialTrailingZeroes();
		int input = 5;
		Util.printInput(input);
		Util.printResult(ins.trailingZeroes(input), 1);

		input = 30;
		Util.printInput(input);
		Util.printResult(ins.trailingZeroes(input),7);
		
		input = 2147483647;
		Util.printInput(input);
		Util.printResult(ins.trailingZeroes(input),536870902);
		
		 
	} 
}
