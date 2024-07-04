import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            String line;
            String[] parts;

            line = reader.readLine();
            int numberOfSets = Integer.parseInt(line);

            for (int i = 0; i < numberOfSets; i++) {
                line = reader.readLine();
                parts = line.split("\\s+");

                int dimension = Integer.parseInt(parts[0]);
                int[][] matrix = new int[dimension][dimension];


                for (int iY = 0; iY < dimension; iY++) {
                    line = reader.readLine();
                    parts = line.split("\\s+");

                    for (int iX = 0; iX < dimension; iX++) {
                        matrix[iY][iX] = Integer.parseInt(parts[iX]);
                    }
                }

                int sum = IntStream.range(0, dimension).map(iX -> matrix[iX][iX]).sum();

                int wrongLines = (int) Arrays.stream(matrix)
                        .filter(l -> Arrays.stream(l).distinct().count() < dimension)
                        .count();
                int wrongColumns = (int) IntStream.range(0, dimension).mapToObj(iX ->
                        Arrays.stream(matrix).map(l -> l[iX]).collect(Collectors.toList()))
                        .filter(l -> l.stream().distinct().count() < dimension)
                        .count();

                System.out.println("Case #" + (i + 1) + ": " + sum + " " + wrongLines + " " + wrongColumns);
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
