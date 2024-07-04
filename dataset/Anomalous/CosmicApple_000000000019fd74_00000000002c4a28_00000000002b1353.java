import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        int numOfTests = input.nextInt();
        for (int currentTest = 1; currentTest <= numOfTests; currentTest++) {
            Solver solver = new Solver(input);
            solver.solve();
            
            System.out.println("Case #" + currentTest + ": " + solver.getOutput());
        }
    }
}

class Solver {
    private int sum;
    private int currentSum = 0;
    private List<int[]> list = new ArrayList<>();
    
    public Solver(Scanner input) {
        sum = input.nextInt();
    }
    
    public void solve() {
        int currentRow = 1;
        int currentColumn = 1;
        
        addToList(currentRow, currentColumn);
        currentSum += getValue(currentRow, currentColumn);
        if (sum == 1) {
            return;
        }
        
        currentRow++;
        currentColumn++;
        
        addToList(currentRow, currentColumn);
        currentSum += getValue(currentRow, currentColumn);
        
        while (currentSum < sum) {
            if (currentSum + getValue(currentRow + 1, currentColumn) > sum) {
                currentColumn--;
                addToList(currentRow, currentColumn);
                currentSum += getValue(currentRow, currentColumn);
            } else {
                currentRow++;
                addToList(currentRow, currentColumn);
                currentSum += getValue(currentRow, currentColumn);
            }            
        }
    }
    
    public String getOutput() {
        StringBuilder output = new StringBuilder();
        for (int[] coordinates : list) {
            output.append("\n").append(coordinates[0]).append(" ").append(coordinates[1]);
        }
        return output.toString();
    }
    
    private int getValue(int row, int column) {
        if (column == 1) {
            return 1;
        } else if (column == 2) {
            return row - 1;
        } else {
            // Not implemented
            return -1;
        }
    }
    
    private void addToList(int a, int b) {
        list.add(new int[]{a, b});
    }
}