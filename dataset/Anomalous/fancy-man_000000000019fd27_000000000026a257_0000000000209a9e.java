import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

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

    static final byte R_INV = 0;
    static final byte R_REV = 1;

    private static void apply(boolean[] array, byte rule) {
        switch (rule) {
            case R_INV:
                for (int i = 0; i < array.length; i++) {
                    array[i] = !array[i];
                }
                break;
            case R_REV:
                for (int i = 0; i < array.length / 2; i++) {
                    boolean tmp = array[i];
                    array[i] = array[array.length - i - 1];
                    array[array.length - i - 1] = tmp;
                }
                break;
        }
    }

    public static boolean[] solve0(Scanner in, int B) {
        boolean[] array = new boolean[B];
        for (int pointer = 0; pointer < B / 2; pointer++) {
            array[pointer] = query(in, pointer + 1);
            array[B - pointer - 1] = query(in, B - pointer);
        }
        return array;
    }

    public static boolean[] solve(Scanner in, int B) {
        int attempts = 0;
        boolean[] array = new boolean[B];
        int pointer = 0;
        int max = B / 2;
        int symmPosition = -1, antiPosition = -1;

        while (pointer < max) {
            boolean left = query(in, pointer + 1);
            boolean right = query(in, B - pointer);
            attempts += 2;

            array[pointer] = left;
            array[B - pointer - 1] = right;

            if (symmPosition < 0 && left == right) {
                symmPosition = pointer;
            }

            if (antiPosition < 0 && left != right) {
                antiPosition = pointer;
            }

            if (symmPosition >= 0 && antiPosition >= 0) {
                if (attempts % 10 == 0) {
                    left = query(in, 1);
                    right = query(in, pointer + 1);

                    if (left != array[0]) {
                        apply(array, R_INV);
                    }

                    array[pointer] = right;
                    array[B - pointer - 1] = symmPosition > 0 ? right : !right;
                } else {
                    left = query(in, 1);
                    left = query(in, 1);

                    if (left != array[0]) {
                        apply(array, R_INV);
                    }
                }
                attempts += 2;
                pointer++;

                while (pointer < max) {
                    left = query(in, pointer + 1);
                    right = query(in, B - pointer);
                    attempts += 2;

                    if (attempts % 10 == 2) {
                        boolean l = query(in, symmPosition + 1);
                        boolean r = query(in, antiPosition + 1);
                        attempts += 2;

                        boolean rule1 = l == array[symmPosition];
                        boolean rule2 = r == array[antiPosition];
                        if (!rule1) {
                            apply(array, R_INV);
                            if (rule2) {
                                apply(array, R_REV);
                            }
                        } else if (!rule2) {
                            apply(array, R_REV);
                        }
                    }

                    array[pointer] = left;
                    array[B - pointer - 1] = right;
                }
                return array;
            }
            pointer++;
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
            StringBuilder result = new StringBuilder();
            for (boolean bit : array) {
                result.append(bit ? '1' : '0');
            }
            System.out.println(result);
            if (!in.nextLine().equals("Y")) {
                break;
            }
        }
    }
}