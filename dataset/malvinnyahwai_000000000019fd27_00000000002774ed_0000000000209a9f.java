import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();
        in.nextLine();
        for (int t = 0; t < T; t++) {
            String input = in.nextLine();
            System.out.println(input);
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
        List output = new ArrayList();
        int count = 0;
        int z = 1;
        for (int i = 0; i < innerSolution.size() - 1; i++) {
            if (innerSolution.get(i) == ")" && innerSolution.get(i + 1) == "(" || innerSolution.get(z-1) == ")" && innerSolution.get(i) == "(") {
                innerSolution.remove(i);
                z=i;
                continue;
            }
            output.add(innerSolution.get(i));
            count = innerSolution.size() - 1;
        }
        if (innerSolution.get(count) != null)
            output.add(innerSolution.get(count));
        String[] aOutput = (String[]) output.toArray(new String[0]);
        System.out.printf("Case #%d: ", n+1);
        for (int i = 0; i < aOutput.length; i++) {
            System.out.print(aOutput[i] + " ");
        }
        System.out.println();
    }
}
