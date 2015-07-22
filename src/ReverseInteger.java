import core.Util;

public class ReverseInteger {
	public int reverse(int x) {
		long xl = x;
		boolean isneg = false;
		if (xl < 0) {
			xl = xl * -1;
			isneg = true;
		}

		long ret = 0;
		do {
			long remainder = xl % 10;
			ret = 10 * ret + remainder;
			xl = xl / 10;
		} while (xl != 0);
		if (!isneg) {
			if (ret > Integer.MAX_VALUE) {
				return 0;
			}
			else {
				return (int) ret;
			}
		}
		else {
			ret = ret * -1;
			if (ret < Integer.MIN_VALUE) {
				return 0;
			}
			else {
				return (int) ret;
			}
		}
	}

	public static void main(String[] args) {
		ReverseInteger ins = new ReverseInteger();
		int input = 123;
		Util.printInput(input);
		Util.printResult(ins.reverse(input), 321);

		input = -1563847412;
		Util.printInput(input);
		Util.printResult(ins.reverse(input), 0);
		
		input = -2147483648;
		Util.printInput(input);
		Util.printResult(ins.reverse(input), 0);
	}
}
