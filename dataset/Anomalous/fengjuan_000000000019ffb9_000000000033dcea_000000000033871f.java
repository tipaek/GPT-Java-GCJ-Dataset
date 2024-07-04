import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt(); // Number of test cases

        for (int testCase = 1; testCase <= t; ++testCase) {
            int size = scanner.nextInt();
            int[] answers = new int[scanner.nextInt()];

            List<int[]> negativeList = new ArrayList<>();
            List<int[]> positiveList = new ArrayList<>();

            for (int i = 1; i < size; i++) {
                int value = scanner.nextInt();
                if (value < 0) {
                    negativeList.add(new int[]{i, -value});
                } else {
                    positiveList.add(new int[]{i, value});
                }
            }

            int[][][] graph = new int[size][size][];
            for (int i = 0; i < answers.length; i++) {
                int u = scanner.nextInt() - 1;
                int v = scanner.nextInt() - 1;
                graph[u][v] = graph[v][u] = new int[]{i, 2};
            }

            Collections.sort(negativeList, Comparator.comparingInt(a -> a[1]));
            Collections.sort(positiveList, Comparator.comparingInt(a -> a[1]));

            List<int[]> combinedList = new ArrayList<>();
            combinedList.add(new int[3]);

            int negIndex = 0, posIndex = 0;
            while (negIndex < negativeList.size() && posIndex < positiveList.size()) {
                if (negativeList.get(negIndex)[1] <= combinedList.size()) {
                    addToList(combinedList, negativeList.get(negIndex), combinedList.size() - 1);
                    negIndex++;
                } else {
                    addToList(combinedList, positiveList.get(posIndex), combinedList.size() - 1);
                    posIndex++;
                }
            }

            while (negIndex < negativeList.size()) {
                addToList(combinedList, negativeList.get(negIndex), combinedList.size() - 1);
                negIndex++;
            }

            while (posIndex < positiveList.size()) {
                addToList(combinedList, positiveList.get(posIndex), combinedList.size() - 1);
                posIndex++;
            }

            int[] check = new int[size];
            for (int[] entry : combinedList) {
                for (int j = 0; j < size; j++) {
                    if (graph[j][entry[0]] != null) {
                        graph[j][entry[0]][1]--;
                        if (graph[j][entry[0]][1] == 0) {
                            answers[graph[j][entry[0]][0]] = 1;
                            if (entry[1] - check[j] > answers[graph[j][entry[0]][0]]) {
                                answers[graph[j][entry[0]][0]] = entry[1] - check[j];
                            }
                            check[entry[0]] = entry[1];
                        }
                    }
                }
            }

            System.out.print("Case #" + testCase + ": ");
            for (int answer : answers) {
                System.out.print(answer + " ");
            }
            System.out.println();
        }
    }

    private static void addToList(List<int[]> list, int[] element, int prevIndex) {
        list.add(new int[3]);
        int[] last = list.get(list.size() - 1);
        last[0] = element[0];
        last[1] = (list.get(prevIndex)[2] == element[1]) ? list.get(prevIndex)[1] : list.get(prevIndex)[1] + 1;
        last[2] = element[1];
    }
}