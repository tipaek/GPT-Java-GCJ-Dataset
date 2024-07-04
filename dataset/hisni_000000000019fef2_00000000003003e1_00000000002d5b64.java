import java.util.*;

public class Solution {
    
    public static void main(String[] args) {
        
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        
        for(int i=1; i<=t;i++){
            int R = s.nextInt();
            int S = s.nextInt();
            
            int f = R-1;
            int l = R*S - f - 1;
            int count = (R-1)*(S-1);

            System.out.println("Case #" + i + ": " + count);

            while( f>0 ){
                for(int k=0;k<S-1;k++){
                    System.out.println(l+" "+f);
                    l--;
                }
                f--;
            }
            
        }
       
    }
}