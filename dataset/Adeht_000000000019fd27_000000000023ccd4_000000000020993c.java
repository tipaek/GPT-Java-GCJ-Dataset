import java.util.*;

class Solution{
    public static void main(String args[]){
        Scanner sc= new Scanner(System.in);
        int trace=0,rowCount=0,columnCount=0,index=0,column=0,row=0;
        boolean flag=false;
        int testCase=sc.nextInt();
        for(int i=0;i<testCase;i++){
            trace=0;
            rowCount=0;
            columnCount=0;
            int sizeOfMatrix=sc.nextInt();
            int[][] matrix=new int[sizeOfMatrix][sizeOfMatrix];
            for(row=0;row<sizeOfMatrix;row++){
                for(column=0;column<sizeOfMatrix;column++){
                    matrix[row][column]=sc.nextInt();
                }
            }
            for(index=0;index<sizeOfMatrix;index++){
                trace+=matrix[index][index];
            }
            for(row=0;row<sizeOfMatrix;row++){
                for(column=0;column<sizeOfMatrix-1;column++){
                    for(index=column+1;index<sizeOfMatrix;index++){
                        if(matrix[row][column]==matrix[row][index]){
                            rowCount++;
                            flag=true;
                            break;
                        }
                    }
                    if(flag){
                        flag=false;
                        break;
                    }
                }
            }
            for(column=0;column<sizeOfMatrix;column++){
                for(row=0;row<sizeOfMatrix-1;row++){
                    for(index=row+1;index<sizeOfMatrix;index++){
                        if(matrix[row][column]==matrix[index][column]){
                            columnCount++;
                            flag=true;
                            break;
                        }
                    }
                    if(flag){
                        flag=false;
                        break;
                    }
                }
            }
            System.out.println("Case #"+(i+1)+": "+trace+" "+rowCount+" "+columnCount);
        }
    }
}