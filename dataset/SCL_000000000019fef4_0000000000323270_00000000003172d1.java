import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
				ArrayList<Long> ar = new ArrayList<Long>();
				for(int k = 2 ; k <= 200000 ; k ++) {
					if(A[j] % k == 0)ar.add(A[j] / k);
				}
				ar.add(A[j]);
				for(int l = 0 ; l < ar.size(); l++) {
					long turn = A[j] / ar.get(l) - 1;
					long count = A[j] / ar.get(l);
					//System.out.println(A[j]+","+l+","+turn+","+count+","+ar.get(l));
					if(count >= D) {
						maxturn = Math.min(maxturn, turn);
						continue;
					}
					for(int k = j + 1 ; k < A.length ; k++) {
						if(A[k] % ar.get(l) == 0) {
							long plus = A[k] / ar.get(l);
							//System.out.println(plus);
							if(count + plus < D) {
								turn += A[k] / ar.get(l) - 1;
								count += plus;
							}else if(count + plus == D) {
								turn += A[k] / ar.get(l) - 1;
								maxturn = Math.min(maxturn, turn);
								break;
							}else {
								turn += (D - count);
								maxturn = Math.min(maxturn, turn);
								break;
							}
						}
						if(count < D && k != A.length - 1) {
							maxturn = Math.min(maxturn, turn + D - count);
						}
						//System.out.println(turn+","+count);
					}
				}

			}
			System.out.println("Case #"+(i+1)+": "+maxturn);
		}
		stdReader.close();
	}
}
