import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            List<Integer> sequence = Arrays.stream(in.next().split("")).map(Integer::parseInt).collect(Collectors.toList());            
            StringBuilder str = new StringBuilder();
            Integer lastElementInSequence = 0;
            for (int index = 0 ; index < sequence.size(); index++){
                if (sequence.get(index).equals(lastElementInSequence))
                    str.append(lastElementInSequence);
                else if (sequence.get(index) > lastElementInSequence) {
                    for (int j = 0; j < sequence.get(index) - lastElementInSequence; j++)
                        str.append("(");
                    str.append(sequence.get(index));
                } else {
                    for (int j = 0; j < lastElementInSequence - sequence.get(index); j++)
                        str.append(")");
                    str.append(sequence.get(index));
                }
                lastElementInSequence = sequence.get(index);
            }

            for (int j = 0; j < lastElementInSequence; j++)
                        str.append(")");

            System.out.println("Case #" + i + ": " + (str.toString()));
        }
    }
}