import java.util.*;

class Main
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
                ArrayList<Integer> list = new ArrayList<Integer>();
                for (int j = 0; j < N; j++) {
                    int num = scan.nextInt();
                    arr[i][j] = num;
                    if (i == j) trace += num;
                    list.add(num);
                }
                Set<Integer> set = new HashSet<Integer>(list);
                if (set.size() != list.size()) rows++;
            }
            for (int i = 0; i < N; i++) {
                ArrayList<Integer> list = new ArrayList<Integer>();
                for (int j = 0; j < N; j++) {
                    list.add(arr[j][i]);
                }
                Set<Integer> set = new HashSet<Integer>(list);
                if (set.size() != list.size()) cols++;
            }
            System.out.println("Case #"+(a+1)+": "+trace+" "+rows+" "+cols);
        }
    }
}