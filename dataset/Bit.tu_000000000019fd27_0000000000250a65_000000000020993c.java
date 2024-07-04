import java.util.*;
import java.io.*;

class CodeJam{
	public static void main(String args[]) throws Exception{
		Scanner br = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	//	PrintWriter fos = new PrintWriter(new FileOutputStream("Output.txt"));
	//	System.out.println("Enter Number Of Test Cases:-\t");
		int t = br.nextInt();
		int ans[][] = new int[t][3];
		for(int i=0; i<t; i++){
	//		System.out.println("Enter Matrix Size:-\t");
			int n = br.nextInt();
			int sum = 0, count = 0, count1 = 0;
			int arr[][] = new int[n][n];
			Set<Integer> st = new HashSet<Integer>();

	//		System.out.println("Enter Data in Matrix:-\t");
			for(int x=0; x<n; x++){
				for(int y=0; y<n; y++){
					arr[x][y] = br.nextInt();
					st.add(arr[x][y]);
				}
				if(st.size() < n)	count++;
				st.clear();
				sum += arr[x][x];
			}
			ans[i][0] = sum;
			ans[i][1] = count;
			for(int x=0; x<n; x++){
				for(int y=0; y<n; y++){
					st.add(arr[y][x]);
				}
				if(st.size() < n)	count1++;
				st.clear();
			}
			ans[i][2] = count1;
			System.out.println("case #" + (i+1) + ": " + sum + " " + count + " " + count1);
		//	fos.write("case #" + (i+1) + ": " + sum + " " + count + " " + count1 + "\n");
		//	fos.flush();
		}
	/*	for(int i=0; i<t; i++){
			System.out.print("case #" + (i+1) + ": ");
			for(int x=0; x<3; x++){
				System.out.print(ans[i][x] + " ");
			}
			System.out.println("");
		}*/
		br.close();
	//	fos.close();
		System.exit(0);
	}
}