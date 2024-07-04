import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * @author
 * @date 04/04/20
 */
public class Trace {
    public static void main(String[] args) throws Exception{
        InputStreamReader r=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(r);
        int t = Integer.valueOf(br.readLine());
        String res="";
        int tc=1;
        while(t>0){
            if(res.length()>0){
                res+="\n";
            }
            int s = Integer.valueOf(br.readLine());
            int m[][] = new int[s][s];
            for(int i=0;i<s;i++) {
                String v[] = br.readLine().split(" ");
                for(int j=0;j<s;j++){
                    m[i][j] = Integer.valueOf(v[j]);
                }
            }
            res += computeLatinSQ(m, s, tc);
            tc++;
            t--;
        }
        System.out.println(res);
    }

    public static String computeLatinSQ(int m[][], int s, int tc){
        int k=0;
        //GetSum
        for(int i=0;i<s;i++){
            k+=m[i][i];
        }
        ////
        int r=0;
        int c=0;
        //GetSum
        for(int i=0;i<s;i++) {
            Set<Integer> s1 = new HashSet<>();
            Set<Integer> s2 = new HashSet<>();
            boolean rc = false;
            boolean cc = false;
            for (int j = 0; j < s; j++) {
                if (!s1.contains(m[i][j])) {
                    s1.add(m[i][j]);
                } else {
                    rc = true;
                }
                if (!s2.contains(m[j][i])) {
                    s2.add(m[j][i]);
                } else {
                    cc = true;
                }
            }
            if (rc) {
                r++;
            }
            if (cc) {
                c++;
            }
        }
        return String.format("Case #%d: %d %d %d", tc, k, r, c);
    }
}