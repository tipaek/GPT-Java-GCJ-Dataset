import java.util.*;

public class Solution {
    public static void main( String[] args ) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        for (int counter = 0; counter < n; counter++) {
            char[] valoriModificati = new char[10];

            int U = in.nextInt();
            Set[] validNumbers = new Set[10];
            for (int i = 0; i < 10; i++) {
                validNumbers[i] = new HashSet<Character>();
            }

            for (int i = 0; i < 10000; i++) {
                int x = in.nextInt();
                String result = in.next();
                if(x == -1) continue;
                if(result.length() == (int)Math.ceil(Math.log10(x+1))){
                    int index = (int)(x / Math.pow(10, (int)(Math.log10(x))));
                    validNumbers[index].add(result.charAt(0));
                }
                validNumbers[0].add(result.charAt(result.length()-1));
            }

            for (int i = 0; i < 9; i++) {
                valoriModificati[i+1] = calculateValues(validNumbers[i+1], validNumbers);
            }
            valoriModificati[0] = (char)validNumbers[0].toArray()[0];

            System.out.print("Case #" + (counter + 1) + ": ");
            for (int i = 0; i < 10; i++) {
                System.out.print(valoriModificati[i]);
            }
            System.out.println();
        }
    }

    private static char calculateValues(Set validNumbers, Set[] allValidNumbers) {
        char a = (char)validNumbers.toArray()[0];
        for (int i = 0; i < 10; i++) {
            allValidNumbers[i].remove(a);
        }
        return a;
    }
}
