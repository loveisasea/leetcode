/*
 Given a set of candidate numbers (C) and a target number (T), find all 
 unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. 
(ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 2,3,6,7 and target 7, 
A solution set is: 
[7] 
[2, 2, 3]  
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

import core.Util;

public class CombinationSum {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		Arrays.sort(candidates);
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		Stack<Integer> stack = new Stack<Integer>(); 
		this.recurGetSum(candidates, 0, stack, target, ret); 
		return ret;

	}

	public void recurGetSum(int[] candidates, int idx, Stack<Integer> stack, int target, List<List<Integer>> ret) {
		int clen = candidates.length;
		for (int i = idx; i < clen; i++) {
			int val = candidates[i];
			if (val == target) {
				List<Integer> list = new ArrayList<Integer>();
				list.add(val);
				Iterator<Integer> iter = stack.iterator();
				while (iter.hasNext()) {
					list.add(iter.next());
				}
				Collections.sort(list);
				ret.add(list);
			}
			else if (val < target) {
				stack.push(val);
				this.recurGetSum(candidates, i, stack, target - val, ret);
			}
			else {
				break;
			}
		}
		if(stack.size()>0){
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
		CombinationSum ins = new CombinationSum();
		Input input = null;
		List<List<Integer>> result = null;

		 input = ins.new Input(new int[]{2,3,6,7},6);
		 result = new ArrayList<List<Integer>>();
		 result.add(new ArrayList<Integer>());
		 result.get(0).add(2);
		 result.get(0).add(2);
		 result.get(0).add(3);
		 result.get(0).add(7);
		 result.add(new ArrayList<Integer>());
		 result.get(1).add(7);
		 Util.printInput(input);
		 Util.printResult(ins.combinationSum(input.candidates, input.target),
		 result);
		
		
		 input = ins.new Input(new int[]{1},2);
		 result = new ArrayList<List<Integer>>();
		 result.add(new ArrayList<Integer>());
		 result.get(0).add(1);
		 result.get(0).add(1);
		 Util.printInput(input);
		 Util.printResult(ins.combinationSum(input.candidates, input.target),
		 result);

		input = ins.new Input(new int[] { 1, 2 }, 3);
		result = new ArrayList<List<Integer>>();
		result.add(new ArrayList<Integer>());
		result.get(0).add(1);
		result.get(0).add(1);
		result.get(0).add(1);
		result.add(new ArrayList<Integer>());
		result.get(1).add(1);
		result.get(1).add(2);
		Util.printInput(input);
		Util.printResult(ins.combinationSum(input.candidates, input.target), result);
		
		input = ins.new Input(new int[]{2,7,3},18);
		 result = null; 
		 Util.printInput(input);
		 Util.printResult(ins.combinationSum(input.candidates, input.target),
		 result);
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

	// public List<List<Integer>> combinationSum(int[] candidates, int target) {
	// List<List<Integer>> ret2 = new ArrayList<List<Integer>>();
	// Map<Integer, Num> map = new HashMap<Integer, Num>();
	// for (int i = 0; i < candidates.length; i++) {
	// int multi = 1;
	// while (true) {
	// int val = multi * candidates[i];
	// if (val <= target) {
	// Num num = map.get(val);
	// if (num == null) {
	// num = new Num(val);
	// map.put(val, num);
	// }
	// num.list.add(candidates[i]);
	// multi++;
	// } else {
	// break;
	// }
	// }
	// }
	// Iterator<Num> iter = map.values().iterator();
	// while (iter.hasNext()) {
	// Num num = iter.next();
	// int val2 = target - num.val;
	// if (val2 == 0) {
	// for (int si : num.list) {
	// List<Integer> list = new ArrayList<Integer>();
	// int multi = num.val / si;
	// for (int i = 0; i < multi; i++) {
	// list.add(si);
	// }
	// ret2.add(list);
	// }
	// map.remove(num.val);
	// }
	// else {
	// Num num2 = map.get(val2);
	// if (num2 != null) {
	// for (int si : num.list) {
	// int multi = num.val / si;
	// List<Integer> list = new ArrayList<Integer>();
	// for (int i = 0; i < multi; i++) {
	// list.add(si);
	// }
	// for (int si2 : num2.list) {
	// List<Integer> list2 = new ArrayList<Integer>();
	// int multi2 = val2 / si2;
	// for (int j = 0; j < multi2; j++) {
	// list2.add(si2);
	// }
	// list2.addAll(list);
	// Collections.sort(list2);
	// ret2.add(list2);
	// }
	// }
	// map.remove(val2);
	// }
	// map.remove(num.val);
	// }
	// iter = map.values().iterator();
	// }
	//
	// Set<String> tmp = new HashSet<String>();
	// List<List<Integer>> ret = new ArrayList<List<Integer>>();
	// for(List<Integer> list : ret2){
	// String listStr = list.toString();
	// if(!tmp.contains(listStr)){
	// ret.add(list);
	// tmp.add(listStr);
	// }
	// }
	// return ret;
	// }

}
