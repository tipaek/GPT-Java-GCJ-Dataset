import java.io.*; 
import java.util.*;

class Vestiguim {
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
	public static void main (String[] args) throws IOException {
	    FastReader kb=new FastReader(); 
	    int t1=kb.nextInt();
	    int t=0;
	   while(t++<t1)
	      {
	        int n=kb.nextInt();
	        int sum=0,row=0,col=0;
	        int [][]arr=new int[n][n];
	      
	        for(int i=0;i<n;i++)
	          {  
	            ArrayList<Integer> list=new ArrayList<>(n);
	             int l=0;
	            for(int j=0;j<n;j++)
	               {
	                int a=kb.nextInt();
	                 arr[i][j]=a;
	                if(list.contains(a))
	                  {
	                      if(l==0)
	                       {
	                        row++;
	                         l=1;
	                       }
	                  }
	               list.add(a);
	              }
	              l=1;
	              sum=sum+arr[i][i];
	        }
	        
	        for(int i=0;i<n;i++)
	          {  
	            ArrayList<Integer> list=new ArrayList<>(n);
	             int l=0;
	            for(int j=0;j<n;j++)
	               {
	                   int a=arr[j][i];
	                if(list.contains(a))
	                  {
	                      if(l==0)
	                       {
	                         col++;
	                         l=1;
	                       }
	                  }
	               list.add(a);
	              }
	              l=1;
	        }
	        System.out.println("Case #"+t+": "+sum+" "+row+" "+col);
	        
	      }
	}
}