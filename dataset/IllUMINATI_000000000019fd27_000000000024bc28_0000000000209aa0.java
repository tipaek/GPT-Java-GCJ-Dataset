

import java.util.Scanner;

 class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = Integer.parseInt(in.nextLine());
        for (int i = 1; i <= t; i++) {
            String[] parts = in.nextLine().split(" ");
            String s = indicium(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
            System.out.printf("Case #%d: %s", i, s);
        }

    }

    private static String indicium(int n, int k) {
        if ((k % n) != 0) {
            return "IMPOSSIBLE";
        } else {
            int num = k / n;
            if (!(num >= 1 && num <= n)) {
                return "IMPOSSIBLE\n";
            }
        }
        String[] initialString = createInitialString(n, k);
        StringBuilder sb = new StringBuilder();
        sb.append("POSSIBLE\n");
        String row = String.join(" ", initialString);
        sb.append(row);
        sb.append("\n");
        for (int i = 1; i < n; i++) {
            rightRotate(initialString, n);
            row = String.join(" ", initialString);
            sb.append(row);
            sb.append("\n");
        }
        return sb.toString();
    }

    private static String[] createInitialString(int n, int k) {
        int num = k / n;
        String[] output = new String[n];
        int index = 0;
        for (int i = num; i <= n; i++) {
            output[index] = String.valueOf(i);
            index++;
        }
        for (int i = 1; i < num; i++) {
            output[index] = String.valueOf(i);
        }
        return output;
    }

    public static void rightRotate(String arr[], int n) {
        String temp = arr[n - 1];
        for (int i = n-1; i >0; i--)
            arr[i] = arr[i-1];
        arr[0] = temp;
    }


}


