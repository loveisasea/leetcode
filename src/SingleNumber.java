import java.util.Arrays;

import core.Util;


public class SingleNumber {
public int singleNumber(int[] nums) {
        int n = 0xffffffff;
        for(int i : nums){
        	n = ~(n ^ i);
        }
        for(int i : nums){
        	if(n==i){
        		return n;
        	}
        }
        return -1;
    }
	
	
	public static void main(String[] args){
		SingleNumber ins = new SingleNumber();
		int[] input = new int[]{1};
		Util.printInput(Arrays.toString(input));
		Util.printResult(ins.singleNumber(input), 1);
		
		  input = new int[]{2,3,1,3,2};
		Util.printInput(Arrays.toString(input));
		Util.printResult(ins.singleNumber(input), 1);
		
		input = new int[]{2,3,1,4,3,2,4};
		Util.printInput(Arrays.toString(input));
		Util.printResult(ins.singleNumber(input), 1);
		
		input = new int[]{2,3,1,4,3,2,4};
		Util.printInput(Arrays.toString(input));
		Util.printResult(ins.singleNumber(input), 1);
	}
}
