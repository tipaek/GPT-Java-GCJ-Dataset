import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {


    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int T = Integer.parseInt(in.nextLine());
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(in.nextLine());
            List<String> list = new ArrayList<>();
            String longest = "";
            for (int n = 1; n <= N; n++) {
                String p = in.nextLine().replace("*", "");
                int pLen = p.length();
                if (pLen > longest.length()) {
                    longest = p;
                }
                list.add(p);
            }
            if (solve(list, longest)) {
                System.out.println("Case #" + t + ": " + longest);
            } else {
                System.out.println("Case #" + t + ": *");
            }
        }
    }

    private static boolean solve(List<String> list, String longest) {
        for (String s : list) {
            if (!longest.contains(s)) {
                return false;
            }
        }
        return true;
    }
}