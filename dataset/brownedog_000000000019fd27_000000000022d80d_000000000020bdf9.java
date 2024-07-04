import java.util.*;
import java.io.*;
public class Solution {

	public static void main(String[] args) {

		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); //number of test cases
		for (int i = 1; i <= t; ++i) {
            
			int n = in.nextInt();
			String answer = "C";	//C first
			String imposs = "";
			int mat[][] = new int [n][2];
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < 2; k++) {
					mat[j][k] = in.nextInt(); //might have a problem if this overfills?
				}
			}
			//System.out.println(Arrays.deepToString(mat));

			ArrayList<Integer> Cam = new ArrayList<Integer>();	//ArrayList for C
			Cam.add(0);
			ArrayList<Integer> Jam = new ArrayList<Integer>();	//ArrayList for J

			for (int x= 1; x < n; x++) {
			    //System.out.println("answer=" + answer);
			    outerloop:
				for (int k = 0; k < Cam.size(); k++) {
					if (mat[x][0]>=mat[Cam.get(k)][0] && mat[x][0]<mat[Cam.get(k)][1]) { //might need some equals too >=
						if(Jam.isEmpty()) {
							answer = answer + "J";
							Jam.add(x);
							break outerloop;
						}
						
						else {
							for(int m = 0; m <Jam.size(); m++) {
								if (mat[x][0]>=mat[Jam.get(m)][0] && mat[x][0]<mat[Jam.get(m)][1]) {
									System.out.println("Case #" + i + ": " + "IMPOSSIBLE");
									imposs = "IMPOSSIBLE";
									break outerloop; //might need a break outerloop
								}
								if (mat[x][0]<=mat[Jam.get(m)][0] && mat[x][1]>=mat[Jam.get(m)][1]) {
									System.out.println("Case #" + i + ": " + "IMPOSSIBLE");
									imposs = "IMPOSSIBLE";
									break outerloop; //might need a break outerloop
								}
								else if (m+1 == Jam.size()) {
								if (mat[x][0]<mat[Jam.get(m)][0] || mat[x][0]>=mat[Jam.get(m)][1]) {
									answer = answer + "J";
									Jam.add(x);
									break outerloop;
								}
								}
							}
						}
						
					}
					
					if (mat[x][1]>mat[Cam.get(k)][0] && mat[x][1]<=mat[Cam.get(k)][1]) { //might need some equals too >=
						if(Jam.isEmpty()) {
							answer = answer + "J";
							Jam.add(x);
							break outerloop;
						}
						else {
							for(int m = 0; m <Jam.size(); m++) {
								if (mat[x][1]>mat[Jam.get(m)][0] && mat[x][1]<=mat[Jam.get(m)][1]) {
									System.out.println("Case #" + i + ": " + "IMPOSSIBLE");
									imposs = "IMPOSSIBLE";
									break outerloop; //might need a break outerloop
								}
								if (mat[x][0]<=mat[Jam.get(m)][0] && mat[x][1]>=mat[Jam.get(m)][1]) {
									System.out.println("Case #" + i + ": " + "IMPOSSIBLE");
									imposs = "IMPOSSIBLE";
									break outerloop; //might need a break outerloop
								}
								if (mat[x][1]<=mat[Jam.get(m)][0] || mat[x][1]<mat[Jam.get(m)][1]) {
									answer = answer + "J";
									Jam.add(x);
									break outerloop;
								}
							}
						}

					}
					
						if (mat[x][0]<=mat[Cam.get(k)][0] && mat[x][1]>=mat[Cam.get(k)][1]) { //might need some equals too >=
						if(Jam.isEmpty()) {
							answer = answer + "J";
							Jam.add(x);
							break;
						}
						else {
							for(int m = 0; m <Jam.size(); m++) {
								if (mat[x][1]>mat[Jam.get(m)][0] && mat[x][1]<=mat[Jam.get(m)][1]) {
									System.out.println("Case #" + i + ": " + "IMPOSSIBLE");
									imposs = "IMPOSSIBLE";
									break; //might need a break outerloop
								}
								if (mat[x][0]<=mat[Jam.get(m)][0] && mat[x][1]>=mat[Jam.get(m)][1]) {
									System.out.println("Case #" + i + ": " + "IMPOSSIBLE");
									imposs = "IMPOSSIBLE";
									break outerloop; //might need a break outerloop
								}
								if (mat[x][1]<=mat[Jam.get(m)][0] || mat[x][1]<mat[Jam.get(m)][1]) {
									answer = answer + "J";
									Jam.add(x);
									break;
								}
							}
						}

					}
					
					
					
					
                   	else if (k+1 == Cam.size()) {
				    if (mat[x][0]<mat[Cam.get(k)][0] || mat[x][0]>=mat[Cam.get(k)][1]) {
							answer = answer + "C";
							Cam.add(x);
							//System.out.println(Cam);
							break outerloop;
						} 
				}
				}
				
			
			}


            if(!imposs.equals("IMPOSSIBLE")){
			System.out.println("Case #" + i + ": " + answer);
            }
		}
	}
}