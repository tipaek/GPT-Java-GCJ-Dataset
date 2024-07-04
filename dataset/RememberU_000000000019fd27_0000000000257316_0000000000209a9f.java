
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;


public class Solution {
    public static void main(String[] args) {

        Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = input.nextInt();
        String[] sol = new String[testCases];
        for (int c = 0; c < testCases; c++) {
            String s = input.next();
            int[] num = new int[s.length()];
            sol[c] = "";
            for (int i = 0; i < s.length(); i++){
                num[i] = s.charAt(i) - '0';
            }

            sol[c] = recursiv("", num, 0, "");

            }

        for (int i = 0; i < testCases; i++) {
            System.out.format("Case #%d: %s \n", i+1, sol[i]);
        }

    }

    private static String addOpen(int x) {
        String s ="";
        for (int i = 0; i < x; i++) {
            s += "(";
        }
        return s;
    }

    private static String addClose(int x) {
        String s ="";
        for (int i = 0; i < x; i++) {
            s += ")";
        }
        return s;
    }

    private static String recursiv(String solution, int[] numbers, int index, String intermediar) {

        if (index == numbers.length) {
            solution += intermediar + addClose(numbers[index-1]);
            return solution;
        }

        if (numbers[index] == 0) {
            if ("".equalsIgnoreCase(intermediar)) {
                solution += numbers[index];
            } else {
                solution += intermediar + addClose(numbers[index-1])+numbers[index];
            }
            index++;
            return recursiv(solution, numbers, index, "");

        }
        else {
           if ("".equalsIgnoreCase(intermediar)) {
               solution += addOpen(numbers[index]);
               intermediar = "" + numbers[index];
               index++;
               return recursiv(solution, numbers, index, intermediar);

           }
            else {
               if (numbers[index] >= numbers[index-1]) {
                   solution += intermediar + addOpen(numbers[index]-numbers[index-1]);
                   intermediar = "" + numbers[index];
                   index++;
                   return recursiv(solution, numbers, index, intermediar);
               } else {
                   solution += intermediar + addClose(numbers[index-1]-numbers[index]);
                   intermediar = "" + numbers[index];
                   index++;
                   return recursiv(solution, numbers, index, intermediar);

           }

          }

        }
    }

}
