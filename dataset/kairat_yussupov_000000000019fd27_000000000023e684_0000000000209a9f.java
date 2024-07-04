import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.Scanner;

public class Solution {


    public static void main(String[] args) throws IOException {
       /* String input = "4\n" +
                "0000\n" +
                "102\n" +
                "131000\n" +
                "1";

        BufferedReader reader = new BufferedReader(new StringReader(input));*/


        Scanner scanner = new Scanner(System.in);

        int line_numbers = Integer.parseInt(scanner.nextLine());

        for (int k = 0; k < line_numbers; k++) {

            StringBuilder sb = new StringBuilder();

            String line = scanner.nextLine();
            char[] chars = line.toCharArray();
            int[] numbers = new int[chars.length];
            for (int i = 0; i < chars.length; i++) {
                numbers[i] = Integer.parseInt(String.valueOf(chars[i]));
            }

            int prev = 0;
            int last = 0;
            for (int i = 0; i < numbers.length; i++) {
                int diff = numbers[i] - prev;
                int abs = Math.abs(diff);
                for (int j = 0; j < abs; j++){
                    if (diff < 0){
                        sb.append(")");
                    } else {
                        sb.append("(");
                    }
                }
                sb.append(numbers[i]);
                //System.out.print(numbers[i] + " ");
                prev = numbers[i];
            }

            int diff = last - numbers[numbers.length-1];
            int abs = Math.abs(diff);
            for (int j = 0; j < abs; j++){
                if (diff < 0){
                    sb.append(")");
                } else {
                    sb.append("(");
                }
            }


            System.out.println("Case #" + (k+1) + ": " + sb.toString());
        }


    }

}
