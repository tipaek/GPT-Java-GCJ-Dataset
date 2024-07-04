import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {

    public static void solve(Scanner scanner) {
        int u = scanner.nextInt();
        char[] result = new char[10];
        ArrayList<HashSet<Character>> characterSets = new ArrayList<>(10);

        for (int i = 0; i < 10; i++) {
            characterSets.add(new HashSet<>());
        }

        ArrayList<Input> inputs = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            int query = scanner.nextInt();
            String response = scanner.next();
            inputs.add(new Input(query, response));
        }

        Collections.sort(inputs);

        for (Input input : inputs) {
            int query = input.q;
            String response = input.r;

            if (query / 10 == 9 || query % 10 == 9) {
                // Placeholder for potential future logic
            }

            if (query < 10 || response.length() == 1) {
                for (int j = 0; j <= query % 10; j++) {
                    if (characterSets.get(j).contains(response.charAt(0))) {
                        break;
                    }
                    characterSets.get(j).add(response.charAt(0));
                }
            } else {
                for (int j = 1; j <= query / 10; j++) {
                    if (characterSets.get(j).contains(response.charAt(0))) {
                        break;
                    }
                    characterSets.get(j).add(response.charAt(0));
                }
                for (int j = 0; j <= query % 10; j++) {
                    if (characterSets.get(j).contains(response.charAt(1))) {
                        break;
                    }
                    characterSets.get(j).add(response.charAt(1));
                }
            }
        }

        for (int i = 9; i >= 0; i--) {
            result[i] = characterSets.get(i).iterator().next();
            for (int j = i - 1; j >= 0; j--) {
                characterSets.get(j).remove(result[i]);
            }
        }

        for (char c : result) {
            System.out.print(c);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            System.out.print("Case #" + i + ": ");
            solve(scanner);
        }
        scanner.close();
    }
}

class Input implements Comparable<Input> {

    Integer q;
    String r;

    public Input(int q, String r) {
        this.q = q;
        this.r = r;
    }

    @Override
    public int compareTo(Input other) {
        return this.q.compareTo(other.q);
    }
}