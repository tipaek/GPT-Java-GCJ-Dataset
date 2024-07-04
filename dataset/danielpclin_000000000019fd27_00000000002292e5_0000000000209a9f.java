import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int T;
            T = in.nextInt();
            for (int t = 1; t <= T; ++t) {
                System.out.print("Case #" + t + ": ");
                String input = in.next();
                int lastDigit = 0;
                for (int i = 0; i < input.length(); i++) {
                    int currentDigit = Integer.parseInt(input.substring(i, i+1));
                    if (lastDigit > currentDigit){
                        for (int j = 0; j < lastDigit - currentDigit; j++) {
                            System.out.print(")");
                        }
                    }else if(lastDigit < currentDigit){
                        for (int j = 0; j < currentDigit - lastDigit; j++) {
                            System.out.print("(");
                        }
                    }
                    System.out.print(currentDigit);
                    lastDigit = currentDigit;
                }
                for (int i = 0; i < lastDigit; i++) {
                    System.out.print(")");
                }
                System.out.println();
            }
        }
    }
}