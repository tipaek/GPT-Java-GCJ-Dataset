import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            solve(scanner, i);
        }
    }

    static void solve(Scanner scanner, int caseNumber) {
        Map<String, Integer> dictionary = new HashMap<>();
        Map<Integer, String> reverseDictionary = new HashMap<>();
        Set<String> zeroSet = new HashSet<>();
        int u = scanner.nextInt();
        int counter = 0;
        boolean[][] matrix = new boolean[10][10];

        for (boolean[] row : matrix) {
            Arrays.fill(row, false);
        }

        for (int i = 0; i < 10000; i++) {
            int m = scanner.nextInt();
            String r = scanner.next();
            for (char c : r.toCharArray()) {
                zeroSet.add(String.valueOf(c));
            }
            if (r.length() == getLength(m)) {
                m = getFirstDigit(m);
                String firstChar = r.substring(0, 1);

                if (!dictionary.containsKey(firstChar)) {
                    dictionary.put(firstChar, counter);
                    reverseDictionary.put(counter, firstChar);
                    Arrays.fill(matrix[counter], 0, m, true);
                    counter++;
                } else {
                    int index = dictionary.get(firstChar);
                    Arrays.fill(matrix[index], m, 10, false);
                }
            }
        }

        String[] solution = new String[10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (!matrix[i][j]) {
                    solution[j] = reverseDictionary.get(i);
                    break;
                }
            }
        }

        System.out.print("Case #" + caseNumber + ": ");
        Set<String> dictionaryKeys = dictionary.keySet();
        for (String c : zeroSet) {
            if (!dictionaryKeys.contains(c)) {
                System.out.print(c);
            }
        }

        for (String s : solution) {
            System.out.print(s);
        }
        System.out.println();
    }

    static int getLength(int number) {
        return String.valueOf(number).length();
    }

    static int getFirstDigit(int number) {
        while (number >= 10) {
            number /= 10;
        }
        return number;
    }
}