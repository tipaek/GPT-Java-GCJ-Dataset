
import java.io.*;
import java.util.*;
class vesti {

	public static void main (String[] args) throws java.lang.Exception
	{
			
		    BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		    int t = Integer.parseInt(br.readLine());
		    while(t-->0){
		         int r=0,c=0,tr=0;
		       int n=Integer.parseInt(br.readLine());
		      int arr[][] = new int[n][n];
		      
		       for(int i=0;i<n;i++){
		           String[] st=br.readLine().trim().split(" ");
		           List<Integer> xt = new ArrayList<Integer>();
		           for(int j=0;j<n;j++){
		            xt.add(Integer.parseInt(st[j]));
		            arr[i][j]=xt.get(j);
		           }
		              Set<Integer> set = new HashSet<Integer>(xt);
		              if(set.size()!=xt.size()) r++;
		          }
		            for(int i=0;i<n;i++){
		                tr=tr+arr[i][i];
		            }
		            
		            for(int i=0;i<n;i++){
		                List<Integer> xt = new ArrayList<Integer>();
		                for(int co=0;co<n;co++){
		                    xt.add(arr[co][i]);
		                }
		                Set<Integer> set = new HashSet<Integer>(xt);
		              if(set.size()!=xt.size()) c++;
		            }
		     System.out.println(tr+" "+c+" "+c);
             } 
		    }
	
}
