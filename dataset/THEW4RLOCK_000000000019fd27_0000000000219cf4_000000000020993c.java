
import java.util.HashMap;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int t = sc.nextInt();
        for(int q=0;q<t;q++){
            int n = sc.nextInt();
            int ar[][]=new int[n][n];
            for(int i=0;i<n;i++)
                for(int j=0;j<n;j++)
                    ar[i][j]=sc.nextInt();
            int sum=0;
            int r=0;
            int c=0;
            out:
            for(int i=0;i<n;i++){
                sum+=ar[i][i];
                HashMap<Integer, Integer> row = new HashMap<>();
                for(int j=0;j<n;j++){

                     if(!row.containsValue(ar[i][j]))
                         row.put(j,ar[i][j]);
                     else {
                         r++;
                         break;
                     }

                }
            }
            for(int i=0;i<n;i++){
                HashMap<Integer, Integer> col = new HashMap<>();
                for(int j=0;j<n;j++){
                    if(!col.containsValue(ar[j][i]))
                        col.put(j, ar[j][i]);
                    else{
                        c++;
                        break;
                    }
                }
            }
            System.out.println("Case #"+(q+1)+": "+sum+" "+r+" "+c);
        }
    }
}
