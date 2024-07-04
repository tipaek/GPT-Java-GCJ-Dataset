import java.util.*;

class Solution {
    public static void main(String[]args) {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        int b = s.nextInt();
        for(int t=1; t<=T; t++) {
            String ans  = "";
            int i=0,val = 0;
            for(i=1;i<=140;) {
                for(int j=1;j<=10;j++,i++) {
                    System.out.println(j);
                    val = s.nextInt();
                    System.out.flush();
                }
            }
            for(;i<=150;i++) {
                System.out.println(i-140);
                ans += s.nextInt();
                System.out.flush();
            }
            System.out.println(ans);
            String c = s.next();
            if(c=="N") {
                return;
            }
            System.out.flush();
        }
    }
}
