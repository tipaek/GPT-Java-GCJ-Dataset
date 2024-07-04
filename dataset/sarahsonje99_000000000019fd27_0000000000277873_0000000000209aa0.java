import java.util.*;
class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        int case_no = 1;
        while(case_no<=t) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            String ans = "POSSIBLE";
            if(k%n!=0 || k>n*n) {
                ans = "IMPOSSIBLE";
                System.out.println("Case #"+case_no+++": "+ans);
            }
            else {
                int quo = k/n;
                
                System.out.println("Case #"+case_no+++": "+ans);
                for(int i = 0; i<n; i++) {
                    int start = (quo-i+n)%n;
                    if(start == 0)
                        start = n;
                    for(int j = 0; j<n; j++) {
                        System.out.print(start+" ");
                        start++;
                        start = start%n;
                        if(start==0) start = n;
                    }
                    System.out.println();
                }
            }
            
            
        }
    }
}