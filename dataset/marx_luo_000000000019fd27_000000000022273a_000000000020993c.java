import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Program1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int caseNum = sc.nextInt();
        List<int[][]> squares = new ArrayList(caseNum);
        // resolve case info data
        for (int i = 0; i < caseNum; i++) {
            int squareLength = sc.nextInt();
            int[][] square = new int[squareLength][squareLength];
            squares.add(square);
            // resolve square data
            for (int squareX = 0; squareX < squareLength; squareX++) {
                for (int squareY = 0; squareY < squareLength; squareY++) {
                    try {
                        square[squareX][squareY] = sc.nextInt();
                    }catch (Exception ex) {
                        System.out.printf("should use nextline to resolve");
                    }
                }
            }
        }

        squares.stream().forEach(square -> {
            for (int x=0; x< square.length;x++) {
                for (int y=0;y < square[x].length;y++) {
                    System.out.print(square[x][y] + " ");
                }
                System.out.printfln("");
            }
        });
    }
}