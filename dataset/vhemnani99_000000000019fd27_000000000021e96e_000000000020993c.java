
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {

    public static void main(String[] args) {

        InputStream inputStream = new Solution().getClass().getClassLoader().getResourceAsStream("Vestigium_input_file.txt");
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int t = Integer.parseInt(in.nextLine());
        for (int i = 1; i <= t ; i++) {
            int n = Integer.parseInt(in.nextLine());
            List<List<Integer>> matrix = new ArrayList<>(n);

            int repRow = 0;
            int repCol = 0;
            for (int j = 0; j < n; j++) {
                List<Integer> row = Arrays.stream(in.nextLine().split(" ")).map(num -> Integer.parseInt(num)).collect(Collectors.toList());
                if (n != row.stream().distinct().count()){
                    repRow++;
                }
                matrix.add(row);
            }
            int trace =  IntStream.range(0, n).map(k->matrix.get(k).get(k)).sum();

            for (int z = 0; z < n; z++) {
                List<Integer> col = new ArrayList<>();
                for (List<Integer> row: matrix) {
                    col.add(row.get(z));
                }
                if (n != col.stream().distinct().count()){
                    repCol++;
                }
            }

            System.out.println("Case #"+i+": "+trace+" "+repRow+" "+repCol);

        }

    }
}