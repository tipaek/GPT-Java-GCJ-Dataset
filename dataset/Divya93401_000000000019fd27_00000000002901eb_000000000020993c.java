import java.util.Hashtable;
import java.util.Scanner;
public class Solution{
public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
       
        for(int p=1; p<=T; p++){
           int n = sc.nextInt();
           int [][] a = new int[n][n];
        for(int i=0; i<n; i++) {
        	for(int j=0; j<n; j++) {
        	a[i][j] = sc.nextInt();
        	}
        }
        	int k = trace(a,n);
        	int r = r(a,n);
        	int c = c(a,n);
        	
        	
        
        System.out.println("Case #" +p+ ":" +" " +k+ " " +r+ " " +c);
        }}
      public static int trace(int arr[][], int n) {
    	  int sum =0;
    	  for(int i=0; i<n; i++)
    	  {for(int j=0; j<n; j++) {
    		  if(i==j)
    			  sum=sum+arr[i][j];
    	  }
    	  }
    	  return sum;
    	  
      }
      public static int r(int arr[][], int n) {
    	  Hashtable<Integer,Integer>h = new Hashtable<>();
    	  int count = 0;
    	  for(int i=0; i<n; i++) {
    		  int row[]= arr[i];
    		  for(int j=0;j<row.length; j++) {
    			  if (h.containsKey(row[j]))
    			  {
    				  count++;
    				  break;
    			  }
    			  else
    			  {
    				  h.put(row[j],1);
    			  }
    		  }
    		  h.clear();
    	  }
    	  return count;
      }
      public static int c(int arr[][], int n)
      { 
    	  Hashtable<Integer,Integer>h = new Hashtable<>();
	  int count = 0;
	  for(int i=0; i<n; i++) {
		  for(int j=0;j<n; j++) {  
			  int ele = arr[j][i];
			  if(h.containsKey(ele)) {
				  count++;
				  break;
			  }else {
				  h.put(ele,1);
			  }
		  }
		  h.clear();
      }
	  return count;
        }
}

