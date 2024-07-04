import java.util.*;
public class Solution {
  public static void main (String [] args){
    Scanner c = new Scanner(System.in);
    int t = c.nextInt();
    int cnt=1;
    while (t>0){
        int n = c.nextInt();
        int[][] mtx = new int[n][n];
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                mtx[i][j]=c.nextInt();
            }
        }
        
        int trace=0;
        for (int i=0;i<n;i++){
            trace+=mtx[i][i];
        }
        int row=0,col=0;
        for (int i=0;i<n;i++){
            HashSet<Integer> set = new HashSet<Integer>();
            for (int j=0;j<n;j++){
                int tmp=mtx[i][j];
                if (set.contains(tmp)){
                    row++;break;
                }
                else{
                    set.add(tmp);
                }
            }
        }
        for (int i=0;i<n;i++){
            HashSet<Integer> set = new HashSet<Integer>();
            for (int j=0;j<n;j++){
                int tmp=mtx[j][i];
                if (set.contains(tmp)){
                    col++;break;
                }
                else{
                    set.add(tmp);
                }
            }
        }
        System.out.println("Case #"+cnt+": "+trace+" "+row+" "+col);
        cnt++;t--;
    }
  }
}