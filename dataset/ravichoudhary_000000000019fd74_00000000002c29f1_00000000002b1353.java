import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            String answer = answer(n);
            sb.append(String.format("CASE #%d: %s\n", i + 1, answer));
        }
        System.out.println(sb);
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