import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    static Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) {
        int cases = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < cases; i++) {
            char[] line = sc.nextLine().toCharArray();
            processing(line, i+1);
        }
    }

    public static void processing(char[] inputArray, int ncase) {
        if (inputArray.length == 1 && inputArray[0] == '0') {
            print(ncase, String.valueOf(inputArray[0]));
        } else {
            if (inputArray.length == 1) {
                print(ncase, builder(Integer.parseInt(String.valueOf(inputArray[0]))));
            } else {
                print(ncase, mainMatcher(inputArray));
            }
        }
    }

    public static String builder(int inputInt) {
        StringBuilder trailing = new StringBuilder();
        StringBuilder leading = new StringBuilder();
        for (int i = 0; i < inputInt; i++) {
            trailing.append("(");
            leading.append(")");
        }
        return trailing.toString() + inputInt + leading.toString();
    }

    public static void print(int ncase, String result) {
        System.out.println("Case #" + ncase + ":" + " " + result);
    }

    public static String mainMatcher(char[] inputArray){
        StringBuilder start = new StringBuilder(builder(Integer.parseInt(String.valueOf(inputArray[0]))));
        for (int i = 1; i < inputArray.length; i++) {
            int next = Integer.parseInt(String.valueOf(inputArray[i]));
            int previous = Integer.parseInt(String.valueOf(inputArray[i-1]));
            if(next == 0){
                start.append(next);
            } else {
                if(next <= previous){
                    start = new StringBuilder(start.substring(0, start.length() - next) + next + start.substring(start.length() - next));
                } else {
                    start = new StringBuilder(start.substring(0, start.length() - previous) + (builder(next).substring(previous)));
                }
            }
        }
        return start.toString();
    }
}
