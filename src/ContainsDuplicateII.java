import java.util.HashMap;
import java.util.Map;

import core.Util;

public class ContainsDuplicateII {
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		if (nums == null) {
			return false;
		}
		if (k <= 0) {
			return false;
		} 
		int length = nums.length;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < length; i++) {
			int n = nums[i];
			Integer m = map.get(n);
			if(m==null){
				map.put(n, i);
			} else{
				if(i-m<=k){
					return true;
				}
				else{
					map.put(n, i);
				}
			}
		}
		return false;
	}
	
	class Input {
		public int[] nums;
		public int k;

		public Input(int[] nums, int k) {
			this.nums = nums;
			this.k = k;
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

	public static void main(String[] args) {
		ContainsDuplicateII ins = new ContainsDuplicateII();
		int[] nums = { 1, 2, 3, 4, 5, 6, 7, 1 };
		Input input = ins.new Input(nums, 8);
		Util.printInput(input);
		Util.printResult(ins.containsNearbyDuplicate(input.nums, input.k), true);
	}
}


