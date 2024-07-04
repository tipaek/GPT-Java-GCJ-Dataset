import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    private static Scanner pc;
    static int tn = 1;
    
    public static void main(String[] args) {
        pc = new Scanner(System.in);
        
        int p = pc.nextInt();
        pc.nextLine();
        
        while(p-- > 0) {
            solve();
        }
    }
    
    private static void solve() {
        
        String N = pc.nextLine();
        StringBuilder nb =  new StringBuilder();
        char[] chairs = N.toCharArray();
        
        int mum = 0;
        int braces = 0;
        
        int last = Character.getNumericValue(chairs[0]);
        mum = last;
        braces = last;
        
        for(int i=0; i < last; i++) {
            nb.append('(');
        }
        nb.append(last);
        
        
        for(int i = 1; i < chairs.length; i++) {
            int dm = Character.getNumericValue(chairs[i]);
            
            if(dm == mum) {
                nb.append(dm);
            } else if(dm > mum) {
                int dif = dm - mum;
                for(int j = 0; j < dif; j++) {
                    nb.append('(');
                    braces++;
                }
                nb.append(dm);
            }else {
                int dif = mum - dm;
                
                for (int j = 0; j < dif; j++) {
                    nb.append(')');
                    braces--;
                }
                nb.append(dm);
            }
            mum = Character.getNumericValue(chairs[i]);
        }
        while(braces-- > 0) {
            nb.append(')');
        }
        System.out.println("Case #" + (tn++) + ": " + nb.toString());
    }
    
}