import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numTests = sc.nextInt();

        for(int t = 1; t <= numTests; t++){
            int n = sc.nextInt();
            System.out.println("Case #" + t + ":");
            System.out.println("1 1");

            if(n == 1) continue;
            n--;

            int cur = 1;
            int curR = 2;
            int curC = 2;
            while(n > 0){
                if(cur > n){
                    curC--;
                    curR--;
                    while(n > 0){
                        System.out.println(curR + " " + curC);
                        n--;
                        curR++;
                    }
                } else {
                    System.out.println(curR + " " + curC);
                    n -= cur;
                    cur++;
                    curR++;
                }
            }
        }
    }
}


