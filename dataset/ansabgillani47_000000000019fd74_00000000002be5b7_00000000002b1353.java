public class PossibleWalkThroughMatrix {
	public static void main(String[] args) {
		System.out.println(countAllWalks(30, 30));
	}


	private static long countAllWalks(int col, int row) {
		long[][] myArray = new long[col+1][row+1];
		for (int i = 0; i <= col; i++) {
			for (int j = 0; j <= row; j++) {
				if(i==0 && j==0){
					myArray[i][j] = 1;
				}
				else{
					myArray[i][j] = computeValue(i,j,myArray);
				}
			}
		}
		return myArray[col][row];

	}

	private static long computeValue(int i, int j, long[][] myArray) {
			if(i-1 < 0){
				return myArray[i][j-1];
			}
			else if(j-1 < 0){
				return myArray[i-1][j];
			}
			else{
				return myArray[i-1][j]+myArray[i][j-1];
			}
	}
}