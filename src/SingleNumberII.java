import java.util.Arrays;

import core.Util;

/*
 Given an array of integers, every element appears three times except for one. 
 Find that single one.

Note:
Your algorithm should have a linear runtime complexity. 
Could you implement it without using extra memory?
 */
public class SingleNumberII {
	//This is copied from others
	public int singleNumber(int[] nums) {
		int one, two, three;
		one = two = three = 0;
		for (int i = 0; i < nums.length; i++)
		{// 一定是出现3次，2次，1次这样的顺序，如果反过来的话，先更新了one的话，会影响到two和three的
			three = two & nums[i];// 已经出现了两次，还出现了一次
			two = two | one & nums[i];// 出现了1次又出现了1次，在加上以前已经出现了2次的，为新的出现了2次的
			one = one | nums[i];// 出现了1次
			// 将出现3次的其出现1次2次全部抹去
			one = one & ~three;
			two = two & ~three;
		}
		return one;
	}
	
	public static void main(String[] args){
		SingleNumberII ins = new SingleNumberII();
		int[] input =null;
		int result = 0;
		
		input = new int[]{111,231,367,231,367,111,18293,367,111,231};
		result = 18293;
		Util.printInput(Arrays.toString(input));
		Util.printResult(ins.singleNumber(input), result);
	}
}
