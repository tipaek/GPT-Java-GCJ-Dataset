import java.util.Scanner;
import java.math.BigInteger;

class Solution {
	public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int i,j;
        BigInteger b1, b2;
        int tcase = 1;
        for (;tcase <= testCases; tcase++) {
            i = scanner.nextInt(); b1 = new BigInteger(String.valueOf(i));
            j = scanner.nextInt(); b2 = new BigInteger(String.valueOf(j));
            b1 = sum(String.valueOf(i));
            // System.out.println("i:" + i);
            // System.out.println("j:" + j);
            // System.out.println("namakhil:b1: " + b1);
            // System.out.println("namakhil: b2:" + b2);
            if(i == 2) {
                if( j ==2 || j == 4)
                    System.out.println("Case #" + tcase +": "+"POSSIBLE");
                else 
                    System.out.println("Case #" + tcase +": "+"IMPOSSIBLE");
            }
            else if(b1.compareTo(b2) == 0) {
                System.out.println("Case #" + tcase +": "+"POSSIBLE");
            } else {
                System.out.println("Case #" + tcase +": "+"IMPOSSIBLE");
            }
        }
    }
    
    static BigInteger sum(String n) 
    { 
        // b1 = 1 
        BigInteger b1 = BigInteger.ONE; 
  
        // b2 = 2 
        BigInteger b2 = new BigInteger("2"); 
  
        // Converting n to BigInteger 
        BigInteger bigInt = new BigInteger(n); 
  
        // Calculating (n * (n + 1)) / 2 
        BigInteger result = 
         (bigInt.multiply(bigInt.add(b1))).divide(b2); 
        return result; 
    }
}