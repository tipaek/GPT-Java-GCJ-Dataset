// Working program with FastReader 
import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.Scanner; 
import java.util.StringTokenizer; 

public class Solution 
{ 
     public static void main(String[] args) 
	{ 
		FastReader sc=new FastReader(); 
	    int test=sc.nextInt();
        for(int t=1;t<=test;t++){
        String s=sc.next();
        char str[]=s.toCharArray();
        int n=str.length;
        int count=0;
        StringBuffer ans=new StringBuffer("");
        for(int i=0;i<n;i++){
            int num=str[i]-'0';
            if(num > count)
            {
                for(int j=count;j<num;j++){
                    ans.append("(");
                }
                count=num;
                ans.append(str[i]);
            }
            else if(num<count)
            {
                for(int j=count;j>num;j--){
                    ans.append(")");
                }
                count=num;
                ans.append(str[i]);
                continue;
            }
            else
            {
                ans.append(str[i]);
            }
        }
        while(count>0){
        ans.append(")");
        count--;
        }
        System.out.println("Case #"+t+": "+ans);
    }
	} 
	
	
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
				catch (IOException e) 
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


} 
