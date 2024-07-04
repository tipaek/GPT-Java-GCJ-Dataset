import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    private static Scanner scan;

    public static void main(String[] args) throws FileNotFoundException {
        scan = new Scanner(System.in);
        int t = scan.nextInt();
        int b = scan.nextInt();
        
        for (int i = 0; i < t; i++) {
            int[] bits = new int[b];
            
            // Initial bit retrieval
            for (int j = 0; j < 5; j++) {
                bits[j] = requestBit(j);
                bits[b - j - 1] = requestBit(b - j - 1);
            }
            
            // Determine initial pattern checks
            int[] chk = new int[3];
            int[] pChk = new int[3];
            for (int j = 7; j <= 28; j++) {
                if (Integer.bitCount(j) != 3) continue;
                
                int[] b0 = new int[5];
                int[] b1 = new int[5];
                int count = 0;
                
                for (int k = 0; k < 5; k++) {
                    if ((j & (1 << k)) >= 1) {
                        b0[k] = bits[k];
                        b1[k] = bits[b - k - 1];
                        chk[count++] = k;
                    }
                }
                
                if (!((b0[0] == b1[0] && b0[1] == b1[1] && b0[2] == b1[2]) || 
                      (b0[0] != b1[0] && b0[1] != b1[1] && b0[2] != b1[2]))) {
                    pChk = b0;
                    break;
                }
            }
            
            // Further bit retrieval and pattern adjustment
            int[] nChk = new int[3];
            int count = 5;
            
            for (int j = 10; j < 150 && count < b - 5; j++) {
                if (j % 10 < 3) {
                    nChk[j % 10] = requestBit(chk[j % 10]);
                }
                
                if (j % 10 == 3) {
                    if (Arrays.equals(nChk, pChk)) {
                        continue;
                    } else if (nChk[0] != pChk[0] && nChk[1] != pChk[1] && nChk[2] != pChk[2]) {
                        invertBits(bits);
                        pChk = Arrays.copyOf(nChk, 3);
                    } else if (nChk[0] == pChk[2] && nChk[1] == pChk[1] && nChk[2] == pChk[1]) {
                        reflectBits(bits);
                        pChk = Arrays.copyOf(nChk, 3);
                    } else if (nChk[0] != pChk[2] && nChk[1] != pChk[1] && nChk[2] != pChk[1]) {
                        reflectAndInvertBits(bits);
                        pChk = Arrays.copyOf(nChk, 3);
                    }
                }
                
                if (j % 10 >= 3) {
                    bits[count] = requestBit(count);
                    count++;
                }
            }
            
            // Print the final bit array
            for (int a : bits) {
                System.out.print(a);
            }
            System.out.println();
        }
        
        scan.close();
    }

    private static int requestBit(int i) {
        System.out.println(i);
        return scan.nextInt();
    }

    private static void invertBits(int[] bits) {
        for (int k = 0; k < bits.length; k++) {
            bits[k] = (bits[k] == 0) ? 1 : 0;
        }
    }

    private static void reflectBits(int[] bits) {
        int b = bits.length;
        for (int k = 0; k < b / 2; k++) {
            int temp = bits[k];
            bits[k] = bits[b - 1 - k];
            bits[b - 1 - k] = temp;
        }
    }

    private static void reflectAndInvertBits(int[] bits) {
        reflectBits(bits);
        invertBits(bits);
    }
}