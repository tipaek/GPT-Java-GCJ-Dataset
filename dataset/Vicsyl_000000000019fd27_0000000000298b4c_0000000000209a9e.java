import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Solution {

    public static void swap(int[] bits) {
        for (int i = 0; i < bits.length / 2; i++) {
            if (bits[i] != 2 && bits[bits.length - 1 - i] != 2) {
                int tmp = bits[i];
                bits[i] = bits[bits.length - 1 - i];
                bits[bits.length - 1 - i] = tmp;
            }
        }
    }

    public static void replace(int[] bits) {
        for (int i = 0; i < bits.length; i++) {
            if (bits[i] != 2) {
                bits[i] = 1 - bits[i];
            }
        }
    }

    public static void solve(int size, BufferedReader reader) throws IOException {

        int[] bits = new int[size];
        for (int i = 0; i < size; i++) bits[i] = 2;

        int different_index = -1;
        int same_index = -1;
        String bit;
        int remaining_to_check_in_iter = 10;

        while (true) {
            int index = 0;
            for (int i = 0; i < remaining_to_check_in_iter; i++) {
                while (bits[index] != 2 && bits[size - 1 - index] != 2 && index <= size / 2) index++;
                if (index > size / 2) {
                    for (int p = 0; p < size; p++) {
                        System.out.print(bits[p]);
                    }
                    System.out.println();
                    String answer = reader.readLine().trim();
                    if (answer.equals("Y")) {
                        return;
                    } else {
                        System.exit(-1);
                    }
                }
                if (bits[index] == 2) {
                    System.out.print(index + 1);
                    bit = reader.readLine().trim();
                    bits[index] = bit.equals("1") ? 1 : 0;
                    i++;
                }
                if (i < remaining_to_check_in_iter) {
                    System.out.print(size - index);
                    bit = reader.readLine().trim();
                    bits[size - 1 - index] = bit.equals("1") ? 1 : 0;

                    if (bits[size - 1 - index] == bits[index] && same_index == -1) {
                        same_index = index;
                    } else if (bits[size - 1 - index] != bits[index] && different_index == -1) {
                        different_index = index;
                    }
                }
            }


            if (same_index != -1 && different_index != -1) {
                System.out.print(same_index + 1);
                String bit_same_s = reader.readLine().trim();
                int bit_same = bit_same_s.equals("1") ? 1 : 0;
                boolean same_same_after = bit_same == bits[same_index];
                System.out.print(different_index + 1);
                String bit_diff_s = reader.readLine().trim();
                int bit_diff = bit_diff_s.equals("1") ? 1 : 0;
                boolean diff_same_after = bit_diff == bits[different_index];
                if (same_same_after && !diff_same_after) {
                    swap(bits);
                } else if (!same_same_after && diff_same_after) {
                    swap(bits);
                    replace(bits);
                } else if (!same_same_after && !diff_same_after) {
                    replace(bits);
                }
                remaining_to_check_in_iter = 8;
            } else {
                System.out.print(1);
                int bit_i = reader.readLine().trim().equals("1") ? 1 : 0;
                boolean same = bit_i == bits[0];
                if (!same) {
                    replace(bits);
                }
                remaining_to_check_in_iter = 9;
            }
        }
    }

    public static void main(String... args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] line = reader.readLine().split(" ");
        int cases = Integer.parseInt(line[0].trim());
        int size = Integer.parseInt(line[1].trim());
        for (int i = 0; i < cases; i++) {
            solve(size, reader);
        }

    }
}
