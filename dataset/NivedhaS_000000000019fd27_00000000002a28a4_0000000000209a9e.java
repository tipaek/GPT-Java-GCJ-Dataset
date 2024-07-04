import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int b = sc.nextInt();
        
        for (int x = 1; x <= t; x++) {
            StringBuffer ans = new StringBuffer();
            for(int i = 1 ; i <= b ; i++){
                System.out.println(i);
                int val = sc.nextInt();
                ans.append(val);
            }
            System.out.println(ans);
            String reply = sc.next();
            if(reply.equalsIgnoreCase("N")){
                break;
            }
        }
    }
}
