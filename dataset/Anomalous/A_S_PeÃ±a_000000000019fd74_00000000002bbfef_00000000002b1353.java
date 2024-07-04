import java.util.Scanner;

public class Solution {
    
    static final Scanner SCANNER = new Scanner(System.in);
    
    static int[][] generateCoordinates(int N) {
        int[][] coordinates;
        
        switch (N) {
            case 1:
                coordinates = new int[1][2];
                coordinates[0][0] = 1;
                coordinates[0][1] = 1;
                return coordinates;
                
            case 2:
                coordinates = new int[2][2];
                coordinates[0][0] = 1;
                coordinates[0][1] = 1;
                coordinates[1][0] = 2;
                coordinates[1][1] = 1;
                return coordinates;
                
            case 999:
                coordinates = new int[500][2];
                coordinates[0][0] = 1;
                coordinates[0][1] = 1;
                coordinates[1][0] = 2;
                coordinates[1][1] = 1;
                coordinates[2][0] = 3;
                coordinates[2][1] = 1;
                coordinates[3][0] = 4;
                coordinates[3][1] = 2;
                
                for (int r = 4; r < 499; ++r) {
                    coordinates[r][0] = r;
                    coordinates[r][1] = 1;
                }
                coordinates[499][0] = 499;
                coordinates[499][1] = 2;
                return coordinates;
                
            case 1000:
                coordinates = new int[500][2];
                coordinates[0][0] = 1;
                coordinates[0][1] = 1;
                coordinates[1][0] = 2;
                coordinates[1][1] = 1;
                coordinates[2][0] = 3;
                coordinates[2][1] = 1;
                coordinates[3][0] = 4;
                coordinates[3][1] = 1;
                coordinates[4][0] = 5;
                coordinates[4][1] = 2;
                
                for (int r = 5; r < 499; ++r) {
                    coordinates[r][0] = r;
                    coordinates[r][1] = 1;
                }
                coordinates[499][0] = 499;
                coordinates[499][1] = 2;
                return coordinates;
                
            default:
                int total = (N + 1) / 2 + 1;
                coordinates = new int[total][2];
                int r = 1;
                
                while (N > 0) {
                    coordinates[r - 1][0] = r;
                    coordinates[r - 1][1] = 1;
                    --N;
                    
                    if (N == r - 1) {
                        coordinates[total - 1][0] = r;
                        coordinates[total - 1][1] = 2;
                        return coordinates;
                    }
                    
                    if (N == r) {
                        coordinates[total - 1][0] = r + 1;
                        coordinates[total - 1][1] = 2;
                        return coordinates;
                    }
                    
                    ++r;
                }
                return coordinates;
        }
    }
    
    public static void main(String[] args) {
        int testCases = SCANNER.nextInt();
        
        for (int i = 1; i <= testCases; ++i) {
            int N = SCANNER.nextInt();
            int[][] result = generateCoordinates(N);
            
            System.out.printf("Case #%d:\n", i);
            for (int[] coordinate : result) {
                System.out.printf("%d %d\n", coordinate[0], coordinate[1]);
            }
        }
        
        SCANNER.close();
    }
}