import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
public class Solution{
    public static void main(String[] args){
    Scanner s = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int ree = Integer.parseInt(s.next());
    int[][] kcool = new int[ree][3];
    for(int p = 0; p < ree; p++){
        int n  = Integer.parseInt(s.next());
        int[][] arr = new int[n][n];
        for(int i = 0; i < n; i++){
            // String line = s.nextLine();
            // StringTokenizer st = new StringTokenizer(line);
            for(int j = 0; j < n; j++){
                arr[i][j] = Integer.parseInt(s.next());
            }
        }
        //-------------------------------
        int k = 0;
        int r = 0;
        int c = 0;
        for(int i = 0; i < n; i++){
            k+=arr[i][i];
            ArrayList<Integer> temp = new ArrayList<Integer>();
            for(int j = 0; j < n; j++){
                if(!temp.contains(arr[i][j])){
                    temp.add(arr[i][j]);
                }else{
                    r++;
                    break;
                }
            }
        }
        for(int j = 0; j < n; j++){
            ArrayList<Integer> temp = new ArrayList<Integer>();
            for(int i = 0; i < n; i++){
                if(!temp.contains(arr[i][j])){
                    temp.add(arr[i][j]);
                }else{
                    c++;
                    break;
                }
            }
        }
        kcool[p][0] = k;
        kcool[p][1] = r;
        kcool[p][2] = c;
    }
    s.close();
    for(int i = 0; i < ree; i++){
        System.out.println("Case #"+(i+1)+": "+kcool[i][0]+" "+kcool[i][1]+" "+kcool[i][2]);
    }
    System.exit(0);
    }
}