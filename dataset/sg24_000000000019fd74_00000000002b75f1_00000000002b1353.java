
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution {
    
    public static void main(String[] args) {
        Scanner in = new Scanner((Readable) new BufferedReader(new InputStreamReader(System.in)));
        int testCount = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        List<BigInteger[]> l = new ArrayList<>();
        in.nextLine();
        for(int testIndex = 0 ;testIndex < testCount ; testIndex++){
            BigInteger sum = new BigInteger(in.nextLine());
            System.out.println("Case #"+(testIndex+1)+": ");
            BigInteger one = new BigInteger("1");
            for(BigInteger i = BigInteger.ZERO ; i.compareTo(sum) < 0 ; i = i.add(one)){
                System.out.println(i.add(one)+" "+1);
            }
        }
        
        
        
        /*  
        for(int i =0 ; i<l.size();i++){
            System.out.println("Case #"+(i+1)+": "+l.get(i)[0]+" "+l.get(i)[1]);
        }*/
        
        
        
    }
    
    
    
    
    
    
    
}