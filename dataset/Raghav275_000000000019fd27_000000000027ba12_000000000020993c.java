
import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Solution
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		
		for(int start = 1; start<=t;start++){
		    int n = s.nextInt();
		    int mat[][] = new int[n][n];
            int row = 0;
            int col = 0;
		    for(int i=0;i<n;i++){
		        for(int j=0;j<n;j++){
		            mat[i][j]=s.nextInt();
		        }
		    }
		    for(int i=0;i<n;i++){
		        HashSet<Integer> set = new HashSet<>();
		        for(int j=0;j<n;j++){
		            if(!set.contains(mat[i][j])){
		                set.add(mat[i][j]);
		            }
		            else{
		                row++;
		                break;
		            }
		        }
		    }
		    for(int i=0;i<n;i++){
		        HashSet<Integer> set = new HashSet<>();
		        for(int j=0;j<n;j++){
		            if(!set.contains(mat[j][i])){
		                set.add(mat[j][i]);
		            }
		            else{
		                col++;
		                break;
		            }
		        }
		    }
		    int trace = 0;
		    for(int i=0;i<n;i++){
		        trace+=mat[i][i];
		    }
		    System.out.println("Case #"+start+": "+trace+" "+row+" "+col);
		}
	}
}
