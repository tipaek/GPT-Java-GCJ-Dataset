import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        
        try {
            int numberOfTestCases = Integer.parseInt(input.readLine());
            for(int index = 0;index<numberOfTestCases;++index){
                
                int N = Integer.parseInt(input.readLine());
                
                int[][] matrix = new int[N][N];
                
                for(int i = 0;i<N;++i) {
                    matrix[i] = parseValues(input.readLine(), N);
                }
                calculate(matrix,N,index+1);
            }
        } catch (NumberFormatException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    
    private static int[] parseValues(String line, int size) {
        int[] ans = new int[size];
        int index = 0;
        for(String s:line.split(" ")) {
            ans[index++] = Integer.parseInt(s);
        }
        return ans;
    }
    
    private static void calculate(int[][] matrix, int size, int testCase) {
        
        int trace = 0;
        int rowDup = 0;
        int colDup = 0;
        
        for(int row=0;row<size;++row) {
            for(int col=0;col<size;++col) {
                if(row == col) {
                    trace += matrix[row][col];
                }
            }
        }
        
        for(int row=0;row<size;++row) {
            Set<Integer> set = new HashSet<>();
            for(int col=0;col<size;++col) {
                if(set.contains(matrix[row][col])) {
                    rowDup++;
                    break;
                }else {
                    set.add(matrix[row][col]);
                }
            }
        }
        
        for(int col=0;col<size;++col) {
            Set<Integer> set = new HashSet<>();
            for(int row=0;row<size;++row) {
                if(set.contains(matrix[row][col])) {
                    colDup++;
                    break;
                }else {
                    set.add(matrix[row][col]);
                }
            }
        }
        System.out.println("Case #"+testCase+": "+trace+" "+rowDup+" "+colDup);
        
    }

}
