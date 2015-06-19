import java.util.Arrays;

import core.Util;



/*
Given a sorted array, remove the duplicates in place such that each element 
appear only once and return the new length.

Do not allocate extra space for another array, you must do this in place with 
constant memory.

For example,
Given input array nums = [1,1,2],

Your function should return length = 2, with the first two elements of nums being 
1 and 2 respectively. It doesn't matter what you leave beyond the new length.
 */
public class RemoveDuplicatesfromSortedArray {
	public int removeDuplicates(int[] nums) {
        if(nums==null ){
        	return 0;
        }
        if(nums.length<=1){
        	return nums.length;
        }
        int i1=0,i2=1;
        int cnt = 1;
        while(i2<nums.length){
        	if(nums[i2]!=nums[i1]){
        		cnt++;
        		i1 ++;
        		if(i1!=i2){
        			nums[i1]=nums[i2];
        		} 
        	}
    		i2++;
        }
        return cnt; 
    }
	
	public static void main(String[] args){
		RemoveDuplicatesfromSortedArray ins = new RemoveDuplicatesfromSortedArray();
		int[] input = null;
		
		input =new int[]{};
		Util.printInput(Arrays.toString(input));
		Util.printResult(ins.removeDuplicates(input), 0);
		Util.printResult(Arrays.toString(input),Arrays.toString(new int[]{}));
		
		
		input =new int[]{1};
		Util.printInput(Arrays.toString(input));
		Util.printResult(ins.removeDuplicates(input), 1);
		Util.printResult(Arrays.toString(input),Arrays.toString(new int[]{1}));
		
		input =new int[]{1,2};
		Util.printInput(Arrays.toString(input));
		Util.printResult(ins.removeDuplicates(input), 2);
		Util.printResult(Arrays.toString(input),Arrays.toString(new int[]{1,2}));
		
		input =new int[]{1,1,2,2,3};
		Util.printInput(Arrays.toString(input));
		Util.printResult(ins.removeDuplicates(input), 3);
		Util.printResult(Arrays.toString(input),Arrays.toString(new int[]{1,2,3,2,3}));
	}
}
