import java.util.HashSet;
import java.util.Scanner;

class Solution{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for (int k = 1; k <= t; k++) {
            int n=sc.nextInt();
            int arr[][]=new int[n][n];


            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr.length; j++) {
                    arr[i][j]=sc.nextInt();
                    
                }
            }

            HashSet<Integer> check_row=new HashSet<>();
            HashSet<Integer> check_column=new HashSet<>();

            int row=0,column=0,trace=0;

            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr.length; j++) {
                    if(i==j)
                    trace+=arr[i][j];
                    check_column.add(arr[j][i]);
                    check_row.add(arr[i][j]);
                }      
                if(check_row.size()!=n)
                row++;
                if(check_column.size()!=n)
                column++;
                check_column.clear();
                check_row.clear();
            }
            System.out.println("Case #"+k+": "+trace+" "+row+" "+column);
        }
        sc.close();
    }

}