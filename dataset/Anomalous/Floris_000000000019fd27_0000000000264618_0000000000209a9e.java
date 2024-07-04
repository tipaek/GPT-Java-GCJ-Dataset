import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        InputStream in = System.in;
        Scanner sc = new Scanner(in);

        int cases = sc.nextInt();
        int bitCount = sc.nextInt();

        for (int cs = 1; cs <= cases; cs++) {
            char[] state = new char[bitCount];
            Arrays.fill(state, '.');

            for (int i = 0; i < 5; i++) {
                state[i] = getBit(i, sc);
                state[bitCount - i - 1] = getBit(bitCount - i - 1, sc);
            }

            int sameIndex = -1;
            int diffIndex = -1;

            for (int q = 0, p = 5; p < bitCount / 2; p++, q += 2) {
                if (q % 10 == 0) {
                    if (sameIndex < 0) {
                        for (int i = 0; i < p; i++) {
                            if (state[i] == state[bitCount - i - 1]) {
                                sameIndex = i;
                                break;
                            }
                        }
                    }

                    if (diffIndex < 0) {
                        for (int i = 0; i < p; i++) {
                            if (state[i] != state[bitCount - i - 1]) {
                                diffIndex = i;
                                break;
                            }
                        }
                    }

                    boolean inverse = false;
                    boolean reverse = false;

                    if (sameIndex >= 0) {
                        inverse = state[sameIndex] != getBit(sameIndex, sc);
                    } else {
                        getBit(0, sc);
                    }

                    if (inverse) {
                        for (int i = 0; i < bitCount; i++) {
                            state[i] = (state[i] == '1') ? '0' : '1';
                        }
                    }

                    if (diffIndex >= 0) {
                        reverse = state[diffIndex] != getBit(diffIndex, sc);
                    } else {
                        getBit(0, sc);
                    }

                    if (reverse) {
                        for (int i = 0; i < bitCount / 2; i++) {
                            char temp = state[i];
                            state[i] = state[bitCount - 1 - i];
                            state[bitCount - 1 - i] = temp;
                        }
                    }

                    q += 2;
                }

                state[p] = getBit(p, sc);
                state[bitCount - p - 1] = getBit(bitCount - p - 1, sc);
            }

            System.out.println(state);
            if (!sc.next().equals("Y")) {
                throw new RuntimeException();
            }
        }
    }

    private static char getBit(int index, Scanner sc) {
        System.out.println(index + 1);
        System.out.flush();
        String value = sc.next();
        
        if ("N".equals(value)) {
            throw new RuntimeException();
        }
        
        if (value.length() > 1) {
            throw new RuntimeException();
        }
        
        return value.charAt(0);
    }
}