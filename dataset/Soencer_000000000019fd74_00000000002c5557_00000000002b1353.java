import java.util.*;
import java.io.*;
import java.lang.Math.*;

public class Solution2 {
    static ArrayList<String> spots = new ArrayList<>();
    static ArrayList<ArrayList<Boolean>> visitedN = new ArrayList<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int k = 0; k < t; k++) {
            int n = in.nextInt();
            path(n, 1, 1);
            System.out.println("Case #"+(k+1)+":");
            for (String print : spots) {
                System.out.println(print);
            }
            spots = new ArrayList<>();
            visitedN = new ArrayList<>();
        }
    }
    static int factorial(int n) {
        if (n == 0) return 1;
        int ret = 1;
        for(int i = 1; i <= n; i++) {
            ret *= i;
        }
        return ret;
    }

    static int pascal(int r, int k) {
        //System.out.println((k-1)+": "+factorial(k-1)+", "+(r-k)+": "+factorial(r-k));
        return factorial(r-1)/(factorial(k-1)*factorial(r-k));
    }
    static boolean visited(int r, int k) {
        if (visitedN.size() < r) {
            visitedN.add(r-1, new ArrayList<Boolean>());
            for(int i = 0; i < r; i++) {
                visitedN.get(r-1).add(false);
            }
        }
        return visitedN.get(r-1).get(k-1);
    }
    static void visit(int r, int k, boolean value) {
        if (visitedN.size() < r) {
            visitedN.add(r-1, new ArrayList<Boolean>());
            for(int i = 0; i < r; i++) {
                visitedN.get(r-1).add(false);
            }
        }
        visitedN.get(r-1).set(k-1, value);
    }
    static boolean path(int total, int r, int k) {
        visit(r, k, true);
        if (total == 0) {
            return true;
        }
        if (total < 0) {
            visit(r, k, false);
            return false;
        }
        if(k-1 <= r-1 && r-1 > 0 && k-1 > 0 && r-1 < 13 && total-pascal(r-1, k-1) >= 0 && !visited(r-1, k-1) && path(total-pascal(r-1, k-1), r-1, k-1)) {
            spots.add(0, r+" "+k);
            return true;
        } else if (k <= r-1 && r-1 > 0 && k > 0 && r-1 < 13 && total-pascal(r-1, k) >= 0 && !visited(r-1, k) && path(total-pascal(r-1, k), r-1, k)) {
            spots.add(0, r+" "+k);
            return true;
        } else if (k-1 <= r && r > 0 && k-1 > 0 && r < 13 && total-pascal(r, k-1) >= 0 && !visited(r,k-1) && path(total-pascal(r,k-1), r, k-1)) {
            spots.add(0, r+" "+k);
            return true;
        } else if (k+1 <= r && r > 0 && k+1 > 0 && r < 13 && total-pascal(r, k+1) >= 0 && !visited(r,k+1) && path(total-pascal(r,k+1), r, k+1)) {
            spots.add(0, r+" "+k);
            return true;
        } else if (k <= r+1 && r+1 > 0 && k > 0 && r+1 < 13 && total-pascal(r+1, k) >= 0 && !visited(r+1,k) && path(total-pascal(r+1,k), r+1, k)) {
            spots.add(0, r+" "+k);
            return true;
        } else if (k+1 <= r+1 && r+1 > 0 && k+1 > 0 && r+1 < 13 && total-pascal(r+1, k+1) >= 0 && !visited(r+1,k+1) && path(total-pascal(r+1,k+1), r+1, k+1)) {
            spots.add(0, r+" "+k);
            return true;
        } else {
            visit(r, k, false);
            return false;
        }
    }
}