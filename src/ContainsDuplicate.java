import java.util.HashSet;
import java.util.Set;

import core.Util;

public class ContainsDuplicate {
	public boolean containsNearbyDuplicate(int[] nums ) {
		if (nums == null) {
			return false;
		} 
		int length = nums.length;
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < length; i++) {
			int n = nums[i]; 
			if(!set.contains(n)){
				set.add(n);
			} else{
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		ContainsDuplicate ins = new ContainsDuplicate();
		int[] nums = { 1, 2, 3, 4, 5, 6, 7, 1 };
		Input input = ins.new Input(nums );
		Util.printInput(input);
		Util.printResult(ins.containsNearbyDuplicate(input.nums ), true);
	}
	
	class Input {
		public int[] nums; 

		public Input(int[] nums ) {
			this.nums = nums; 
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
			return String.format("nums:%s ", numString );
		}
	}
}


