import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Solution {

    public static void main(String[] args) {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int T = in.nextInt();

        for (int t=1; t<=T; t++) {
            int tasks = in.nextInt();
            int c = 0;
            int j = 0;
            StringBuilder result = new StringBuilder();
            Map<Integer, Integer> map = new TreeMap<>();
            for (int i=1; i <= tasks; i++) {
                int start = in.nextInt();
                int end = in.nextInt();
                map.put(start, end);
            }
            for (int start : map.keySet()){
                int end = map.get(start);
                if (c <= start) {
                    c = end;
                    result.append("C");
                } else if (j <= start) {
                    j = end;
                    result.append("J");
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }

            System.out.println("Case #" + t +": " + result.toString());
        }
    }

}