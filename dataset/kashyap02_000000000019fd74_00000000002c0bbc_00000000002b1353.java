import java.util.*;
class Solution {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int t = 1; t <= T; t++){
            int N = sc.nextInt();

            if(N <= 500){
                System.out.println("Case #" + t + ": ");
                for(int i = 1; i <= N; i++)
                    System.out.println(i + " " + i);
            } else {
                System.out.println("Case #" + t + ": ");
                System.out.println("1 1\n2 2\n3 2");
                for(int i = 3; i < 500; i++)
                    System.out.println(i + " " + i);
            }
        }
    }
}
