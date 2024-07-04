import java.util.*;
import java.io.*;

public class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(new BufferedReader(
				new InputStreamReader(System.in)));
		int t = sc.nextInt();
		for (int i=1; i<=t; i++){
		    int n = sc.nextInt();
		    int[][] mat = new int[n][n]; 
		    for (int j=0; j<n; j++){
		        for (int k=0; k<n; k++){
		            mat[j][k] = sc.nextInt();
		        }
		    }
		    int[] res = solve(mat);
		    System.out.println("Case #"+i+": "+res[0]+" "+res[1]+" "+res[2]);
		}
    }
    
    private static int[] solve(int[][] mat){
        int sum = 0;
        int r=0; int c=0;
        int[] rowNums = new int[mat.length+1];
        int[] colNums = new int[mat.length+1];
        for (int k=0; k<mat.length; k++){
            sum += mat[k][k];
            Arrays.fill(rowNums,0);
            Arrays.fill(colNums,0);
            int count = 0;
            for (int i=0; i<mat.length; i++){
                rowNums[mat[k][i]]++;
                if (rowNums[mat[k][i]]>1)
                    count = 1;
            }
            if (count==1) r++;
            count = 0;
            for (int i=0; i<mat.length; i++){
                colNums[mat[i][k]]++;
                if (colNums[mat[i][k]]>1)
                    count = 1;
            }
            if (count==1) c++;
        }
        return new int[] {sum,r,c};
    }
}