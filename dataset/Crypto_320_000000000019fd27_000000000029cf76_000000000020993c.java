import java.util.ArrayList;
import java.util.Scanner;

public class test96 {

    public static void main(String[] args) {
        
        //System.out.println(isLatinSquare(a));
        isLatinSquare(5);

        
    }


    private static void isLatinSquare(int a) {
        Scanner scanner= new Scanner(System.in);
        int testCase=0;
        int size;
        int theArray[][];
        ArrayList<Integer>countRow=new ArrayList<>();
        int rowCount=0;
           int dSum=0;

        System.out.println("Shkruaj sa teste do te besh");
       try {
       testCase=scanner.nextInt();
       size=0;
       } catch (Exception e) {
           e.printStackTrace();
       }

       while (testCase>0) {
           System.out.println("Shkruaj madhesine e matrikses");
           size=scanner.nextInt();
           testCase--;
            rowCount=0;
           dSum=0;
            boolean switcherR=false;

           theArray=new int[size][size];
          //countRow=new ArrayList<>(size);
           for (int i = 0; i < size; i++) {
            System.out.println("Shkruaj varguen e "+(i+1));
            for(int j=0;j<size;j++)
            {
                
                   int z=scanner.nextInt();
                    theArray[i][j]=z;
                   if(i==j)
                   dSum+=theArray[i][j];
                       
                   if(switcherR!=true)
                    {
                         for (int k = 0; k < j; k++) 
                        {   if(theArray[i][k]==theArray[i][j])
                            {
                            rowCount++;switcherR=true;continue;
                            }
                        }   
                    }      
                
            }
            switcherR=false;
               
           }
           countRow.add(dSum);countRow.add(rowCount);countRow.add(countCols(theArray));

           
       }
       for(int i=0;i<(countRow.size());i=i+3)
       {
           System.out.println("Case #"+(i+1)+" :"+ countRow.get(i)+" "+countRow.get(i+1)+" "+countRow.get(i+2));
       }
       scanner.close();
      
       
    }
    public static int countCols(int arr[][])
    {
        boolean switcherC=false;
        int countCol=0;
        
        for(int i=0;i<arr.length;i++)
        {
            for(int j=0;j<arr.length;j++)
            {
                if(switcherC!=true)
                {
                     for (int k = 0; k < j; k++) 
                    {   if(arr[k][i]==arr[j][i])
                        {
                        countCol++;switcherC=true;continue;
                        }
                    }   
                }     
            }
            switcherC=false;
        }

        return countCol;
    }

}