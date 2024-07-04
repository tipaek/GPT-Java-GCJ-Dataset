import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        //.out.println("codejam");
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        /*
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        int n = in.nextInt();
        int m = in.nextInt();
        */
        String head = in.nextLine();
        String[] heads = head.split(" ");
        int t = Integer.parseInt(heads[0]);
        int b = Integer.parseInt(heads[1]);


        for (int i = 1; i <= t; ++i) {

            //System.out.println("now");
            String ans;
            if (b == 10) {
                ans = solve(in, b);
            } else {
                ans = solve2(in, b);
            }
            if (ans == "")
                break;
            System.out.println(ans);
            String response = in.nextLine();
            if (response.equals("N")){ break; }
        }
    }

    public static String solve(Scanner in, int b){
        //first 14 rounds
        for (int i = 0; i < 14; i++) {
            //send 10 queries
            for (int j = 0; j < 10; j++) {
                System.out.println(1);
                String temp = in.nextLine();
            }
        }
        //last one
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < 10; j++) {
            System.out.println(j+1);
            String curr = in.nextLine();
            sb.append(curr);
        }
        return sb.toString();

    }

    public static String solve2(Scanner in, int b){
        //first 5 match second 5
        String first = "";
        for (int i = 0; i < 5; i++) {
            System.out.println(i+1);
            String temp = in.nextLine();
            first += temp;
        }
        String second = "";
        for (int i = 0; i < 5; i++) {
            System.out.println(i+6);
            String temp = in.nextLine();
            second += temp;
        }

        Set<String> set = new HashSet<>();

        //14 rounds
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 14; i++) {
            //send 10 queries
            for (int j = 0; j < 10; j++) {
                System.out.println(j+i);
                String temp = in.nextLine();
                sb.append(temp);
            }
            set.add(sb.toString());
        }
        String ans1 = sb.toString();

        String ofirst = "";
        String osecond = "";
        for (String s : set) {
            if (s.substring(0,5).equals(first)) {
                ofirst = s;
            }
            if (s.substring(0,5).equals(second)) {
                osecond = s;
            }
        }
        String original = ofirst + osecond;

        if (original.substring(0,10).equals(ans1)) {
            return original;
        }

        sb = new StringBuilder();
        for (int i = 0; i < original.length(); i++) {
            sb.append(original.charAt(20-1-i));
        }
        String temp = sb.toString();
        if (temp.substring(0, 10).equals(ans1)) {
            return temp;
        }

        sb = new StringBuilder();
        for (int i = 0; i < original.length(); i++) {
            sb.append(original.charAt(i) == '0'? '1' : '0');
        }
        temp = sb.toString();
        if (temp.substring(0, 10).equals(ans1)) {
            return temp;
        }

        sb = new StringBuilder();
        for (int i = 0; i < original.length(); i++) {
            sb.append(original.charAt(20-1-i) == '0'? '1' : '0');
        }
        return sb.toString();

    }
}