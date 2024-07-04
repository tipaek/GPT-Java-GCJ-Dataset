
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
		  int[] start = new int[n];
		  int[] end = new int[n];
		  int over[] = new int[n];
		  int overwith[] = new int[n];
		  String str = "";
		  
		  for(int j = 0;j<n;j++)
		  {
		          start[j] = s.nextInt();
		          end[j] = s.nextInt();
		          //str = str+"C";
		  }
		  for(int j = 0; j<n; j++)
		  {
		      for(int k = 0; k<j; k++)
		      {
	            if(start[j]<end[k])
	            {
	                if(end[j]>=end[k])
	                {
	                      over[j]++;
	                      overwith[j] = k;
	                      //over[j][1] = k;
	                }
	                else
	                {
	                    if(end[j]>start[k])
	                    {
	                          over[j]++;
	                          overwith[j] = k;
	                          //over[j][1] = k;
	                    }
	                }
	            }
    	      }
    	      if(over[j]>=2)
		      {
		          str = "IMPOSSIBLE";
		          break;
		      }
		      if(over[j]==1)
		      {
		          if(str.charAt(overwith[j])=='C')
		          {
		              str = str+"J";
		          }
		          else
		          {
		              str = str+"C";
		          }
		      }
		      else
		      {
		          str = str+"C";
		      }
		      
		      //System.out.println(over[j]+" over");
		  }
		      
		  
		  
		  System.out.println("Case #"+i+": "+str);
		}
		s.close();
	}
}
