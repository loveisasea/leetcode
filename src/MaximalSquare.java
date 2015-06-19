/*
 Given a 2D binary matrix filled with 0's and 1's, find the largest square containing all 
 1's and return its area.

For example, given the following matrix:

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0
Return 4.
Credits:
Special thanks to @Freezen for adding this problem and creating all test cases.

 */

import java.util.Arrays;
import java.util.BitSet;

import core.Util;

public class MaximalSquare {
	public int maximalSquare(char[][] matrix) {
		if(matrix==null || matrix.length==0){
			return 0;
		}		
		else if(matrix.length==1){
			for(int i=0;i<matrix[0].length;i++){
				if(matrix[0][i]=='1'){
					return 1;
				}
			}
			return 0;
		}
		BitSet[] bsMatrix = new BitSet[matrix.length];

		// init
		int max = 0;
		for (int i = 0; i < matrix.length; i++) {
			BitSet bs = new BitSet(matrix[i].length);
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == '1'){
					bs.set(j);
					max=1;
				}
			}
			bsMatrix[i] = bs;
		}
		if(max==0){
			return max;
		}
		
		for (int i = 1; i < matrix.length; i++) {
			boolean achieve = false;
			for (int j = 0; j < matrix.length - i; j++) {
				bsMatrix[j].and(bsMatrix[j + 1]);
				if (!achieve) {
					int srt = 0, end = 0;
					srt = bsMatrix[j].nextSetBit(0);
					while (srt >= 0) {
						end = bsMatrix[j].nextClearBit(srt);
						if (end == -1) {
							if (bsMatrix[j].size() - srt >= i +1) {
								achieve = true;
							}
							break;
						}
						else if (end - srt >= i +1) {
							achieve = true;
							break;
						} else {
							srt =bsMatrix[j].nextSetBit(end+1);
						}
					} 
				} 
				if (!achieve) {
					bsMatrix[j].clear();
				} else {
					max = i + 1;
				}
			}
			if(!achieve){
				return max*max;
			}
		} 
		return max*max;
	}
	
	public static void main(String[] args){
		MaximalSquare ins  = new MaximalSquare();
		Input input = null;
		
		input = ins.new Input(new char[][]{
				new char[]{'1','0'}});
		Util.printInput(input);
		Util.printResult(ins.maximalSquare(input.charss), 1);
		
		input = ins.new Input(new char[][]{
				new char[]{'0','0'}});
		Util.printInput(input);
		Util.printResult(ins.maximalSquare(input.charss), 0);
		
		input = ins.new Input(new char[][]{
				new char[]{'1','0'},
				new char[]{'0','1'}});
		Util.printInput(input);
		Util.printResult(ins.maximalSquare(input.charss), 1);
		
		input = ins.new Input(new char[][]{
				new char[]{'0','0'},
				new char[]{'0','0'}});
		Util.printInput(input);
		Util.printResult(ins.maximalSquare(input.charss), 0);
		
		
		input = ins.new Input(new char[][]{
				new char[]{'1','0'},
				new char[]{'0','1'}});
		Util.printInput(input);
		Util.printResult(ins.maximalSquare(input.charss), 1);
		
		input = ins.new Input(new char[][]{
				new char[]{'1','1'},
				new char[]{'1','1'}});
		Util.printInput(input);
		Util.printResult(ins.maximalSquare(input.charss), 4);
		
		input = ins.new Input(new char[][]{
				new char[]{'1','0'},
				new char[]{'1','1'}});
		Util.printInput(input);
		Util.printResult(ins.maximalSquare(input.charss), 1);
		
		input = ins.new Input(new char[][]{
				new char[]{'1','0','1','0','0'},
				new char[]{'1','0','1','1','1'},
				new char[]{'1','1','1','1','1'},
				new char[]{'1','1','1','0','0'},
				new char[]{'1','1','1','1','0'}
		});
		Util.printInput(input);
		Util.printResult(ins.maximalSquare(input.charss), 9);
		
	}
	
	class Input{
		char[][] charss;
		public Input(char[][] charss){
			this.charss = charss;
		}
		
		@Override
		public String toString(){
			StringBuilder sb = new StringBuilder();
			for(char[] chars : this.charss){
				sb.append("\n").append(Arrays.toString(chars));
			}
			return sb.toString();
		}
	}
}
