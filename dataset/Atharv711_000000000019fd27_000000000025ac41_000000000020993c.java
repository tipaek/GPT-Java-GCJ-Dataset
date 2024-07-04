import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Matrix
{

    public static void main(String args[])
    {
        int matrix[][] = initMatrix();
        // printData(matrix); //Uncomment to print array
        if(latinSquare(matrix))
        {
            System.out.println("This is a Latin Square");
        }
        else
        {
            System.out.println("This is not a Latin Square");          
        } 
    }

    public static boolean latinSquare(int[][] array) 
    {
        for (int i = 0; i<array.length ;i++) 
        {
            // check for duplicates in each row
            if(duplicates(array[i]))
            {
                return false;
            }

            // create a column array
            int[] column = new int[array[i].length]; 
            for(int j = 0; j<array.length; j++)
            {
                column[j] = array[j][i]; // could throw an exception if the input file isn't square 3x3, 2x2, 4x4, etc
            }

            // check for duplicates in each column
            if(duplicates(column))
            {
                return false;
            }
        }
        return true;
    }

    public static boolean duplicates(int[] array)
    {
        for (int i = 0; i<array.length; i++) 
        {
            for(int j = 0; j<array.length; j++)
            {
                if (i != j && array[i] == array[j])
                {
                    return true;
                }
            }    
        }
        return false;
    }

    ///PLACE YOUR METHODS HERE
    public static int[][] initMatrix()
    {
        int matrix[][];
        Scanner filein = null;
        try 
        {
            filein = new Scanner(new File("matrix.txt"));
            int numRows = Integer.parseInt(filein.nextLine());
            matrix = new int[numRows][];
            parseData(matrix, filein);
            filein.close();
            return matrix;
        } 
        catch (FileNotFoundException e) 
        {
            System.out.println(e.getMessage());
            if(filein != null)
            {
                filein.close();
            }
            return null;
        }
    }

    public static void parseData(int matrix[][], Scanner in)
    {
        for(int r = 0; r < matrix.length; r++)
        {
            String splitLine[] = in.nextLine().split(" ");
            matrix[r] = new int[splitLine.length];
            for(int c = 0; c < matrix[r].length; c++)
            {
                matrix[r][c] = Integer.parseInt(splitLine[c]);
            }
        }
    }

    public static void printData(int matrix[][])
    {
        for(int r = 0; r < matrix.length; r++)
        {
            for(int c = 0; c < matrix[r].length; c++)
            {
                System.out.print(matrix[r][c] + " ");
            }
            System.out.println();
        }
    }
}