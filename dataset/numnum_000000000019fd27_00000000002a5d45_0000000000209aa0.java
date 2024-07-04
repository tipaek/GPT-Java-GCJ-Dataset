import java.util.Scanner;
import java.util.ArrayList;

public class Solution
{
    public static boolean canUse(int[][] matrix, int num, int x, int y)
    {
        for (int i = 0; i < matrix.length; i++)
        {
            if (matrix[i][y] == num && x != i)
            {
                return false;
            }
        }
        for (int i = 0; i < matrix.length; i++)
        {
            if (matrix[x][i] == num && y != i)
            {
                return false;
            }
        }
        return true;
    }
    
    public static void solve(int test, int size, int trace)
    {
        if (trace >= size)
        {
        int[][] matrix = new int[size][size];
        ArrayList<Integer>[] canRow = new ArrayList[size];
        for (int i = 0; i < canRow.length; i++)
        {
            canRow[i] = new ArrayList<Integer>();
        }
        
        int[] dia = new int[size];
        int max = size;
        int remainder = (trace % dia.length);
        
        for (int i = 1; i <= dia.length; i++)
        {
            if (i <= remainder)
            {
                dia[i-1] = trace/dia.length;
            }
            else
            {
                dia[i-1] = trace/dia.length + 1;
            }
        }
        
        boolean good = false;
        while (!good)
        {
            good = true;
            for (int i = 0; i < dia.length-2; i++)
            {
                if (dia[i] == dia[i+1] && dia[i+1] != dia[i+2])
                {
                    int temp = dia[i+1];
                    dia[i+1] = dia[i+2];
                    dia[i+2] = temp;
                    good = false;
                }
            }
        }
        
        for (int i = 0; i < size; i++)
        {
            matrix[i][i] = dia[i];
        }
        
        for (int r = 0; r < size; r++)
        {
            for (int i = 0; i < size; i++)
            {
                canRow[i] = new ArrayList<Integer>();
            }
            for (int c = 0; c < size; c++)
            {
                if (matrix[r][c] == 0)
                {
                    for (int i = 1; i <= size; i++)
                    {
                        if (canUse(matrix, i, r, c))
                        {
                            canRow[c].add(i);
                        }
                    }
                }
            }
            int minCol = -1;
            int minColSize = -1;
            int selectedNum = -1;
            boolean rowSolved = false;
            while (!rowSolved)
            {
                minCol = -1;
                minColSize = 99999;
                selectedNum = -1;
                
                for (int c = 0; c < matrix.length; c++)
                {
                    // FIND THE MOST RESTRICTED COLUMN
                    if (matrix[r][c] == 0 && canRow[c].size() > 0)
                    {
                        if (canRow[c].size() > 0 && canRow[c].size() < minColSize)
                        {
                            minColSize = canRow[c].size();
                            minCol = c;
                        }
                    }
                }
                
                if (minCol > -1)
                {
                    // TAKE A NUMBER FROM THAT COLUMN
                    selectedNum = canRow[minCol].get(0);
                    
                    // REMOVE ALL INSTANCES OF THAT NUMBER
                    for (int c = 0; c < canRow.length; c++)
                    {
                        int numIndex = -1;
                        for (int i = 0; i < canRow[c].size(); i++)
                        {
                            if (canRow[c].get(i) == selectedNum)
                            {
                                numIndex = i;
                                i = canRow[c].size();
                            }
                        }
                        if (numIndex > -1)
                        {
                            //for (int j = numIndex; j < canRow[c].size()-1; j++)
                            //{
                                //canRow[c].set(j, j+1);
                            //}
                            //canRow[c].remove(canRow[c].size()-1);
                            canRow[c].remove(numIndex);
                        }
                    }
                    
                    // SET THE MATRIX NUMBER
                    matrix[r][minCol] = selectedNum;
                }
                else
                {
                    // CONGRATULATIONS, THE ROW IS SOLVED!
                    rowSolved = true;
                }
            }
        }
        
        boolean foundZero = false;
        
        for (int i = 0; i < size; i++)
        {
            for (int j = 0; j < size; j++)
            {
                if (matrix[i][j] == 0)
                {
                    foundZero = true;
                    j = size;
                    i = size;
                }
            }
        }
        
        System.out.print("Case #" + test + ": ");
        if (!foundZero)
        {
            System.out.println("POSSIBLE");
            for (int i = 0; i < size; i++)
            {
                for (int j = 0; j < size; j++)
                {
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }
        }
        else
        {
            System.out.println("IMPOSSIBLE");
        }
    }
        else
        {
        System.out.print("Case #" + test + ": ");
            System.out.println("IMPOSSIBLE");
        }
        
    }
    
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
            input.nextLine();
        for (int ks = 1; ks <= T; ks++) {
            String newLine = input.nextLine();
            int spaceLoc = newLine.indexOf(" ");
            String firstEntry = newLine.substring(0, spaceLoc);
            String secondEntry = newLine.substring(spaceLoc + 1);
            int firstNum = 0;
            int secondNum = 0;
            int ele = 0;
            for (int j = firstEntry.length()-1; j >= 0; j--)
            {
                firstNum += Character.getNumericValue(firstEntry.charAt(j))*Math.pow(10, ele);
                ele++;
            }
            ele = 0;
            for (int j = secondEntry.length()-1; j >= 0; j--)
            {
                secondNum += Character.getNumericValue(secondEntry.charAt(j))*Math.pow(10, ele);
                ele++;
            }
            ele = 0;
            solve(ks, firstNum, secondNum);
        }
    }
}