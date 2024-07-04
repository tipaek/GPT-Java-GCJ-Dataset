import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        scanner.nextLine();

        String[] inputs = new String[T];
        for (int i = 0; i < T; i++) {
            inputs[i] = scanner.nextLine();
        }

        for (int i = 0; i < T; i++) {
            System.out.print("Case #" + (i+1) + ": ");
            System.out.println(nestingDepth(inputs[i]));
        }

    }

    private static String nestingDepth(String input) {
        List<String> blocks = toBlocks(input);

        return nestBlocks(blocks);
    }

    private static String nestBlocks(List<String> blocks) {
        StringBuilder builder = new StringBuilder("");

        int nestingLvl = 0;
        for (String block : blocks) {
            Integer value = Integer.valueOf(""+block.charAt(0));
            while (nestingLvl < value) {
                nestingLvl++;
                builder.append("(");
            }
            while (nestingLvl > value) {
                nestingLvl--;
                builder.append(")");
            }
            builder.append(block);
            while (nestingLvl < value) {
                nestingLvl++;
                builder.append("(");
            }
            while (nestingLvl > value) {
                nestingLvl--;
                builder.append(")");
            }
        }
        while (nestingLvl > 0) {
            nestingLvl--;
            builder.append(")");
        }
        return builder.toString();
    }

    private static List<String> toBlocks(String input) {
        List<String> result = new LinkedList<>();
        int i = 0;
        while (i < input.length()) {
            char current = input.charAt(i);
            String block = "" + current;
            while (i < input.length() - 1 && current == input.charAt(i+1)) {
                i++;
                block = block + input.charAt(i);
            }
            result.add(block);
            i++;
        }
        return result;
    }
}
