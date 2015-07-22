import java.util.ArrayList;
import java.util.List;

import core.Util;

public class PascalTriangle {
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		numRows--;
		if (numRows >= 0) {
			List<Integer> l = new ArrayList<Integer>();
			l.add(1);
			ret.add(l);
		}
		if (numRows == 1) {
			List<Integer> l = new ArrayList<Integer>();
			l.add(1);
			l.add(1);
			ret.add(l); 
		}
		else if (numRows >= 2) {
			int[] triangle = new int[numRows / 2 + 1];
			triangle[0] = 1;
			for (int i = 1; i <= numRows; i++) {
				int prev1 = triangle[0];
				int prev2 = triangle[1];
				if (i % 2 == 0) {
					for (int j = 1; j < triangle.length && j < i / 2 + 1; j++) {
						if (j == i / 2) {
							triangle[j] = prev1 * 2;
						} else {
							prev2 = triangle[j];
							triangle[j] = prev1 + prev2;
							prev1 = prev2;
						}
					}
				}
				else {
					for (int j = 1; j < triangle.length && j < i / 2 + 1; j++) {
						prev2 = triangle[j];
						triangle[j] = prev1 + prev2;
						prev1 = prev2;
					}
				}

				List<Integer> l = new ArrayList<Integer>();
				if (i % 2 == 0) {
					for (int j = 0; j < i/2; j++) {
						l.add(triangle[j]);
					}
					l.add(triangle[i/2]);
					for (int j = i/2 - 1; j >= 0; j--) {
						l.add(triangle[j]);
					}
				}
				else {
					for (int j = 0; j < i/2+1; j++) {
						l.add(triangle[j]);
					}
					for (int j = i/2; j >= 0; j--) {
						l.add(triangle[j]);
					}
				}
				ret.add(l);
			}
		}

		return ret;
	}

	public static void main(String[] args) {
		PascalTriangle ins = new PascalTriangle();
		int input = 1;

//		input = 0;
//		Util.printInput(input);
//		Util.printResult(ins.generate(input).toString(), "[]");
//		
//		input = 1;
//		Util.printInput(input);
//		Util.printResult(ins.generate(input).toString(), "[[1]]");
//
//		input = 2;
//		Util.printInput(input);
//		Util.printResult(ins.generate(input).toString(), "[[1], [1, 1]]");

		input = 3;
		Util.printInput(input);
		Util.printResult(ins.generate(input).toString(), "[[1], [1, 1], [1, 2, 1]]");

		 input = 4;
		 Util.printInput(input);
		 Util.printResult(ins.generate(input).toString(), "[[1], [1, 1], [1, 2, 1], [1, 3, 3, 1]]");

		 input = 5;
		 Util.printInput(input);
		 Util.printResult(ins.generate(input).toString(),
		 "[[1], [1, 1], [1, 2, 1], [1, 3, 3, 1], [1, 4, 6, 4, 1]]");
		//
		// input = 6;
		// Util.printInput(input);
		// Util.printResult(ins.generate(input).toString(),
		// "[1, 6, 15, 20, 15, 6, 1]");
		//
		// input = 7;
		// Util.printInput(input);
		// Util.printResult(ins.generate(input).toString(),
		// "[1, 7, 21, 35, 35, 21, 7, 1]");
	}
}
