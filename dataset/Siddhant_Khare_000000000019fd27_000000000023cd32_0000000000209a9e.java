package esab;
import java.util.Scanner;

class Solution {
    public static void Solution(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int t =0; t<T; t++){
            System.out.println(t%10);
        }
    }
}