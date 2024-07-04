import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        in.nextLine();

        for (int i=1; i<= t; i++) {
            int n = in.nextInt();
            in.nextLine();
            int k = 0, r = 0, c = 0;
            ArrayList<Set<Integer>> ySets = new ArrayList<>(n);
            for (int y = 0; y < n; y++)
                ySets.add(new HashSet<>(n));
            for (int y = 0; y < n; y++) {
                Set<Integer> xSet = new HashSet<>(n);
                for (int x = 0; x < n; x++) {
                    int cell = in.nextInt();
                    xSet.add(cell);
                    ySets.get(x).add(cell);
                    if (x==y)
                        k += cell;
                }
                if (xSet.size() < n)
                    r++;
                in.nextLine();
            }
            for (int y = 0; y < n; y++) {
                if (ySets.get(y).size() < n)
                    c++;
            }

            System.out.println("Case #" + i + ": " + k + " " + r + " " + c);
        }
    }
}
