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
            else if (n<=1000){
                solve2(n, test);
            }
        }
    }

    private static void solve2(int n, int test) {
        System.out.println(String.format("Case #%d:", test));
        System.out.println("1 1");
        System.out.println("2 2");
        int sum = 3;
        int row = 2;
        while(n-sum >= row){
            sum += row;
            System.out.println((row+1) + " 2");
            row += 1;
        }
        while (n != sum){
            sum += 1;
            System.out.println((row+1) + " 1");
            row += 1;
        }
        System.out.println((row+1) + " 1");
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
