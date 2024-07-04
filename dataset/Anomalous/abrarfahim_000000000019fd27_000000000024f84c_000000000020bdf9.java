import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[] s = new int[n];
            int[] e = new int[n];

            for (int j = 0; j < n; j++) {
                s[j] = sc.nextInt();
                e[j] = sc.nextInt();
            }

            int[] order = new int[n];
            for (int l = 0; l < n; l++) {
                order[l] = l;
            }

            // Bubble sort based on end times
            for (int a = 0; a < n; a++) {
                for (int b = 0; b < n - 1; b++) {
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
                } else {
                    if (bufferE.size() == 2) {
                        if (bufferE.get(0) > s[k] && bufferE.get(1) > s[k]) {
                            impossible = true;
                            break;
                        }
                        if (bufferE.get(0) > s[k]) {
                            updateBuffer(bufferS, bufferE, 1, s[k], e[k]);
                            y.append("C");
                        } else {
                            updateBuffer(bufferS, bufferE, 0, s[k], e[k]);
                            y.append("J");
                        }
                    } else {
                        if (bufferE.get(0) > s[k]) {
                            bufferS.add(s[k]);
                            bufferE.add(e[k]);
                            y.append("C");
                        } else {
                            bufferS.clear();
                            bufferE.clear();
                            bufferS.add(s[k]);
                            bufferE.add(e[k]);
                            y.append("J");
                        }
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

    private static void updateBuffer(ArrayList<Integer> bufferS, ArrayList<Integer> bufferE, int index, int s, int e) {
        bufferS.set(index, s);
        bufferE.set(index, e);
    }
}