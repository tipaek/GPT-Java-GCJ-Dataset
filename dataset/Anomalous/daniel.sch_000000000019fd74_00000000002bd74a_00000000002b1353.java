import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Solution {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int numberInstances = Integer.parseInt(br.readLine());

            for (int i = 1; i <= numberInstances; i++) {
                StringBuilder sb = new StringBuilder();
                int input = Integer.parseInt(br.readLine().split(" ")[0]);

                if (input <= 29) {
                    for (int counter = 0; counter < input; counter++) {
                        sb.append(counter + 1).append(" 1\n");
                    }
                } else {
                    int maxDepth = 29;
                    LinkedList<Integer> powers = getPowers(input - maxDepth);
                    int additionalOnes = powers.size();
                    boolean leftSide = true;
                    int currentRow = 1;

                    while (currentRow <= maxDepth) {
                        if (!powers.isEmpty() && currentRow == powers.peekLast() + 1) {
                            powers.removeLast();
                            if (leftSide) {
                                for (int k = 1; k <= currentRow; k++) {
                                    sb.append(currentRow).append(" ").append(k).append("\n");
                                }
                                leftSide = false;
                            } else {
                                for (int k = currentRow; k >= 1; k--) {
                                    sb.append(currentRow).append(" ").append(k).append("\n");
                                }
                                leftSide = true;
                            }
                        } else {
                            sb.append(currentRow).append(" ").append(leftSide ? 1 : currentRow).append("\n");
                        }
                        currentRow++;
                    }

                    for (int counter = 0; counter < additionalOnes; counter++) {
                        sb.append(maxDepth + counter + 1).append(" ").append(leftSide ? 1 : maxDepth + counter + 1).append("\n");
                    }
                }

                sb.setLength(sb.length() - 1);  // Remove the last newline character
                System.out.println("Case #" + i + ": \n" + sb);
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }

    private static LinkedList<Integer> getPowers(int number) {
        LinkedList<Integer> powers = new LinkedList<>();
        for (int max = 29; max >= 0; max--) {
            int powerOfTwo = (int) Math.pow(2, max);
            if (number >= powerOfTwo) {
                powers.add(max);
                number -= powerOfTwo;
            }
        }
        return powers;
    }
}