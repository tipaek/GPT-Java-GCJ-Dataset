import java.util.*;

public class Main
{
    public static void main (String [] args) {
        Main m = new Main();
        m.run();
    }
    
    public void run()
    {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        for (int a = 0; a < T; a++) {
            int N = scan.nextInt();
            int trace = 0;
            int rows = 0;
            int cols = 0;
            int[][] arr = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int num = scan.nextInt();
                    arr[i][j] = num;
                    if (i == j) trace += num;
                }
            }
            for (int i = 0; i < N; i++) {
                int[] r = new int[N];
                int[] c = new int[N];
                for (int j = 0; j < N; j++) {
                    r[j] = arr[i][j];
                    c[j] = arr[j][i];
                }
                rows += check(r);
                cols += check(c);
            }
            System.out.println("Case #"+(a+1)+": "+trace+" "+rows+" "+cols);
        }
    }
    
    public int check(int[] arr)
    {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < arr.length; i++) {
            if (list.indexOf(arr[i]) == -1)
                list.add(arr[i]);
            else return 1;
        }
        return 0;
    }
}