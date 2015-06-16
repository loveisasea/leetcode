public class HouseRobber {
	public int rob(int[] nums) {
		if(nums==null || nums.length==0){
			return 0;
		}
		return this.getMaxNum(nums, 0, nums.length - 1);
	}

	private int getMaxNum(int[] nums, int srt, int end) {  
		if(srt>=nums.length){
			srt = nums.length-1;
		}
		if(end>=nums.length){
			end = nums.length-1;
		}
		if(srt<0){
			srt = 0;
		}
		if(end<0){
			end = 0;
		}
		int step = end - srt;
		if (step == 0) {
			return nums[srt];
		}
		else if (step == 1) {
			return nums[srt] > nums[end] ? nums[srt] : nums[end];
		}
		else if (step == 2) {
			int max1 = nums[srt] + nums[end];
			int max2 = nums[srt + 1];
			return max1 > max2 ? max1 : max2;
		}
		else if (step == 3) {
			int max1 = nums[srt] + nums[end];
			int max2 = nums[srt + 1] + nums[end];
			int max3 = nums[srt] + nums[end - 1];
			int max = max1 > max2 ? max1 : max2;
			max = max > max3 ? max : max3;
			return max;
		}
		else { 
			int half = (srt + end) / 2;
			int max1 = getMaxNum(nums, srt, half - 1) + getMaxNum(nums, half + 1, end);
			half++;
			int max2 = getMaxNum(nums, srt, half - 1) + getMaxNum(nums, half + 1, end);
			return max1 > max2 ? max1 : max2;
		}
	}
}
