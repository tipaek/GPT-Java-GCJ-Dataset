import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();
        for (int n = 0; n < T; n++) {
            Scanner m = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
            String input = m.nextLine();
            int numbers[] = new int[input.length()];
            List<String> innerSolution = new ArrayList<String>();
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
            List<String> output = new ArrayList<String>();
            int count = 0;
            for (int i = 0; i < innerSolution.size() - 1; i++) {
                if (innerSolution.get(i) == ")" && innerSolution.get(i + 1) == "(") {
                    i++;
                    continue;
                }
                output.add(innerSolution.get(i));
                count = innerSolution.size() - 1;
            }
            if (innerSolution.get(count) != null){
                output.add(innerSolution.get(count));
            }
            String[] aOutput = output.toArray(new String[0]);
            System.out.printf("Case #%d: ", n+1);
            for (int i = 0; i < aOutput.length; i++) {
                System.out.print(aOutput[i] + " ");
            }
            System.out.println();
        }
    }
}
