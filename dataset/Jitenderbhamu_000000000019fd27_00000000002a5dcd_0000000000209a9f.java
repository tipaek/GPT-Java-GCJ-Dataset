import java.util.*;
import java.util.Scanner;
public class Vestigium
     {
       public static void main(String [] args)
       {
         int sumFirst = 0, sumSecond = 0, sumThird = 0, add1 = 0, add2 = 0;
         int secondRow = 0;
         int firstElement = 0;
         int secondElement = 0;
         System.out.println("Enter the number of test cases");
         Scanner input = new Scanner(System.in);
         int testCase = input.nextInt();

         //this is used to calculate the first matrix
         int sofirstmatrix = input.nextInt();
         int firstMatrix[][] = new int[5][5];
         FirstMatrix fm = new FirstMatrix();
         fm.firstArrayEnter(firstMatrix, sofirstmatrix);
         add1 = fm.firstArrayTrace(firstMatrix, sofirstmatrix, sumFirst);
         System.out.println(add1);
         int firstRoow = fm.firstArrayRow(firstMatrix, sofirstmatrix);
         System.out.println(firstRoow - 1);
         int firstColon = fm.firstArrayColumn(firstMatrix);
         System.out.println(firstColon - 1);



         //this is used to calculate the Second Matrix
         int sosecondMatrix = input.nextInt();
         int secondMatrix[][] = new int[5][5];
         SecondMatrix sm = new SecondMatrix();
         sm.secondArrayEnter(secondMatrix, sosecondMatrix);
         add2 = sm.secondArrayTrace(secondMatrix, sosecondMatrix, sumSecond);
         System.out.println(add2);
         int secondRoow = sm.secondArrayRow(secondMatrix, sosecondMatrix);
         System.out.println(secondRoow - 1);
         int secondcolon = sm.secondArrayColumn(secondMatrix);
         System.out.println(secondcolon - 1);



}
}

     class FirstMatrix
     {
       public int firstArrayEnter(int [][] firstMatrix, int sofirstmatrix)
       {
         Scanner input = new Scanner(System.in);
         //enter the first matrix
         for(int i = 0; i < sofirstmatrix; i++)
         {
           for(int j = 0; j < sofirstmatrix; j++)
           {
             firstMatrix[sofirstmatrix][sofirstmatrix] = input.nextInt();
           }
         }
         return sofirstmatrix;
       }

         public int firstArrayTrace(int [][] firstMatrix, int sofirstmatrix, int sumFirst)
         {
         //find the trace of firstMatrix
         for(int i = 0; i < sofirstmatrix; i++)
         {
           for(int j = 0; j < sofirstmatrix; j++)
           {
             if(i == j)
             {
             sumFirst = sumFirst + (firstMatrix[sofirstmatrix][sofirstmatrix]);
             }
           }
         }
        return sofirstmatrix;
       }

       public int firstArrayRow(int [][] firstMatrix, int sofirstmatrix)
       {
         int firstRow = 0,firstElement = 0, secondElement = 0;
         for(int i = 0; i < firstMatrix.length; i++)
         {
           for(int j = 0; j < firstMatrix.length; j++)
           {
             firstElement = firstMatrix[i][j];
             secondElement  = firstMatrix[i++][j++];
             if(firstElement == secondElement)
             {
               firstRow++;
             }
             break;
           }
           break;
         }
         return firstRow;
       }

       public int firstArrayColumn(int [][] firstMatrix)
       {
         int firstColumn = 0,firstElement = 0, secondElement = 0;
         for(int j = 0; j < firstMatrix.length; j++)
         {
           for(int i = 0; i < firstMatrix.length; i++)
           {
             firstElement = firstMatrix[i][j];
             secondElement  = firstMatrix[i++][j++];
             if(firstElement == secondElement)
             {
               firstColumn++;
             }
             break;
       }
       break;
     }
     return firstColumn;
   }
 }


 class SecondMatrix
 {
   public int secondArrayEnter(int [][] secondMatrix, int sosecondMatrix)
   {
     Scanner input1 = new Scanner(System.in);
     //enter the first matrix
     for(int i = 0; i < sosecondMatrix; i++)
     {
       for(int j = 0; j < sosecondMatrix; j++)
       {
         secondMatrix[sosecondMatrix][sosecondMatrix] = input1.nextInt();
       }
     }
     return sosecondMatrix;
   }

     public int secondArrayTrace(int [][] secondMatrix, int sosecondMatrix, int sumSecond)
     {
     //find the trace of firstMatrix
     for(int i = 0; i < secondMatrix.length; i++)
     {
       for(int j = 0; j < secondMatrix.length; j++)
       {
         if(i == j)
         {
         sumSecond = sumSecond + (secondMatrix[sosecondMatrix][sosecondMatrix]);
         }
       }
     }
    return sumSecond;
   }

   public int secondArrayRow(int [][] secondMatrix, int sosecondMatrix)
   {
     int secondRow = 0,firstElement = 0, secondElement = 0;
     for(int i = 0; i < secondMatrix.length; i++)
     {
       for(int j = 0; j < secondMatrix.length; j++)
       {
         firstElement = secondMatrix[i][j];
         secondElement  = secondMatrix[i][j++];
         if(firstElement == secondElement)
         {
           secondRow++;
         }
         break;
       }
       break;
     }
     return secondRow;
   }

   public int secondArrayColumn(int [][] secondMatrix)
   {
     int secondColumn = 0,firstElement = 0, secondElement = 0;
     for(int j = 0; j < secondMatrix.length; j++)
     {
       for(int i = 0; i < secondMatrix.length; i++)
       {
         firstElement = secondMatrix[i][j];
         secondElement  = secondMatrix[i++][j];
         if(firstElement == secondElement)
         {
           secondColumn++;
         }
         break;
   }
   break;
 }
 return secondColumn;
}
}
