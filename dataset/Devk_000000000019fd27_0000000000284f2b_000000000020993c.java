import java.util.HashSet;
import java.util.Scanner;

class Solution {

    static Scanner sc= new Scanner(System.in);
    public static void main(String[] args) {
        int t=sc.nextInt();
        
        for (int i = 0; i < t; i++) {
            int a=0,r=0,c=0;

            HashSet A= new HashSet<Integer>();
            HashSet B= new HashSet<Integer>();
            
            int n = sc.nextInt();
            int mat[][]= new int[n][n];
            sc.nextLine();
            for (int j = 0; j < n; j++) {
                String s= sc.nextLine();
                for (int k = 0; k < s.length(); k=k+2) {
                    mat[j][k/2]=Character.getNumericValue(s.charAt(k));
                    A.add(mat[j][k/2]);
                    if (j==(k/2)) {
                       a+=mat[j][k/2];
                    }
                }
                if (A.size()<n) {
                    r++;
                }
                A.clear();
            }
            for (int j = 0; j < n; j++) {
                for (int j2 = 0; j2 < n; j2++) {
                    B.add(mat[j2][j]);
                }
                if (B.size()<n) {
                    c++;
                }
                B.clear();
            }
            System.out.format("case #%d: %d %d %d",i+1,a,r,c);
            System.out.println();
            
            
        }

    }
}