import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[] s = new int[n];
            int[] e = new int[n];
            int[] order = new int[n];

            for (int j = 0; j < n; j++) {
                s[j] = sc.nextInt();
                e[j] = sc.nextInt();
                order[j] = j;
            }

            // Sort activities by end time using bubble sort
            for (int a = 0; a < n - 1; a++) {
                for (int b = 0; b < n - 1 - a; b++) {
                    if (e[b] > e[b + 1]) {
                        swap(e, b, b + 1);
                        swap(s, b, b + 1);
                        swap(order, b, b + 1);
                    }
                }
            }

            boolean impossible = false;
            StringBuilder y = new StringBuilder();
            ArrayList<Integer> bufferS = new ArrayList<>();
            ArrayList<Integer> bufferE = new ArrayList<>();

            for (int k = 0; k < n; k++) {
                if (bufferS.isEmpty()) {
                    bufferS.add(s[k]);
                    bufferE.add(e[k]);
                    y.append("J");
                } else if (bufferE.size() == 2) {
                    if (bufferE.get(0) > s[k] && bufferE.get(1) > s[k]) {
                        impossible = true;
                        break;
                    }
                    if (bufferE.get(0) > s[k]) {
                        bufferE.set(1, e[k]);
                        bufferS.set(1, s[k]);
                        y.append("C");
                    } else if (bufferE.get(1) > s[k]) {
                        bufferE.set(0, e[k]);
                        bufferS.set(0, s[k]);
                        y.append("J");
                    } else {
                        bufferE.set(0, e[k]);
                        bufferS.set(0, s[k]);
                        y.append("J");
                    }
                } else {
                    if (bufferE.get(0) > s[k]) {
                        bufferE.add(e[k]);
                        bufferS.add(s[k]);
                        y.append("C");
                    } else {
                        bufferE.set(0, e[k]);
                        bufferS.set(0, s[k]);
                        y.append("J");
                    }
                }
            }

            char[] fin = new char[n];
            if (!impossible) {
                for (int l = 0; l < n; l++) {
                    fin[order[l]] = y.charAt(l);
                }
            }

            String out = impossible ? "IMPOSSIBLE" : new String(fin);
            System.out.println("Case #" + (i + 1) + ": " + out);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}