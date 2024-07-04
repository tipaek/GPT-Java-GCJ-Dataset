    import java.io.*;
     
    import java.util.*;
     
  public  class Solution {
        public static void main(String args[] ) throws Exception {
                 
                 BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new
             FileOutputStream(java.io.FileDescriptor.out), "ASCII"), 512);
     
                  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     
            String line = br.readLine();
            int t = Integer.parseInt(line);
            for(int T=0;T<t;T++){
                line = br.readLine();
                String[] strs = line.trim().split("\\s+");
                int x = Integer.parseInt(strs[0]);
                int y = Integer.parseInt(strs[1]);
                String s = strs[2];
                int tt=0;
                if(Math.abs(x)+Math.abs(y)==0){}
                else {for(int i=0;i<s.length();i++){
                    if(s.charAt(i)=='S'){ y--; }
                    else if(s.charAt(i)=='N'){   y++; }
                    else if(s.charAt(i)=='W') x--;
                    else x++;
                    tt++;
                    if(Math.abs(x)+Math.abs(y)-tt<=0) break;
                }}
                
                String pri = "";
                if(Math.abs(x)+Math.abs(y)-tt<=0) pri = String.valueOf(tt);
                else pri = "IMPOSSIBLE";
                out.write("Case #"+String.valueOf(T+1)+": "+pri);
                 out.write('\n');
            }
            out.flush();
        }
    }