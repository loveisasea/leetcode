import java.util.Arrays;

import core.Util;

/*
 Given two sorted integer arrays nums1 and nums2, 
 merge nums2 into nums1 as one sorted array.

 Note:
 You may assume that nums1 has enough space (size that is greater or equal to m + n) 
 to hold additional elements from nums2. The number of elements initialized in nums1 
 and nums2 are m and n respectively.
 */
public class MergeSortedArray {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		// add nums2 to tail of nums1
		for (int i = 0; i < n; i++) {
			nums1[m + i] = nums2[i];
		}

		int i1 = 0, i2 = m;
		while (i1 < m + n && i2 < m + n) {
			// nums1 < nums2: nothing need to change
			if (nums1[i1] <= nums1[i2]) {
				i1++;
			} else {
				// nums2 < nums1: find out next i2end where nums1 < nums2
				int i2end = i2;
				do {
					i2end++;
				} while (i2end < m + n && nums1[i1] > nums1[i2end]);
				// rotate from i1 to i2end by (i2end - i2);
				if(i2end-i1>=1){
					rotate(nums1, i1, i2end, i2end - i2);
				} 
				i1 = i1 + i2end - i2 + 1;
				i2 = i2end;
			}
		}
	}

	final void rotate(int[] nums, int srt, int end, int k) {
		int cnt = 0;
		int init = srt;
		int i = srt;
		int previous = nums[init];
		do {
			if (i + k >= end) {
				i = (i + k) - end + srt;
				int tmp = previous;
				previous = nums[i];
				nums[i] = tmp;
				if (i == init) {
					i++;
					init = i;
					previous = nums[init];
				}
			}
			else {
				i = i + k;
				int tmp = previous;
				previous = nums[i];
				nums[i] = tmp;
			}
			cnt++;
		} while (cnt < end - srt);
	}

	public static void main(String[] args) {
		MergeSortedArray ins = new MergeSortedArray();
		Input input = null;
		int[] result = null;

		input = ins.new Input(new int[] { 1, 2, 3, 0, 0, 0 }, 3, new int[] { 2, 5, 6 }, 3);
		result = new int[] { 1, 2, 2, 3, 5, 6 };
		Util.printInput(input);
		ins.merge(input.nums1, input.m, input.nums2, input.n);
		Util.printResult(Arrays.toString(input.nums1), Arrays.toString(result));

		input = ins.new Input(new int[] { 1, 3, 5, 11, 0, 0, 0, 0 }, 4, new int[] { 2, 4, 6, 10 }, 4);

		input = ins.new Input(new int[] { 1, 5, 6, 0, 0 }, 3, new int[] { 2, 3 }, 2);
		result = new int[] { 1, 2, 3, 5, 6 };
		Util.printInput(input);
		ins.merge(input.nums1, input.m, input.nums2, input.n);
		Util.printResult(Arrays.toString(input.nums1), Arrays.toString(result));

		input = ins.new Input(new int[] { 1, 3, 5, 11, 0, 0, 0, 0 }, 4, new int[] { 2, 4, 6, 10 }, 4);
		result = new int[] { 1, 2, 3, 4, 5, 6, 10, 11 };
		Util.printInput(input);
		ins.merge(input.nums1, input.m, input.nums2, input.n);
		Util.printResult(Arrays.toString(input.nums1), Arrays.toString(result));

	}

	class Input {
		int[] nums1;
		int m;
		int[] nums2;
		int n;

		Input(int[] nums1, int m, int[] nums2, int n) {
			this.nums1 = nums1;
			this.m = m;
			this.nums2 = nums2;
			this.n = n;
		}

		@Override
		public String toString() {
			return String.format("nums1:%s m:%s nums2:%s n:%s",
					Arrays.toString(this.nums1),
					this.m,
					Arrays.toString(this.nums2),
					this.n);
		}

	}
}
