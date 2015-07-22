import java.util.Arrays;

import core.Util;

public class RotateArray {
	public void rotate(int[] nums, int k) {		
		if (nums==null || nums.length <= 1) {
			return;
		}
		k = k % nums.length;
		if (k == 0) {
			return;
		} 
		int cnt = 0;
		int init = 0;
		int i=0; 
		int previous = nums[init]; 
		do{ 
			if(i+k>=nums.length){
				i = (i+k) - nums.length;
				int tmp = previous;
				previous = nums[i];
				nums[i] = tmp; 
				if(i==init){
					i++;
					init = i;
					previous=nums[init];
				}
			} 
			else{
				i=i+k;
				int tmp = previous;
				previous = nums[i];
				nums[i] = tmp; 
			} 
			cnt++;
		}while (cnt<nums.length); 
	}

	// misunderstand the question
	// public void rotate(int[] nums, int k) {
	// k=k+1;
	// int len = nums.length;
	// for (int i = 0; i * k < len; i++) {
	// for (int j = i * k; j < i*k + k/2; j++) {
	// int j2 = 2*i*k+k-j-1;
	// if(j2>len-1){
	// break;
	// }
	// int temp = nums[j];
	// nums[j] = nums[j2];
	// nums[j2] = temp;
	// }
	// }
	// for (int i = 0; i < len / 2; i++) {
	// int temp = nums[i];
	// nums[i] = nums[len - i - 1];
	// nums[len - i - 1] = temp;
	// }
	// }

	public static void main(String[] args) {
		RotateArray ins = new RotateArray();

		int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		Input input = ins.new Input(nums, 2);
		int[] results = { 9, 10,1, 2, 3, 4, 5, 6, 7, 8 };
		Util.printInput(input);
		ins.rotate(input.nums, input.k);
		Util.printResult(Arrays.toString(input.nums), Arrays.toString(results));

	}

	class Input {
		int[] nums;
		int k;

		public Input(int[] nums, int k) {
			this.nums = nums;
			this.k = k;
		}

		@Override
		public boolean equals(Object oth) {
			if (oth == null) {
				return false;
			}
			return this.toString().equals(oth.toString());
		}

		@Override
		public String toString() {
			String numString = null;
			if (nums != null) {
				StringBuilder sb = new StringBuilder();
				sb.append("[");
				for (int i = 0; i < nums.length - 1; i++) {
					sb.append(nums[i]);
					sb.append(",");
				}
				sb.append(nums[nums.length - 1]);
				sb.append("]");
				numString = sb.toString();
			}
			return String.format("nums:%s, k:%s", numString, this.k);
		}

	}
}
