import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int cases = in.nextInt();
        for (int i = 0; i < cases; i++) {
            StringBuilder start = new StringBuilder();
            StringBuilder result = new StringBuilder();
            start.append(in.next());
            int[] numbers = new int[start.length()+2];
            numbers[0] = 0;
            numbers[numbers.length-1] = 0;
            start.append(0);
            for (int j = 1; j < numbers.length; j++) {
                numbers[j] = Integer.parseInt(start.charAt(j-1)+"");
                int a = numbers[j-1];
                int b = numbers[j];
                if (a == b) result.append(b);
                else if (a < b) {
                    int signs = b-a;
                    for (int k = 0; k < signs; k++) {
                        result.append('(');
                    }
                    result.append(b);
                }
                else {
                    int signs = a-b;
                    for (int k = 0; k < signs; k++) {
                        result.append(')');
                    }
                    result.append(b);
                }
            }
            result.deleteCharAt(result.length()-1);
            System.out.println("Case #" + (i+1) + ": " + result.toString());

        }

    }
}
