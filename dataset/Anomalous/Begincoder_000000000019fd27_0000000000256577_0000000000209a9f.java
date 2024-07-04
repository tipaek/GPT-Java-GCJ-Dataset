import java.util.Scanner;

class Codechef {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        if (t >= 1 && t <= 100) {
            String[] results = new String[t];
            
            for (int caseIndex = 0; caseIndex < t; caseIndex++) {
                int n = sc.nextInt();
                results[caseIndex] = processNumber(n);
            }
            
            for (int i = 0; i < t; i++) {
                System.out.println("Case #" + (i + 1) + ":" + results[i]);
            }
        }
    }
    
    static String processNumber(int n) {
        StringBuilder result = new StringBuilder();
        int digitsCount = countDigits(n);
        
        while (n != 0) {
            int ld = n % 10;
            if (ld != 0) {
                int counter = 0;
                for (int i = 2; i < digitsCount; i++) {
                    int q = n % (int) Math.pow(10, i);
                    if (q == ld) {
                        counter++;
                    } else {
                        break;
                    }
                }
                
                if (counter > 0) {
                    int a = n % (int) Math.pow(10, counter + 1);
                    StringBuilder lt = new StringBuilder();
                    StringBuilder rt = new StringBuilder();
                    for (int i = 0; i < ld; i++) {
                        lt.insert(0, ")");
                        rt.append("(");
                    }
                    result.insert(0, lt + String.valueOf(a) + rt);
                    n /= (int) Math.pow(10, counter + 1);
                } else {
                    result.insert(0, "(" + ld + ")");
                    n /= 10;
                }
            } else {
                result.insert(0, ld);
                n /= 10;
            }
        }
        
        return result.toString();
    }
    
    static int countDigits(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n /= 10;
        }
        return count;
    }
}