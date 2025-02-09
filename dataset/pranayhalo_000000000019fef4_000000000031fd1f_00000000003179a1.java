/*
 * Author: pranay.agra
 * Time: 2020-05-01 10:35:01
 */

import java.io.*;
import java.util.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner std = new Scanner(System.in);
        BufferedWriter log = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder strBu = new StringBuilder();
        MergeSort merge = new MergeSort();

        int t = std.nextInt();
        int caseN = 0;

        while (caseN++ < t) {
           HashMap<Character, Integer> ans = new HashMap<>();
           TreeMap<Integer, Character> freq = new TreeMap<Integer, Character>(new MyCopr());
           HashSet<Character> allLetters = new HashSet<>();
           int U = std.nextInt();
           for (int i = 0; i < 10000; i++) {
               long val = std.nextLong();
               char[] letters = std.next().toCharArray();

               ans.put(letters[0], ans.getOrDefault(letters[0], 0) + 1);

               for (int j = 0; j < letters.length; j++) {
                   allLetters.add(letters[j]);
               }

           }

        for (Character elem: ans.keySet()) {
            freq.put(ans.get(elem), elem);
            allLetters.remove(elem);
        }

        Character zeroLetter = 'a';

        for (Character elem: allLetters) {
            zeroLetter = elem;
        }

        log.write("Case #" + caseN + ": " + zeroLetter);

        for (Integer elem: freq.keySet()) {
            log.write(freq.get(elem) + "");
        }

        log.write("\n");

        }
        log.flush();





    }
    static class MyCopr implements Comparator<Integer>{

        @Override
        public int compare(Integer str1, Integer str2) {
            return str2 - str1;
        }

    }

    /**
     Remember to check for overflow (long)
     Does number need to be greater than a lower bound?
     **/

    static class Scanner {
        StringTokenizer st;
        BufferedReader br;

        public Scanner(InputStream system) {
            br = new BufferedReader(new InputStreamReader(system));
        }

        public Scanner(String file) throws Exception {
            br = new BufferedReader(new FileReader(file));
        }

        public String next() throws IOException {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        public String nextLine() throws IOException {
            return br.readLine();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        public double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }

        public char nextChar() throws IOException {
            return next().charAt(0);
        }

        public Long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        public int[] nextArrInt(int n) throws IOException {
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
            return a;
        }

        public long[] nextArrLong(int n) throws IOException {
            long[] a = new long[n];
            for (int i = 0; i < n; i++)
                a[i] = nextLong();
            return a;
        }

        public boolean ready() throws IOException {
            return br.ready();
        }

        public void waitForInput() throws InterruptedException {
            Thread.sleep(3000);
        }
    }

    static class MergeSort {
        private void merge(int arr[], int l, int m, int r) {
            int n1 = m - l + 1;
            int n2 = r - m;

            int L[] = new int[n1];
            int R[] = new int[n2];

            for (int i = 0; i < n1; ++i)
                L[i] = arr[l + i];
            for (int j = 0; j < n2; ++j)
                R[j] = arr[m + 1 + j];

            int i = 0, j = 0;

            int k = l;
            while (i < n1 && j < n2) {
                if (L[i] <= R[j]) {
                    arr[k] = L[i];
                    i++;
                } else {
                    arr[k] = R[j];
                    j++;
                }
                k++;
            }
            while (i < n1) {
                arr[k] = L[i];
                i++;
                k++;
            }
            while (j < n2) {
                arr[k] = R[j];
                j++;
                k++;
            }
        }

        void sort(int arr[]) {
            lensort(arr, 0, arr.length - 1);
        }

        private void lensort(int arr[], int l, int r) {
            if (l < r) {
                int m = (l + r) / 2;
                lensort(arr, l, m);
                lensort(arr, m + 1, r);
                merge(arr, l, m, r);
            }
        }
    }
}