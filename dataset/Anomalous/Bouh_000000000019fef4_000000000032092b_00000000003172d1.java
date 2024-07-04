import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        String result = processInput(scanner);
        System.out.println(result);
    }

    private static String processInput(Scanner scanner) {
        StringBuilder result = new StringBuilder();
        int testCases = scanner.nextInt();
        
        for (int i = 1; i <= testCases; i++) {
            int N = scanner.nextInt();
            int D = scanner.nextInt();
            List<BigInteger> numbers = new ArrayList<>();
            
            for (int j = 0; j < N; j++) {
                numbers.add(new BigInteger(scanner.next()));
            }
            
            result.append("Case #").append(i).append(": ").append(evaluateCase(N, D, numbers)).append("\n");
        }
        
        return result.toString().trim();
    }

    private static String evaluateCase(int N, int D, List<BigInteger> numbers) {
        Map<BigInteger, Integer> frequencyMap = new HashMap<>();
        int maxFrequency = 1;
        
        for (BigInteger number : numbers) {
            frequencyMap.put(number, frequencyMap.getOrDefault(number, 0) + 1);
            maxFrequency = Math.max(maxFrequency, frequencyMap.get(number));
        }
        
        if (maxFrequency >= D) {
            return "0";
        }
        
        if (maxFrequency == 1) {
            for (BigInteger num1 : numbers) {
                for (BigInteger num2 : numbers) {
                    if (num2.equals(num1.multiply(BigInteger.TWO))) {
                        return "1";
                    }
                }
            }
            return "2";
        }
        
        if (maxFrequency == 2) {
            BigInteger minDouble = new BigInteger("360000000001");
            for (BigInteger number : numbers) {
                if (frequencyMap.get(number) >= 2 && number.compareTo(minDouble) < 0) {
                    minDouble = number;
                }
            }
            for (BigInteger number : numbers) {
                if (!number.equals(minDouble) && number.compareTo(minDouble) > 0) {
                    return "1";
                }
            }
        }
        
        return "2";
    }
}