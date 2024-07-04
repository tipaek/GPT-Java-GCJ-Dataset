import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int B = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int[] arr = new int[B];

            for (int j = 0; j < 5; j++) {
                System.out.println(j + 1);
                arr[j] = sc.nextInt();
                System.out.println(arr.length - j);
                arr[arr.length - j - 1] = sc.nextInt();
            }

            if (B > 10) {
                List<Integer> list;
                int idx = 5;
                int[][] diff = new int[2][2];
                diff[0][0] = diff[0][1] = diff[1][0] = diff[1][1] = -1;

                while (idx < arr.length / 2) {
                    list = new ArrayList<>();
                    check(diff, arr);
                    int[] temp = diff[0][0] == -1 ? diff[1] : diff[0];
                    list.add(temp[0]);
                    list.add(temp[1]);

                    addNext(list, idx, 4, arr.length);
                    List<Integer> values = getValues(list, sc);
                    checkAndPerform(diff, arr, values);
                    for (int j = 0; j < values.size(); j++) {
                        arr[list.get(j)] = values.get(j);
                    }
                    idx += 4;
                }
            }

            for (int v : arr)
                System.out.print(v);

            System.out.println();
            if (sc.next().equals("N")) break;
        }
    }

    public static void check(int[][] diff, int[] arr) {
        if (diff[0][0] != -1 && diff[1][0] != -1)
            return;

        for (int i = 0; i < 5; i++) {
            if (arr[i] == arr[arr.length - i - 1]) {
                diff[0][0] = i;
                diff[0][1] = arr.length - i - 1;
            } else {
                diff[1][0] = i;
                diff[1][1] = arr.length - i - 1;
            }
        }
    }

    public static void checkAndPerform(int[][] diff, int[] arr, List<Integer> values) {

        if (diff[0][0] == -1 || diff[1][0] == -1) {
            int idx = diff[0][0] != -1 ? diff[0][0] : diff[1][0];
            if (arr[idx] != values.get(0)) {
                complement(arr);
            }
            return;
        }

        if (values.get(0) != arr[diff[0][0]] && values.get(1) != arr[diff[0][1]]) {
            complement(arr);
        } else if (values.get(0) == arr[diff[1][0]] && values.get(1) == arr[diff[1][1]]) {
            reverse(arr);
        } else if (values.get(0) != arr[diff[1][0]] && values.get(1) != arr[diff[1][1]]) {
            reverse(arr);
            complement(arr);
        }
    }

    public static void complement(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] ^ 1;
        }
    }

    public static void reverse(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;
        }
    }

    public static List<Integer> getValues(List<Integer> index, Scanner sc) {
        List<Integer> out = new ArrayList<>();
        for (Integer idx : index) {
            System.out.println(idx + 1);
            out.add(sc.nextInt());
        }
        return out;
    }

    public static void addNext(List<Integer> list, int s, int e, int len) {
        for (int i = s; i < s + e; i++) {
            list.add(i);
            list.add(len - 1 - i);
        }
    }
}
