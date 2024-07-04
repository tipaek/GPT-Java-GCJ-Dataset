import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        for(int i=1;i<=T;i++) {
            int lines = s.nextInt();
            HashSet<Integer>[] rows = new HashSet[lines];
            HashSet<Integer>[] cols = new HashSet[lines];

            int trace = 0;
            for(int j=0;j<lines;j++) {
                for(int k=0;k<lines;k++) {
                    int item = s.nextInt();
                    if (rows[j] == null) rows[j] = new HashSet();
                    if (cols[k] == null) cols[k] = new HashSet();
                    rows[j].add(item);
                    cols[k].add(item);
                    if( j == k ) {
                        trace += item;
                    }
                }
            }
            int r = 0;
            int c = 0;
            for(int j=0;j<lines;j++){
                if(rows[j].size() != lines) {
                    r++;
                }
                if(cols[j].size() != lines) {
                    c++;
                }
            }
            System.out.printf("Case #%d: %d %d %d\n", i, trace, r, c);
        }
    }
}
