import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        int b = in.nextInt();
        for (int k = 1; k <= t; k++) {
            Map<String, Integer> freq = new HashMap<>();
//            for (int j = 0; j < 3; j++) {
                StringBuilder sb = new StringBuilder();
                for (int i = 1; i <= b; i++) {
                    System.out.println(i);
                    sb.append(in.nextInt());
                }
//                freq.merge(sb.toString(), 1, Integer::sum);
//            }
//            System.out.println(freq.keySet().stream().max(Comparator.comparingInt(freq::get)).get());
            System.out.println(sb);
            String s = in.nextLine();
            if (s != "Y") {
                return;
            }
        }
    }
}
