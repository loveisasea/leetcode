import core.Util;

public class PalindromeNumber {
	public boolean isPalindrome(int x) {
		if (x == 0) {
			return true;
		}
		if (x < 0) {
			return false;
		}
		int len = (int) Math.log10(x) + 1;
		for (int i = 0; i < len / 2; i++) {
			if (this.charAt(x, i) != this.charAt(x, len - i - 1)) {
				return false;
			}
		}

		return true;
	}

	private int charAt(int n, int idx) {
		return (int) ((n / Math.pow(10, idx)) % 10);
	}

	// old method
	// public boolean isPalindrome(int x) {
	// if (x<0){
	// return false;
	// }
	// int x0 = x;
	// int x1 = 0;
	// do {
	// int remainder = x0 % 10;
	// x1 = 10 * x1 + remainder;
	// x0 = x0 / 10;
	// } while (x0 != 0);
	// if(x1 == x){
	// return true;
	// }
	// return false;
	// }

	public static void main(String[] args) {
		PalindromeNumber ins = new PalindromeNumber();
		int input = 0;
		Util.printInput(input);
		Util.printResult(ins.isPalindrome(input), true);

		input = 1;
		Util.printInput(input);
		Util.printResult(ins.isPalindrome(input), true);

		input = 12;
		Util.printInput(input);
		Util.printResult(ins.isPalindrome(input), false);

		input = 11;
		Util.printInput(input);
		Util.printResult(ins.isPalindrome(input), true);

		input = 121;
		Util.printInput(input);
		Util.printResult(ins.isPalindrome(input), true);

		input = Integer.MAX_VALUE;
		Util.printInput(input);
		Util.printResult(ins.isPalindrome(input), false);

		input = Integer.MIN_VALUE;
		Util.printInput(input);
		Util.printResult(ins.isPalindrome(input), false);
	}
}
