import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Solution {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int numberInstances = Integer.parseInt(br.readLine());
            for (int i = 1; i <= numberInstances; i++) {
                StringBuilder sb = new StringBuilder();
                String[] arguments = br.readLine().split(" ");
                int input = Integer.parseInt(arguments[0]);

                if (input <= 29) {
                    for (int counter = 0; counter < input; counter++) {
                        sb.append((counter + 1)).append(" 1\n");
                    }
                } else {
                    int maxDepth = 29;
                    LinkedList<Integer> powers = calculatePowers(input - maxDepth);
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
                            if (leftSide) {
                                sb.append(currentRow).append(" 1\n");
                            } else {
                                sb.append(currentRow).append(" ").append(currentRow).append("\n");
                            }
                        }
                        currentRow++;
                    }

                    for (int counter = 0; counter < additionalOnes; counter++) {
                        if (leftSide) {
                            sb.append(maxDepth + counter + 1).append(" 1\n");
                        } else {
                            sb.append(maxDepth + counter + 1).append(" ").append(maxDepth + counter + 1).append("\n");
                        }
                    }
                }

                sb.deleteCharAt(sb.length() - 1);
                System.out.println("Case #" + i + ":\n" + sb);
            }
        } catch (NumberFormatException | IOException e) {
            e.printStackTrace();
        }
    }

    private static LinkedList<Integer> calculatePowers(int number) {
        LinkedList<Integer> powers = new LinkedList<>();
        for (int max = 29; max >= 0; max--) {
            int power = (int) Math.pow(2, max);
            if (number >= power) {
                powers.add(max);
                number -= power;
            }
        }
        return powers;
    }
}