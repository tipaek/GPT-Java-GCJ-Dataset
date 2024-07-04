import java.util.*;
import java.io.*;
public class Solution{
    public static void main(String args[]) throws Exception{
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int k = 1;k <= t;k++){
            int b = sc.nextInt();
            int ar[][] = new int[15][b];
            for(int i = 0; i < 15;i++){
                for(int j = 0; j < b;j++){
                    System.out.println(j+1);
                    ar[i][j] = sc.nextInt();
                }
            }
            String s = "";
            int temp = 0;
            for(int i = 0; i < b;i++){
                temp = ar[0][i];
                for(int j = 1; j < 15;j++){
                    temp = ar[j][i];
                }
                s += temp;
            }
            System.out.println(s);
            char ch = sc.next().charAt(0);
            if(ch == 'N')
                break;
        }
    }
}