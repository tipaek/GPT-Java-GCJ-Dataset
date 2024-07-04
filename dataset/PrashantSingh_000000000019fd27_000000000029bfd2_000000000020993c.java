import java.util.Scanner;
import java.util.*; 
public class Solution {
    private static Scanner sc;
    static int tn=1;
    public static void main(String args[]) {
        sc= new Scanner(System.in);
        int t= sc.nextInt();
        sc.nextLine();
        while(t-->0){
            int size =sc.nextInt();
            int[][] mat = new int[size][size];
            int k=0;
            for(int i=0;i<mat.length;i++){
                for(int j=0;j<mat[i].length;j++){
                    mat[i][j]=sc.nextInt();
                    if(i==j){
                        k+=mat[i][j];
                    }
                }
        }
        int r =0;
        for(int i = 0;i<mat.length;i++){
            Set<Integer> set1 = new HashSet<>();
            for(int j=0;j<mat[i].length;j++){
                if(set1.contains(mat[i][j])){
                    r++;
                    break;
                }
                set1.add(mat[i][j]);
            }
        }
        int c=0;
        for(int i=0;i<mat.length;i++){
            Set<Integer> set2 = new HashSet<>();
            for(int j=0;j<mat[i].length;j++){
                if(set2.contains(mat[j][i])){
                    c++;
                    break;
                }
                set2.add(mat[j][i]);
            }
        }
        System.out.println("Case #"+(tn++)+": "+k+" "+r+" "+c);
        }
    }
}