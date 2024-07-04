//package googlecodejam;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Solution {
    static class Info {
        long num;
        char[] code;

        public Info(long num, char[] code) {
            this.num = num;
            this.code = code;
        }
    }

    public static String solve(List<Info> infos, Set<Character> chars, int M) {
        Map<Character, Integer> poss = new HashMap<>();
        for(char c: chars) {
            poss.put(c, 9);
        }
        for(Info info: infos) {
            if (info.num == -1) {
                info.num = ThreadLocalRandom.current().nextLong((long) Math.pow(10, M) - 1);
            }
            long maxPoss = ((long) Math.pow(10, info.code.length)) - 1;
            if (info.num != -1) maxPoss = Math.min(maxPoss, info.num);
            String strNum = Long.toString(maxPoss);

            poss.put(info.code[0], Math.min(Character.digit(strNum.charAt(0), 10), poss.get(info.code[0])));
            if (strNum.charAt(0) == '1' && strNum.length() > 1) {
                poss.put(info.code[1], Math.min(Character.digit(strNum.charAt(1), 10), poss.get(info.code[1])));
            }

        }
        char[] D= new char[10];
        for(char c: poss.keySet()) D[poss.get(c)] = c;
        return new String(D);
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int cases = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < cases; i++) {
            int M = Integer.parseInt(scan.nextLine());
            List<Info> infos = new ArrayList<>();
            Set<Character> chars = new HashSet<>();
            for (int j=0; j < 10000; j++) {
                String ln = scan.nextLine();
                String[] in = ln.split(" ");
                Info info = new Info(Long.parseLong(in[0]), in[1].toCharArray());
                for (char c: in[1].toCharArray()) chars.add(c);
                infos.add(info);
            }
            System.out.printf("Case #%d: %s\n", (i + 1), solve(infos, chars, M));
        }
    }



}
