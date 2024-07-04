import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int t1 = t;

        while (t > 0) {
            int n = sc.nextInt();
            int[] l = new int[n];
            int[] r = new int[n];
            int[] ts = new int[n];

            for (int i = 0; i < n; i++) {
                l[i] = sc.nextInt();
                r[i] = sc.nextInt();
                ts[i] = i;
            }

            // Sorting intervals by start time
            for (int i = 0; i < n - 1; i++) {
                int min = i;
                for (int j = i + 1; j < n; j++) {
                    if (l[j] < l[min]) {
                        min = j;
                    }
                }
                swap(l, i, min);
                swap(r, i, min);
                swap(ts, i, min);
            }

            int[] duty = {0, 0};
            StringBuilder s = new StringBuilder();
            boolean isPossible = true;

            for (int i = 0; i < n; i++) {
                if (l[i] >= duty[0]) {
                    duty[0] = r[i];
                    s.append("C");
                } else if (l[i] >= duty[1]) {
                    duty[1] = r[i];
                    s.append("J");
                } else {
                    isPossible = false;
                    s = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }

            if (isPossible) {
                char[] ch = s.toString().toCharArray();
                for (int i = 0; i < n - 1; i++) {
                    int min = i;
                    for (int j = i + 1; j < n; j++) {
                        if (ts[j] < ts[min]) {
                            min = j;
                        }
                    }
                    swap(ts, i, min);
                    swap(ch, i, min);
                }
                s = new StringBuilder(new String(ch));
            }

            System.out.println("Case #" + (t1 - t + 1) + ": " + s);
            t--;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}