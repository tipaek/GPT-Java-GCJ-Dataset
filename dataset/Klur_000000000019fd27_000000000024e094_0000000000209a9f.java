import java.util.*;
import java.io.*;

/**
 * In
 * 4
 * 0000
 * 101
 * 111000
 * 1
 * Out
 * Case #1: 0000
 * Case #2: (1)0(1)
 * Case #3: (111)000
 * Case #4: (1)
 *
 */
public class Solution {

    private static final char LEFT = '(';
    private static final char RIGHT = ')';

    public static void solve(String input){
        StringBuilder sb = new StringBuilder();
        char[] numbers = input.toCharArray();

        for(int count = 0; count<numbers.length; count++){
            int number = Character.getNumericValue(numbers[count]);
            if(count==0){
                //most left
                sb.append(getCharNum(LEFT,number));
                sb.append(number);
            } else {
                int prev = Character.getNumericValue(numbers[count-1]);
                int diff = number - prev;
                if(diff>0){
                    sb.append(getCharNum(LEFT,diff));
                }
                if(diff<0){
                    sb.append(getCharNum(RIGHT, Math.abs(diff)));
                }
                sb.append(number);
            }
            if(count==numbers.length-1) {
                //most right
                sb.append(getCharNum(RIGHT, number));
            }
        }
        System.out.println(sb.toString());

    }

    private static String getCharNum(char c, int n){
        StringBuilder sb = new StringBuilder();
        for (int i=1;i<=n;i++){
            sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCase = sc.nextInt();
        for (int testCount = 1; testCount<=testCase;testCount++){
            System.out.print("Case #" + testCount + ": ");
            solve(sc.next());
        }
    }
}
