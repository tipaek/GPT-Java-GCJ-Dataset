import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {


    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for(int i = 1; i <=t; i++) {
            String s = in.next();
            StringBuilder output = new StringBuilder();
            char[] arr = s.toCharArray();
            int noOfOpen = 0, noOfClosed = 0, prevNum = 0, curNum = 0;

            for(int j = 0; j < arr.length; j++) {
                curNum = arr[j] - '0';

                if(curNum < prevNum) {

                    for(int k = 0; k < prevNum - curNum; k++) {
                        output.append(')');
                        noOfClosed++;
                    }
                    output.append(curNum);
                }else if(curNum > prevNum) {

                    for(int k = 0; k < curNum-prevNum; k++) {
                        output.append('(');
                        noOfOpen++;
                    }
                    output.append(curNum);

                }else {
                    output.append(curNum);
                }
                prevNum = curNum;

            }

            if(noOfClosed < noOfOpen) {
                for(int k = 0; k < noOfOpen - noOfClosed; k++)
                    output.append(')');
            }

            System.out.println("Case #" + i + ": " +  output.toString());

        }
    }




}
