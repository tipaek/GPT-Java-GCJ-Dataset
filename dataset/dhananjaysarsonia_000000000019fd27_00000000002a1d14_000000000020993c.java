
import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;
public class Solution {
    private static Scanner scanner;
    private static int tn=1;

    public static void main(String args[]) {

        scanner =new Scanner(System.in);
        int testcase= scanner.nextInt();
        scanner.nextLine();

        while(testcase>0){
            testcase--;
            int n= scanner.nextInt();
            int[][] arr=new int[n][n];
            int k=0;
            for(int i=0;i<arr.length;i++){
                for(int j=0;j<arr[i].length;j++){
                    arr[i][j]= scanner.nextInt();

                    if(i==j)k+=arr[i][j];

                }
            }
            


            int rowCount=0;
            for(int i=0;i<arr.length;i++){
                Set<Integer> set=new HashSet<>();
                for(int j=0;j<arr[i].length;j++){
                    if(set.contains(arr[i][j])){
                        rowCount++;
                        break;
                    }
                    set.add(arr[i][j]);

                }
            }


            int columnCount=0;
            for(int i=0;i<arr.length;i++){
                Set<Integer> set=new HashSet<>();
                for(int j=0;j<arr[i].length;j++){
                    if(set.contains(arr[j][i])){
                        columnCount++;
                        break;
                    }
                    set.add(arr[j][i]);

                }
            }
            System.out.println("Case #" + (tn++)+": "+ k+" "+rowCount+" "+columnCount);

        }

    }
    



}