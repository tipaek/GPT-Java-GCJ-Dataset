import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = Integer.parseInt(sc.nextLine());
        int U = Integer.parseInt(sc.nextLine());
        ArrayList<String> listInput = new ArrayList<>();

        for (int t = 0; t < T; t++) {
            Set<Character>[] arrayMap = new HashSet[11];
            for (int i = 0; i < 11; i++) {
                arrayMap[i] = new HashSet<>();
            }

            while (sc.hasNextLine()) {
                String input = sc.nextLine();
                listInput.add(input);
                String[] parts = input.split(" ");
                int N = Integer.parseInt(parts[0]);
                String str = parts[1];

                if (N < 10) {
                    arrayMap[N].add(str.charAt(0));
                }
                if (N > 10 && str.length() == 2) {
                    arrayMap[0].add(str.charAt(1));
                }
            }

            for (String input : listInput) {
                String[] parts = input.split(" ");
                int N = Integer.parseInt(parts[0]);
                String str = parts[1];

                if (N < 10) {
                    for (int i = N + 1; i < 10; i++) {
                        arrayMap[i].remove(str.charAt(0));
                    }
                }
                if (N == 10 && str.length() == 1) {
                    arrayMap[0].remove(str.charAt(0));
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