import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import core.Util;

public class TwoSum {
	public int[] twoSum(int[] nums, int target) {
		if (nums == null) {
			return null;
		} 

		// map: <target - value,index>
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			int val = target - nums[i]; 
			map.put(val, i);
		}

		for (int i = 0; i < nums.length; i++) {
			Integer tIndex = map.get(nums[i]);
			if (tIndex != null && i!= tIndex) {
				return new int[] { i + 1, tIndex + 1, };
			}
		}
		return null;
	}

	public static void main(String[] args) {
		TwoSum ins = new TwoSum();
		Input input = null;
		int[] result = null;

		input = ins.new Input(new int[] { 1, 2, 3, 4, 5, 6, 7 }, 7);
		result = new int[] { 1, 6 };
		Util.printInput(input);
		Util.printResult(Arrays.toString(ins.twoSum(input.nums, input.target)), Arrays.toString(result));

	}

	class Input {
		int[] nums;
		int target;

		public Input(int[] nums, int target) {
			this.nums = nums;
			this.target = target;
		}

		@Override
		public String toString() {
			return String.format("nums: %s, target:%s", Arrays.toString(this.nums), this.target);
		}
	}
}
