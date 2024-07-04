import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static int query(Scanner in, int position) throws Exception {
        System.out.println(position);
        System.out.flush();

        char response = in.next().charAt(0);
        if (response == 'N') {
            throw new Exception("malformed line");
        }

        System.err.printf("Query: %2d, Response: %s%n", position, response);
        return response - '0';
    }

    public static void answer(Scanner in, int[] bits) throws Exception {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bits.length; i++) {
            sb.append(bits[i]);
        }
        System.out.println(sb.toString());
        System.out.flush();

        char response = in.next().charAt(0);
        if (response == 'N') {
            throw new Exception("malformed line");
        }
    }

    public static int[] complement(int[] bits) {
        int[] result = new int[bits.length];
        for (int i = 0; i < bits.length; i++) {
            result[i] = (bits[i] == 0) ? 1 : 0;
        }
        return result;
    }

    public static int[] reverse(int[] bits) {
        int[] result = new int[bits.length];
        for (int i = 0; i < bits.length; i++) {
            result[bits.length - i - 1] = bits[i];
        }
        return result;
    }

    public static boolean compare(int[] bits1, int[] bits2) {
        for (int i = 0; i <= bits1.length; i++) {
            if (bits1[i] != bits2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(final String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        int b = in.nextInt();

        int[] bits = new int[b];
        int left;
        int right;

        try {
            while (t > 0) {
                Arrays.fill(bits, 0);
                left = 0;
                right = b - 1;

                while (left < right) {
                    // Read left
                    System.err.println("Read Left");
                    for (int i = 0; i < 5 && left <= right; i++) {
                        bits[left] = query(in, left + 1);
                        left++;
                    }

                    System.err.printf("Left: %d, Right: %d%n", left, right);
                    System.err.println(Arrays.toString(bits));

                    // Read right
                    System.err.println("Read Right");
                    for (int i = 0; i < 5 && left <= right; i++) {
                        bits[right] = query(in, right + 1);
                        right--;
                    }

                    if (left < right) {
                        System.err.println("Checking");
                        int[] set1 = Arrays.copyOfRange(bits, 0, 5);
                        int[] set2 = Arrays.copyOfRange(bits, bits.length - 5, bits.length);
                        int[] set3 = new int[5];
                        for (int i = 0; i < 5; i++) {
                            set3[i] = query(in, left + 1);
                            left++;
                        }
                        int[] set4 = new int[5];
                        for (int i = 0; i < 5; i++) {
                            set4[i] = query(in, right + 1);
                            right--;
                        }
                        int[] set5 = new int[5];
                        for (int i = 0; i < 5; i++) {
                            set5[i] = query(in, i + 1);
                        }
                        int[] set6 = new int[5];
                        for (int i = 0; i < 5; i++) {
                            set6[i] = query(in, left - 5 + i + 1);
                        }

                        System.err.printf("set1: %s%n", Arrays.toString(set1));
                        System.err.printf("set2: %s%n", Arrays.toString(set2));
                        System.err.printf("set3: %s%n", Arrays.toString(set3));
                        System.err.printf("set4: %s%n", Arrays.toString(set4));
                        System.err.printf("set5: %s%n", Arrays.toString(set5));
                        System.err.printf("set6: %s%n", Arrays.toString(set6));

                        if (compare(set6, complement(set3))) {
                            set4 = complement(set4);
                            set5 = complement(set5);
                        } else {
                            int[] rset4 = reverse(set4);
                            if (compare(set6, rset4)) {
                                set4 = reverse(set3);
                                set5 = reverse(set5);
                            } else if (compare(set6, complement(rset4))) {
                                set4 = reverse(complement(set3));
                                set5 = reverse(complement(set5));
                            }
                        }

                        if (compare(set5, complement(set1))) {
                            bits = complement(bits);
                        } else {
                            int[] rset2 = reverse(set2);
                            if (compare(set5, rset2)) {
                                bits = reverse(bits);
                            } else if (compare(set5, complement(rset2))) {
                                bits = reverse(complement(bits));
                            }
                        }

                        for (int i = 0; i < 5; i++) {
                            bits[left - 5 + i + 1] = set6[i];
                        }
                        for (int i = 0; i < 5; i++) {
                            bits[right + i + 1] = set4[i];
                        }
                    }
                }

                answer(in, bits);
                t--;
            }
        } catch (Exception e) {
            System.exit(-1);
        } finally {
            in.close();
        }
    }
}
