import java.io.*;
import java.util.*;

  public class Solution{
      
	
	  
	   public static BufferedReader ob;
	   
	   
	   public static void  sort(int [][]ar , int col) {
		   
		   Arrays.sort(ar, new Comparator<int[]>() { 
			   public int compare(final int []e1 , int []e2) {
				    if(e1[col] > e2[col])
				    	return 1;
				    else
				    	return -1;
			   }
		   });
		   
	   }
	   
    public static void main (String args[])throws IOException{
  
	
	
	  ob = new BufferedReader(new InputStreamReader(System.in));
	  int t = Integer.parseInt(ob.readLine());
	    
	    int cas = 1;
	    while(t --> 0) {
	    	 int n = Integer.parseInt(ob.readLine());
	    	 
	    	 int [][]mat = new int[n][2];
	    	 StringTokenizer st;
	    	 
	    	 for(int i = 0; i < n; i++) {
	    		 st = new StringTokenizer(ob.readLine());
	    		 for(int j = 0; j < 2; j++) {
	    			 mat[i][j] = Integer.parseInt(st.nextToken());
	    		 }
	    	 }
	    	 sort(mat,1);
	    
	    	 int []ans = new int[n];
	    	 
	    	 ans[0] = 1;
	    	 int k = 1;
	    	int s = mat[0][1];
	    	 
	    	   while(k < n) {
	    		   if(mat[k][0] >= s) {
	    			   ans[k] = 1;
	    			   s = mat[k][1];
	    		   }
	    		   k++;
	    	   }
	    		   
	    		   
	    		   
	    		   
	    	 int j = 1;
	    	 int x = -1;
	    	 while(j < n) {
	    		 
	    		 if(ans[j] != 1 && mat[j][0] >= x) {
	    			 x = mat[j][1];
	    			 ans[j] = 2;
	    		 }
	    		 j++;
	    	 }
	    	   
	    	   
	    	   
	    	   
	    
	    	 StringBuilder sb = new StringBuilder();
	    	 boolean v = false;
	    	 
	    	 for(int i = 0;i < n; i++) {
	    		 if(ans[i] == 0)v = true;
	    	 }
	    	 if(v) {
	    		 System.out.println("Case"+" "+"#"+cas+":"+" "+"IMPOSSIBLE");
	    		 cas++;
	    	 }else {
	    		 for(int i = 0; i < n; i++) {
	    			 if(ans[i] == 1)sb.append('C');
	    		 else 
	    			 sb.append('J');
	    		 }
	    	 String str = sb.toString();
	    	 System.out.println("Case"+" "+"#"+cas+":"+" "+str);
	    	 cas++;
	    	 }
	    		 
	    	 }
  }
  }
	    	 