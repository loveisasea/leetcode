import core.Util;

public class Numberof1Bits { // you need to treat n as an unsigned value
	public int hammingWeight(int n) {
		
//		System.out.println(String.format("n:                                          %s",Integer.toBinaryString(n)));
//		n = n - ((n >>> 1) & 0x55555555);
//		System.out.println(String.format("n - ((n >>> 1) & 0x55555555):               %s",Integer.toBinaryString(n)));
//		n = (n & 0x33333333) + ((n >>> 2) & 0x33333333);
//		System.out.println(String.format("(n & 0x33333333) + ((n >>> 2) & 0x33333333):%s",Integer.toBinaryString(n)));
//		n = (n + (n >>> 4)) & 0x0f0f0f0f;
//		System.out.println(String.format("(n + (n >>> 4)) & 0x0f0f0f0f:               %s",Integer.toBinaryString(n)));
//		n = n + (n >>> 8);
//		System.out.println(String.format("n + (n >>> 8):                              %s",Integer.toBinaryString(n)));
//		n = n + (n >>> 16);
//		System.out.println(String.format("n + (n >>> 16):                             %s",Integer.toBinaryString(n)));
//		n= n & 0x3f;
//		System.out.println(String.format("n & 0x3f:                                   %s",Integer.toBinaryString(n)));
//		return n; 
		return Integer.bitCount(n);
	}
	
//	public int hammingWeight(int n) {
//		int ret = 0;
//		while (n != 0) {
//			if ((n & 1) == 1) {
//				ret++;
//			}
//			n = n >> 1;
//		}
//		return ret;
//	}
	
	public static void main(String[] args){
		Numberof1Bits ins  = new Numberof1Bits();
		int input  = 0;
		Util.printInput(input);
		Util.printResult(ins.hammingWeight(input), 0);
		
		input  = 1;
		Util.printInput(input);
		Util.printResult(ins.hammingWeight(input), 1);
		
		input  = 3;
		Util.printInput(input);
		Util.printResult(ins.hammingWeight(input), 2);
		
		input  = 11;
		Util.printInput(input);
		Util.printResult(ins.hammingWeight(input), 3);
		
		input  = 100000;
		Util.printInput(input);
		Util.printResult(ins.hammingWeight(input), 6);
	}
}
