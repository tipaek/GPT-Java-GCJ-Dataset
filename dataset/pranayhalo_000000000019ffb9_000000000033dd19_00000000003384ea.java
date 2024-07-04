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
            long L = std.nextLong();
            long R = std.nextLong();
            boolean swapped = false;
            if (R >= L) {
                //swap R and L
                long tmp = R;
                R = L;
                L = tmp;
                swapped = true;
            }

            //guaranteed that L >= R
            //find i for first time L < R --
            long mid = binarySearch(0L, 2000000000L, L - R); //if 10 6, then answer should be 2 (10 -> 9 -> 7)
            L -= (mid * (mid + 1)) / 2;
            //now we have L >= R (and next mid + 1 will cause L < R)
            //take from L first,


            boolean isSame = false;
            if (L == R) {
                isSame = true;
            }


            long Lans = 0;
            long Rans = 0;
            long Lstart = mid + 1;
            long Rstart = mid + 2;

            Lans = binarySearch2(0, 2000000000L, L, Lstart); //# panckaes
            long l = Lstart + (Lans - 1) * 2; //last number
            long nums = (Lstart + l) * (Lans / 2);
            if (Lans % 2 == 1) {
                nums += ((Lstart + l) / 2);
            }
            if (Lans == 0) {
                nums = 0;
            }
            L -= nums;

            Rans = binarySearch2(0, 2000000000L, R, Rstart);
            l = Rstart + (Rans - 1) * 2; //last number
            nums = (Rstart + l) * (Rans / 2);
            if (Rans % 2 == 1) {
                nums += ((Rstart + l) / 2);
            }
            if (Rans == 0) {
                nums = 0;
            }
            R -= nums;

            long finalAns = mid + Lans + Rans;

            if (!isSame && swapped) {
                long tmp = R;
                R = L;
                L = tmp;
            }
            log.write("Case #" + caseN + ": " + finalAns + " " + L + " " + R + "\n");
        }
        log.flush();



    }

    static long binarySearch2(long start, long end, long target, long a) {
        long mid = (start + end) / 2; //a + a+2 + a+4 (mid times)
        while (start < end - 1) {
            mid = (start + end) / 2; //1+2+...+mid
            long l = a + (mid - 1) * 2; //last number
            long nums = (a + l) * (mid / 2);
            if (mid % 2 == 1) {
                nums += ((a + l) / 2);
            }
            if (mid == 0) {
                nums = 0;
            }
            if (mid == 1) {
                nums = a;
            }
            if (nums > target) {
                end = mid - 1;
            } else if (nums < target) {
                start = mid;
            } else {
                return mid;
            }
        }
        long tmp = start;
        if (start == end - 1) {
            // try start and end, return best answer
            mid = end;
            long l = a + (mid - 1) * 2; //last number
            long nums = (a + l) * (mid / 2);
            if (mid % 2 == 1) {
                nums += ((a + l) / 2);
            }
            if (mid == 0) {
                nums = 0;
            }
            if (mid == 1) {
                nums = a;
            }
            if (nums <= target) {
                return end;
            }
        }
        return start;

    }

    static long binarySearch(long start, long end, long target) {
        long mid = (start + end) / 2; //1+2+...+mid
        while (start < end - 1) {
            mid = (start + end) / 2; //1+2+...+mid
            long nums = (mid * (mid + 1)) / 2; //summation
            if (nums > target) {
                end = mid - 1;
            } else if (nums < target) {
                start = mid;
            } else {
                return mid;
            }
        }
        long tmp = start;
        if (start == end - 1) {
            // try start and end, return best answer
            mid = end;
            long nums = (mid * (mid + 1)) / 2; //summation
            if (nums <= target) {
                return end;
            }
        }
        return start;

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