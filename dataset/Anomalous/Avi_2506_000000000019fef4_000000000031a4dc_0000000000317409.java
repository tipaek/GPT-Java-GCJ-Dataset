import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        System.arraycopy(arr, left, L, 0, n1);
        System.arraycopy(arr, mid + 1, R, 0, n2);

        int i = 0, j = 0;
        int k = left;

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

    static void sort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            sort(arr, left, mid);
            sort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    static int gcd(int a, int b) {
        return (b == 0) ? a : gcd(b, a % b);
    }

    static long power(long n, long m) {
        long result = 1;
        while (m > 0) {
            result *= n;
            m--;
        }
        return result;
    }

    static int binarySearch(int[] arr, int x) {
        int left = 0, right = arr.length - 1;
        int mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (arr[mid] == x)
                return mid;
            if (arr[mid] < x)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return Math.max(left, mid);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 1; i <= t; i++) {
            String[] input = br.readLine().split(" ");
            int e = Integer.parseInt(input[0]);
            int n = Integer.parseInt(input[1]);
            String st = input[2];

            int ans = e;
            int temp = 0;

            while (e > 0) {
                e--;
                if (st.charAt(temp) == 'S')
                    n--;
                else
                    n++;
                temp++;
            }

            for (int j = temp; j < st.length(); j++) {
                if (st.charAt(j) == 'S')
                    n--;
                else
                    n++;
                if (n > 0)
                    n--;
                else if (n < 0)
                    n++;
                ans++;
                if (n == 0)
                    break;
            }

            if (n == 0)
                System.out.println("Case #" + i + ": " + ans);
            else
                System.out.println("Case #" + i + ": IMPOSSIBLE");
        }
    }
}