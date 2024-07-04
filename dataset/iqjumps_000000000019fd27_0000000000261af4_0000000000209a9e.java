import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    static Scanner in;
    static int cnt;
    public static void main(String[] args) {
        in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();
        int n = in.nextInt();
        for (int t = 1; t <= T; ++t) {
            solve(n);
        }
    }

    public static void solve(int n) {
        int[] arr = new int[n];
        cnt = 0;
        int i = 0;
        for (;i<5;i++) {
            arr[i] = query(i);
            arr[n-1-i] = query(n-1-i);
        }
        if (n == 10) {
            answer(arr);
            return;
        }
        while (2 * i < n || cnt >= 150) {
            if (cnt % 10 == 0) {
                int same = findSame(i, arr);
                int different = findDifferent(i, arr);
                apply(determine(same, different, arr), i, arr);
                continue;
            }
            arr[i] = query(i);
            arr[n-1-i] = query(n-1-i);
            i++;
        }
        answer(arr);
    }

    static int query(int index) {
        cnt++;
        System.out.println(index+1);
        return in.nextInt();
    }

    static void answer(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int num : arr) {
            sb.append(num);
        }
        System.out.println(sb.toString());
        in.nextLine();
        in.nextLine();
    }

    static int findSame(int cur, int[] arr) {
        for (int i=0; i<cur; i++) {
            if (arr[i] == arr[arr.length-1-i]) {
                return i;
            }
        }
        return -1;
    }

    static int findDifferent(int cur, int[] arr) {
        for (int i=0; i<cur; i++) {
            if (arr[i] != arr[arr.length-1-i]) {
                return i;
            }
        }
        return -1;
    }

    static void apply(int type, int cur, int[] arr) {
        if (type < 0) {
            //System.out.println("ERROR");
            return;
        }
        if (type == 0) {
            return;
        }
        for (int i=0; i<cur; i++) {
            if (type >= 2) {
                arr[i] = arr[i] == 0 ? 1 : 0;
                arr[arr.length-1-i] = arr[arr.length-1-i] == 0 ? 1 : 0;
            }
            if (type % 2 == 1) {
                int tmp = arr[i];
                arr[i] = arr[arr.length-1-i];
                arr[arr.length-1-i] = tmp;
            }
        }
    }

    static int determine(int same, int different, int[] arr) {
        int num1 = query(same);
        int num2 = query(arr.length - 1 - same);
        int num3 = query(different);
        int num4 = query(arr.length - 1 - different);

        if (arr[same] == num1 && arr[arr.length-1-same] == num2
                && arr[different] == num3 && arr[arr.length-1-different] == num4) {
            return 0; // nothing
        }
        if (arr[same] == num1 && arr[arr.length-1-same] == num2
                && arr[different] != num3 && arr[arr.length-1-different] != num4) {
            return 1; // reversed
        }
        if (arr[same] != num1 && arr[arr.length-1-same] != num2
                && arr[different] != num3 && arr[arr.length-1-different] != num4) {
            return 2; // complement
        }
        if (arr[same] != num1 && arr[arr.length-1-same] != num2
                && arr[different] == num3 && arr[arr.length-1-different] == num4) {
            return 3; // reversed + complement
        }
        return -1;
    }
}

