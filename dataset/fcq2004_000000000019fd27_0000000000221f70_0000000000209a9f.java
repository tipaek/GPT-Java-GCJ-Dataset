import java.util.*;
import java.io.*;

public class Solution {
    static char[] theList;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();

        for (int i = 0; i < T; i++) {
            theList = in.next().toCharArray();
            ArrayList<Integer> m = new ArrayList<>();
            for (int j = 0; j < theList.length; j++) {
                m.add(theList[j] - 48);
            }
            System.out.println("Case #" + (i + 1) + ": " + solve(m));
        }
    }

    static String solve(ArrayList<Integer> ar) {
        int[] left = new int[ar.size()];
        int[] right = new int[ar.size()];
        int start = -1;
        int end = -1;
        while (!check(ar)) {
            for (int i = 0; i < ar.size(); i++) {
                if (ar.get(i) > 0 && ar.size() == 1) {
                    left[0]++;
                    right[0]++;
                } else if (ar.get(i) > 0 && i == ar.size() - 1) {
                    if (start != -1) {
                        end = i;
                        left[start]++;
                        right[end]++;
                        start = -1;
                        end = -1;
                    } else {
                        left[i]++;
                        right[i]++;
                        start = -1;
                        end = -1;
                    }
                } else if (ar.get(i) > 0 && start == -1) {
                    System.out.println(start);
                    start = i;
                } else if (ar.get(i) <= 0 && start != -1) {
                    end = i - 1;
                    left[start]++;
                    right[end]++;
                    start = -1;
                    end = -1;
                }
            }
            for (int i = 0; i < ar.size(); i++) {
                ar.set(i, ar.get(i) - 1);
            }
        }
        String s = "";
        for (int i = 0; i < theList.length; i++) {
            for (int j = 0; j < left[i]; j++) {
                s += '(';
            }
            s += theList[i];
            for (int j = 0; j < right[i]; j++) {
                s += ')';
            }
        }
        return s;
    }

    static boolean check(ArrayList<Integer> ar) {
        for (Integer i : ar) {
            if (i > 0) {
                return false;
            }
        }
        return true;
    }
}