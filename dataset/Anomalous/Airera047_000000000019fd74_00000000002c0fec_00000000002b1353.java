import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int testN = input.nextInt();
        
        for (int i = 0; i < testN; i++) {
            int numberT = input.nextInt();
            int currentSum = 0;
            int r = 1;
            int k = 1;
            int testCase = i + 1;
            
            System.out.println("Case #" + testCase + ":");
            
            while (currentSum <= numberT) {
                int pascalValue = (int) calPascal(r, k);
                currentSum += pascalValue;
                
                System.out.println(r + " " + k);
                
                if (currentSum < numberT / 3) {
                    if ((r + 1) % 2 != 0) {
                        k++;
                    }
                    r++;
                } else if (k == r) {
                    k++;
                    r++;
                } else {
                    k++;
                }
            }
        }
        
        input.close();
    }

    public static double calPascal(int r, int k) {
        double result = 1.0;
        for (int s = 0; s < k - 1; s++) {
            result = result * (r - 1 - s) / (s + 1);
        }
        return result;
    }
}