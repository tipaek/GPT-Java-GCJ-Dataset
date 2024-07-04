
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
                int[] s = new int[n];
                int[] e = new int[n];
                for(int j=0;j<n;j++){
                    String[] sl = in.readLine().trim().split(" ");
                    s[j] = Integer.parseInt(sl[0]);
                    e[j] = Integer.parseInt(sl[1]);
                }
                char[] fr = new char[n];
                boolean imp = false;
                check:
                for(int j=0;j<n;j++){
                    if (fr[j]=='\0') fr[j]= 'C';
                    for(int k=0;k<n;k++){
                        if (k==j) continue;
                        if ((s[k]>=s[j] && s[k]<e[j]) || (s[j]>=s[k] && s[j]<e[k]) ){
                            //System.out.println("Case "+i+" : Overlap between "+(j+1)+" and "+(k+1));
                            char mc = fr[j]=='C' ? 'J' : 'C';
                            if (fr[k]!='\0' && fr[k]!=mc) {
                                //System.out.println(" Impossible to assign "+mc+" to "+(k+1)+" because fr[k] is "+fr[k]);
                                imp = true;
                                break check;
                            }else fr[k] = mc;
                        }
                    }
                }
                String sr = imp ? "IMPOSSIBLE" : new String(fr);

                String ret = "Case #"+i+": "+sr;
                out.write((ret+"\n").getBytes());
                i++;
            }
            out.flush();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
}
