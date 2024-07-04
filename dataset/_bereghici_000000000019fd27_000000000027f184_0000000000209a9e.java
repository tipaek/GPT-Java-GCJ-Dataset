import java.util.*;
import java.util.stream.Collectors;

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
                System.out.println(toString(list));
                String ans = sc.next();
            }
        } else if (b == 20) {
            for (int i = 0; i < t; ++i) {
                List<String> a0 = new ArrayList<>();
                List<String> b0 = new ArrayList<>();
                List<String> c0 = new ArrayList<>();
                List<String> d0 = new ArrayList<>();
                for (int ii = 1; ii <= 5; ++ii) {
                    System.out.println(ii);
                    String el = sc.next();
                    a0.add(el);
                }
                for (int ii = 11; ii <= 15; ++ii) {
                    System.out.println(ii);
                    String el = sc.next();
                    c0.add(el);
                }
                List<String> a1 = new ArrayList<>();
                List<String> d1 = new ArrayList<>();
                for (int ii = 1; ii <= 5; ++ii) {
                    System.out.println(ii);
                    String el = sc.next();
                    a1.add(el);
                }
                for (int ii = 16; ii <= 20; ++ii) {
                    System.out.println(ii);
                    String el = sc.next();
                    d1.add(el);
                }

                if (a0.equals(a1)) {
                    d0 = d1;
                } else if (a0.equals(complementary(a1))) {
                    d0 = complementary(d1);
                } else if (a0.equals(reversed(d1))) {
                    d0 = reversed(a1);
                } else if (a0.equals(reversed(complementary(d1)))) {
                    d0 = reversed(complementary(a1));
                }

                List<String> c2 = new ArrayList<>();
                List<String> b2 = new ArrayList<>();
                for (int ii = 6; ii <= 10; ++ii) {
                    System.out.println(ii);
                    String el = sc.next();
                    b2.add(el);
                }
                for (int ii = 11; ii <= 15; ++ii) {
                    System.out.println(ii);
                    String el = sc.next();
                    c2.add(el);
                }

                if (c0.equals(c2)) {
                    b0 = b2;
                } else if (c0.equals(complementary(c2))) {
                    b0 = complementary(b2);
                } else if (c0.equals(reversed(b2))) {
                    b0 = reversed(c2);
                } else if (c0.equals(reversed(complementary(b2)))) {
                    b0 = reversed(complementary(c2));
                }

                List<String> a3 = new ArrayList<>();
                for (int ii = 1; ii <= 5; ++ii) {
                    System.out.println(ii);
                    String el = sc.next();
                    a3.add(el);
                }
                String result = "";
                if (a0.equals(a3)) {
                    result = toString(a0) +
                            toString(b0) +
                            toString(c0) +
                            toString(d0);
                } else if (a0.equals(complementary(a3))) {
                    result = toString(complementary(a0)) +
                            toString(complementary(b0)) +
                            toString(complementary(c0)) +
                            toString(complementary(d0));

                } else if (a0.equals(reversed(a3))) {
                    result = toString(reversed(a0)) +
                            toString(reversed(b0)) +
                            toString(reversed(c0)) +
                            toString(reversed(d0));

                } else if (a0.equals(reversed(complementary(a3)))) {
                    result = toString(reversed(complementary(a0))) +
                            toString(reversed(complementary(b0))) +
                            toString(reversed(complementary(c0))) +
                            toString(reversed(complementary(d0)));
                } else {
                    if (d0.equals(reversed(a3))) {
                        result = toString(reversed(d0)) +
                                toString(reversed(c0)) +
                                toString(reversed(b0)) +
                                toString(reversed(a0));

                    } else if (d0.equals(reversed(complementary(a3)))) {
                        result = toString(reversed(complementary(d0))) +
                                toString(reversed(complementary(c0))) +
                                toString(reversed(complementary(b0))) +
                                toString(reversed(complementary(a0)));
                    }
                }
                System.out.println(result);
                String ans = sc.next();
            }
        }
    }

    private static String toString(List<String> a) {
        return a.stream().reduce("", (a0, a1) -> a0 + a1);
    }

    public static List<String> complementary(List<String> a) {
        return a.stream().map(i -> i.equals("0") ? "1" : "0").collect(Collectors.toList());
    }

    public static List<String> reversed(List<String> a) {
        List<String> result = new ArrayList<>(a);
        Collections.reverse(result);
        return result;
    }

}
