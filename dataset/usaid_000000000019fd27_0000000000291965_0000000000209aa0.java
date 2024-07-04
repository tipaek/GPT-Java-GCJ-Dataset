
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int [][] matrix;
        LinkedList<Integer> upperData = new LinkedList<>();
        LinkedList<Integer> trace = new LinkedList<>();
        int testCase = sc.nextInt();
        int k,n;
        for (int i = 0; i < testCase; i++) {
             n = sc.nextInt();
            matrix = new int[n][n];
             k = sc.nextInt();
            for (int j = 1; j <= n; j++) {
                upperData.add(j);
            }
            //fill diagonal
            for (int j = 0; j < n; j++) {
                matrix[j][j]=upperData.getFirst();
            }


            //fill upper triangle
            int index =1;
            for (int j = 0; j < n; j++) {
                index = 1;
                for (int l = j+1; l < n; l++) {
                    matrix[j][l] = upperData.get(index++);
                }
            }
            //fill lower triangle

            int tempIndex=0;
            index=0;
            for (int j = n-1; j >=0; j--) {
                index++;
                tempIndex=index;
                for (int l = 0; l < j; l++) {
                    matrix[j][l]=upperData.get(tempIndex++);
                }

            }

            //calculate Trace
            int place = n;
            if(k> n*n)
            {
                System.out.println("Case #"+(i+1)+": IMPOSSIBLE");
            }
            if(k%2!=0){
                k=k-1;
                trace.add(1);
                place--;
            }
            int flag=0;
            for (int j = 0; j < n; j++) {
                if((k / upperData.get(j)) == place){


                    for (int l = 0; l < place; l++) {
                        trace.add(upperData.get(j));
                    }
                    flag=1;
                    break;
                }
            }

            int element,elementIndex=0;
            if(flag==1){
                for (int j = 0; j < n; j++) {
                    element = trace.get(j);
                    if(matrix[j][j]==element){
                        continue;
                    }
                    for (int l = 0; l < n; l++) {
                        if(element==matrix[l][j]){
                            elementIndex=l;
                        }
                    }
                    swapRow(matrix,elementIndex,j,n);
                }
            }
            int sum=0;
            for (int j = 0; j < n; j++) {
                sum+=matrix[j][j];
            }
            if(sum==k){
                System.out.println("Case #"+(i+1)+": POSSIBLE");
                for (int j = 0; j < n; j++) {
                    for (int l = 0; l < n; l++) {
                        System.out.print(matrix[j][l]+" ");
                    }
                    System.out.println();
                }
            }
            else
                System.out.println("Case #"+(i+1)+": IMPOSSIBLE");

        }
    }
    static void swapRow(int [][] matrix, int col, int from, int n ){
        int temp;
        for (int i = 0; i < n; i++) {
            temp = matrix[col][i];
            matrix[col][i] = matrix[from][i];
            matrix[from][i] = temp;
        }
    }
    static void swapCol(int [][] matrix, int col,int from,int n){
        int temp;
        for (int i = 0; i < n; i++) {
            temp = matrix[i][col];
            matrix[i][col] = matrix[i][from];
            matrix[i][from] = temp;
        }
    }
}
