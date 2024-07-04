public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numTestCase = in.nextInt();
        int [][][] matrixArray = new int[numTestCase][][];
        int []sizeArray = new int[numTestCase];
        int N;
        for (int i = 0; i < numTestCase; ++i) {
        	N = in.nextInt();
        	matrixArray[i] = new int[N][N];
        	for (int j = 0; j < N; j++) {
        		for (int k = 0; k < N; k++) {
        			matrixArray[i][j][k] = in.nextInt();
        		}
        	}
        	sizeArray[i] = N;
        }
        
        for (int i = 0; i < numTestCase; ++i) {
        	computeTrace(i+1, matrixArray[i], sizeArray[i]);
        }
	}
	
	static void computeTrace(int testCase, int [][] square, int N){
		int trace = 0;
		int numRepeatedRow = 0;
		int numRepeatedCol = 0;
		int j;
		for (int i = 0; i < N; i++) {
			trace += square[i][i];
			boolean []rIndexArray = new boolean[N + 1];
			boolean []cIndexArray = new boolean[N + 1];
			
			j = 0;
			while(j < N){
				if(rIndexArray[square[i][j]]){
					numRepeatedRow++;
					break;
				}
				else{
					rIndexArray[square[i][j]] = true;
				}
				j++;
			}
			
			j = 0;
			while(j < N){
				if(cIndexArray[square[j][i]]){
					numRepeatedCol++;
					break;
				}
				else{
					cIndexArray[square[j][i]] = true;
				}
				
				j++;
			}
		}
				
		System.out.println("Case #" + testCase + ": " + trace + " " + numRepeatedRow + " " + numRepeatedCol);
	}
}	