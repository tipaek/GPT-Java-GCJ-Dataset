import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Vestigium {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int dataSize = Integer.parseInt(scanner.nextLine());

        for (int caseNumber = 1; caseNumber <= dataSize; caseNumber++) {
            String input = scanner.nextLine();
            ArrayList<Integer> numbers = convertToIntList(input);
            System.out.print("Case #" + caseNumber + ": ");
            processNumbers(numbers);
            System.out.println();
        }
    }

    private static ArrayList<Integer> convertToIntList(String input) {
        ArrayList<Integer> output = new ArrayList<>();
        for (char c : input.toCharArray()) {
            output.add(Character.getNumericValue(c));
        }
        return output;
    }

    private static void processNumbers(ArrayList<Integer> numbers) {
        numbers.add(-99); // Sentinel value to handle end of list
        int count = 0;
        boolean increase = true;
        int index = 0;

        while (index < numbers.size() - 1) {
            int current = numbers.get(index);
            while (current == count) {
                System.out.print(current);
                index++;
                if (index < numbers.size() - 1) {
                    current = numbers.get(index);
                    if (current < count || current == 0) {
                        increase = false;
                    } else {
                        increase = true;
                    }
                } else {
                    break;
                }
            }
            if (index < numbers.size() - 1) {
                if (increase) {
                    System.out.print("(");
                    count++;
                } else {
                    System.out.print(")");
                    count--;
                }
            }
        }

        while (count > 0) {
            System.out.print(")");
            count--;
        }
    }
}