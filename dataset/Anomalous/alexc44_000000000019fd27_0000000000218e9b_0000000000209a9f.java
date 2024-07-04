import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cases = scanner.hasNextLine() ? Integer.parseInt(scanner.nextLine()) : 0;

        for (int i = 0; i < cases; i++) {
            String curr = scanner.nextLine();
            int[] arr = curr.chars().map(Character::getNumericValue).toArray();
            System.out.println("Case #" + (i + 1) + ": " + generateOutput(arr));
        }
    }

    public static String generateOutput(int[] arr) {
        StringBuilder[] strBuilders = new StringBuilder[arr.length + 1];
        for (int i = 0; i < strBuilders.length; i++) {
            strBuilders[i] = new StringBuilder();
        }

        for (int i = 0; i < arr.length; i++) {
            while (arr[i] > 0) {
                strBuilders[i].append('(');
                arr[i]--;
                int next = i + 1;
                while (next < arr.length && arr[next] > 0) {
                    arr[next]--;
                    next++;
                }
                strBuilders[next].insert(0, ')');
            }
        }

        StringBuilder output = new StringBuilder(strBuilders[0]);
        for (int i = 0; i < arr.length; i++) {
            output.append(arr[i]).append(strBuilders[i + 1]);
        }

        return output.toString();
    }
}