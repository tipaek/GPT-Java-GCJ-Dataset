import java.util.Arrays;
import java.util.Scanner;
public class Solution {
    public static void main(String[] args){
        Scanner sn = new Scanner(System.in);
        int t = sn.nextInt();
        int count =1;
        while(t != count-1)
        {
            int n = sn.nextInt();
            int[][] mat = new int[n][n];
            for(int i =0; i< n; i++)
            {
                for(int j= 0; j < n; j++)
                {
                    mat[i][j] = sn.nextInt();
                }
            }
            int k =0;
            int r= 0;
            int c =0;
            for(int i=0;i<n;i++) {
                for (int j = 0; j < n; j++) {
                    if (j == i) {
                        k += mat[i][j];
                    }
                }
            }
            for(int i=0;i<n;i++) {
                for (int j = 0; j < n-1; j++) {
                    for(int x =j+1; x< n; x++)
                    {
                        if(mat[i][j] == mat[i][x])
                        {
                            r++;
                            break;
                        }

                    }
                    break;
                }
            }
            for(int i= 0; i < n; i++)
            {
                for(int j = 0; j < n-1; j++)
                {
                    for(int x = j+1 ;x < n; x++)
                    {
                        if(mat[j][i] == mat[x][i])
                        {
                            c++;i++;j=0;
                            break;
                        }
                    }
                    if(i == n)
                        break;

                }
            }
            System.out.println("Case #" + count +" "+k + " "+r+ " "+c);
            count++;
        }


    }
}