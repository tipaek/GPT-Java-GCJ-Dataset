import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        String result = solveProblem(scanner);
        System.out.println(result);
    }

    public static String solveProblem(Scanner scanner) {
        StringBuilder result = new StringBuilder();
        int t = scanner.nextInt();
        for (int i = 1; i <= t; ++i) {
            int R = scanner.nextInt();
            int S = scanner.nextInt();
            result.append("Case #").append(i).append(": ").append(solveCase(R, S)).append("\n");
        }
        return result.toString().trim();
    }

    public static String solveCase(int R, int S) {
        StringBuilder result = new StringBuilder();
        int count = 0;
        List<Integer> list = new ArrayList<>();
        
        for (int i = 1; i <= S; i++) {
            for (int j = 1; j <= R; j++) {
                list.add(j);
            }
        }
        System.err.println(list);
        
        int placeToCut = getPlaceToCut(list, R, S);
        while (placeToCut != -1) {
            count++;
            List<Integer> subList = list.subList(0, placeToCut);
            int toFind = (placeToCut + S - 1) / S;
            int last = subList.lastIndexOf(toFind);
            int A = last + 1;
            int B = placeToCut - last - 1;
            result.append(A).append(" ").append(B).append("\n");
            list = sortList(list, A, B);
            placeToCut = getPlaceToCut(list, R, S);
        }
        
        return count + "\n" + result.toString();
    }

    public static int getPlaceToCut(List<Integer> list, int R, int S) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(R * S - 1 - i) != (R - (i / S))) {
                return list.size() - i;
            }
        }
        return -1;
    }

    public static List<Integer> sortList(List<Integer> list, int A, int B) {
        List<Integer> sortedList = new ArrayList<>();
        sortedList.addAll(list.subList(A, A + B));
        sortedList.addAll(list.subList(0, A));
        sortedList.addAll(list.subList(A + B, list.size()));
        return sortedList;
    }
}