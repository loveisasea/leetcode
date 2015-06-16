
import core.Util;

public class CountPrimes {
	public int countPrimes(int n) { 
		if (n <= 2) {
			return 0;
		} 
		boolean[] cnts = new boolean[n];
		int p1st = 1;
		for (int i = 2; i < cnts.length; i++) {
			//get the current smallest prime
			for (int k = p1st + 1; k < cnts.length; k++) {
				if (!cnts[k]) {
					p1st = k;
					break;
				}
			}
			//set nonprime for those multiplied by current prime 
			int j = 2;
			while (true) {
				int jind = p1st * j;
				if (jind >= cnts.length) {
					break;
				}
				else {
					cnts[jind] = true;
					j++;
				}
			}
		}
		//calculate the result
		int ret = 0;
		for(int i=2;i<cnts.length;i++){
			if(!cnts[i]){
				ret++;
			}
		}
		return ret;
	}

	// public int countPrimes(int n) {
	// List<Integer> primes = new ArrayList<Integer>();
	// for (int i = 2; i <= n; i++) {
	// boolean isPrime = true;
	// int half = i / 2 + 1;
	// for (Integer existP : primes) {
	// if (existP > half) {
	// break;
	// }
	// int yushu = i % existP;
	// if (yushu == 0) {
	// isPrime = false;
	// break;
	// }
	// }
	// if (isPrime) {
	// primes.add(i);
	// }
	// }
	// return primes.size();
	// }

	public static void main(String[] args) {
		CountPrimes ins = new CountPrimes();

		int input = 1;
		Util.printInput(input);
		Util.printResult(ins.countPrimes(input), 0);

		input = 2;
		Util.printInput(input);
		Util.printResult(ins.countPrimes(input), 0);

		input = 3;
		Util.printInput(input);
		Util.printResult(ins.countPrimes(input), 1);

		input = 4;
		Util.printInput(input);
		Util.printResult(ins.countPrimes(input), 2);

		input = 5;
		Util.printInput(input);
		Util.printResult(ins.countPrimes(input), 2);
		
		input = 19;
		Util.printInput(input);
		Util.printResult(ins.countPrimes(input),7);
		
		input = 20;
		Util.printInput(input);
		Util.printResult(ins.countPrimes(input),8);

		input = 499979;
		Util.printInput(input);
		Util.printResult(ins.countPrimes(input), 41537);

	}
}
