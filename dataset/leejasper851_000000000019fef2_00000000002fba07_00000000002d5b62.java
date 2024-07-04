import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        
        int numCases = Integer.parseInt(reader.readLine());
        for (int caseN = 1; caseN <= numCases; caseN++) {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            
            boolean num1Neg = false;
            boolean num2Neg = false;
            if (num1 < 0) {
                num1Neg = true;
                num1 *= -1;
            }
            if (num2 < 0) {
                num2Neg = true;
                num2 *= -1;
            }
            
            if (num1 % 2 == num2 % 2) {
                writer.println("Case #" + caseN + ": IMPOSSIBLE");
                continue;
            }
            
            String str1 = Integer.toBinaryString(num1);
            String str2 = Integer.toBinaryString(num2);
            while (str1.length() < 32) {
                str1 = "0" + str1;
            }
            while (str2.length() < 32) {
                str2 = "0" + str2;
            }
            
            int[] arr1 = new int[32];
            int[] arr2 = new int[32];
            for (int i = 0; i < 32; i++) {
                arr1[i] = (str1.charAt(32 - i - 1) == '0') ? 0 : 1;
                arr2[i] = (str2.charAt(32 - i - 1) == '0') ? 0 : 1;
            }
            
            for (int i = 1; i < 32; i++) {
                if (checkEnd(arr1, arr2, i)) {
                    break;
                }
                if (arr1[i] == 0 && arr2[i] == 0) {
                    if (arr1[i - 1] == 1) {
                        arr1[i - 1] = -1;
                        arr1[i] = 1;
                    } else {
                        arr2[i - 1] = -1;
                        arr2[i] = 1;
                    }
                }
                if (arr1[i] == 1 && arr2[i] == 1) {
                    if (arr1[i - 1] == 1) {
                        arr1[i - 1] = -1;
                        arr1[i] = 0;
                        add1(arr1, i + 1);
                    } else {
                        arr2[i - 1] = -1;
                        arr2[i] = 0;
                        add1(arr2, i + 1);
                    }
                }
            }
            
            writer.print("Case #" + caseN + ": ");
            for (int i = 0; i < 32; i++) {
                if (checkEnd(arr1, arr2, i)) {
                    break;
                }
                if (arr1[i] == 1) {
                    writer.print(!num1Neg ? "E" : "W");
                } else if (arr1[i] == -1) {
                    writer.print(!num1Neg ? "W" : "E");
                } else if (arr2[i] == 1) {
                    writer.print(!num2Neg ? "N" : "S");
                } else {
                    writer.print(!num2Neg ? "S" : "N");
                }
            }
            writer.println();
        }
        reader.close();
        writer.close();
    }
    
    private static boolean checkEnd(int[] arr1, int[] arr2, int ind) {
        for (int i = ind; i < 32; i++) {
            if (arr1[i] != 0 || arr2[i] != 0) {
                return false;
            }
        }
        return true;
    }
    
    private static void add1(int[] arr, int ind) {
        for (int i = ind; i < 32; i++) {
            if (arr[i] == 0) {
                arr[i] = 1;
                break;
            } else {
                arr[i] = 0;
            }
        }
    }
}