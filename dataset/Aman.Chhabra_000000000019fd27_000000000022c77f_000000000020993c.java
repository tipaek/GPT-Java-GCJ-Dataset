import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        List<SolutionResult> resultList = new ArrayList<>();
        while(testCases-->0) {
            int length = scanner.nextInt();
            int[][] input = new int[length][length];
            for(int i=0;i<length;i++)
                for(int j=0;j<length;j++)
                    input[i][j]=scanner.nextInt();
            resultList.add(solveProblem(input));
        }
        int count = 0;
        for(SolutionResult result: resultList) {
            System.out.println("Case #"+ ++count +": "+result.k+" "+result.r+" "+result.c);
        }
    }

    private static SolutionResult solveProblem(int[][] input) {
        SolutionResult solutionResult = new SolutionResult();
        for (int i = 0;i <input.length;i++) {
            List<Integer> rowList = new ArrayList();
            for (int j = 0; j < input.length; j++) {
                if(rowList.contains(input[i][j])) {
                     solutionResult.r++;
                    break;
                } else {
                    rowList.add(input[i][j]);
                }
            }
        }

        for (int i = 0;i <input.length;i++) {
            List<Integer> colList = new ArrayList();
            for (int j = 0; j < input.length; j++) {
                if(colList.contains(input[j][i])) {
                    solutionResult.c++;
                    break;
                } else {
                    colList.add(input[j][i]);
                }
            }
        }

        for (int i = 0;i <input.length;i++) {
            solutionResult.k += input[i][i];
        }

        return solutionResult;
    }

    static class SolutionResult{
        int k;
        int r;
        int c;
    }
}
