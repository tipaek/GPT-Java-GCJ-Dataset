import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i=1;i<=T;i++) {
            int N = sc.nextInt();
            int[][] act = new int[N][2];
            char[] str = new char[N];
            for(int j=0;j<N;j++) {
                act[j][0] = sc.nextInt();
                act[j][1] = sc.nextInt();
            }
            System.out.print("Case #" + i + ": ");
            int active = 0;
            for(int j=0;j<N;j++) {
                if(active == 0) {
                    str[j] = 'C';
                    active++;
                } else if(active < 3) {
                    if(act[j][0] < act[j-1][1]) {
                        if(str[j-1] == 'C') {
                            str[j] = 'J';
                        } else {
                            str[j] = 'C';
                        }
                        active++;
                    } else {
                        str[j] = str[j-1];
                        active--;
                    }
                } else {
                    break;
                }
            }
            if(active > 2) {
                System.out.println("IMPOSSIBLE");
            } else {
                System.out.println(str);
            }
        }
    }
}
