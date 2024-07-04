

import java.io.*;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {

    public static void main(String[] args) throws IOException {
        //test();

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = in.nextInt();
        in.nextLine();
        for (int i = 0; i < t; ++i) {
            List<String> ls = new ArrayList<>();
            int u = in.nextInt();
            in.nextLine();
            for (int j = 0; j < 10000; j++) {
                String q = in.next();
                String r = in.next();
                ls.add(r);
            }

            String result = solve(ls);
            String answer = "Case #" + (i + 1) + ": " + result;
            System.out.println(answer);
        }
        in.close();
        out.close();
    }

    static String solve(List<String> ls) {
        BigInteger[] weight = w(20);
        ConcurrentMap<Integer, BigInteger> map = new ConcurrentHashMap<>();
        ls.forEach(s -> {
            for (int i = 0; i < s.length(); i++) {
                int ch = s.charAt(i);
                BigInteger w = weight[s.length() - i];
                map.put(ch, map.getOrDefault(ch, w).add(w));
            }
        });
        List<Integer> li = map.entrySet().stream().sorted((e1, e2) -> -e1.getValue().compareTo(e2.getValue()))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        String from1 = li.stream().collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
        String from0 = from1.substring(from1.length() - 1) + from1.substring(0, from1.length() - 1);
        return from0;
    }

    static BigInteger [] w(int n) {
        BigInteger [] a = new BigInteger[n];
        a[0] = BigInteger.ONE;
        for (int i = 1; i< a.length; i++) {
            a[i] = BigInteger.TEN.multiply(a[i-1]);
        }
        return a;
    }

    static void test() {

        try {
            Files.write(Paths.get(""), generate("CODEJAMFUN"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static List<String> generate(String s) {
        Random random = new Random();
        List<String> lg = IntStream.range(0, 10000).mapToLong(i -> nextNumber(random)).mapToObj(v -> "" + v + " " + map(v, s)).collect(Collectors.toList());
        List<String> ls = new ArrayList<>();
        ls.add("1");
        ls.add("16");
        ls.addAll(lg);
        return ls;
    }

    static String map(long v, String s) {
        StringBuilder sb = new StringBuilder();
        while (v > 0) {
            int last = (int) (v % 10);
            sb.append(s.charAt(last));
            v /= 10;
        }
        sb.reverse();
        return sb.toString();
    }

    static long nextNumber(Random random) {
        return nextLong(random, nextM(random));
    }

    static long nextM(Random random) {
        return nextLong(random, 10000000000000000L - 1L);
    }

    static long nextLong(Random random, long bound) {
        long temp;
        do {
            temp = Math.abs(random.nextLong()) + 1L;
        } while (temp > bound);
        return temp;
    }


}