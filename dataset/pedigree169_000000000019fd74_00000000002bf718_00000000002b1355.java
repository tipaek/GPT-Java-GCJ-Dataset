import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pedigree {
    static FastReader br = new FastReader();
    
    public static void main(Straing args[]) {
    
        int t=br.nextInt();
        for(int i=1;i<=t;i++) {
            String res = solve(br.nextInt());
            System.out.println("Case #" + i + ":" + res);
            }
            }
            }