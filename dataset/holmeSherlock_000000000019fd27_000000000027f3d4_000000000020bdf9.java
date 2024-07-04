import java.util.*;
class Solution {
    static void sort(int[] start,int[] end,int n){
        for (int i=0;i<n-1;i++){
            for (int j=0;j<n-i-1;j++){
                if(start[j]>start[j+1]){
                    int c=start[j];
                    start[j]=start[j+1];
                    start[j+1]=c;
                    c=end[j];
                    end[j]=end[j+1];
                    end[j+1]=c;
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        int c=0;
        while(c<t) {
            c++;
            int n = sc.nextInt();
            int[] start = new int[n];
            int[] end = new int[n];
            for (int i = 0; i < n; i++) {
                start[i] = sc.nextInt();
                end[i] = sc.nextInt();
            }
            int[] s1 = start.clone();
            int[] e1 = end.clone();
            sort(start, end, n);
            char[] ans = new char[n];
            int C, J;
            J = C = 0;
            for (int i = 0; i < n; i++) {
                int cs = start[i];
                int ce = end[i];
                if (C <= cs) {
                    int index = 0;
                    for (int k = 0; k < n; k++) {
                        if (s1[k] == cs && e1[k] == ce) {
                            index = k;
                            break;
                        }
                    }
                    C = ce;
                    ans[index] = 'C';
                }
                else if (J <= cs) {
                    int index = 0;
                    for (int k = 0; k < n; k++) {
                        if (s1[k] == cs && e1[k] == ce) {
                            index = k;
                            break;
                        }
                    }
                    ans[index] = 'J';
                    J = ce;
                } else {
                    ans = null;
                    break;
                }
            }
            if (ans == null)
                System.out.println("Case #" + c + ": IMPOSSIBLE");
            else {
                StringBuilder sb=new StringBuilder();
                sb.append(ans);
                System.out.println("Case #" + c + ": " +sb.toString());
            }
        }
    }
}