import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int b = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            ArrayList<Integer> array = new ArrayList<>(b);

            // Initialize the array with dummy values
            for (int j = 0; j < b; j++) {
                array.add(-1);
            }

            System.out.println(1);
            array.set(0, scanner.nextInt());

            int known = 1;
            int queries = 1;

            while (known < b) {
                if (queries % 10 != 0) {
                    int index = (known % 2 == 0) ? (known / 2) + 1 : b - (known / 2);
                    System.out.println(index);
                    array.set(index - 1, scanner.nextInt());
                    queries++;
                    known++;
                } else {
                    ArrayList<ArrayList<Integer>> candidates = generateCandidates(array);
                    int possible = 0b1111;

                    int index = 0;
                    while (possible != 0b1000 && possible != 0b0100 && possible != 0b0010 && possible != 0b0001) {
                        System.out.println(index + 1);
                        int bit = scanner.nextInt();
                        possible = updatePossibleCandidates(candidates, index, bit, possible);
                        index++;
                        queries++;
                    }

                    switch (possible) {
                        case 0b1000:
                            array = candidates.get(3);
                            break;
                        case 0b0100:
                            array = candidates.get(2);
                            break;
                        case 0b0010:
                            array = candidates.get(1);
                            break;
                        default:
                            array = candidates.get(0);
                    }
                }
            }

            for (int n : array) {
                System.out.print(n);
            }
            System.out.println();
        }
    }

    public static int updatePossibleCandidates(ArrayList<ArrayList<Integer>> candidates, int index, int bit, int possible) {
        for (int i = 0; i < candidates.size(); i++) {
            if (((possible >> i) & 1) == 1 && candidates.get(i).get(index) != bit) {
                possible -= 1 << i;
            }
        }
        return possible;
    }

    public static ArrayList<ArrayList<Integer>> generateCandidates(ArrayList<Integer> array) {
        int b = array.size();
        ArrayList<ArrayList<Integer>> candidates = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            candidates.add(new ArrayList<>());
        }

        for (int i = 0; i < b; i++) {
            candidates.get(0).add(1 - array.get(i)); // complement
            candidates.get(1).add(array.get(b - i - 1)); // reverse
            candidates.get(2).add(1 - array.get(b - i - 1)); // complement of reverse
            candidates.get(3).add(array.get(i)); // original
        }

        return candidates;
    }
}