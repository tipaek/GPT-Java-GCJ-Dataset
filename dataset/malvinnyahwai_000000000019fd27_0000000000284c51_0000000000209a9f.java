import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();
        in.nextLine();
        for (int t = 0; t < T; t++) {
            String input = in.nextLine();
            compute(input, t);
        }
    }
    private static void compute(String input, int n){
        int numbers[] = new int[input.length()];
        List innerSolution = new ArrayList();
        for (int x = 0; x < input.length(); x++) {
            numbers[x] = Character.getNumericValue(input.charAt(x));
            if (numbers[x] != 0) {
                int numberOfBrackets = numbers[x];
                for (int i = 0; i < numberOfBrackets; i++) {
                    innerSolution.add("(");
                }
                innerSolution.add(String.valueOf(numbers[x]));
                for (int i = 0; i < numberOfBrackets; i++) {
                    innerSolution.add(")");
                }
            } else {
                innerSolution.add("0");
            }
        }
        String[] output = (String[]) innerSolution.toArray(new String[0]);
        boolean reAdjust = true;
        while(reAdjust) {
            reAdjust = false;
            int previousLength = output.length;
            int count = 0;
            for (int i = 0; i < output.length - 1; i++) {
                if (output[i].equals(")") && output[i + 1].equals("(")) {
                    output[i] = "error";
                    count++;
                    output[i + 1] = "error";
                    count++;
                    reAdjust = true;
                }
            }
            if(reAdjust) {
                String[] tempOutput = new String[previousLength - count];
                int z = 0;
                for (int i = 0; i < previousLength; i++) {
                    if (output[i].equals("error"))
                        continue;
                    tempOutput[z] = output[i];
                    z++;
                }
                output = tempOutput;
            }
        }
        System.out.printf("Case #%d: ", n+1);
        for (int i = 0; i < output.length; i++) {
            System.out.print(output[i] + " ");
        }
        System.out.println();
    }
}
