
import java.util.*;
import java.io.*;
public class Solution {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int c = in.nextInt(); // number Testcases. 




		for (int t=1;t<=c;t++) {
			int n = in.nextInt();
			int[][] cameron = new int[2][n]; //Start ist oben, ende ist unten
			int[][] jamie = new int[2][n];
			int cc=0;
			int cj=0;
			boolean fits=true;

			int start = 0;
			int end = 0;
			String solution = "C";

			cameron[0][0]= in.nextInt();
			cameron[1][0]= in.nextInt();
			jamie[0][0]=0;
			jamie[1][0]=0;

			for (int i=1;i<n;i++) {
				start = in.nextInt();
				end = in.nextInt();
				fits=true;

				for (int k=0; k<=cc;k++) {
					if (cameron[0][k]<start  && cameron[1][k]>end  || cameron[0][k]<end  && cameron[0][k]>start || cameron[1][k]>start  && cameron[1][k]<end) {

						fits=false;
					}
				}
				if (fits) {

					cc++;
					solution=solution+"C";
					cameron[0][cc]=start;
					cameron[1][cc]=end;
				}
				else {
					fits=true;
					for (int k=0; k<=cj;k++) {
						if (jamie[0][k]<start && jamie[1][k]>end || jamie[0][k]<end && jamie[0][k]>start || jamie[1][k]>start && jamie[1][k]<end) {

							fits=false;
						}
					}
					if (fits) {
						cj++;
						jamie[0][cj]=start;
						jamie[1][cj]=end;
						solution=solution+"J";
					}
				}

				if (! fits) {
					solution= "IMPOSSIBLE";
					break;
				}
			}

			System.out.println("Case #" + t + ": " + solution);
		}
	}


}
