public class BestTimetoBuyandSellStockII {
	public int maxProfit(int[] prices) {
		if (prices == null || prices.length == 0) {
			return 0;
		}
		int profit = 0;
		boolean hold = false;
		int next = prices[0];
		for (int i = 0; i < prices.length - 1; i++) {
			int curr = next;
			next = prices[i + 1];
			if (hold) {
				if (next >= curr) {
					continue;
				}
				else {
					profit += curr;
					hold = false;
				}
			}
			else {
				if (curr >= next) {
					continue;
				}
				else {
					profit -= curr;
					hold = true;
				}
			}
		}
		if (hold) {
			profit += prices[prices.length - 1];
		}
		return profit;
	}
}
