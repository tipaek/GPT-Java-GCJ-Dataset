import static java.lang.Integer.parseInt;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.stream.Stream;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int[] arr = Stream.of(in.next().split("")).mapToInt(no -> parseInt(no)).toArray();
            System.out.println("Case #" + i + ": " + solve(arr));
        }
    }

    private static String solve(int[] arr) {
        StringBuilder str = new StringBuilder("");
        int currentDepth = 0;
        for (int i : arr){
            if (i == 0 ){
                while (currentDepth != 0){
                    str.append(")");
                    currentDepth--;
                }
            }else if (i < currentDepth){
                while (currentDepth != i){
                    str.append(")");
                    currentDepth--;
                }
            }else if (i > currentDepth){
                while(currentDepth != i){
                    str.append("(");
                    currentDepth++;
                }
            }
            str.append(i);
        }
        while (currentDepth != 0){
            str.append(")");
            currentDepth--;
        }
        return str.toString();
    }

}
