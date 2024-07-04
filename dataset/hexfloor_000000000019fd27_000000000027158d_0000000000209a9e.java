import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {
    public static String solve(Scanner in, int b) {
       int []a = new int[b];
       for (int j = 0; j<b; j++) {
           System.out.println(j + 1);
           int value = Integer.parseInt(in.next());
           a[j] = value;
       }
       return Arrays.stream(a).boxed().map(Object::toString).collect(Collectors.joining());
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int b = in.nextInt();
        for (int i = 1; i <= t; i++) {
            String result = solve(in,b);
            System.out.println(result);
        }
    }
}