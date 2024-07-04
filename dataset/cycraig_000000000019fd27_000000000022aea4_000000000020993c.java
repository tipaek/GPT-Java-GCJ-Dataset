import java.util.*;
import java.io.*;

public class Solution {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int trace = 0;
            int rowDuplicates = 0;
            int colDuplicates = 0;
            Set<Integer>[] colSeen = new HashSet[n];
            for(int j = 0; j < n; j++) colSeen[j] = new HashSet<>();
            boolean[] colDuplicate = new boolean[n];
            for(int j = 0; j < n; j++) {
                boolean[] rowSeen = new boolean[n];
                boolean rowDuplicate = false;
                for(int k = 0; k < n; k++) {
                    int x = in.nextInt()-1;
                    if(rowSeen[x]) rowDuplicate = true;
                    rowSeen[x] = true;
                    //System.out.print((x+1) + " ");
                    if(colSeen[k].contains(x)) colDuplicate[k] = true;
                    colSeen[k].add(x);
                    if(k == j) trace += (x+1);
                }
                //System.out.println();
                if(rowDuplicate) rowDuplicates++;
            }
            for(int j = 0; j < n; j++) {
                //System.out.println(colDuplicate[j]);
                colDuplicates += (colDuplicate[j]) ? 1 : 0;
            }
            System.out.println("Case #" + i + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }
    }
  
}
