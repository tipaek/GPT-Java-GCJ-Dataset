import java.util.Scanner;

public class Solution {
    public static void main (String args[]) {
        Scanner input = new Scanner (System.in);
        
        int numOfTests = input.nextInt ();
        for (int currentTest = 1; currentTest <= numOfTests; currentTest++) {
            Solver solver = new Solver(input);
            solver.solve();
            
            System.out.println("Case #" + currentTest + ": " + solver.getOutput());
            
        }
    }
}

class Solver  {
    int sum;
    int currentSum = 0;
    int[][] list = new int[2][0];
    public Solver(Scanner input) {
        sum = input.nextInt();
    }
    public void solve() {
        int currentRow = 1;
        int currentColumn = 1;
        
        addToList (currentRow, currentColumn);
        currentSum += getValue (currentRow, currentColumn);
        if (sum == 1) {
            return;
        }
        
        currentRow++;
        currentColumn++;
        
        addToList (currentRow, currentColumn);
        currentSum += getValue (currentRow, currentColumn);
        
        
        
        while (currentSum < sum) {
            if (currentSum + getValue (currentRow + 1, currentColumn) > sum) {
                currentColumn--;
                addToList (currentRow, currentColumn);
                currentSum += getValue (currentRow, currentColumn);
            } else {
                currentRow++;
                addToList (currentRow, currentColumn);
                currentSum += getValue (currentRow, currentColumn);
            }            
        }
    }
    public String getOutput () {
        String output = "";
        for (int i = 0; i < list[0].length; i++) {
            output += "\n" + list[0][i] + " " + list[1][i];
        }
        return output;
    }
    
    int getValue (int row, int column) {
        if (column == 1) {
            return 1;
        } else if (column == 2) {
            return (row - 1);
        } else {
            //we didnt code this!!!!
            return -1;
        }
    }
    
    void addToList (int a, int b) {
        int[][] newList = new int[2][list[0].length + 1];
        for (int i = 0; i < list[0].length; i++) {
            newList[0][i] = list[0][i];
            newList[1][i] = list[1][i];
        }
        newList[0][list[0].length] = a;
        newList[1][list[0].length] = b;
        list = newList;
    }
}