import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i=1;i<=T;i++) {
            int N = sc.nextInt();
            int[][] act = new int[N][3];
            char[] str = new char[N];
            for(int j=0;j<N;j++) {
                act[j][0] = sc.nextInt();
                act[j][1] = sc.nextInt();
            }
            System.out.print("Case #" + i + ": ");
            boolean impossible = false;
            int cu = -1;
            int ju = -1;
            for(int j=0;j<N;j++) {
                int active = -1;
                for(int k =0; k<N;k++) {
                    if(act[k][2] == 0) {
                        if(active == -1) active=k;
                        else if (act[active][0] > act[k][0]) {
                            active = k;
                        } else if (act[active][0] == act[k][0]) {
                            if (act[active][1] > act[k][1]) {
                                active = k;
                            }
                        }
                    }
                }
                if(act[active][0] >= cu) {
                    str[active] = 'C';
                    cu = act[active][1];
                } else if(act[active][0] >= ju) {
                    str[active] = 'J';
                    ju = act[active][1];
                } else {
                    impossible = true;
                    break;
                }
                act[active][2] = 1;
            }
            if(impossible) {
                System.out.println("IMPOSSIBLE");
            } else {
                System.out.println(str);
            }
        }
    }
}
