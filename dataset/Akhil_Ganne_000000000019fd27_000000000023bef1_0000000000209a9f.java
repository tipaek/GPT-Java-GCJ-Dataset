import java.io.*;
import java.util.*;


 class Solution {

    
    public static void main(String[] args) throws IOException{
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        int tc = 1;
        int x=1;
        while(t-->0)
        {
            
            String s = br.readLine();
            int open =0;
            bw.write("Case #"+x+": ");
            for(int i=0;i<s.length();i++)
            {
                int diff = (s.charAt(i)-'0')-open;
                if(diff>0)
                {
                    for(int j=0;j<diff;j++)
                        bw.write("(");
                        open+=diff;
                }
                else if(diff<0)
                {
                     for(int j=diff;j<0;j++)
                        bw.write(")");
                        open+=diff;
                }
                bw.write(s.charAt(i)+"");
            }
            for(int i=0;i<open;i++)
                bw.write(")");
            bw.write("\n");
            
            x++;
        }
        bw.flush();
    }
}
