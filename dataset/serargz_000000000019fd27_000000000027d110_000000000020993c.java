import java.util.Scanner;
import java.lang.Math;
import java.util.*;

public class Solution {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int t = sc.nextInt();

        for(int i=0; i<t; i++)
            System.out.println("Case #" + (i+1) + ": " + doit(i));
    }

    private static String doit(int t) {

        int n = sc.nextInt();
        List<Set<Integer>> rows = new ArrayList<>(n);
        List<Set<Integer>> cols = new ArrayList<>(n);

        Set<Integer> repeatedRows = new HashSet<Integer>();
        Set<Integer> repeatedCols = new HashSet<Integer>();

        for(int i=0; i<n; i++) {
            rows.add(new HashSet<>());
            cols.add(new HashSet<>());
        }

        int k=0, tmp;
        for(int r=0; r<n; ++r) {
            for(int c=0; c<n; ++c) {
                tmp = sc.nextInt();
                if(rows.get(r).contains(tmp))
                    repeatedRows.add(r);
                else
                    rows.get(r).add(tmp);

                if(cols.get(c).contains(tmp))
                    repeatedCols.add(c);
                else
                    cols.get(c).add(tmp);

                if(r == c) k += tmp;
            }
        }

        return String.format("%d %d %d", k, repeatedRows.size(), repeatedCols.size());
    }
}

