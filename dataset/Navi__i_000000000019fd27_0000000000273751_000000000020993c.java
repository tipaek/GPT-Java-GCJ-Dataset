
import java.util.*;
import java.lang.*;
import java.io.*;
public class Solution
{

	public static void main (String[] args) throws IOException
	{
	    Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
         int itr = scan.nextInt(); 
		int x = 1;
		while(itr-->0){
		      int n =scan.nextInt(); 
		      int k = 0;
		      int r = 0;
		      int c = 0;
		      
		  //    String[] s = new String[n];
		  //    for(int i =0 ;i<n ;i++){
		  //          s[i] = br.readLine();
		  //   }
		      
		      
		      
		      int[][] mat = new int[n][n];
		      for(int i = 0 ;i<n ;i++){
//String[] temp = s[i].split(" ");
		         for(int j = 0 ;j<n ;j++){
		             mat[i][j] = scan.nextInt(); 
		             if(i==j)
		               k+=mat[i][j];
		         }    
		      }
		      
		      
		      for(int i = 0 ;i<n ;i++){
		          boolean[] flag = new boolean[n];
		          for(int j = 0 ;j<n ;j++){
	     
		                     if(flag[mat[i][j]-1]==true){
		                         r++;
		                         break;
		                     }else{
		                         flag[mat[i][j]-1] = true;
		                     }
		               
		          }
		      }
		      
		      for(int i = 0 ;i<n ;i++){
		          boolean[] flag = new boolean[n];
		          for(int j = 0 ;j<n ;j++){
		                     if(flag[mat[j][i]-1]==true){
		                         c++;
		                         break;
		                     }else{
		                         flag[mat[j][i]-1]=true;
		                     }
		               }
		          }
		      
		      System.out.println("Case #"+x+": "+k+" "+r+" "+c);
		      x++;   
		      
		}
	}
}
