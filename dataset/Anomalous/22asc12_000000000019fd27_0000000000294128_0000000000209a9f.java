import java.util.Scanner;

public class Solution {
    public static void process(String tmp, int caso) {
        int size = tmp.length();
        System.out.print("Case #" + caso + ": ");
        
        if (size == 1) {
            if (tmp.charAt(0) == '1') {
                System.out.print("(" + tmp.charAt(0) + ")");
            } else {
                System.out.print(tmp.charAt(0));
            }
        } else {
            for (int i = 0; i < size; i++) {
                char currentChar = tmp.charAt(i);
                if (i == 0) {
                    char nextChar = tmp.charAt(i + 1);
                    if (currentChar == '1' && nextChar == '0') {
                        System.out.print("(" + currentChar + ")");
                    } else if (currentChar == '1' && nextChar == '1') {
                        System.out.print("(" + currentChar);
                    } else if (currentChar == '0' && nextChar == '1') {
                        System.out.print(currentChar + "(");
                    } else {
                        System.out.print(currentChar);
                    }
                } else if (i == size - 1) {
                    if (currentChar == '1') {
                        System.out.print(currentChar + ")");
                    } else {
                        System.out.print(currentChar);
                    }
                } else {
                    char nextChar = tmp.charAt(i + 1);
                    if (currentChar == '1' && nextChar == '1') {
                        System.out.print(currentChar);
                    } else if (currentChar == '1' && nextChar == '0') {
                        System.out.print(currentChar + ")");
                    } else if (currentChar == '0' && nextChar == '1') {
                        System.out.print(currentChar + "(");
                    } else {
                        System.out.print(currentChar);
                    }
                }
            }
        }
        
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        for (int i = 1; i <= cases; i++) {
            String tmp = sc.next();
            process(tmp, i);
        }
        sc.close();
    }
}