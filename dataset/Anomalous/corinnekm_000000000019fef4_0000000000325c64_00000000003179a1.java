import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        ArrayList<String> listInput = new ArrayList<>();

        int T = Integer.parseInt(sc.nextLine());
        int U = Integer.parseInt(sc.nextLine());

        for (int t = 0; t < T; t++) {
            Set<Character>[] arrayMap = new HashSet[11];
            for (int i = 0; i < 11; i++) {
                arrayMap[i] = new HashSet<>();
            }

            // Fill arrayMap
            while (sc.hasNextLine()) {
                String input = sc.nextLine();
                listInput.add(input);
                String[] parts = input.split(" ");
                int N = Integer.parseInt(parts[0]);
                char firstChar = parts[1].charAt(0);

                if (N <= 10) {
                    arrayMap[N].add(firstChar);
                }
            }

            // Remove characters from arrayMap
            for (String input : listInput) {
                String[] parts = input.split(" ");
                int N = Integer.parseInt(parts[0]);
                char firstChar = parts[1].charAt(0);

                if (N < 10) {
                    for (int i = N + 1; i < 10; i++) {
                        arrayMap[i].remove(firstChar);
                    }
                }
                if (N == 10 && parts[1].length() == 1) {
                    arrayMap[0].remove(firstChar);
                }
            }

            StringBuilder result = new StringBuilder();
            for (Set<Character> set : arrayMap) {
                if (!set.isEmpty()) {
                    result.append(set.iterator().next());
                }
            }
            System.out.println("Case #" + (t + 1) + ": " + result.toString());
        }
    }
}