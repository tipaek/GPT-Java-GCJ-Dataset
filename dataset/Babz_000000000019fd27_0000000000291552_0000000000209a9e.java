import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        int length = in.nextInt();
        int[] myArray = new int[length];
        // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int j = 1; j <= t; ++j) {
            for (int i = 0; i < length; i++) {
                myArray[i] = 0;
            }
            boolean testFailed = false;
            for (int i = 1; i <= 150; ++i) {
                if ((i % 10) == 1) {
                    System.out.println(Arrays.stream(myArray)
                            .mapToObj(String::valueOf)
                            .collect(Collectors.joining("")));
                    System.out.flush();
                    String answer = in.next();
                    if (answer.equals("Y")) {
                        break;
                    } else {
                        testFailed = true;
                        break;
                    }
                }

                System.out.println(i);
                System.out.flush();
                String recieved = in.next();
                if (recieved.equals("N")) {
                    break;
                } else {
                    myArray[i - 1] = Integer.parseInt(recieved);
                }

            }
            if (testFailed) {
                break;
            }
        }
        in.close();
    }

}