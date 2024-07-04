import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; ++i) {
            int b = sc.nextInt();
            List<String> list = new ArrayList<>();
            for (int ii = 1; ii <= b; ++ii) {
                System.out.println(ii);
                String el = sc.next();
                list.add(el);
            }
            // 1. Normal
            System.out.println(list.stream().reduce("", (s0, s1) -> s0 + s1));
            String ans = sc.next();
            if (ans.equals("Y")) {
                continue;
            }
            // 2.Complementary
            System.out.println(list.stream()
                    .map(bit -> bit.equals("0") ? "1" : "0")
                    .reduce("", (s0, s1) -> s0 + s1)
            );
            ans = sc.next();
            if (ans.equals("Y")) {
                continue;
            }

            // 3. Reverse
            Collections.reverse(list);
            System.out.println(list.stream()
                    .reduce("", (s0, s1) -> s0 + s1)
            );
            ans = sc.next();
            if (ans.equals("Y")) {
                continue;
            }

            // 4. Reverse complementary
            System.out.println(list.stream()
                    .map(bit -> bit.equals("0") ? "1" : "0")
                    .reduce("", (s0, s1) -> s0 + s1)
            );
            ans = sc.next();
            if (ans.equals("Y")) {
                continue;
            }
        }
    }

    public static void transformComplementary(List<Integer> list) {
        Collections.reverse(list);
    }
}
