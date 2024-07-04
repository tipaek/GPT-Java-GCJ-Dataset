import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    static Scanner src = new Scanner(System.in);

    public static void main(String args[]) {


        int t = src.nextInt();

        int caseNum = 1;
        while (t-- > 0) {

            int n = src.nextInt();
            int a[][] = new int [n][n];

            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    a[i][j] = src.nextInt();
                }
            }

            int sum = calSum(a);
            int row = wrongRow(a);
            int col = wrongCol(a);


            print(caseNum,sum+" "+row+" "+col);
            

            caseNum++;
        }
    }

    private static int wrongCol(int[][] a) {

        int wrong = 0;
        int n = a.length;
        for(int i=0;i<a.length;i++){
            Set<Integer> set = new HashSet<Integer>();
            for(int j=0;j<a.length;j++){
                if(set.contains(a[j][i])){
                    wrong++;
                    break;
                }
                set.add(a[j][i]);
            }

        }

        return wrong;
    }

    private static int wrongRow(int[][] a) {

        int wrong = 0;
        int n = a.length;
        int total = ((n-1)*n)/2;
        for(int i=0;i<a.length;i++){
            Set<Integer> set = new HashSet<Integer>();
            for(int j=0;j<a.length;j++){
                if(set.contains(a[i][j])){
                    wrong++;
                    break;
                }
                set.add(a[i][j]);
            }

        }

        return wrong;

    }

    private static int calSum(int[][] a) {

        int sum  = 0;

        for(int i=0;i<a.length;i++){
            sum+=a[i][i];
        }

        return sum;
    }

    public static void print(int caseNum, String output){

        System.out.println("Case #"+caseNum+": "+output);
    }

}
