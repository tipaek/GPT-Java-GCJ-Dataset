/*package whatever //do not write package name here */

//canner(new BufferedReader(new InputStreamReader(System.in)));
    import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	    int t=sc.nextInt();
	    int x=1;
	    while(x<=t){
	        
	          int n=sc.nextInt();
	          int ar[][]=new int[n][n];
	          for(int i=0;i<n;i++){for(int j=0;j<n;j++){ar[i][j]=sc.nextInt();}}
	          
	          int tr=0;int r=0;int c=0;
	          int fr[]=new int[n+1];//int fr1[]=new int[n+1];
	          for(int i=0;i<n;i++){tr+=ar[i][i];Arrays.fill(fr,0);
	              for(int j=0;j<n;j++){fr[ar[i][j]]++;
	                  if(fr[ar[i][j]]>1){r++;break;}
	              }}
	              for(int i=0;i<n;i++){//tr+=ar[i][i];
	              Arrays.fill(fr,0);
	              for(int j=0;j<n;j++){fr[ar[j][i]]++;
	                  if(fr[ar[j][i]]>1){c++;break;}
	              }}
	              
	        System.out.println("#"+x+": "+tr+" "+r+" "+c);      
	              
	     x++;         
	    }
	   System.exit(0);     
	}
}