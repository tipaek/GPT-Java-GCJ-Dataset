
import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        int testCase = Integer.parseInt(sc.nextLine());

        int array[][];
        int n=0;
        String result="";
        int test =1;
        for (int k = 0; k < testCase; k++) {
            n= Integer.parseInt(sc.nextLine());
            array = new int[n][n];
            for (int i = 0; i < n; i++) {
                String line[] = sc.nextLine().split(" ");
                for (int j = 0; j < n; j++) {
                    array[i][j]=Integer.parseInt(line[j]);
                }
            }
            result+="Case #"+(test++)+": "+computeTrace(array) +" "+computeRow(array)+" "+computeCol(array)+"\n";

        }
        System.out.println(result);

    }
    static int check(int [] a){
        int flag=0;
        for (int i = 0; i < a.length; i++) {
            for (int j = i+1; j < a.length; j++) {
                if(a[i]==a[j]){
                    flag=1;
                    break;
                }
            }
        }
        return flag;
    }
    static int computeRow(int [][] arr){
        int check=0;
        for (int i = 0; i < arr.length; i++) {
            check+=check(arr[i]);
        }
        return  check;
    }

    static int computeCol(int [][] arr){
        int check =0,flag=0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
               int temp = arr[j][i];
                for (int k = j+1; k < arr.length; k++) {
                    if(arr[k][i]==temp){
                        flag=1;
                    }
                }
                if(flag==1){
                    check++;
                    flag=0;
                    break;
                }
            }
        }
        return check;
    }

    static int computeTrace(int [][] array){
        int sum=0;
        for (int i = 0; i < array.length ; i++) {
            for(int j=0;j<array.length;j++){
                if(i==j){
                    sum+=array[i][j];
                }
            }
        }
        return sum;
    }
}



