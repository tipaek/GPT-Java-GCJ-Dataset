import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    private static int b;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        String[] input = scanner.nextLine().split(" ");
        int t = Integer.parseInt(input[0]);
        b = Integer.parseInt(input[1]);
        
        for (int i = 0; i < t; i++) {
            List<Integer> sameIndices = new ArrayList<>();
            List<Integer> differentIndices = new ArrayList<>();
            int[] bits = new int[b];
            int unknownBits = b;
            int askCounter = 0;
            int currentIndex = 0;

            while (unknownBits > 0) {
                if (askCounter > 1 && askCounter % 10 == 0) {
                    if (updateBits(bits, sameIndices, scanner, true)) askCounter++;
                    if (updateBits(bits, differentIndices, scanner, false)) askCounter++;
                }

                System.out.println(currentIndex + 1);
                askCounter++;
                int firstBit = Integer.parseInt(scanner.nextLine());
                bits[currentIndex] = firstBit;
                unknownBits--;

                if (unknownBits == 0) break;

                if (askCounter > 1 && askCounter % 10 == 0) {
                    if (updateBits(bits, sameIndices, scanner, true)) askCounter++;
                    if (updateBits(bits, differentIndices, scanner, false)) askCounter++;
                }

                int lastIndex = b - 1 - currentIndex;
                System.out.println(lastIndex + 1);
                askCounter++;
                int lastBit = Integer.parseInt(scanner.nextLine());
                bits[lastIndex] = lastBit;
                unknownBits--;

                if (firstBit == lastBit) {
                    sameIndices.add(currentIndex);
                } else {
                    differentIndices.add(currentIndex);
                }

                currentIndex++;
            }

            StringBuilder result = new StringBuilder();
            for (int bit : bits) {
                result.append(bit);
            }
            System.out.println(result.toString());

            if ("N".equals(scanner.nextLine())) {
                return;
            }
        }
    }

    private static boolean updateBits(int[] bits, List<Integer> indices, Scanner scanner, boolean same) {
        if (indices.isEmpty()) return false;

        int index = indices.get(0);
        System.out.println(index + 1);
        int currentBit = Integer.parseInt(scanner.nextLine());

        if (same && bits[index] != currentBit) {
            for (int idx : indices) {
                bits[idx] = 1 - bits[idx];
                bits[b - 1 - idx] = 1 - bits[b - 1 - idx];
            }
        } else if (!same && bits[index] != currentBit) {
            for (int idx : indices) {
                int temp = bits[idx];
                bits[idx] = bits[b - 1 - idx];
                bits[b - 1 - idx] = temp;
            }
        }

        return true;
    }
}