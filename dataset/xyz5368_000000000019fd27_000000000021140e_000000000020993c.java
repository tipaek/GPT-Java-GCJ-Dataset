import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		for(int i = 0; i < t; i++){
			int n = in.nextInt();
			int[][]square = new int[n][n];
			int cross = 0;
			int rowrep = 0;
			int colrep = 0;
			HashSet<Integer> row = new HashSet<Integer>();
			ArrayList<Integer> rowa = new ArrayList<Integer>();
			HashSet<Integer> col = new HashSet<Integer>();
			ArrayList<Integer> cola = new ArrayList<Integer>();
			//read in
			for(int j = 0; j < n; j++){
				for(int l = 0; l < n; l++){
					square[j][l] = in.nextInt();
					if(j==l)
						cross += square[j][l];
					row.add(square[j][l]);
					rowa.add(square[j][l]);
				}
				if(row.size() != rowa.size())
					rowrep++;
				row.clear();
				rowa.clear();
			}
			for(int j = 0; j < n; j++){
				for(int l = 0; l < n; l++){
					col.add(square[l][j]);
					cola.add(square[l][j]);
				}
				if(col.size() != cola.size())
					colrep++;
				col.clear();
				cola.clear();
			}
			
			System.out.printf("Case #%d: %d %d %d\n",i+1,cross,rowrep,colrep);
		}
	}

}
