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
            int N = std.nextInt();
            int D = std.nextInt();
            HashMap<Long, Integer> ans = new HashMap<>();
            HashMap<Long, Integer> iter = new HashMap<>();
            for (int i = 0; i < N; i++) {
                long val = std.nextLong();
                ans.put(val, ans.getOrDefault(val, 0) + 1);
                iter.put(val, ans.getOrDefault(val, 0) + 1);
            }
            int foundAnswer = -1;
            if (D == 2) {
                foundAnswer = 1;
                for (Long pancake: ans.keySet()) {
                    int freqPancake = ans.get(pancake);
                    if (freqPancake >= 2) {
                        foundAnswer = 0;
                    }
                }
                log.write("Case #" + caseN + ": " + foundAnswer + "\n");
            } else { // D==3


                foundAnswer = 2;

                for (Long pancake: ans.keySet()) {
                    int freqPancake = ans.get(pancake);
                    if (freqPancake >= 3) {
                        foundAnswer = 0;
                        break;
                    } else if (freqPancake == 2) {
                        //2 duplicates of same thing
                        for (Long findOtherPancake: iter.keySet()) {
                            if (findOtherPancake > freqPancake) {
                                foundAnswer = 1;
                                break;
                            }
                        }
                    } else { //exactly 1 pancake
                        int twiceSize = ans.getOrDefault(pancake*2, -1); //there is a pancake twice the size!
                        if (twiceSize != -1) {
                            foundAnswer = 1;
                        }
                    }
                }

                log.write("Case #" + caseN + ": " + foundAnswer + "\n");
            }
        }
        log.flush();

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