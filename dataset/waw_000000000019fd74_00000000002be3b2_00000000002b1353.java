import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    static final Map<String, Integer> cache = new HashMap<>();

    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));


        int cases = scanner.nextInt();

        scanner.nextLine();
        for(int i=0;i<cases;i++){
            int n = scanner.nextInt();

            List<String> result = solve(n);

            System.out.println(String.format("Case #%d: %s", i + 1, prettyPrint(result)));
        }

    }

    private static String prettyPrint(List<String> result) {
        String res = "";
        for(int i=result.size() - 1 ; i>=0;i--) {
            res += "\n" + result.get(i);
        }
        return res;
    }

    private static List<String> solve(int n) {


        return walk(0, n, 0, 0, new HashSet<>());

    }

    private static List<String> walk(int count, int remaining, int i, int j, Set<String> visited) {
        int currentValue = getValueAt(i,j);
        visited.add(i + "#" + j);

        if(count == 500) {
            return null;
        }

        if(remaining - currentValue == 0) {
            List<String> result = new ArrayList<>();
            result.add(String.format("%d %d", i + 1, j+1));
            return result;
        }

        if(remaining - currentValue < 0) {
            return null;
        }

        int[][] neighbours = new int[][] {{-1, -1}, {-1, 0}, {0, -1}, {0, 1}, {1, 0}, {1, 1}};

        for(int[] neighbour : neighbours) {
            int newI = i + neighbour[0];
            int newJ = j + neighbour[1];

            if(newI >= 0 && newJ >=0 && newJ <= newI && !visited.contains(newI + "#" + newJ)) {
                Set<String> newVisited = new HashSet<>(visited);
                List<String> result = walk(count+1, remaining - currentValue, newI, newJ, newVisited);
                if(result != null ) {
                    result.add(String.format("%d %d", i + 1, j+1));
                    return result;
                }
            }

        }

        return null;
    }

    private static int getValueAt(int i, int j) {
        if( j == 0 ||  i == j) {
            return 1;
        }
        Integer fromCache = cache.get(i + "#" + j);

        int sum = getValueAt(i - 1, j - 1) + getValueAt(i - 1, j);

        cache.put(i + "#" + j, sum);

        return sum;
    }
}
