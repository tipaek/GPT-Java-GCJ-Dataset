import java.io.PrintStream;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    Scanner             sc       = new Scanner(getClass().getResourceAsStream(IN));
    static final String FILENAME = "A-small";
    static final String IN       = FILENAME + ".in";
    static final String OUT      = FILENAME + ".out";
    PrintStream         out      = System.out;

    private void solve() {
        int num = sc.nextInt();
        int sum = 0;
        int r = 0;
        int c = 0;
        Set<Integer>[] colSet = new HashSet[num];
        for(int k=0;k<num;k++){
            colSet[k] = new HashSet<>();
        }
        for(int i=0;i<num;i++){
            Set<Integer> rowSet = new HashSet<>();
            boolean repeat = false;
            for(int j=0;j<num;j++){
                int n = sc.nextInt();
                if(!rowSet.add(n)){
                    repeat = true;
                }
                if(j==i){
                    sum += n;
                }
                colSet[j].add(n);
            }
            if(repeat){
                r++;
            }
        }
        for(Set set : colSet) {
            if(set.size()<num){
                c++;
            }
        }
        out.println(sum + " " + r + " " + c);
    }

    private void run() throws Exception {
        // out = new PrintStream(new FileOutputStream(OUT));
        int t = sc.nextInt();
        for (int i = 1; i <= t; i++) {
            out.print("Case #" + i + ": ");
            solve();
        }
        sc.close();
        out.close();
    }

    public static void main(String args[]) throws Exception {
        new Solution().run();
    }

}
