import core.Util;

public class StringtoInteger {
	public int myAtoi(String str) {
		if (str == null) {
			return 0; // fym
		}
		int sign = 0;
		long ret = 0;
		long minValue = (long) Integer.MIN_VALUE * -1;
		boolean leadingspaceend = false;
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c == ' ') {
				if (leadingspaceend) {
					break;
				}
				continue;
			}
			else {
				leadingspaceend = true;
				if (c == '+') { 
					if (sign != 0) {
						break;
					}
					sign = 1;
					continue;
				}
				else if (c == '-') {
					if (sign != 0) {
						break;
					}
					sign = -1;
					continue;
				}
				int n = c - 48;
				if (n < 0 || n > 9) {
					break;
				}
				if (sign == 0) {
					sign = 1;
				}
				ret = ret * 10 + n;
				if (sign == 1 && ret >= Integer.MAX_VALUE) {
					return Integer.MAX_VALUE;
				}
				else if (sign == -1 && ret >= minValue) {
					return Integer.MIN_VALUE;
				}
			}
		} 
		return (int) (ret * sign);
	}

	public static void main(String[] args) {
		StringtoInteger ins = new StringtoInteger();
		String input = "    -0012a";
		Util.printInput(input);
		Util.printResult(ins.myAtoi(input), -12);

		input = "2147483648";
		Util.printInput(input);
		Util.printResult(ins.myAtoi(input), 2147483647);

		input = "      -11919730356x";
		Util.printInput(input);
		Util.printResult(ins.myAtoi(input), -2147483648);

		input = "+-2";
		Util.printInput(input);
		Util.printResult(ins.myAtoi(input), 0);

		input = "+1";
		Util.printInput(input);
		Util.printResult(ins.myAtoi(input), 1);

		input = "1";
		Util.printInput(input);
		Util.printResult(ins.myAtoi(input), 1);

		input = "   +0 123";
		Util.printInput(input);
		Util.printResult(ins.myAtoi(input), 0);
	}
}
