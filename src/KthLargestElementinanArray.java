import java.util.Arrays;

import core.Util;

public class KthLargestElementinanArray {
	public int findKthLargest(int[] nums, int k) {
		int[] cachs = new int[k];
		for(int i=0;i<k;i++){
			cachs[i]=Integer.MIN_VALUE;
		}
		for (int i = 0; i < nums.length; i++) {
			int val = nums[i];
			int srt = 0;
			int end = k - 1;
			int mid = (srt + end) / 2;
			if (val > cachs[0]) {
				mid = 0;
			} else if (val < cachs[k - 1]) {
				continue;
			}
			else {
				while (true) {
					if (end - srt <= 1) {
						mid=end;
						break;
					}
					if (val > cachs[mid]) {
						end = mid;
					} else if (val < cachs[mid]) {
						srt = mid;
					} else {
						break;
					}

					mid = (srt + end) / 2;
				}
			}
			for (int i1 = k - 1; i1 > mid; i1--) {
				cachs[i1] = cachs[i1 - 1];
			}
			cachs[mid] = val;
		}
		return cachs[k - 1];
	}

	public static void main(String[] args) {
		KthLargestElementinanArray ins = new KthLargestElementinanArray();
		Input input = null;

		 input = ins.new Input(new int[]{4,2,6,3,10},1);
		 Util.printInput(input.toString());
		 Util.printResult(ins.findKthLargest(input.nums, input.k), 10);
		
		 input = ins.new Input(new int[]{4,2,6,3,10},2);
		 Util.printInput(input.toString());
		 Util.printResult(ins.findKthLargest(input.nums, input.k), 6);

		input = ins.new Input(new int[] { 4, 2, 6, 3, 10 }, 3);
		Util.printInput(input.toString());
		Util.printResult(ins.findKthLargest(input.nums, input.k), 4);

		input = ins.new Input(new int[] { 4, 2, 6, 3, 10 }, 4);
		Util.printInput(input.toString());
		Util.printResult(ins.findKthLargest(input.nums, input.k), 3);

		input = ins.new Input(new int[] { 4, 2, 6, 3, 10 }, 5);
		Util.printInput(input.toString());
		Util.printResult(ins.findKthLargest(input.nums, input.k), 2);

	}

	class Input {
		int[] nums;
		int k;

		Input(int[] nums, int k) {
			this.nums = nums;
			this.k = k;
		}

		@Override
		public String toString() {
			return String.format("nums:%s  k:%s", Arrays.toString(this.nums), this.k);
		}
	}
}
