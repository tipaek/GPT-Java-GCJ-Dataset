import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class Solution {
	public static void main(String[] args) throws Exception{
        FS sc=new FS(System.in);
        StringBuffer sb = new StringBuffer();
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = sc.nextInt();
        int numbers = sc.nextInt();
        int[][] a=new int[numbers][2];
        for(int i = 0;i < numbers; i++){
            a[i][0] = sc.nextInt();
            a[i][1] = sc.nextInt();
        }
        int count=0;
        while(count != t){
            int current_interval = a[0][0];
            for(int[] interval : a[count]){
                int current_start = current_interval[0][0];
                int current_end = current_interval[0][1];
                int next_start = interval[0];
                int next_end = interval[1];
                if(current_end > next_start){
                    sb.append("C");
                    current_interval[1] = Math.max(current_end,next_start);
                }else if(current_end < next_start){
                    current_interval=interval;
                    sb.append("J");
                }else{
                    sb.append("IMPOSSIBLE");
                }
            } 
            count++;
            out.printf("Case #%d: %s",t,sb);
    	    out.close();
        }
    }
	  private static class FS{
	        BufferedReader br;
	        StringTokenizer st;
	        FS(InputStream in){
	            br = new BufferedReader(new InputStreamReader(in));
	            st = new StringTokenizer("");
	        }
	         int nextInt() throws Exception
	        {
	            return Integer.parseInt(next());
	        }
	        
	        String next() throws Exception
	        {
	            if (st.hasMoreTokens())
	                return st.nextToken();
	            st = new StringTokenizer(br.readLine());
	            return next();
	        }
	    }
}
