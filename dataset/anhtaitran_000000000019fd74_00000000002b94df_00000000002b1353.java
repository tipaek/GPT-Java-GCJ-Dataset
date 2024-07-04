import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 1; i <= t; i++){
            int n = sc.nextInt();
            System.out.println("Case #" + i + ": ");
            solve(n);
        }
    }

    private static void solve(int n) {
        int i = 1, j = 1;
        if (n <= 501){
            while (n > 0){
                System.out.println(i + " " + j);
                n--;
                if (i == 1 && j == 1){
                    i++;
                }
                else if (i == 2 && j == 1){
                    j++;
                }
                else{
                    i++; j++;
                }
            }
        }
        else if (n <= 1000){
            System.out.println(1 + " " + 1);
            i = 2;
            j = 1;
            n--;
            while (n >= j){
                n -= j;
                System.out.println(i + " " + j);
                i++; j++;
            }
            j = i;
            while (n > 0){
                n--;
                System.out.println(i + " " + j);
                i++; j++;
            }
        }
        else{

        }
    }
}