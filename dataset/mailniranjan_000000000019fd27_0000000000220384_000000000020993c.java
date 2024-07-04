import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        Scanner scanner = new Scanner(System.in);
        int totalTestCases = scanner.nextInt();
        InputReader inputReader = new InputReader(totalTestCases, scanner);
        OutputWriter outputWriter = new OutputWriter();
        
        while(inputReader.hasNextMatrix())
        {
            int[][] matrix = inputReader.getNextMatrix();
            Result output = new SolutionComputer(matrix).compute();
            outputWriter.write(output);
        }
        
        outputWriter.complete();
    }
    
    private static class SolutionComputer
    {
        private int[][] matrix;
        
        SolutionComputer(int[][] matrix)
        {
            this.matrix = matrix;
        }
        
        Result compute()
        {
            int trace = 0;
            
            for(int row = 0, col = 0; row < matrix.length; row++, col++)
            {
                trace = trace + matrix[row][col];
            }
            
            int totalRowsThatContainRepeatedValues = 0;
    
            int[] numbersFrom1ToN = new int[matrix.length + 1];
            
            for(int row = 0; row < matrix.length; row++)
            {
                for(int col = 0; col < matrix.length; col++)
                {
//                    System.out.println("Processing:"  + row + ":" + col);
                    if(numbersFrom1ToN[matrix[row][col]] > 0)
                    {
                        totalRowsThatContainRepeatedValues++;
                        break;
                    }
                    else
                    {
                        numbersFrom1ToN[matrix[row][col]]++;
                    }
                }
                
                //reset. to avoid create new array for each row
                for(int i = 0; i < numbersFrom1ToN.length; i++)
                {
                    numbersFrom1ToN[i] = 0;
                }
            }
            
            int totalColsThatContainRepeatedValues = 0;
            
            for(int col = 0; col < matrix.length; col++)
            {
                for(int row = 0; row < matrix.length; row++)
                {
//                    System.out.println("Processing:"  + row + ":" + col);
                    if(numbersFrom1ToN[matrix[row][col]] > 0)
                    {
                        totalColsThatContainRepeatedValues++;
                        break;
                    }
                    else
                    {
                        numbersFrom1ToN[matrix[row][col]]++;
                    }
                }
    
                //reset. to avoid create new array for each row
                for(int i = 0; i < numbersFrom1ToN.length; i++)
                {
                    numbersFrom1ToN[i] = 0;
                }
            }
            
            
            return new Result(trace, totalRowsThatContainRepeatedValues , totalColsThatContainRepeatedValues);
        }
    }
    
    private static class Result
    {
        int trace;
        int totalRowsThatContainRepeatedValues;
        int totalColsThatContainRepeatedValues;
        
        Result(int trace, int totalRowsThatContainRepeatedValues, int totalColsThatContainRepeatedValues)
        {
            this.trace = trace;
            this.totalRowsThatContainRepeatedValues = totalRowsThatContainRepeatedValues;
            this.totalColsThatContainRepeatedValues = totalColsThatContainRepeatedValues;
        }
    }
    
    private static class InputReader
    {
        private int totalTestCases;
        private int curTestCase = 1;
        private Scanner scanner;
        
        InputReader(int totalTestCases, Scanner scanner)
        {
            this.totalTestCases = totalTestCases;
            this.scanner = scanner;
        }
        
        boolean hasNextMatrix()
        {
            return curTestCase <= totalTestCases;
        }
        
        int[][] getNextMatrix()
        {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            for(int i = 0; i < matrixSize; i++)
            {
                for(int j = 0; j < matrixSize; j++)
                {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            curTestCase++;
            return matrix;
        }
    }
    
    private static class OutputWriter
    {
        private int curCase = 1;
        private BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        
        public void write(Result result) throws IOException
        {
            bufferedWriter.write(String.format("Case #%d: %d %d %d", curCase, result.trace,
                    result.totalRowsThatContainRepeatedValues,
                    result.totalColsThatContainRepeatedValues));
            bufferedWriter.newLine();
            curCase++;
        }
        
        public void complete() throws IOException
        {
            bufferedWriter.flush();
        }
    }
}