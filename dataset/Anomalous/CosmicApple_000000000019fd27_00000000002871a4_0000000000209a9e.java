import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numOfTests = input.nextInt();
        int length = input.nextInt();

        if (length != 10) {
            while (true) {
                System.out.println("0");
            }
        }

        for (int currentTest = 1; currentTest <= numOfTests; currentTest++) {
            DataFinder dataFinder = new DataFinder(length);
            for (int i = 0; i < 10; i++) {
                dataFinder.readBit(i, input);
            }
            System.out.println(dataFinder.generateOutput());
            input.next();
        }
    }
}

class DataFinder {
    private int[] arr;

    public DataFinder(int length) {
        arr = new int[length];
    }

    public void readBit(int index, Scanner input) {
        System.out.println(index + 1);
        arr[index] = input.nextInt();
    }

    public String generateOutput() {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            output.append(arr[i]);
        }
        return output.toString();
    }
}