
import java.util.Scanner;

 public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int t =0; t<T; t++){
            System.out.println(t%10);
            System.out.flush();
        }
    }
}