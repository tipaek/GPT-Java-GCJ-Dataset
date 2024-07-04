
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Solution
 */
public class Solution {

    public ArrayList<int[]> distribution(int number, int sum, int upper) { // a + b + c + d = sum
        ArrayList<int[]> l = new ArrayList<>();
        int[] a = new int[number];
        rec(number, 0, sum, a, upper, l);
        return l;
    }

    public void rec(int number, int t, int sum, int[] a, int upper, ArrayList<int[]> l) { // t: indexing from 0
        if (t == number - 1) {
            if (sum <= upper) {
                a[t] = sum;
                l.add(a);
            }
        } else {
            for (int i = 0; i <= upper; i++) {
                if (i > sum) {
                    break;
                }
                int[] b = a.clone();
                b[t] = i;
                rec(number, t + 1, sum - i, b, upper, l);
            }
        }
    }

    public int getMaxValue(int[] numbers) {
        int maxValue = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > maxValue) {
                maxValue = numbers[i];
            }
        }
        return maxValue;
    }

    public void print2darr(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            String s = "";
            for (int j = 0; j < arr[0].length; j++) {
                s += Integer.toString(arr[i][j]) + " ";
            }
            System.out.println(s);
        }
    }

    public String[] permutation(String s) {
        String first = s.substring(0, 1);
        // ArrayList<String> p = new ArrayList<>();
        String[] p = new String[fact(s.length())];
        if (s.length() == 1) {
            p[0] = (first);
            return p;
        }
        String[] t = permutation(s.substring(1, s.length()));
        int count = 0;
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < s.length(); j++) {
                p[count] = (putAti(t[i], first, j));
                count++;
            }

        }
        return p;
    }

    public String putAti(String s, String put, int i) {
        if (i == 0) {
            return put + s;
        } else if (i == s.length()) {
            return s + put;
        } else {
            return s.substring(0, i) + put + s.substring(i, s.length());
        }
    }

    public int fact(int n) {
        if (n == 0) {
            return 1;
        }
        return n * fact(n - 1);
    }

    public int isPalindrome(String A) {
        String s = A.replace(" ", "");
        s = s.toLowerCase();
        s = s.replaceAll("\\W", "");
        int t = 1;
        System.out.println(s);
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.substring(i, i + 1).equals(s.substring(s.length() - i - 1, s.length() - i))) {

            } else {
                t = 0;
                break;
            }
        }
        return t;

    }

    public String longestCommonPrefix(ArrayList<String> A) {
        String s = A.get(0).substring(0, 1);
        boolean t = true;
        int j = 0;
        while (t) {
            for (int i = 1; i < A.size(); i++) {
                if (A.get(i).charAt(j) == s.charAt(j)) {
                } else {
                    t = false;
                    break;
                }
            }
            if (t) {
                j++;
                s += A.get(0).charAt(j);
            }

        }

        return s;
    }

    public String countAndSay(int A) {
        String s = "1";
        String t = "";
        for (int i = 1; i < A; i++) {
            char p = s.charAt(0);
            int c = 0;
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == p) {
                    c++;
                } else {
                    t += Integer.toString(c) + s.charAt(j - 1);
                    c = 1;
                    p = s.charAt(j);
                }
            }
            t += Integer.toString(c) + p;
            s = t;
            t = "";

        }

        return s;
        // 1 is read off as one 1 or 11
        // 11 is read off as two 1s or 21.
        // 21 is read off as one 2, then one 1 or 1211.
        // Given an integer n, generate the nth sequence.
    }

    public static void main(String[] args) {
        Solution t = new Solution();

        // 3
        // 5 2
        // 10 13 15 16 17
        // 5 6
        // 9 10 20 26 30
        // 8 3
        // 1 2 3 4 5 6 7 10
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        for (int i = 0; i < n; i++) {
            int ars = s.nextInt();
            int k = s.nextInt();
            ArrayList<Integer> ar = new ArrayList<>();
            for (int j = 0; j < ars; j++) {
                ar.add(s.nextInt());
            }
            for (int j = 0; j < k; j++) {
                
                t.insertmin(ar);
            }
            int max = 0;
            for (int j = 0; j < ar.size() - 1; j++) {
                if ((ar.get(j + 1) - ar.get(j)) > max) {
                    max = (ar.get(j + 1) - ar.get(j));
                    
                }
            }
            System.out.println("Case #" + (i + 1) + ": " + max);

        }

    }

    private void insertmin(ArrayList<Integer> ar) {
        int max = 0;
        int t = 0;
        for (int i = 0; i < ar.size() - 1; i++) {
            if ((ar.get(i + 1) - ar.get(i)) > t) {
                t = ar.get(i + 1) - ar.get(i);
                max = i;
            }
        }

        ar.add(max + 1, (ar.get(max + 1) + ar.get(max)) / 2);

    }
}