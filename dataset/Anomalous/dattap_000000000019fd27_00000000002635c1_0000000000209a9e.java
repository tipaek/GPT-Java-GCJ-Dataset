import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int T = Integer.parseInt(input[0]);
        int B = Integer.parseInt(input[1]);

        for (int testCase = 1; testCase <= T; testCase++) {
            int[] original = new int[B];
            int[] complement = new int[B];
            int[] reverse = new int[B];
            int[] reverseComplement = new int[B];

            for (int i = 0; i < 10; i++) {
                System.out.println(i + 1);
                int value = Integer.parseInt(sc.nextLine());
                original[i] = value;
                complement[i] = ~value;
                reverse[i] = original[B - i - 1];
                reverseComplement[i] = ~original[B - i - 1];
            }

            int[] b2 = new int[B];
            for (int i = 0; i < 10; i++) {
                System.out.println(i + 1);
                b2[i] = Integer.parseInt(sc.nextLine());
            }

            if (checkAndPrint(sc, original, b2, B) || 
                checkAndPrint(sc, complement, b2, B) || 
                checkAndPrint(sc, reverse, b2, B) || 
                checkAndPrint(sc, reverseComplement, b2, B)) {
                continue;
            }
        }
    }

    private static boolean checkAndPrint(Scanner sc, int[] array, int[] b2, int B) {
        for (int i = 0; i < 10; i++) {
            if (b2[i] == array[i] || b2[i] == ~array[i] || b2[i] == array[B - i - 1] || b2[i] == ~array[B - i - 1]) {
                StringBuilder s1 = new StringBuilder();
                for (int j = 0; j < 10; j++) {
                    s1.append(array[j]);
                }
                System.out.println(s1);
                String output = sc.nextLine();
                return output.equals("Y");
            }
        }
        return false;
    }
}