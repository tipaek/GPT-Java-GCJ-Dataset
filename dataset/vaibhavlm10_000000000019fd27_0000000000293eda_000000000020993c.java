
import java.io.*;
import java.util.*;
import java.lang.*;
 public class Solution {
	public static void main (String[] args) 
	{
			
		    Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		    int t = sc.nextInt();
		    int cas = 1;
		    while(t>0){
		         int r=0,c=0,tr=0;
		       int n=sc.nextInt();
		      int arr[][] = new int[n][n];
		      Set<Integer> set = new HashSet<Integer>();
		       for(int i=0;i<n;i++){
		           for(int j=0;j<n;j++){
		           arr[i][j]=sc.nextInt();
		            set.add(arr[i][j]);
		           }
		              
		              if(set.size()!=n) r++;
		              set.clear();
		          }
		            for(int i=0;i<n;i++){
		                tr=tr+arr[i][i];
		            }
		            
		            for(int i=0;i<n;i++){
		                for(int co=0;co<n;co++){
		                    set.add(arr[co][i]);
		                }
		                
		              if(set.size()!=n) c++;
		              set.clear();
		            }
		     System.out.println("Case #"+cas+": "+tr+" "+r+" "+c);
            t--; cas++;} 
             
		    }
     }
