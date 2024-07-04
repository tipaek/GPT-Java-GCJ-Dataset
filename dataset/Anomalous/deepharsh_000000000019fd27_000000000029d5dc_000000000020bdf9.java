import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int i = 1; i <= testCases; i++) {
            int n = scanner.nextInt();
            int[] numbers = new int[n * 2];
            
            for (int j = 0; j < numbers.length; j++) {
                numbers[j] = scanner.nextInt();
            }
            
            System.out.println("Case #" + i + ": " + generateSequence(numbers, "", 0));
        }
    }

    public static String generateSequence(int[] numbers, String sequence, int index) {
        if (index >= numbers.length - 2) {
            return "Impossible";
        }
        
        sequence += "C";
        
        if (numbers[index + 1] <= numbers[index + 2]) {
            while (numbers[index + 1] <= numbers[index + 2]) {
                sequence += "C";
                index += 2;
                
                if (index >= numbers.length - 2) {
                    return sequence;
                }
            }
            return generateJSequence(numbers, sequence, index + 2);
        } else {
            return generateJSequence(numbers, sequence, index + 2);
        }
    }

    public static String generateJSequence(int[] numbers, String sequence, int index) {
        if (index >= numbers.length - 2) {
            return "IMPOSSIBLE";
        }
        
        sequence += "J";
        
        if (numbers[index + 1] <= numbers[index + 2]) {
            while (numbers[index + 1] <= numbers[index + 2]) {
                sequence += "J";
                index += 2;
                
                if (index >= numbers.length - 2) {
                    return sequence;
                }
            }
            return generateSequence(numbers, sequence, index + 2);
        } else {
            return generateSequence(numbers, sequence, index + 2);
        }
    }
}