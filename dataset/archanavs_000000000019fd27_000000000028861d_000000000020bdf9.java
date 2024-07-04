import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
	    int c[] = new int[1441];
		int jamie[] = new int[1441];
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();
        for (int i = 1; i <= T; i++) {
            int N = in.nextInt();
            int start[] = new int[N];
            int end[] = new int[N];
            for(int j=0; j<N;j++) {
            		start[j] = in.nextInt();
            		end[j] = in.nextInt();
            }
            
            outputCase(i, N, start, end, c, jamie);
            
        }

	}

	private static void outputCase(int T, int n, int[] start, int[] end, int[]c, int[]j) {

		
		for(int i=0; i<1441; i++) { c[i]=0; j[i] = 0;}
		String result = "";
		for (int i=0; i< n; i++){
			boolean jfail = false, cfail = false;
			int begin = start[i];
			int finish = end[i];
			for (int k=begin+1; k<finish; k++) {
				if(c[k]!=0) cfail = true;
				if(j[k]!=0) jfail = true;
			}
			if(cfail && jfail) {
				System.out.println("Case #" + T +": IMPOSSIBLE");
				return;
			} else {
				if(!cfail){
					for (int k=begin; k<=finish; k++) {
						c[k] = 1;
					}
					result = result + "C";
					
				}
				else {
					for (int k=begin; k<=finish; k++) {
						j[k] = 1;
					}
					result = result + "J";
				}
			}
			
			
		}
		
		
		System.out.println("Case #" + T +": " + result);
		
	}

}
