import java.util.Scanner;
import java.io.*;
class Solution {
	public static int M[][];
	public static String out;
		static Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	public static void main(String[] args) {
		    int T = Integer.valueOf(input.nextLine());
		    String out = "";
		    for (int i = 1; i <= T; ++i) {
		    	String[] in = input.nextLine().split(" ");
		    	int N =	Integer.valueOf(in[0]);
		    	int K = Integer.valueOf(in[1]);
		    	M = new int[N][N];
		    	out += solve(i,K,N)+"\n";
		    }
		    System.out.println(out);
	}
	public static String solve(int num,int K,int N) {
		int trace = 0;
		int check = 0;
		StringBuilder out =new StringBuilder();
		for (int i = 0; i < N; i++) {
			check += K/N;
		}
		if (check != K) 
			return "Case #"+num+": IMPOSSIBLE";
		int k = N;
		for (int i = 1; i <= N; i++) 
        {
            int temp = k; 
            while (temp <= N) 
            {
                out.append(temp + " "); 
                temp++;
            } 
            for (int j = 1; j < k; j++) 
                out.append(j + " "); 
            k--; 
            out.append("\n");
        }
		String[] rows = out.toString().split("\n");
		String[][] table = new String[rows.length][rows.length];
		for (int i = 0; i < table.length; i++) {
			table[i] = rows[i].split(" ");
			for (int j = 0; j < table.length; j++) {
				M[i][j] = Integer.valueOf(table[i][j]);
			}
		}
		flipInPlace(M);
		out =new StringBuilder();
		for (int i = 0; i < table.length; i++) {
			for (int j = 0; j < table.length; j++) {
				out.append(M[i][j]+" ");
			}
			if(i != table.length - 1)
				out.append("\n");
		}
		for (int i = 0; i < M.length; i++) {
			for (int j = 0; j < M.length; j++) {
				if(i == j)
					trace+=Integer.valueOf(M[i][j]);	
			}
		}
		if(trace != K)
			return "Case #"+num+": IMPOSSIBLE";
		for (int i = 0; i < M.length; i++) {
			if(duplicates(M[i]))
				return "Case #"+num+": IMPOSSIBLE";
			int[] column = new int[M[i].length]; 
            for(int j = 0; j<M.length; j++)
                column[j] = M[j][i];
            if(duplicates(column))
            	return "Case #"+num+": IMPOSSIBLE";
		}
		return "Case #"+num+": POSSIBLE\n"+out.toString();
	}
	public static boolean duplicates(int[] array)
    {
        for (int i = 0; i<array.length; i++) 
        {
            for(int j = 0; j<array.length; j++)
            {
                if (i != j && array[i] == array[j])
                {
                    return true;
                }
            }    
        }
        return false;
    }
	public static void flipInPlace(int[][] theArray) {
	    for(int i = 0; i < (theArray.length / 2); i++) {
	        int[] temp = theArray[i];
	        theArray[i] = theArray[theArray.length - i - 1];
	        theArray[theArray.length - i - 1] = temp;
	    }
	}

}
