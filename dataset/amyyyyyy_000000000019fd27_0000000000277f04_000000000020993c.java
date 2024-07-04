import java.io.*;
import java.util.*;

public class Solution {
/*3
4
1 2 3 4
2 1 4 3
3 4 1 2
4 3 2 1
4
2 2 2 2
2 3 2 3
2 2 2 3
2 2 2 2
3
2 1 3
1 3 2
1 2 3
*/
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int test = Integer.parseInt(br.readLine().trim());
		int count = 0;
		int rcount = 0;
		HashSet<Integer> h = new HashSet<Integer>(); 
		HashSet<Integer> c = new HashSet<Integer>();
		boolean rrepeat = false;
		boolean crepeat = false;
		int ccount = 0;
       
		for(int t = 1; t <= test; t++) {

			int n = Integer.parseInt(br.readLine().trim());
			int [][]mat = new int [n][n];
			int [][]mat1=new int [n][n];
			for (int i=0; i<n; i++)
			{
				StringTokenizer st = new StringTokenizer(br.readLine());   //two strings in one line
				for (int j=0; j<n; j++)
				{
					int x = Integer.parseInt(st.nextToken());
					mat[i][j]=x;
					mat1[j][i]=x;
					if (i==j)
						count+=mat[i][j];
					//System.out.println(mat[i][j]);
					if (h.add(mat[i][j])==false)
					{
						rrepeat=true;
					}
				}
				if (rrepeat==true)
					rcount++;
				rrepeat = false;
				h.clear();
			}
			for (int k=0; k<n; k++)
			{
				for (int z=0; z<n; z++)
				{
					if (c.add(mat1[k][z])==false)
						crepeat=true;
				}
				if (crepeat==true)
					ccount++;
				crepeat = false;
				c.clear();
			}
			//System.out.println(count);
			

			System.out.println("Case #" + t + ": " + count + " " + rcount + " "+ ccount);
			count=0;
			rcount=0;
			ccount=0;
			h.clear();
		}

	}

}