
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        int numCases = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < numCases; i++) 
        {
            int size = Integer.parseInt(scan.nextLine());
            int[][] testCase = new int[size][size];
            int trace = 0, repeatedRows = 0, repeatedCols=0;
            int uniqueSum = size * (size + 1) / 2;
            int uniqueProduct = 1;
            for(int j = 1; j <= size; j++)
            {
                uniqueProduct *= j;
            }
            for(int j = 0; j < size; j++)
            {
                String line = scan.nextLine();
                String[] stringRow = line.split(" ");
                int[] row = new int[size];
                int rowSum = 0, rowProduct = 1;
                for(int k = 0; k < size; k++)
                {
                    row[k] = Integer.parseInt(stringRow[k]);
                    rowSum += row[k];
                    rowProduct *= row[k];
                }
                testCase[j] = row;
                trace += testCase[j][j];
                if(rowSum != uniqueSum || rowProduct != uniqueProduct)
                {
                    repeatedRows += 1;
                }
            }
            for(int j = 0; j < size; j++)
            {
                int colSum = 0, colProduct = 1;
                for(int k = 0; k < size; k++)
                {
                    colSum += testCase[k][j];
                    colProduct *= testCase[k][j];
                }
                if(colSum!=uniqueSum || colProduct != uniqueProduct)
                {
                    repeatedCols +=1;
                }
            }
            System.out.println("Case #" + (i+1) +": " + trace + " " + repeatedRows + " " + repeatedCols);
        }
    }
    
}
