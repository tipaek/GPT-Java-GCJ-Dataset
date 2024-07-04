
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t=s.nextInt();
        for(int b=1; b<=t; b++){
            int n=s.nextInt();
            int[][] a=new int[n][n];
            int trace=0;
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    a[i][j]=s.nextInt();
                }
            }
            for(int i=0; i<n; i++)
                trace+=a[i][i];
            int row=0, column=0;
            int[] check=new int[n];
            for(int i=0; i<n; i++){
                check[i]=i+1;
            }
            for(int i=0; i<n; i++){
                int[] r_array=new int[n];
                for(int j=0; j<n; j++){
                    r_array[j]=a[i][j];
                }
                Arrays.sort(r_array);
                if(!Arrays.equals(r_array, check))
                    row++;
            }
            for(int i=0; i<n; i++){
                int[] c_array=new int[n];
                for(int j=0; j<n; j++){
                    c_array[j]=a[j][i];
                }
                Arrays.sort(c_array);
                if(!Arrays.equals(c_array, check))
                    column++;
            }

            System.out.println("Case #"+b+": "+trace+" "+row+" "+column);
        }
    }
}
