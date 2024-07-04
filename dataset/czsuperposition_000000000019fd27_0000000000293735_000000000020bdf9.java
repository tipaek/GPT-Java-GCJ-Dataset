import java.lang.reflect.Array;
import java.util.*;

public class Solution {
    private static int[][] a;
    private static int[] b;
    private static int N;
    private static ArrayList<Integer> JList;
    private static ArrayList<Integer> CList;
    public static boolean fn(int nextActivity)
    {
        if(nextActivity == N)
            return true;
        int i = a[nextActivity][1];
        boolean JcanDo = JList.size() == 0 || b[JList.get(JList.size()-1)] <= a[nextActivity][0];
        boolean CcanDo = CList.size() == 0 || b[CList.get(CList.size()-1)] <= a[nextActivity][0];
        if(!JcanDo && !CcanDo)
            return false;
        if(CcanDo)
        {
            CList.add(i);
            boolean out1 = fn(nextActivity+1);
            if(out1)
                return true;
            CList.remove(CList.size()-1);
        }
        if(JcanDo)
        {
            JList.add(i);
            boolean out1 = fn(nextActivity+1);
            if(out1)
                return true;
            JList.remove(JList.size()-1);
        }
         return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        String[] answer = new String[T];
        for(int i=0;i<T;i++) {
            N = scanner.nextInt();
            a = new int[N][2];
            b = new int[N];
            for (int j = 0; j < N; j++) {
                a[j][0] = scanner.nextInt();
                a[j][1] = j;
                b[j] = scanner.nextInt();
            }
            Arrays.sort(a, (x,y) -> Integer.compare(x[0], y[0]));
            JList = new ArrayList<>();
            CList = new ArrayList<>();
            if(fn(0))
            {
                Collections.sort(JList);
                int kk=0;
                String ans = "";
                for(int k: JList)
                {
                    while(kk<k) {
                        ans += "C";
                        kk++;
                    }
                    ans+='J';
                    kk++;
                }
                while(kk<N) {
                    ans += "C";
                    kk++;
                }
                answer[i] = ans;
            }
            else
                answer[i] = ("IMPOSSIBLE");

        }
        for(int i=0;i<T;i++)
            System.out.println("Case #" + (i+1) + ": " + answer[i]);

    }
}