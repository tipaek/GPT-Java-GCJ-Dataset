import java.io.*;

public class Solution {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(br.readLine());

        for (int test = 1; test <= cases; test++) {

            String input = br.readLine();

            //DONOT CHANGE THE LINE IF NOT NECESSARY
            System.out.print("Case #" + test + ": ");

            System.out.println(findNestingDepth(input.trim()));

        }
    }

    static String findNestingDepth(String sample) {

        String result = "";

        int prevNumber = Integer.parseInt(sample.charAt(0)+"");
        for (int i = 0; i < prevNumber; i++) {
            result += "(";
        }
        result += sample.charAt(0);

        int rem = prevNumber;

        for (int i = 1; i < sample.length(); i++) {
            int number = Integer.parseInt(sample.charAt(i) + "");

            if (number == prevNumber) {
                result += number;
            } else {

                if (number == 0) {
                    for (int j = 0; j < rem; j++) {
                        result += ")";
                    }
                } else {
                    if (rem < 0) {
                        for (int j = 0; j < Math.abs(rem); j++) {
                            result += "(";
                        }
                    }
                    else if(rem == 0){
                        for (int j = 0; j < number; j++) {
                            result += "(";
                        }
                    }
                    else {
                            result += "(";
                    }

                }

                result += number;
                rem = number;

                prevNumber = number;

            }
        }
        for (int j = 0; j < rem; j++) {
            result += ")";
        }

        return result;
    }

}