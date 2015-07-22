/*
 * 
Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
A solution set is: 
[1, 7] 
[1, 2, 5] 
[2, 6] 
[1, 1, 6] 
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

import core.Util;

public class CombinationSumII {
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Arrays.sort(candidates);
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		Stack<Integer> stack = new Stack<Integer>();
		this.recurGetSum(candidates, 0, stack, target, ret);
		// Collections.sort(ret, new Comparator<List<Integer>>(){
		//
		// @Override
		// public int compare(List<Integer> o1, List<Integer> o2) {
		// if(o1==null && o2==null){
		// return 0;
		// }
		// if(o1==null){
		// return -1;
		// }
		// else if(o2==null){
		// return 1;
		// }
		// else {
		// if(o1.size()==0 && o2.size()==0){
		// return 0;
		// }
		// else if(o1.size()==0){
		// return -1;
		// }
		// else if(o2.size()==0){
		// return 1;
		// }else{
		// int i1= 0;
		// int i2=0;
		// if(i1)
		// if()
		// }
		//
		// }
		// }
		//
		// });
		return ret;

	}

	public void recurGetSum(int[] candidates, int idx, Stack<Integer> stack, int target, List<List<Integer>> ret) {
		int clen = candidates.length;
		int i = idx;
		while (i < clen) {
			int val = candidates[i];
			if (i > 0 && val == candidates[i - 1] && (stack.size()==0 || stack.peek() != val)) {
				i++;
				continue;
			}
			else if (val == target) {
				List<Integer> list = new ArrayList<Integer>();
				list.add(val);
				Iterator<Integer> iter = stack.iterator();
				while (iter.hasNext()) {
					list.add(iter.next());
				}
				Collections.sort(list);
				ret.add(list);
				break;
			}
			else if (val > target) {
				break;
			}
			else {
				stack.push(val);
				this.recurGetSum(candidates, i + 1, stack, target - val, ret);
			}
			i++;
		}
		if (stack.size() > 0) {
			stack.pop();
		}
	}

	// class Node {
	// int idx;
	// Node prev;
	// Node[] nexts;
	//
	// public Node(int idx, Node prev, int cnt) {
	// this.idx = idx;
	// this.prev = prev;
	// this.nexts = new Node[cnt];
	// }
	// }

	public static void main(String[] args) {
		CombinationSumII ins = new CombinationSumII();
		Input input = null;
		List<List<Integer>> result = null;

		
//		 input = ins.new Input(new int[] { 2, 3, 6, 7 }, 6);
//		 result = new ArrayList<List<Integer>>();
//		 result.add(new ArrayList<Integer>());
//		 result.get(0).add(6);
//		 Util.printInput(input);
//		 Util.printResult(ins.combinationSum2(input.candidates, input.target),
//		 result);
//		
//		 input = ins.new Input(new int[] { 2 }, 2);
//		 result = new ArrayList<List<Integer>>();
//		 result.add(new ArrayList<Integer>());
//		 result.get(0).add(2);
//		 Util.printInput(input);
//		 Util.printResult(ins.combinationSum2(input.candidates, input.target),
//		 result);
//		
//		 input = ins.new Input(new int[] { 1, 2, 3 }, 3);
//		 result = new ArrayList<List<Integer>>();
//		 result.add(new ArrayList<Integer>());
//		 result.get(0).add(1);
//		 result.get(0).add(2);
//		 result.add(new ArrayList<Integer>());
//		 result.get(1).add(3);
//		 Util.printInput(input);
//		 Util.printResult(ins.combinationSum2(input.candidates, input.target),
//		 result);
//		
//		 input = ins.new Input(new int[] { 1, 1 }, 1);
//		 result = new ArrayList<List<Integer>>();
//		 result.add(new ArrayList<Integer>());
//		 result.get(0).add(1);
//		 Util.printInput(input);
//		 Util.printResult(ins.combinationSum2(input.candidates, input.target),
//		 result);
//		
//		input = ins.new Input(new int[] { 1, 1 }, 2);
//		result = new ArrayList<List<Integer>>();
//		result.add(new ArrayList<Integer>());
//		result.get(0).add(1);
//		result.get(0).add(1);
//		Util.printInput(input);
//		Util.printResult(ins.combinationSum2(input.candidates, input.target), result);
//
//		input = ins.new Input(new int[] { 10, 1, 2, 7, 6, 1, 5 }, 8);
//		result = new ArrayList<List<Integer>>();
//		result.add(new ArrayList<Integer>());
//		result.get(0).add(1);
//		result.get(0).add(1);
//		result.get(0).add(6);
//		result.add(new ArrayList<Integer>());
//		result.get(1).add(1);
//		result.get(1).add(2);
//		result.get(1).add(5);
//		result.add(new ArrayList<Integer>());
//		result.get(2).add(1);
//		result.get(2).add(7);
//		result.add(new ArrayList<Integer>());
//		result.get(3).add(2);
//		result.get(3).add(6);
//		Util.printInput(input);
//		Util.printResult(ins.combinationSum2(input.candidates, input.target), result);
//		
		
		input = ins.new Input(new int[] { 3, 1, 3, 5, 1, 1 }, 8);
		result = new ArrayList<List<Integer>>();
		result.add(new ArrayList<Integer>());
		result.get(0).add(1);
		result.get(0).add(1);
		result.get(0).add(1);
		result.get(0).add(5);
		result.add(new ArrayList<Integer>());
		result.get(1).add(1);
		result.get(1).add(1);
		result.get(1).add(3);
		result.get(1).add(3);
		result.add(new ArrayList<Integer>());
		result.get(2).add(3);
		result.get(2).add(5); 
		Util.printInput(input);
		Util.printResult(ins.combinationSum2(input.candidates, input.target), result);

	}

	class Input {
		int[] candidates;
		int target;

		public Input(int[] candidates, int target) {
			this.candidates = candidates;
			this.target = target;
		}

		@Override
		public String toString() {
			return String.format("candidates:%s, target:%s", Arrays.toString(this.candidates), this.target);
		}
	}
}
