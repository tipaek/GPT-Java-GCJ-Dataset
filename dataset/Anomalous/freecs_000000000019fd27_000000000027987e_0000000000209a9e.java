import java.util.Scanner;

public class Solution {

    public void solve(int test, Scanner sc) {
        int t = sc.nextInt();
        int b = sc.nextInt();

        while (t > 0) {
            int sameIndex = -1;
            int diffIndex = -1;

            int[] arr = new int[b + 1];
            int halfLength = (b + 1) / 2;

            int iteration = 1;

            for (int i = 1; i <= halfLength; i++) {
                if (iteration % 10 == 1) {
                    handleSpecialCase(sc, arr, sameIndex, i, b);
                    iteration++;
                    i--;
                } else if (iteration % 10 == 2) {
                    handleSpecialCase(sc, arr, diffIndex, i, b);
                    iteration++;
                    i--;
                } else {
                    System.out.println(i);
                    arr[i] = sc.nextInt();
                    int symmetricIndex = b - i + 1;
                    System.out.println(symmetricIndex);
                    arr[symmetricIndex] = sc.nextInt();

                    if (sameIndex < 0 && arr[i] == arr[symmetricIndex]) {
                        sameIndex = i;
                    } else if (diffIndex < 0 && arr[i] != arr[symmetricIndex]) {
                        diffIndex = i;
                    }

                    iteration += 2;
                }
            }

            StringBuilder result = new StringBuilder();
            for (int i = 1; i <= b; i++) {
                result.append(arr[i]);
            }

            System.out.println(result.toString());

            String response = sc.next();
            if (response.equals("N")) {
                return;
            }

            t--;
        }
    }

    private void handleSpecialCase(Scanner sc, int[] arr, int index, int i, int b) {
        if (index > 0) {
            System.out.println(index);
            int bit = sc.nextInt();

            boolean changed = bit != arr[index];
            if (changed) {
                for (int j = index; j < i; j++) {
                    if (arr[j] == arr[b - j + 1]) {
                        arr[j] = 1 - arr[j];
                        arr[b - j + 1] = 1 - arr[b - j + 1];
                    }
                }
            }
        } else {
            System.out.println("0");
            sc.next();
        }
    }

    public Solution() {
        Scanner sc = new Scanner(System.in);
        int tests = 1;

        for (int t = 1; t <= tests; t++) {
            solve(t, sc);
        }
    }

    public static void main(String[] args) {
        new Solution();
    }
}