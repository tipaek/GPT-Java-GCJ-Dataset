
import java.lang.*;
import java.util.*;
public class Solution
{
    public static void main(String args[])
    {
        int test_case;
        Scanner scan=new Scanner(System.in);
        test_case=scan.nextInt();
        int N,t=0;
        while(test_case!=0){
            N=scan.nextInt();
            t++;
            calRepeatRowCol(N,t);
            test_case--;
        } 
    }
    
    public static void calRepeatRowCol(int matrixSize,int test_case)
    {
        Scanner input=new Scanner(System.in);
        int R=0,C=0,sum=0;
        int[][] squareMatrix=new int[matrixSize][matrixSize];
        for(int row=0;row<matrixSize;row++){
            for(int col=0;col<matrixSize;col++){
                squareMatrix[row][col]=input.nextInt();
            }
        }
        for(int i=0;i<matrixSize;i++){
            int array[]=new int[matrixSize +1];
            for(int j=0;j<matrixSize;j++){
                if(array[squareMatrix[i][j]]==1){
                    R++;
                    break;
                }
                else{
                    array[squareMatrix[i][j]]=1;
                }
            }
        }
        for(int i=0;i<matrixSize;i++){
            int array[]=new int[matrixSize +1];
            for(int j=0;j<matrixSize;j++){
                if(array[squareMatrix[j][i]]==1){
                    C++;
                    break;
                }
                else{
                    array[squareMatrix[j][i]]=1;
                }
            }
        }
       
       
       for(int i=0;i<matrixSize;i++){
           sum+=squareMatrix[i][i];
       }
            System.out.println("Case #"+test_case+":"+sum+R+C);
        }
  }
