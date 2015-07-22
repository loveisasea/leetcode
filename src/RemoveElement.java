/*
 Given an array and a value, remove all instances of that value in place and return the new length.

 The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 */

import java.util.Arrays;

import core.Util;

public class RemoveElement {
	public int removeElement(int[] nums, int val) {
		if (nums == null) {
			return 0;
		}
		else if (nums.length == 0) {
			return 0;
		}

		int srt = 0, end = nums.length - 1;
		int len = nums.length; 
		while (srt <= end) { 
			do{
				if(end==srt){
					if(nums[srt]==val){
						len--; 
					}
					return len; 
				}
				if (nums[end] == val) {
					end--;
					len--;
				} else { 
					break;
				}
			}while(true); 
			while (srt <= end) {
				if (nums[srt] == val) {
					nums[srt] = nums[end];
					srt++;
					len--;
					end--;
					break;
				} else {
					srt++;
				}
			}
		}
		return len;
	}

	public static void main(String[] args) {
		RemoveElement ins = new RemoveElement();
		Input input = null;
		int[] result = null;
		
		input = ins.new Input(new int[] {},1);
		result = new int[]{};
		Util.printInput(input);
		Util.printResult(ins.removeElement(input.nums,input.val), 0);
		Util.printResult(Arrays.toString(input.nums), Arrays.toString(result));
		
		input = ins.new Input(new int[] {1},1);
		result = new int[]{};
		Util.printInput(input);
		Util.printResult(ins.removeElement(input.nums,input.val), 0);
		Util.printResult(Arrays.toString(input.nums), Arrays.toString(result));
		
		input = ins.new Input(new int[] {2},1);
		result = new int[]{2};
		Util.printInput(input);
		Util.printResult(ins.removeElement(input.nums,input.val), 1);
		Util.printResult(Arrays.toString(input.nums), Arrays.toString(result));
		
		input = ins.new Input(new int[] {0,4,4,0,4,4,4,0,2},4);
		result = new int[]{0,2,0,0};
		Util.printInput(input);
		Util.printResult(ins.removeElement(input.nums,input.val), 4);
		Util.printResult(Arrays.toString(input.nums), Arrays.toString(result)); 
	}

	class Input {
		int[] nums;
		int val;

		public Input(int[] nums, int val) {
			this.nums = nums;
			this.val = val;
		}

		@Override
		public String toString() {
			return String.format("nums:%s, val:%s", Arrays.toString(this.nums), this.val);
		}
	}
}
