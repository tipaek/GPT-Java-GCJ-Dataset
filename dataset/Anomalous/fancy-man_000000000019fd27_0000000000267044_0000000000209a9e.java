import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    private static final byte R_INV = 0;
    private static final byte R_REV = 1;

    public static boolean query(Scanner in, int position) {
        System.out.println(position);
        String line = in.nextLine();
        switch (line) {
            case "N":
                throw new RuntimeException("Exit");
            case "0":
                return false;
            case "1":
                return true;
            default:
                throw new RuntimeException("Malformed");
        }
    }

    private static void apply(boolean[] array, byte rule) {
        switch (rule) {
            case R_INV:
                for (int i = 0; i < array.length; i++) {
                    array[i] = !array[i];
                }
                break;
            case R_REV:
                for (int i = 0; i < array.length / 2; i++) {
                    boolean temp = array[i];
                    array[i] = array[array.length - i - 1];
                    array[array.length - i - 1] = temp;
                }
                break;
        }
    }

    public static boolean[] solve0(Scanner in, int B) {
        boolean[] array = new boolean[B];
        for (int i = 0; i < B / 2; i++) {
            array[i] = query(in, i + 1);
            array[B - i - 1] = query(in, B - i);
        }
        return array;
    }

    public static boolean[] solve(Scanner in, int B) {
        boolean[] array = new boolean[B];
        int attempts = 0;
        int symmPosition = -1, antiPosition = -1;

        for (int i = 0; i < B / 2; i++) {
            array[i] = query(in, i + 1);
            array[B - i - 1] = query(in, B - i);
            attempts += 2;

            if (symmPosition < 0 && array[i] == array[B - i - 1]) {
                symmPosition = i;
            }
            if (antiPosition < 0 && array[i] != array[B - i - 1]) {
                antiPosition = i;
            }

            if (symmPosition >= 0 && antiPosition >= 0 && attempts % 10 == 0) {
                boolean left = query(in, 1);
                boolean right = query(in, i + 1);

                if (left != array[0]) {
                    apply(array, R_INV);
                }

                array[i] = right;
                if (symmPosition > 0) {
                    array[B - i - 1] = right;
                } else {
                    array[B - i - 1] = !right;
                }

                attempts += 2;
                i++;
                for (; i < B / 2; i++) {
                    array[i] = query(in, i + 1);
                    array[B - i - 1] = query(in, B - i);
                    attempts += 2;

                    if (attempts % 10 == 2) {
                        left = query(in, symmPosition + 1);
                        right = query(in, antiPosition + 1);
                        attempts += 2;

                        if (left != array[symmPosition]) {
                            apply(array, R_INV);
                            if (right == array[antiPosition]) {
                                apply(array, R_REV);
                            }
                        } else {
                            if (right != array[antiPosition]) {
                                apply(array, R_REV);
                            }
                        }
                    }
                }
                return array;
            }
        }

        if (symmPosition >= 0) {
            boolean left = query(in, symmPosition + 1);
            if (left != array[symmPosition]) {
                apply(array, R_INV);
            }
        } else {
            boolean left = query(in, antiPosition + 1);
            if (left != array[antiPosition]) {
                apply(array, R_INV);
            }
        }

        return array;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        String[] tokens = in.nextLine().split(" ");
        int t = Integer.parseInt(tokens[0]);
        int b = Integer.parseInt(tokens[1]);

        for (int c = 1; c <= t; ++c) {
            boolean[] array = b <= 10 ? solve0(in, b) : solve(in, b);
            StringBuilder result = new StringBuilder(b);

            for (boolean bit : array) {
                result.append(bit ? '1' : '0');
            }

            System.out.println(result.toString());
            if (!in.nextLine().equals("Y")) {
                break;
            }
        }
    }
}