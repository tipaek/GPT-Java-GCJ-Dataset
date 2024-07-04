import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int x = 1; x <= T; x++) {
            int N = sc.nextInt();
            String[] strings = new String[N];
            for (int i = 0; i < N; i++) {
                strings[i] = sc.next();
            }
            String result = mergeStrings(strings[0], strings[1]);
            int j = 2;
            while (!result.equals("*") && j < N) {
                result = mergeStrings(result, strings[j]);
                j++;
            }
            if (!result.equals("*")) {
                result = removeAsterisks(result);
            }
            System.out.println("Case #" + x + ": " + result);
        }
    }

    public static String mergeStrings(String A, String B) {
        StringBuilder merged = new StringBuilder();
        int ia = A.indexOf('*');
        int ib = B.indexOf('*');

        if (ia < ib) {
            for (int i = 0; i < ia; i++) {
                if (A.charAt(i) != B.charAt(i)) return "*";
                merged.append(A.charAt(i));
            }
            merged.append(B, ia, ib);
        } else {
            for (int i = 0; i < ib; i++) {
                if (A.charAt(i) != B.charAt(i)) return "*";
                merged.append(B.charAt(i));
            }
            merged.append(A, ib, ia);
        }

        merged.append('*');
        int endA = A.lastIndexOf('*');
        int endB = B.lastIndexOf('*');

        merged.append(A, ia + 1, endA);
        merged.append(B, ib + 1, endB);

        ia++;
        ib++;
        int lenA = A.length();
        int lenB = B.length();

        if (lenA - ia > lenB - ib) {
            merged.append(A, ia, lenA - lenB + ib);
            int j = ib;
            for (int i = lenA - lenB + ib; i < lenA; i++) {
                if (A.charAt(i) != B.charAt(j)) return "*";
                merged.append(A.charAt(i));
                j++;
            }
        } else {
            merged.append(B, ib, lenB - lenA + ia);
            int j = ia;
            for (int i = lenB - lenA + ia; i < lenB; i++) {
                if (A.charAt(j) != B.charAt(i)) return "*";
                merged.append(B.charAt(i));
                j++;
            }
        }

        return merged.toString();
    }

    public static String removeAsterisks(String str) {
        return str.replace("*", "");
    }
}