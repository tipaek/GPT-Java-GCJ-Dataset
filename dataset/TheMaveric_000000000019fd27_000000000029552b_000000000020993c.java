import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        for(int b=1; b<=t; b++){
            int n=in.nextInt();
            int[][] arr=new int[n][n];
            int trace=0;
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    arr[i][j]=in.nextInt();
                }
            }
            for(int i=0; i<n; i++)
                trace+=arr[i][i];
            int row=0, column=0;
            int[] chk=new int[n];
            for(int i=0; i<n; i++){
                chk[i]=i+1;
            }
            for(int i=0; i<n; i++){
                int[] r_array=new int[n];
                for(int j=0; j<n; j++){
                    r_array[j]=arr[i][j];
                }
                Arrays.sort(r_array);
                if(!Arrays.equals(r_array, chk))
                    row++;
            }
            for(int i=0; i<n; i++){
                int[] c_array=new int[n];
                for(int j=0; j<n; j++){
                    c_array[j]=arr[j][i];
                }
                Arrays.sort(c_array);
                if(!Arrays.equals(c_array, chk))
                    column++;
            }

            System.out.println("Case #"+b+": "+trace+" "+row+" "+column);
        }
    }
}