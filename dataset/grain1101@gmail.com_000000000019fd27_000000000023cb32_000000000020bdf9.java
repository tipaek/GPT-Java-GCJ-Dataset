import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class Solution {
    public Solution() {

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            List<PII> listPII = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                int l = in.nextInt();
                int r = in.nextInt();
                PII pii = new PII(l, r);
                listPII.add(pii);
            }
            Collections.sort(listPII, new Comparator<PII>() {
                @Override
                public int compare(PII o1, PII o2) {
                    return o1.getKey() - o2.getKey();
                }
            });
            PII C = new PII(-1, -1);
            PII J = new PII(-1, -1);
            List<Character> retChar = new ArrayList<>();
            boolean flag = true;
            for (int j = 0; j < n; j++) {
                PII next = listPII.get(j);
                if (isOverlap(C, next) && isOverlap(J, next)) {
                    flag = false;
                    break;
                }
                if (!isOverlap(C, next)) {
                    C = next;
                    retChar.add('C');
                } else if (!isOverlap(J, next)) {
                    J = next;
                    retChar.add('J');
                }
            }
            if (!flag){ System.out.println("Case #" + i + ": IMPOSSIBLE");}
            else {System.out.println("Case #" + i + ": " + retChar.stream().map(String::valueOf).collect(Collectors.joining()));}
        }
    }
    private static boolean isOccupied(PII pii) {
        return pii.getKey() != -1 && pii.getValue() != -1;
    }

    private static boolean isOverlap(PII a, PII b) {
        if (a.getKey() > b.getKey()) return isOverlap(b, a);
        if (a.getKey() == -1) return false;
        return a.getValue() > b.getKey();
    }
}

class PII {
    int key;
    int value;
    public PII(int _key, int _value) {
        key = _key;
        value = _value;
    }
    public int getKey() {
        return key;
    }
    public int getValue() {
        return value;
    }
}