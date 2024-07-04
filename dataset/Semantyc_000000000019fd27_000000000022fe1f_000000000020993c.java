
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;

public class Solution {
    public static void main(String[] args){
        try {
            //Scanner sc = new Scanner(System.in);
            BufferedInputStream bf = new BufferedInputStream(System.in);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(bf, StandardCharsets.UTF_8));
            OutputStream out = new BufferedOutputStream ( System.out );

            int t = Integer.parseInt(in.readLine().trim());
            int i = 1;
            while(t-->0){
                int n = Integer.parseInt(in.readLine().trim());
                int[][] m = new int[n][n];
                int kk = 0;
                for(int j=0;j<n;j++){
                    String[] sl = in.readLine().trim().split(" ");
                    for(int k=0;k<n;k++){
                        m[j][k] = Integer.parseInt(sl[k]);
                    }
                    kk += m[j][j];
                }
                int r = 0;
                for(int j=0;j<n;j++){
                    HashSet<Integer> s = new HashSet();
                    for(int k=0;k<n;k++){
                        if (!s.add(m[j][k])){
                            r++;
                            break;
                        }
                    }
                }
                int c = 0;
                for(int k=0;k<n;k++){
                    HashSet<Integer> s = new HashSet();
                    for(int j=0;j<n;j++){
                        if (!s.add(m[j][k])){
                            c++;
                            break;
                        }
                    }
                }

                String ret = "Case #"+i+": "+kk+" "+r+" "+c;
                out.write((ret+"\n").getBytes());
                i++;
            }
            out.flush();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
}
