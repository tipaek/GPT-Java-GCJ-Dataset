import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
	public static void main(String args[]) throws Exception{
		//BufferedReader input = new BufferedReader(new FileReader("../GCJ2018/io/input.txt"));
	    BufferedReader stdReader = new BufferedReader(new InputStreamReader(System.in));
		//pw = new PrintWriter(new FileWriter("../GCJ2018/io/output.txt"));
		int T = Integer.parseInt(stdReader.readLine());
		for(int i = 0 ; i < T ; i++){
			String[] s = stdReader.readLine().split(" ");
			int N = Integer.parseInt(s[0]);
			int D = Integer.parseInt(s[1]);
			s = stdReader.readLine().split(" ");
			long[] A = new long[N];
			for(int j = 0 ; j < s.length ; j++) {
				A[j] = Long.parseLong(s[j]);
			}
			long maxturn = D - 1;
			Arrays.sort(A);
			for(int j = 0 ; j < A.length ; j++) {
				long turn = 0;
				long count = 1;
				for(int k = j + 1 ; k < A.length ; k++) {
					if(A[k] % A[j] == 0) {
						long plus = A[k] / A[j];
						if(count + plus < D) {
							turn += A[k] / A[j] - 1;
							count += plus;
						}else if(count + plus == D) {
							turn += A[k] / A[j] - 1;
							maxturn = Math.min(maxturn, turn);
							break;
						}else {
							turn += (D - count);
							maxturn = Math.min(maxturn, turn);
							break;
						}
					}
				}
				
				if(A[j] % 2 == 0) {
					long newa = A[j] / 2;
					turn = 1;
					count = 2;
					for(int k = j + 1 ; k < A.length ; k++) {
						if(A[k] % newa == 0) {
							long plus = A[k] / newa;
							if(count + plus < D) {
								turn += A[k] / newa - 1;
								count += plus;
							}else if(count + plus == D) {
								turn += A[k] / newa - 1;
								maxturn = Math.min(maxturn, turn);
								break;
							}else {
								turn += (D - count);
								maxturn = Math.min(maxturn, turn);
								break;
							}
						}
					}
				}
			}
			System.out.println("Case #"+(i+1)+": "+maxturn);
		}
		stdReader.close();
	}
}
