import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        int row = 0;
        int col = 0;
        int trace = 0;
        Set<Integer> hash_Set = new HashSet<Integer>();
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 1; i <= t; ++i) {
            int size = in.nextInt();
            int[] colarray = new int[size];
            for (int j = 1; j <= size; j++) {
                for (int k = 1; k <= size; k++) {
                    int n = in.nextInt();
                    if (j == k) trace += n;
                    if (!hash_Set.add(n)) row++;
                    if (row > k) row = k;
                    if (!set.add(10*k+n)) colarray[k-1]++;
                    if (colarray[k-1] > 1) colarray[k-1] = 1;
                }
                hash_Set.clear();
            }
            for (int c : colarray){
                col += c;
            }
            System.out.println("Case #" + i + ": " + trace + " " + row + " " + col);
            hash_Set.clear();
            set.clear();
            trace = 0;
            row = 0;
            col = 0;
            Arrays.fill(colarray,0);
        }
    }
}