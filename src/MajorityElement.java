import java.util.Arrays;

import core.Util;

public class MajorityElement {
	public int majorityElement(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		 int ret = nums[0];
		 int cnt = 1;
		 for( int i=1;i<nums.length;i++){
			 if(nums[i]==ret){
				 cnt++;
			 }
			 else if(cnt>1){
				 cnt--;
			 }
			 else{
				 ret = nums[i];
			 }
		 }
		 return ret;
	}

//	public int majorityElement(int[] nums) {
//		if (nums == null || nums.length == 0) {
//			return 0;
//		}
//		Map<Integer, Integer> cnts = new HashMap<Integer, Integer>();
//		for (int i : nums) {
//			Integer cnt = cnts.get(i);
//			if (cnt == null) {
//				cnt = 0;
//			}
//			cnt++;
//			if (cnt > nums.length / 2) {
//				return i;
//			}
//			cnts.put(i, cnt);
//		}
//		return -1;
//	}

	public static void main(String[] args) {
		MajorityElement ins = new MajorityElement();
		int[] input = new int[]{ 6, 6, 6, 7, 7 };
		Util.printInput(Arrays.toString(input));
		Util.printResult(ins.majorityElement(input), 6);
		
		input = new int[]{ -1,100,2,100,100,4,100};
		Util.printInput(Arrays.toString(input));
		Util.printResult(ins.majorityElement(input), 100);

	}
}
