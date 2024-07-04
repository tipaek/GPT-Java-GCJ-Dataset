import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	
	private static StringBuilder oput;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int caseCount = Integer.parseInt(reader.readLine());
		
		for(int i=1; i <= caseCount; i++) {
			String[] caseInputs = reader.readLine().split(" ");
			int n =  Integer.parseInt(caseInputs[0]);
			int k =  Integer.parseInt(caseInputs[1]);
			
			 oput = new StringBuilder("Case #").append(i).append(": ");
			if (k% n !=0) {
				 oput.append("IMPOSSIBLE");
			} else {
				 oput.append("POSSIBLE");
				 int fVal = k / n;
				 for(int j=0 ; j< n; j++) {
					fVal = getMatrixRow(n,fVal);
				 }
			}
			System.out.println(oput);
		}
		
		
	}

	private static int getMatrixRow(int n, int fVal) {
		oput.append("\n");
		oput.append(fVal);
		int nextVal = fVal;
		for(int i=1; i< n; i++) {
			if(nextVal+1 > n) {
				nextVal = 1;
			}else {
				nextVal++;
			}
			oput.append(" ").append(nextVal);
		}
		return nextVal;
	}

}

