import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tests = scanner.nextInt();
        for(int cases = 1; cases <= tests; cases++)
        {
            int N = scanner.nextInt();
            int trace = 0;
            List<HashSet> rows = new ArrayList<>();
            List<HashSet> cols = new ArrayList<>();

            for(int r = 0; r < N; r++){
                rows.add(new HashSet());
                for(int c = 0; c < N; c++){
                    if (r == 0){
                        cols.add(new HashSet());
                    }
                    int num = scanner.nextInt();
                    rows.get(r).add(num);
                    cols.get(c).add(num);
                    if (r == c){
                        trace += num;
                    }
                }
            }

            int nr = 0;
            int nc = 0;
            for(int i = 0; i < N; i++){
                if (rows.get(i).size() != N){
                    nr++;
                }

                if (cols.get(i).size() != N){
                    nc++;
                }
            }
            System.out.println("Case #" + cases + ":" + " " + trace + " " + nr + " "  + nc);
        }

    }
}

