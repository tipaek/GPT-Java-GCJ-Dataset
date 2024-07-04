import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import javafx.util.Pair;


public class Solution {
    public Solution() {

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            List<Pair<Integer, Integer>> listPII = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                int l = in.nextInt();
                int r = in.nextInt();
                Pair<Integer, Integer> pii = new Pair<Integer, Integer>(l, r);
                listPII.add(pii);
            }
            Collections.sort(listPII, new Comparator<Pair<Integer, Integer>>() {
                @Override
                public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
                    return o1.getKey() - o2.getKey();
                }
            });
            Pair<Integer, Integer> C = new Pair<Integer, Integer>(-1, -1);
            Pair<Integer, Integer> J = new Pair<Integer, Integer>(-1, -1);
            List<Character> retChar = new ArrayList<>();
            boolean flag = true;
            for (int j = 0; j < n; j++) {
                Pair<Integer, Integer> next = listPII.get(j);
                if (isOccupied(C) && isOccupied(J) && isOverlap(C, next) && isOverlap(J, next)) {
                    flag = false;
                    break;
                }
                if (!isOccupied(C)) {
                    C = next;
                    retChar.add('C');
                } else if (!isOccupied(J)) {
                    J = next;
                    retChar.add('J');
                } else {
                    if (!isOverlap(C, next)) {
                        C = next;
                        retChar.add('C');
                    } else if (!isOverlap(J, next)) {
                        J = next;
                        retChar.add('J');
                    }
                }
            }
            if (!flag){ System.out.println("Case #" + i + ": IMPOSSIBLE");}
            else {System.out.println("Case #" + i + ": " + retChar.stream().map(String::valueOf).collect(Collectors.joining()));}
        }
    }
    private static boolean isOccupied(Pair<Integer, Integer> pii) {
        return pii.getKey() != -1 && pii.getValue() != -1;
    }

    private static boolean isOverlap(Pair<Integer, Integer> a, Pair<Integer, Integer> b) {
        if (a.getKey() > b.getKey()) return isOverlap(b, a);
        return a.getValue() > b.getKey();
    }
}