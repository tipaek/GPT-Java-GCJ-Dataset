import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int bitLength = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            boolean[] bits = new boolean[bitLength];
            boolean[] matches = new boolean[bitLength / 2];
            
            for (int i = 0; i < bitLength / 2; i++) {
                System.out.println(i + 1);
                bits[i] = scanner.nextInt() == 1;
                System.out.println(bitLength - i);
                bits[bitLength - i - 1] = scanner.nextInt() == 1;
                matches[i] = bits[i] == bits[bitLength - i - 1];
            }
            
            boolean[] complements = new boolean[bitLength / 10];
            boolean[] reversals = new boolean[bitLength / 10];
            
            for (int i = 0; i < bitLength / 10; i++) {
                boolean allMatch = true;
                boolean allDifferent = true;
                int firstMatchIndex = -1;
                int firstDifferentIndex = -1;
                
                for (int j = 0; j < 5; j++) {
                    if (matches[i * 5 + j]) {
                        allDifferent = false;
                        firstMatchIndex = j;
                    } else {
                        allMatch = false;
                        firstDifferentIndex = j;
                    }
                }
                
                if (allMatch || allDifferent) {
                    System.out.println(i * 5 + 1);
                    complements[i] = (scanner.nextInt() == 1) != bits[i * 5];
                    System.out.println(1);
                    scanner.nextInt();
                } else {
                    System.out.print(i * 5 + firstMatchIndex + 1);
                    complements[i] = (scanner.nextInt() == 1) != bits[i * 5 + firstMatchIndex];
                    System.out.print(i * 5 + firstDifferentIndex + 1);
                    reversals[i] = ((scanner.nextInt() == 1) == bits[i * 5 + firstDifferentIndex]) == complements[i];
                }
            }
            
            for (int i = 0; i < bitLength / 10; i++) {
                if (complements[i]) {
                    for (int j = 0; j < 5; j++) {
                        int index = i * 5 + j;
                        bits[index] = !bits[index];
                        bits[bitLength - index - 1] = !bits[bitLength - index - 1];
                    }
                }
                if (reversals[i]) {
                    for (int j = 0; j < 5; j++) {
                        int index = i * 5 + j;
                        boolean temp = bits[index];
                        bits[index] = bits[bitLength - index - 1];
                        bits[bitLength - index - 1] = temp;
                    }
                }
            }
            
            StringBuilder output = new StringBuilder();
            for (boolean bit : bits) {
                output.append(bit ? '1' : '0');
            }
            System.out.println(output);
            
            if (scanner.next().equals("N")) break;
        }
    }
}