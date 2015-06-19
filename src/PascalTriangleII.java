import java.util.ArrayList;
import java.util.List;

import core.Util;

public class PascalTriangleII {
	public List<Integer> getRow(int rowIndex) {
		List<Integer> ret = new ArrayList<Integer>();
		if (rowIndex == 0) {
			ret.add(1); 
			return ret;
		}
		else if (rowIndex == 1) {
			ret.add(1);
			ret.add(1);
			return ret;
		}
		int[] triangle = new int[rowIndex / 2 + 1];
		triangle[0] = 1;
		for (int i = 1; i <= rowIndex; i++) {
			int prev1 = triangle[0];
			int prev2 = triangle[1];
			if (i % 2 == 0) { 
				for (int j = 1; j < triangle.length && j < i / 2 + 1; j++) {
					if (j == i / 2) {
						triangle[j] = prev1 * 2;
					} else {
						prev2 = triangle[j];
						triangle[j] =prev1 + prev2;
						prev1 = prev2; 
					}
				}
			}
			else { 
				for (int j = 1; j < triangle.length && j < i / 2 + 1; j++) {
					prev2 = triangle[j]; 
					triangle[j] =prev1 + prev2;
					prev1 = prev2; 
				}
			}
		}

		if (rowIndex % 2 == 0) {
			for (int i = 0; i < triangle.length - 1; i++) {
				ret.add(triangle[i]);
			}
			ret.add(triangle[triangle.length - 1]);
			for (int i = triangle.length - 2; i >= 0; i--) {
				ret.add(triangle[i]);
			}
		}
		else {
			for (int i = 0; i < triangle.length; i++) {
				ret.add(triangle[i]);
			}
			for (int i = triangle.length - 1; i >= 0; i--) {
				ret.add(triangle[i]);
			}
		}
		return ret;
	}

	public static void main(String[] args) {
		PascalTriangleII ins = new PascalTriangleII();
		int input = 1;

//		 input = 1;
//		 Util.printInput(input);
//		 Util.printResult(ins.getRow(input).toString(), "[1, 1]");
//		
//		 input = 2;
//		 Util.printInput(input);
//		 Util.printResult(ins.getRow(input).toString(), "[1, 2, 1]");
//		
//		 input = 3;
//		 Util.printInput(input);
//		 Util.printResult(ins.getRow(input).toString(), "[1, 3, 3, 1]");

//		input = 4;
//		Util.printInput(input);
//		Util.printResult(ins.getRow(input).toString(), "[1, 4, 6, 4, 1]");

		input = 5;
		Util.printInput(input);
		Util.printResult(ins.getRow(input).toString(), "[1, 5, 10, 10, 5, 1]");

		input = 6;
		Util.printInput(input);
		Util.printResult(ins.getRow(input).toString(), "[1, 6, 15, 20, 15, 6, 1]");

		input = 7;
		Util.printInput(input);
		Util.printResult(ins.getRow(input).toString(), "[1, 7, 21, 35, 35, 21, 7, 1]");
	}
}
