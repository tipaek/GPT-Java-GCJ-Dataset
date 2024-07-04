import java.util.*;
import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader;


class Solution
{   
	

    static class FastReader 
    { 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader() 
        { 
            br = new BufferedReader(new
                     InputStreamReader(System.in)); 
        } 
  
        String next() 
        { 
            while (st == null || !st.hasMoreElements()) 
            { 
                try
                { 
                    st = new StringTokenizer(br.readLine()); 
                } 
                catch (IOException  e) 
                { 
                    e.printStackTrace(); 
                } 
            } 
            return st.nextToken(); 
        } 
  
        int nextInt() 
        { 
            return Integer.parseInt(next()); 
        } 
  
        long nextLong() 
        { 
            return Long.parseLong(next()); 
        } 
  
        double nextDouble() 
        { 
            return Double.parseDouble(next()); 
        } 
  
        String nextLine() 
        { 
            String str = ""; 
            try
            { 
                str = br.readLine(); 
            } 
            catch (IOException e) 
            { 
                e.printStackTrace(); 
            } 
            return str; 
        } 
    } 
  
    public static void main(String[] args) 
    { 
        FastReader s=new FastReader(); 
       int tc=s.nextInt();
       int a = 1;
       while(a<=tc) {
    	   int n=s.nextInt();
    	   int arr[][]=new int[n][3];
    	   for(int i=0;i<n;i++) {
    		   arr[i][0]=s.nextInt();
    		   arr[i][1]=s.nextInt();
    		   arr[i][2]=i;
    	   }
    	   Arrays.sort(arr,new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[0]-o2[0];
			}
    	   });
    	   int ans[]=new int[n];
    	   int clast=-1;
    	   int jlast=-1;
    	   for(int i=0;i<n;i++) {
    		   if(arr[i][0]>=clast) {
    			   ans[arr[i][2]]=1;
    			   clast=arr[i][1];
    		   }else if(arr[i][0]>=jlast) {
    			   ans[arr[i][2]]=2;
    			   jlast=arr[i][1];
    		   }else if(arr[i][0]<clast &&arr[i][0]<jlast) {
    			   ans[0]=-1;
    			   break;
    		   }
    	   }
    	   String st="";
    	   char c=(char)67;
    	   char j=(char)74;
    	   if(ans[0]==-1) {
    		   System.out.println("Case #"+a+": IMPOSSIBLE");
    	   }else {
    		   for(int i=0;i<n;i++) {
    			   if(ans[i]==1) {
    				   st+=c;
    			   }else {
    				   st+=j;
    			   }
    		   }
    		   System.out.println("Case #"+a+": "+st);
    	   }
    	   a++;
    	   
       }
              
    }
    
    
}