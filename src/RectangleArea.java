import core.Util;

/*
 Find the total area covered by two rectilinear rectangles in a 2D plane.

 Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.

 Rectangle Area
 Assume that the total area is never beyond the maximum possible value of int.
 */
public class RectangleArea {
	public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
		long width = (long)(C < G ? C : G) - (A > E ? A : E);
		if (width <= 0) {
			width = 0;
		}
		long height = (long)(D < H ? D : H) - (B > F ? B : F);
		if (height <= 0) {
			height = 0;
		}
		return (int) (((long)C - A) * ((long)D - B) + ((long)G - E) * ((long)H - F) - (long)width * height);
	}

	public static void main(String[] args) {
		RectangleArea ins = new RectangleArea();
		Input input = null;
		// input = ins.new Input(-2, -2, 2, 2, -2, -2, 2, 2);
		// Util.printInput(input);
		// Util.printResult(ins.computeArea(input.A, input.B, input.C, input.D,
		// input.E, input.F, input.G, input.H), 16);

//		input = ins.new Input(-2, -2, 2, 2, -1, -1, 1, 1);
//		Util.printInput(input);
//		Util.printResult(ins.computeArea(input.A, input.B, input.C, input.D, input.E, input.F, input.G, input.H), 16);
//
//		input = ins.new Input(-2, -2, 2, 2, -1, -1, 1, 1);
//		Util.printInput(input);
//		Util.printResult(ins.computeArea(input.A, input.B, input.C, input.D, input.E, input.F, input.G, input.H), 16);
//		
		input = ins.new Input(-1500000001, 0, -1500000000, 1, 1500000000, 0, 1500000001, 1);
		Util.printInput(input);
		Util.printResult(ins.computeArea(input.A, input.B, input.C, input.D, input.E, input.F, input.G, input.H), 2);

	}

	class Input {
		int A;
		int B;
		int C;
		int D;
		int E;
		int F;
		int G;
		int H;

		public Input(int A, int B, int C, int D, int E, int F, int G, int H) {
			this.A = A;
			this.B = B;
			this.C = C;
			this.D = D;
			this.E = E;
			this.F = F;
			this.G = G;
			this.H = H;
		}

		@Override
		public String toString() {
			return String.format("[%s,%s,%s,%s,%s,%s,%s,%s]", A, B, C, D, E, F, G, H);
		}
	}

	// misunderstand the question, it is to calculate the intersect area
	// public int computeArea(int A, int B, int C, int D, int E, int F, int G,
	// int H) {
	// int aLeft,aBottom,aRight,aTop;
	// int bLeft,bBottom,bRight,bTop;
	// if(A <= E){
	// aLeft = A;
	// aBottom = B;
	//
	// bLeft = E;
	// bBottom = F;
	//
	// }
	// else{
	// aLeft = E;
	// aBottom = F;
	//
	// bLeft = A;
	// bBottom = B;
	//
	// }
	// if(D>=H){
	// aRight = C;
	// aTop = D;
	// bRight = G;
	// bTop = H;
	// }
	// else{
	// aRight = G;
	// aTop = H;
	// bRight = C;
	// bTop = D;
	// }
	// if(aRight <= aLeft || bRight<=bLeft || aTop<=aBottom || bTop<=bBottom){
	// return 0;
	// }
	// int width;
	// if(aRight>bRight){
	// width = bRight -bLeft;
	// }
	// else if (aRight < bLeft){
	// return 0;
	// }
	// else{
	// width = aRight -bLeft;
	// }
	// int height;
	// if(aBottom<bBottom){
	// height = bTop -bBottom;
	// }
	// else if (aBottom > bTop){
	// return 0;
	// }
	// else{
	// height = bTop -aBottom;
	// }
	// return width * height;
	// }
}
