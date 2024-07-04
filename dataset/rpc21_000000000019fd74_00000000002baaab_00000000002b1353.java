import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int test = 1; test<=t; test++){
            int n = in.nextInt();
            if(n<=501){
                solve1(n, test);
            }
        }
    }

    private static void solve1(int n, int test) {
        System.out.println(String.format("Case #%d:", test));
        if(n<=500){
            for(int i=1; i<=n; i++){
                System.out.println(i+" 1");
            }
        }
        else{
            System.out.println("1 1");
            System.out.println("2 1");
            System.out.println("3 2");
            System.out.println("3 1");
            for(int i=4; i<=499; i++){
                System.out.println(i+" 1");
            }
        }
    }
}
