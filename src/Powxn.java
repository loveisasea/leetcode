import core.Util;

public class Powxn {
	public double myPow(double x, int n) {
		boolean sign = n > 0;
		if (!sign) {
			n = n * (-1);
		}
		double ret = 1;
		double curr = x;
		while (n != 0) {
			if (n % 2 != 0) {
				ret = ret * curr;
			}
			curr = curr * curr;
			n = n / 2;

		}
		if (!sign) {
			ret = 1 / ret;
		}
		return ret;
	}

	public static void main(String[] args) {
		Powxn ins = new Powxn();
		Input input = null;

		input = ins.new Input(2, 0);
		Util.printInput(input);
		Util.printResult(ins.myPow(input.x, input.n), 1);

		input = ins.new Input(2, 1);
		Util.printInput(input);
		Util.printResult(ins.myPow(input.x, input.n), 2);

		input = ins.new Input(2, 5);
		Util.printInput(input);
		Util.printResult(ins.myPow(input.x, input.n), 32);

		input = ins.new Input(34.00515, -3);
		Util.printInput(input);
		Util.printResult(ins.myPow(input.x, input.n), 0.00003);

	}

	class Input {
		double x;
		int n;

		public Input(double x, int n) {
			this.x = x;
			this.n = n;
		}

		@Override
		public String toString() {
			return String.format("x:%s, n:%s", this.x, this.n);
		}
	}
}
