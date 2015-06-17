import core.Util;


public class ReverseBits { // you need to treat n as an unsigned value
	public int reverseBits(int n) {
		n = ((n & 0x0000ffff)<<16) + ((n & 0xffff0000)>>>16);
		System.out.println(String.format("((n & 0x0000ffff)<<16) + ((n & 0xffff0000)>>16): %s",padLeft(Integer.toBinaryString(n))));
		n = ((n & 0x00ff00ff)<<8) + ((n & 0xff00ff00)>>>8);
		System.out.println(String.format("((n & 0x00ff00ff)<<8) + ((n & 0xff00ff00)>>8)  : %s",padLeft(Integer.toBinaryString(n))));
		n = ((n & 0x0f0f0f0f)<<4) + ((n & 0xf0f0f0f0)>>>4);
		System.out.println(String.format("((n & 0x0f0f0f0f)<<4) + ((n & 0xf0f0f0f0)>>4)  : %s",padLeft(Integer.toBinaryString(n))));
		n = ((n & 0x33333333)<<2) + ((n & 0xcccccccc)>>>2);
		System.out.println(String.format("((n & 0x33333333)<<2) + ((n & 0xcccccccc)>>2)  : %s",padLeft(Integer.toBinaryString(n))));
		n = ((n & 0x55555555)<<1) + ((n & 0xaaaaaaaa)>>>1);
		System.out.println(String.format("((n & 0x55555555)<<1) + ((n & 0xaaaaaaaa)>>1)  : %s",padLeft(Integer.toBinaryString(n))));
		return n;
	}

	public static void main(String[] args) {
		ReverseBits ins  = new ReverseBits();
		int input  = 0;
		Util.printInput(input);
		Util.printResult(ins.reverseBits(input), Integer.reverse(input));
		
		input  = 1;
		Util.printInput(input);
		Util.printResult(ins.reverseBits(input), Integer.reverse(input));
		
		input  = 3;
		Util.printInput(input);
		Util.printResult(ins.reverseBits(input), Integer.reverse(input));
		
		input  = 11;
		Util.printInput(input);
		Util.printResult(ins.reverseBits(input), Integer.reverse(input));
		
		input  = 100000;
		Util.printInput(input);
		Util.printResult(ins.reverseBits(input), Integer.reverse(input));
		
		input = Integer.reverse(input);
		Util.printInput(input);
		Util.printResult(ins.reverseBits(input), Integer.reverse(input));
	}
	
	private String padLeft(String s ){
		int n=32;
		char ch = '0';
		if(s==null){
			return s;
		}
		if (s.length()>=n){
			return s;
		}
		int len =n - s.length();
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<len;i++){
			sb.append(ch);
		}
		return sb.toString()+s;
	}
}
