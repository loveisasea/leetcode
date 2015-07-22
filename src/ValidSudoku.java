public class ValidSudoku {
	public boolean isValidSudoku(char[][] board) {
		// check horizontal
		boolean[] tmp = new boolean[10];
		int xlen = board.length;
		for (int i = 0; i < xlen; i++) {
			int ylen = board[i].length;
			for (int j = 0; j < ylen; j++) {
				int idx = board[i][j] - '0';
				if (idx >= 0 && idx <= 9) {
					if (tmp[idx]) {
						return false;
					}
					else {
						tmp[idx] = true;
					}
				}
			}
			for (int k = 0; k < 10; k++) {
				tmp[k] = false;
			}
		}
		// check vertical
		if (board.length > 0) {
			int ylen = board[0].length;
			for (int j = 0; j < ylen; j++) {
				for (int i = 0; i < xlen; i++) {
					int idx = board[i][j] - '0';
					if (idx >= 0 && idx <= 9) {
						if (tmp[idx]) {
							return false;
						}
						else {
							tmp[idx] = true;
						}
					}
				}
				for (int k = 0; k < 10; k++) {
					tmp[k] = false;
				}
			}
		}

		if (board.length > 0) {
			// check sub 9 
			for (int i = 0; i < xlen; i=i+3) {
				int ylen = board[i].length;
				for (int j = 0; j < ylen; j=j+3) {
					for(int k=0;k<3;k++){
						for(int l=0;l<3;l++){
							int idx = board[i+k][j+l] - '0';
							if (idx >= 0 && idx <= 9) {
								if (tmp[idx]) {
									return false;
								}
								else {
									tmp[idx] = true;
								}
							}
						}
					}
					
				} 
			}
		}
		return true;
	}
}
