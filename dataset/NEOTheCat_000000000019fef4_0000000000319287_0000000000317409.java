import java.util.Scanner;

public class Solution {
    private static String PATTEN = "Case #%d: %s";
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        for (int p = 1; p <= t; p++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            String s = sc.next();
            int sum = 0;
            if ((x==0) && (y==0)){
                System.out.println(String.format(PATTEN, p, 0));
            }
            boolean flag = false;
            for (int i =0;i<s.length();i++){
                sum++;
                if (s.charAt(i)=='N'){
                    y++;
                }
                if (s.charAt(i)=='S'){
                    y--;
                }
                if (s.charAt(i)=='W'){
                    x--;
                }
                if (s.charAt(i)=='E'){
                    x++;
                }
                if (Math.abs(x)+Math.abs(y)<=sum){
                    System.out.println(String.format(PATTEN, p, sum));
                    flag = true;
                    break;
                }
            }
            if (!flag){
                System.out.println(String.format(PATTEN, p, "IMPOSSIBLE"));
            }
        }
    }
}