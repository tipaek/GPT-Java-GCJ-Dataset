import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args){
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        int bitLength = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            String[] response = new String[bitLength];
            
            for (int index = 1; index <= bitLength; index++) {
                System.out.println(index);
                response[index - 1] = String.valueOf(scanner.nextInt());
            }

            System.out.println(1);
            scanner.nextInt();

            for (int index = 1; index < bitLength; index += 10) {
                System.out.println(index);
                response[index - 1] = String.valueOf(scanner.nextInt());
            }

            System.out.printf("Case #%d: %s%n", testCase, String.join("", response));
        }
    }
}