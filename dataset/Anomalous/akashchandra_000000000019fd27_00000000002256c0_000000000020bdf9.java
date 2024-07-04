import java.util.Scanner;

class Solution {
    
    // Function to merge two subarrays
    public static void merge(int[][] m, int start, int mid, int end) {
        int p = start, q = mid + 1;
        int[][] arr = new int[end - start + 1][2];
        int k = 0;

        while (p <= mid && q <= end) {
            if (m[p][0] <= m[q][0]) {
                arr[k][0] = m[p][0];
                arr[k++][1] = m[p++][1];
            } else {
                arr[k][0] = m[q][0];
                arr[k++][1] = m[q++][1];
            }
        }

        while (p <= mid) {
            arr[k][0] = m[p][0];
            arr[k++][1] = m[p++][1];
        }

        while (q <= end) {
            arr[k][0] = m[q][0];
            arr[k++][1] = m[q++][1];
        }

        for (int i = 0; i < k; i++) {
            m[start][0] = arr[i][0];
            m[start++][1] = arr[i][1];
        }
    }
    
    // Function to perform merge sort on the array
    public static void mergeSort(int[][] m, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(m, start, mid);
            mergeSort(m, mid + 1, end);
            merge(m, start, mid, end);
        }
    }
    
    // Function to calculate the schedule
    public static String calc(int[][] a, int[][] b, int n) {
        String p = "CJ";
        mergeSort(a, 0, n - 1);
        int[] m = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][0] == b[j][0] && a[i][1] == b[j][1]) {
                    m[i] = j;
                    break;
                }
            }
        }

        int c = 0, j = 1;
        for (int i = 2; i < n; i++) {
            if (a[i][0] >= a[c][1]) {
                p += "C";
                c = i;
            } else if (a[i][0] >= a[j][1]) {
                p += "J";
                j = i;
            } else {
                return "IMPOSSIBLE";
            }
        }

        StringBuilder f = new StringBuilder();
        for (int i = 0; i < n; i++) {
            f.append(p.charAt(m[i]));
        }
        return f.toString();
    }
    
    // Main function to read input and output the results
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 1; i <= t; i++) {
            int n = sc.nextInt();
            int[][] a = new int[n][2];
            int[][] b = new int[n][2];

            for (int j = 0; j < n; j++) {
                a[j][0] = sc.nextInt();
                a[j][1] = sc.nextInt();
                b[j][0] = a[j][0];
                b[j][1] = a[j][1];
            }

            String result = calc(a, b, n);
            System.out.println("Case #" + i + ": " + result);
        }
        sc.close();
    }
}