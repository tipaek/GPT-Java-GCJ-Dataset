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
        String[] myArry = new String[length];// Scanner has functions to read ints, longs, strings, chars, etc.
        for (int j = 1; j <= t; ++j) {
            for (int i = 1; i <= 150; ++i) {
                System.out.println(i);
                System.out.flush();
                String recieved = in.next();
                if (recieved.equals("N")) {
                    continue;
                } else {
                    myArry[i - 1] = recieved;
                }
                if (i >= 10 && length <= 10) {
                    System.out.println(Arrays.stream(myArry)
                            .collect(Collectors.joining("")));
                    System.out.flush();
                    String answer = in.next();
                    if (answer.equals("Y")) {
                        break;
                    } else {
                        break;
                    }
                }
            }
        }
        in.close();
    }

}