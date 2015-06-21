/*
 Given a m x n grid filled with non-negative numbers, find a path from top left to 
 bottom right which minimizes the sum of all numbers along its path.

 Note: You can only move either down or right at any point in time.
 */

import java.util.Arrays;

import core.Util;

public class MinimumPathSum {
	public int minPathSum(int[][] grid) {
		if (grid == null || grid.length == 0) {
			return 0;
		}
		int ilen = grid.length;
		int jlen = grid[0].length;

		for (int i = ilen - 2; i >= 0; i--) {
			grid[i][jlen - 1] = grid[i][jlen - 1] + grid[i + 1][jlen - 1];
		}
		for (int j = jlen - 2; j >= 0; j--) {
			grid[ilen - 1][j] = grid[ilen - 1][j] + grid[ilen - 1][j + 1];
		}
		for (int i = ilen - 2; i >= 0; i--) {
			for (int j = jlen - 2; j >= 0; j--) {
				grid[i][j] = grid[i][j] + (grid[i + 1][j] < grid[i][j + 1] ? grid[i + 1][j] : grid[i][j + 1]);
			}
		}
		return grid[0][0];
	}

	public static void main(String[] args) {
		MinimumPathSum ins = new MinimumPathSum();
		Input input = null;

		input = ins.new Input(new int[][] {
				new int[] { 1 }
		});
		Util.printInput(input);
		Util.printResult(ins.minPathSum(input.grid), 1);

		input = ins.new Input(new int[][] {
				new int[] { 1, 0, 1, 0, 0 }
		});
		Util.printInput(input);
		Util.printResult(ins.minPathSum(input.grid), 2);

		input = ins.new Input(new int[][] {
				new int[] { 0 },
				new int[] { 1 },
				new int[] { 1 },
				new int[] { 0 },
				new int[] { 0 }
		});
		Util.printInput(input);
		Util.printResult(ins.minPathSum(input.grid), 2);

		input = ins.new Input(new int[][] {
				new int[] { 1, 0, 1, 0, 0 },
				new int[] { 1, 0, 1, 1, 1 },
				new int[] { 1, 1, 1, 1, 1 },
				new int[] { 1, 1, 1, 0, 0 },
				new int[] { 1, 1, 1, 1, 0 }
		});
		Util.printInput(input);
		Util.printResult(ins.minPathSum(input.grid), 4);

	}

	class Input {
		int[][] grid;

		public Input(int[][] grid) {
			this.grid = grid;
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			for (int[] is : this.grid) {
				sb.append("\n").append(Arrays.toString(is));
			}
			return sb.toString();
		}
	}
}
