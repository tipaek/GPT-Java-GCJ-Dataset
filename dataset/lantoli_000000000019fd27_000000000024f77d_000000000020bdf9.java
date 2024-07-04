import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws Exception {
        //String inFile = "sample.in";
        //Scanner sc = new Scanner(Solution.class.getResource(inFile).openStream());
        Scanner sc = new Scanner(System.in);
        int tests = sc.nextInt();
        sc.nextLine();
        for (int test=1; test<=tests; test++) {
            int n = sc.nextInt();
            int[] start = new int[n];
            int[] end = new int[n];
            for (int i = 0; i < n; i++) {
                start[i] = sc.nextInt();
                end[i] = sc.nextInt();
            }
            System.out.println("Case #" + test + ": " + doit(n, start, end));
        }
    }

    private static String doit(int n, int[] start, int[] end) {
        Integer[] index = new Integer[n];
        for (int i = 0; i < n; i++) {
            index[i] = i;
        }
        Arrays.sort(index, (i1, i2) -> {
           if (start[i1] != start[i2]) {
               return Integer.compare(start[i1], start[i2]);
           }
           return Integer.compare(end[i2], end[i1]);
        });
        boolean person = false;
        char[] ret = new char[n];
        for (int i = 0; i < n; i++) {
            if (i+2 < n) {
                int i1 = index[i], i2 = index[i+1] , i3 = index[i+2];
                int left = Math.min(start[i1], Math.min(start[i2], start[i3]));
                int right = Math.max(end[index[i]], Math.max(end[index[i+1]], end[index[i+2]]));
                for (int pos = left; pos <= right; pos++) {
                    if (pos >= start[i1] && pos < end[i1] && pos >= start[i2] && pos < end[i2] && pos >= start[i3] && pos < end[i3]) {
                        return "IMPOSSIBLE";
                    }
                }
            }
            ret[index[i]] = person ? 'C' : 'J';
            person = !person;
        }
        return String.valueOf(ret);
    }
}
