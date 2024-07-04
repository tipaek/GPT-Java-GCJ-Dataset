import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        for (int counter = 0; counter < n; counter++) {
            char[] modifiedValues = new char[10];

            int U = in.nextInt();
            Set<Character>[] validNumbers = new Set[10];
            for (int i = 0; i < 10; i++) {
                validNumbers[i] = new HashSet<>();
            }

            for (int i = 0; i < 10000; i++) {
                int x = in.nextInt();
                String result = in.next();
                if (x == -1) continue;
                if (result.length() == (int) Math.ceil(Math.log10(x + 1))) {
                    int index = (int) (x / Math.pow(10, (int) (Math.log10(x))));
                    validNumbers[index].add(result.charAt(0));
                }
                validNumbers[0].add(result.charAt(result.length() - 1));
            }

            for (int i = 1; i < 10; i++) {
                modifiedValues[i] = calculateValues(validNumbers[i], validNumbers);
            }
            modifiedValues[0] = (char) validNumbers[0].toArray()[0];

            System.out.print("Case #" + (counter + 1) + ": ");
            for (char value : modifiedValues) {
                System.out.print(value);
            }
            System.out.println();
        }
    }

    private static char calculateValues(Set<Character> validNumbers, Set<Character>[] allValidNumbers) {
        char a = validNumbers.iterator().next();
        for (Set<Character> validSet : allValidNumbers) {
            validSet.remove(a);
        }
        return a;
    }
}