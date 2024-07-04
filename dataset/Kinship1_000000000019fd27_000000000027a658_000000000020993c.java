
import java.util.*;
import java.lang.*;
import java.io.*;


public class Solution
{
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;

        public FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        String next(){
            while(st == null || !st.hasMoreElements()){
                try{
                    st = new StringTokenizer(br.readLine());
                } catch(IOException e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        int nextInt(){
            return Integer.parseInt(next());
        }
        long nextLong(){
            return Long.parseLong(next());
        }
        double nextDouble(){
            return Double.parseDouble(next());
        }
        String nextLine(){
            String str = "";
            try{
                str = br.readLine();
            }
            catch(IOException e){
                e.printStackTrace();
            }
            return str;
        }
    }
    
    

//    static PrintWriter pw = new PrintWriter(System.out);
    
	public static void main (String[] args) throws java.lang.Exception
	{

	  //FastReader s = new FastReader();
	  Scanner s =new Scanner(System.in);
		int t = s.nextInt();
		//System.out.println("hi2");
		for(int i=1;i<=t;i++)
		{

		  int n = s.nextInt();
		  //System.out.println("hi1");
		  int trace = 0,r=0,c=0;
		  Integer[][] a = new Integer[n][n];
		  Integer[][] b = new Integer[n][n];
		  
		  for(int j = 0;j<n;j++)
		  {
		      for(int k = 0;k<n;k++)
		      {
		          a[j][k] = s.nextInt();
		          if(j==k)
		            trace+=a[j][k];
		          b[k][j] = a[j][k];
		          //System.out.println("hi"); 
		          
		      }
		      
		      Set<Integer> set = new HashSet<Integer>(Arrays.asList(a[j]));
		      if(set.size()<n)
		        r+=1;
		  }
		  for(int j = 0; j<n; j++)
		  {
		      Set<Integer> set = new HashSet<Integer>(Arrays.asList(b[j]));
		      if(set.size()<n)
		        c+=1;
		  }
		  
		  System.out.println("Case #"+i+": "+trace+" "+r+" "+c);
		}
		s.close();
	}
}
