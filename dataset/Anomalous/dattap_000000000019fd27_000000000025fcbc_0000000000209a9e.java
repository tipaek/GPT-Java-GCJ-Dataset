import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int T = Integer.parseInt(input[0]);
        int B = Integer.parseInt(input[1]);

        for (int t = 1; t <= T; t++) {
            int[] original = new int[B];
            int[] complement = new int[B];
            int[] reversed = new int[B];
            int[] reversedComplement = new int[B];
            
            for (int i = 1; i <= 10; i++) {
                System.out.println(i);
                int bit = Integer.parseInt(sc.nextLine());
                original[i - 1] = bit;
                complement[i - 1] = ~bit;
                reversed[i - 1] = original[B - i];
                reversedComplement[i - 1] = ~original[B - i];
            }

            System.out.println(1);
            int check1 = Integer.parseInt(sc.nextLine());

            System.out.println(2);
            int check2 = Integer.parseInt(sc.nextLine());

            if (isValid(check1, check2, original, 0)) {
                if (processResult(sc, original)) continue;
                else break;
            }

            if (isValid(check1, check2, complement, 0)) {
                if (processResult(sc, complement)) continue;
                else break;
            }

            if (isValid(check1, check2, original, B - 2)) {
                if (processResult(sc, reversed)) continue;
                else break;
            }

            if (isValid(check1, check2, complement, B - 2)) {
                if (processResult(sc, reversedComplement)) continue;
                else break;
            }
        }
    }

    private static boolean isValid(int check1, int check2, int[] array, int index) {
        return check1 == array[index] && check2 == array[index + 1];
    }

    private static boolean processResult(Scanner sc, int[] array) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            result.append(array[i]);
        }
        System.out.println(result.toString());
        String output = sc.nextLine();
        return output.equals("Y");
    }
}