import java.util.*;

public class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        for(int n = 1; n <= cases; n++){
            int r = sc.nextInt();
            int s = sc.nextInt();
            int lastOrder = r*s;
            System.out.println("CASE #" + n + ": " + (r-1)*(s-1));
            int rm = r;
            while(rm > 1){
                int sm = s;
                while(sm > 1){
                    System.out.println(rm + " " + (lastOrder-1-rm));
                    lastOrder--;
                    sm--;
                }
                lastOrder--;
                rm--;
            }
        }
    }
}