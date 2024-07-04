import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int b = sc.nextInt();
        if (b == 10) {
            for (int i = 0; i < t; ++i) {
                List<String> list = new ArrayList<>();
                for (int ii = 1; ii <= b; ++ii) {
                    System.out.println(ii);
                    String el = sc.next();
                    list.add(el);
                }
                System.out.println(list.stream().reduce("", (s0, s1) -> s0 + s1));
                String ans = sc.next();
            }
        }
    }
}
