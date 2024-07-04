import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int N = scanner.nextInt();
            int D = scanner.nextInt();
            List<Long> numbers = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                numbers.add(scanner.nextLong());
            }

            Collections.sort(numbers);
            int count = 0;
            long currentNumber = -1;
            int maxCount = 0;
            long maxNumber = 0;
            boolean firstIteration = true;
            boolean isCut = true;

            for (long number : numbers) {
                if (firstIteration) {
                    currentNumber = number;
                    maxCount = 1;
                    maxNumber = number;
                    firstIteration = false;
                    count++;
                } else {
                    if (number == currentNumber) {
                        count++;
                        if (count == D) {
                            isCut = false;
                            break;
                        }
                    } else {
                        if (count == D) {
                            isCut = false;
                            break;
                        }

                        if (count > maxCount) {
                            maxCount = count;
                            maxNumber = currentNumber;
                        }

                        count = 1;
                        currentNumber = number;
                    }
                }
            }

            int divisibleCount = 0;
            for (long number : numbers) {
                if (number != maxNumber && number % maxNumber == 0) {
                    divisibleCount++;
                }
            }

            int result = D - maxCount - divisibleCount;

            if (!isCut) {
                System.out.println("Case #" + caseNumber + ": 0");
            } else {
                System.out.println("Case #" + caseNumber + ": " + result);
            }
        }
    }
}