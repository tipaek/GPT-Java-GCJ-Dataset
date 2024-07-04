import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        Record[] records = new Record[10000];
        for (int i = 0; i < T; i++) {
            int U = sc.nextInt();
            for (int j = 0; j < 10000; j++) {
                long M = sc.nextLong();
                String s = sc.nextLine().trim();
                records[j] = new Record(s, M);
            }
            String res = solve(records, U);

            System.out.println("Case #" + (i + 1) + ": " + res);
        }
    }

    public static String solve(Record[] records, int U) {
        HashMap<Integer, HashSet<Character>> possible = new HashMap<>();
        HashSet<Character> usedLetters = new HashSet<>();
        for (int i = 0; i < records.length; i++) {
            for(char c : records[i].s.toCharArray()) {
                usedLetters.add(c);
            }
        }
        StringBuilder D = new StringBuilder();
        usedLetters.forEach(c -> D.append(c));
        //System.out.println(D);
        // init
        for (int i = 0; i < 10; i++) {
            possible.put(i, new HashSet<>(usedLetters));
        }
        //out(possible);
        // first - can not be 0;
        for (int i = 0; i < records.length; i++) {
            Record r = records[i];
            char first = r.s.charAt(0);
            if (possible.get(0).contains(first)) {
                possible.get(0).remove(first);
            }
            if (r.M != -1) {
                if (Long.toString(r.M).length() == r.s.length()) {
                    int f = Long.toString(r.M).charAt(0) - '0';
                    for (int j = f + 1; j < 10; j++) {
                        if (possible.get(j).contains(r.s.charAt(0))) {
                            possible.get(j).remove(r.s.charAt(0));
                        }
                    }
                }
            }
        }
        //out(possible);
        reCalculate(possible);
        //out(possible);
        resolveMultiple(possible);
        //out(possible);
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            res.append(possible.get(i).iterator().next());
        }
        return res.toString();
    }

    public static void resolveMultiple(HashMap<Integer, HashSet<Character>> possible) {
        for (int i = 2; i <= 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (possible.get(j).size() == i) {
                    // remove one and recheck
                    possible.get(j).remove(possible.get(j).iterator().next());
                    reCalculate(possible);
                    resolveMultiple(possible);
                    return;
                }
            }
        }
    }

    public static void reCalculate(HashMap<Integer, HashSet<Character>> possible) {
        for (int i = 0; i < 10; i++) {
            if (possible.get(i).size() == 1) {
                char v = possible.get(i).iterator().next();
                // remove from others
                for (int j = 0; j < 10; j++) {
                    if (j != i) {
                        if (possible.get(j).contains(v)) { possible.get(j).remove(v); reCalculate(possible);}
                    }
                }
            }
        }
    }

    public static void out(HashMap<Integer, HashSet<Character>> possible) {
        for (int i = 0; i < 10; i++) {
            System.out.println(i + ": " + possible.get(i));
        }
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
    }

    public static int getInt(String D, String number) {
        int res = 0;
        for (int i = number.length() - 1; i >= 0; i--) {
            char c = number.charAt(i);
            for (int j = 0; j < D.length(); j++) {
                if (c == D.charAt(0)) {
                    res += j * Math.pow(10, number.length() - 1 - i);
                    break;
                }
            }
        }
        return res;
    }
}
class Record {
    String s;
    long M;

    public Record(String s, long m) {
        this.s = s;
        M = m;
    }
}

