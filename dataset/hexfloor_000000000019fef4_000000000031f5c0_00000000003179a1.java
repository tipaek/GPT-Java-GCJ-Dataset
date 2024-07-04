

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = in.nextInt();
        in.nextLine();
        for (int i = 0; i < t; ++i) {
            List<String> ls = new ArrayList<>();
            int u = in.nextInt();
            in.nextLine();
            for (int j = 0; j<10000; j++) {
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
        ConcurrentMap<Integer, Long> map = new ConcurrentHashMap<>();
        ls.stream().parallel().forEach(s -> s.chars().forEach(ch -> map.merge(ch, 1L, Long::sum)));
        List<Integer> li =map.entrySet().stream().sorted((e1, e2) -> - e1.getValue().compareTo(e2.getValue()))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
       String from1 = li.stream().collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
       String from0 = from1.substring(from1.length() -1) + from1.substring(0, from1.length() - 1);
       return from0;
    }

}