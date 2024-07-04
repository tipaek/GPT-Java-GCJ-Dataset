import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class Solution {


    public static final char LEFT = '[';
    public static final char RIGHT = ']';


    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(in.nextLine());  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int[] digits = lineToInt(in.nextLine(), "");
            String sol = solve(digits).replaceAll("\\[", "(").replaceAll("\\]", ")");
            System.out.println( String.format("Case #%d: %s", i, sol));
        }

    }

    private static String solve(int[] s){
        int start=0;
        while(start < s.length && s[start] == 0)start++;

        if(start >= s.length){
            return arrayToString(s);
        }

        StringBuilder sb = new StringBuilder(arrayToString(s));

        if(s[start] > 0){
           int end = findEndOfLongestPositive(s, start);
            sb.replace(end+1, s.length, solve(Arrays.copyOfRange(s, end+1, s.length)));
           replacePos(s, start, sb, end);
        } else {
            int end = findEndOfLongestNegative(s, start);
            sb.replace(end+1, s.length, solve(Arrays.copyOfRange(s, end+1, s.length)));
            replaceNeg(s, start, sb, end);
        }

        return sb.toString();
    }

    private static void replaceNeg(int[] s, int end, StringBuilder sb, int start) {
        String sub = subNegative(s, start, end);
        sb.replace(start, end+1, sub);
    }

    private static void replacePos(int[] s, int start, StringBuilder sb, int end) {
        String sub = subPositive(s, start, end);
        sb.replace(start, end +1, sub);
    }

    private static int findEndOfLongestPositive(int[] s, int start){
        int end = s.length-1;
        while(end > start && s[end] <=0) end--;
        return end;
    }

    private static int findEndOfLongestNegative(int[] s, int start){
        int end = s.length-1;
        while(end > start && s[end] >=0) end--;
        return end;
    }

    private static String subNegative(int[] s, int start, int end) {
        StringBuilder sb = new StringBuilder();
        sb.append(RIGHT);
        int[] sub = modify(s, 1 , start, end);
        String subS = solve(sub);
        sb.append(modify(subS , -1));
        sb.append(LEFT);
        return sb.toString();
    }

    private static String subPositive(int[] s, int start, int end) {
        StringBuilder sb = new StringBuilder();
        sb.append(LEFT);
        int[] sub = modify(s, -1, start, end);
        String subS = solve(sub);
        sb.append(modify(subS , 1));
        sb.append(RIGHT);

        return sb.toString();
    }

    public static int[] modify(int[] s, int d, int start, int end) {
        return IntStream.rangeClosed(start, end).map(index -> s[index]).map(i -> i+d).toArray();
    }

    public static String arrayToString(int[] arr){
        char[] result = new char[arr.length];
        for (int i = 0; i < arr.length; i++) {
           result[i] = (char) (arr[i]+48);
        }

        return new String(result);
    }

    public static String arrayToString(int[] arr, int start, int end){
        int[] sub = Arrays.copyOfRange(arr, start, end+1);
        return Arrays.toString(sub).replaceAll("[, \\[\\]]", "");
    }

    public static String modify(String s, int d) {
        char[] result = s.toCharArray();
        for (int i = 0; i < result.length; i++) {
            char c = result[i];
            if(c != LEFT && c != RIGHT){
                result[i] = (char) (c + d);
            }
        }

        return new String(result);
    }

    public static int[] lineToInt(String line, String regex) {
        return Stream.of(line.split(regex)).mapToInt(Integer::parseInt).toArray();
    }
}