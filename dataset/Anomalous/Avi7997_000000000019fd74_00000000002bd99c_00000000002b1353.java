import java.io.*;
import java.util.*;

class Node {
    int row, col, value;

    Node(int row, int col, int value) {
        this.row = row;
        this.col = col;
        this.value = value;
    }
}

public class Solution {
    public static List<List<Integer>> pascal = new ArrayList<>();

    public static void storePascal(int n) {
        List<Integer> currentRow = new ArrayList<>();
        currentRow.add(1);
        pascal.add(currentRow);

        for (int i = 1; i <= n; i++) {
            List<Integer> prevRow = currentRow;
            currentRow = new ArrayList<>();
            currentRow.add(1);

            for (int j = 1; j < prevRow.size(); j++) {
                currentRow.add(prevRow.get(j) + prevRow.get(j - 1));
            }

            currentRow.add(1);
            pascal.add(currentRow);
        }
    }

    public static void printPascal() {
        for (List<Integer> row : pascal) {
            for (int j = 0; j < row.size() && j < 2; j++) {
                System.out.print(row.get(j) + " ");
            }
            System.out.println();
        }
    }

    public static List<Node> findNodesForSum(int sum) {
        List<Node> nodes = new ArrayList<>();
        List<Integer> x = new ArrayList<>();
        int temp = sum - 496, currentRow = 0, count = 0, i = 0;

        if (temp > 0) {
            if (temp - 496 > 0) {
                int c = temp - 496;
                x.add(c);
                temp -= c;
            }
            x.add(temp);
        }

        temp = 0;
        currentRow = 0;

        while (temp < sum && currentRow < pascal.size() && count < 500) {
            List<Integer> currentList = pascal.get(currentRow);

            if (currentRow > 0 && i < x.size() && currentList.get(currentList.size() - 2).equals(x.get(i))) {
                nodes.add(new Node(currentRow + 1, currentList.size() - 1, currentList.get(currentList.size() - 2)));
                temp += currentList.get(currentList.size() - 2);
                i++;
            } else {
                nodes.add(new Node(currentRow + 1, currentList.size(), currentList.get(currentList.size() - 1)));
                temp += currentList.get(currentList.size() - 1);
                currentRow++;
            }
            count++;
        }

        return nodes;
    }

    public static void main(String[] args) throws IOException {
        storePascal(500);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine().split(" ")[0]);

        for (int p = 0; p < t; p++) {
            int sum = Integer.parseInt(reader.readLine().split(" ")[0]);
            List<Node> nodes = findNodesForSum(sum);

            System.out.println("Case #" + (p + 1) + ":");
            for (Node node : nodes) {
                System.out.println(node.row + " " + node.col);
            }
        }
    }
}