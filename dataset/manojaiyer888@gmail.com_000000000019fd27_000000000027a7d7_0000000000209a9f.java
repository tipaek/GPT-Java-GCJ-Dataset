import java.util.Scanner;
import java.util.Set;

public class Solution {
    private static Scanner inn;
    static int tn = 1;
    
    public static void main(String[] args) {
        inn = new Scanner(System.in);
        
        int p = inn.nextInt();
        inn.nextLine();
        
        while(p-- > 0) {
            solve();
        }
    }
    
    private static void solve() {
        
        String N = inn.nextLine();
        StringBuilder mb =  new StringBuilder();
        char[] sitchairss = N.toCharArray();
        
        int numm = 0;
        int cbrases = 0;
        
        int last = Character.getNumericValue(sitchairss[0]);
        numm = last;
        cbrases = last;
        
        for(int i=0; i < last; i++) {
            mb.append('(');
        }
        mb.append(last);
        
        
        for(int i = 1; i < sitchairss.length; i++) {
            int dm = Character.getNumericValue(sitchairss[i]);
            
            if(dm == numm) {
                mb.append(dm);
            } else if(dm > numm) {
                int dif = dm - numm;
                for(int j = 0; j < dif; j++) {
                    mb.append('(');
                    cbrases++;
                }
                mb.append(dm);
            }else {
                int dif = numm - dm;
                
                for (int j = 0; j < dif; j++) {
                    mb.append(')');
                    cbrases--;
                }
                mb.append(dm);
            }
            numm = Character.getNumericValue(sitchairss[i]);
        }
        while(cbrases-- > 0) {
            mb.append(')');
        }
        System.out.println("Case #" + (tn++) + ": " + mb.toString());
    }
    
}

