import java.util.Scanner;

public class Solution {
    public static Scanner input;
    public static int[] arr = new int[100];
    public static int samePairIndex = -1;
    public static int diffPairIndex = -1;

    public static int query (int position) {
        System.out.println(position + 1);
        return input.nextInt();
    }

    public static void getPairs(int i, int b) {
        arr[i] = query(i);
        arr[b - 1 - i] = query(b - 1 - i);
        if (samePairIndex == -1 && arr[i] == arr[b - 1 - i]) {
            samePairIndex = i;
        }
        if (diffPairIndex == -1 && arr[i] == arr[b - 1 - i]) {
            diffPairIndex = i;
        }
    }

    public static void doCorrection(int b) {
        boolean complement = false;
        if (samePairIndex != -1 && arr[samePairIndex] != query(samePairIndex)) {
            complement = true;
        }
        boolean swap = complement;
        if (diffPairIndex != -1 && arr[diffPairIndex] != query(diffPairIndex)) {
            swap = !complement;
        }
        if (complement) {
            for (int x = 0; x < b; x++) {
                arr[x] = arr[x] == 0 ? 1 : 0;
            }
        }
        if (swap) {
            for (int x = 0; x < b / 2; x++) {
                int temp = arr[x];
                arr[x] = arr[b - x - 1];
                arr[b - x - 1] = temp;
            }
        }
    }

    public static void main(String[] args) {
        input = new Scanner(System.in);
        int t = input.nextInt();
        int b = input.nextInt();

        int curr = 0;
        /*
        for (; curr < 5; curr++) {
            getPairs(curr, b);
        }
        doCorrection(b);

        while (curr < b / 2) {
            int j = 0;
            for (j = 0; j < 4 && j < b / 2; curr++, j++) {
                getPairs(curr, b);
            }
            if (j == 4)
                doCorrection(b);
        }
         */

        // 2nd try
        query(0);
        for (int i = 0; i < 4 && curr < b / 2; i++, curr++) {
            getPairs(curr, b);
        }
        query(0);
        query(0);
        doCorrection(b);
        while (curr < b / 2) {
            int i = 0;
            for (i = 0; i < 4 && curr < b / 2; i++, curr++) {
                getPairs(curr, b);
            }
            if (curr == b / 2) {
                break;
            }
            int temp = query(0);
            temp = query(0);
            doCorrection(b);
        }
        // end

        for (int i = 0; i < b; i++) {
            System.out.print(arr[i]);
        }
        System.out.println();

        char res = input.next().charAt(0);
        if (res == 'N') {
            System.exit(0);
        }

        input.close();
    }
}
