import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static String nestingDepths(int[] rem, int[] org, int st, int fin) {
        // inv: include st, not fin
        // System.out.println(String.format("(%d, %d)", st, fin));
        if (fin == st) { return ""; }
        int min= 23;
        List<Integer> minIndexes= new ArrayList<>();
        for (int i= st; i < fin; i++ ) {
            if (rem[i] < min) {
                min= rem[i];
                minIndexes= new ArrayList<>(Arrays.asList(i));
            } else if (rem[i] == min) {
                minIndexes.add(i);
            }
        }
        final int realMin= min;
        int[] newRem= Arrays.stream(rem).map(n -> n - realMin).toArray();

        StringBuilder result= new StringBuilder();
        result.append(buildString('(', realMin));
        int prev= st;
        for (int index : minIndexes) {
            result.append(nestingDepths(newRem, org, prev, index));
            result.append(Integer.toString(org[index]));
            prev= index + 1;
        }
        result.append(buildString(')', realMin));
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);
        int T= input.nextInt();
        input.nextLine();
        for (int i= 0; i < T; i++ ) {
            String s= input.nextLine();
            int[] org= new int[s.length()];
            for (int j= 0; j < s.length(); j++ ) {
                org[j]= Character.getNumericValue(s.charAt(j));
            }
            String num= String.format("Case #%d: ", i + 1);
            System.out.println(num + nestingDepths(org, org, 0, org.length));
        }
    }

    private static String buildString(char c, int n) {
        char[] arr= new char[n];
        Arrays.fill(arr, c);
        return new String(arr);
    }
}
