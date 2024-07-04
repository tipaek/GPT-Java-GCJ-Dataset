
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.Scanner;
public class JavaApplication53 {

    public static void solve(int T){
        Scanner s = new Scanner(System.in);
        int N=0 , trace=0;
        N = s.nextInt();
        int a[][] = new int[N][N];
        for (int i=0; i<N ; i++){
            for (int j=0 ; j<N ; j++){
                a[i][j] = s.nextInt();
                if (i==j){
                    trace+=a[i][j];
                }
            }
        }
        HashMap<Integer , Integer> h = new HashMap<>();
        HashMap<Integer , Integer> h1 = new HashMap<>();
        int row =0  ,coumn=0;
        for (int i=0 ; i<N ; i++){
            boolean check = true , check2 = true;
            for (int j=0 ; j<N ; j++){
                if (h.get(a[i][j])!= null && h.get(a[i][j])==1){
                   h.put(a[i][j], 2);
                   if (check)
                       row++;
                   else
                       break;
                   check = false;
                }else{
                    h.put(a[i][j], 1);
                }
                if (h1.get(a[j][i])!= null && h1.get(a[j][i])==1){
                   h1.put(a[j][i], 2);
                   if (check2)
                       coumn++;
                   else
                       break;
                   check2 = false;
                }else{
                    h1.put(a[j][i], 1);
                }
            }
            h.clear();
            h1.clear();
        }
        System.out.println("Case #"+T+": "+trace +"   "+row+"  "+coumn);
        s.close();
    }
    
    public static void main(String[] args)  
    { 
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        int T=1;
        while (t != 0){
            solve(T++);
            t--;
        }
        s.close();
    }  
}
    
