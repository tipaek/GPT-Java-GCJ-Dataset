import java.util.HashMap;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        for(int q=0;q<t;q++)
        {

            int n= sc.nextInt();
            int[][]matrix= new int[n][n];
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    matrix[i][j]=sc.nextInt();
                }
            }
            int trace=0;
            for(int i=0;i<n;i++)
                trace+=matrix[i][i];
            HashMap<Integer,Integer> map= new HashMap<>();
            int row=0,col=0;
            for(int i=0;i<n;i++){
                map= new HashMap<>();
                for(int j=0;j<n;j++){
                    if(map.containsKey(matrix[i][j])){
                        row++;
                        break;
                    }
                    map.put(matrix[i][j],1);
                }
            }
            for(int i=0;i<n;i++){
                map= new HashMap<>();
                for(int j=0;j<n;j++){
                    if(map.containsKey(matrix[j][i])){
                        col++;
                        break;
                    }
                    map.put(matrix[j][i],1);
                }
            }
            System.out.println("Case #"+(q+1)+"; "+trace+" "+row+" "+col);
        }
    }


}