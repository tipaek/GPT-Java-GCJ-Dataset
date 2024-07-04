import java.util.*;

class D implements Comparable<D> {
    int x, y, index;
    
    public D (int x, int y, int index) {
        this.x = x; this.y = y; this.index= index;
    }
    public int compareTo(D d) {
        return this.x - d.x;
    }
}

class Solution {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int t = Integer.parseInt(inp.nextLine());
        int k=t;
        while (k-- > 0) {
            int n = Integer.parseInt(inp.nextLine());
            D[] tasks = new D[n];
            for (int i=0; i<n; i++) {
                String[] s = inp.nextLine().split(" ");
                tasks[i] = new D(Integer.parseInt(s[0]),
                                 Integer.parseInt(s[1]), i);
            }
            Arrays.sort(tasks);
            
            int c = 0, j = 0, flag = 0;
            char[] ans = new char[n];
            for (int i=0; i<n; i++) {
                if (tasks[i].x >= c) {
                    c = tasks[i].y;
                    ans[tasks[i].index] = 'C';
                    continue;
                }
                else if (tasks[i].x >= j) {
                    j = tasks[i].y;
                    ans[tasks[i].index] = 'J';
                    continue;
                }
                flag = 1;
                break;
            }
            if (flag == 0) {
                System.out.println("Case #" + (t-k) + ": "+ String.valueOf(ans));
            } else {
                System.out.println("Case #" + (t-k) + ": IMPOSSIBLE");
            }
        }
    }
}