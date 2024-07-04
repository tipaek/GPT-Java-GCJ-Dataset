import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      int n = in.nextInt();
      int[][] ar = new int[n][n];
      for(int a=0; a<n; a++)
        for(int b=0; b<n; b++)
            ar[a][b] = in.nextInt();
      System.out.println("Case #" +i+ ": " +sum(ar)+ " " +rows(ar)+ " " +columns(ar));
    }
  }

    public static int sum (int[][] array) {
        int s = 0;
        for(int i=0; i<array.length; i++)
            s+=array[i][i];
        return s;
	}
	
	public static int rows (int [][] array){
	    int rep = 0;
	    for(int i=0; i<array.length; i++){
	        int[] Rar = new int[array.length];
	        boolean repeat = false;
	        for(int j=0; j<array.length; j++)
	            Rar[j] = array[i][j];
	        Arrays.sort(Rar);
	        
	        for(int k=0; k<array.length; k++)
	            if(Rar[k]!=(k+1))
	                repeat = true;
	        if(repeat)
	            rep++;
	    }
	    return rep;
	}
	
	public static int columns (int [][] array){
	    int rep = 0;
	    for(int i=0; i<array.length; i++){
	        int[] Rar = new int[array.length];
	        boolean repeat = false;
	        for(int j=0; j<array.length; j++)
	            Rar[j] = array[j][i];
	        Arrays.sort(Rar);
	        
	        for(int k=0; k<array.length; k++)
	            if(Rar[k]!=(k+1))
	                repeat = true;
	        if(repeat)
	            rep++;
	    }
	    return rep;
	}
}