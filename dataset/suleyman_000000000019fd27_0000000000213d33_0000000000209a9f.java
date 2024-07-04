import java.util.Scanner;

public class Solution {

    public static StringBuilder sb;
    public static int open;

    public static void append(int number) {

//        System.out.print("gir ");
//        System.out.print(" open: " + open);
//        System.out.print(" number: " + number);
//        System.out.println(" sb: " + sb);

        if(open < number) {

            for(int i=0; i<(number-open); i++)
                sb.append('(');
        }
        else if(open > number) {

            for(int i=0; i<(open-number); i++)
                sb.append(')');
        }

        open = number;

        sb.append(number);

//        System.out.print("cik ");
//        System.out.print(" open: " + open);
//        System.out.print(" number: " + number);
//        System.out.println(" sb: " + sb);
//
//        System.out.println();
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int T = Integer.parseInt(scanner.next());

        for(int c=1; c<=T; c++) {   // each case

            String s = scanner.next();

            sb = new StringBuilder();
            open = 0;

            for(int i=0; i<s.length(); i++) {   // each number

                int x = s.charAt(i) - '0';

                append(x);
            }

            for(int i=0; i<open; i++)
                sb.append(')');

            System.out.println("Case #" + c + ": " + sb);
        }
    }
}
