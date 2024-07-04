import java.util.*;


public class Solution {
    
    static Scanner SCNR = new Scanner(System.in);
    
    static String method1(int B) {
        
        int [] arr = new int [B+1];
        int i, j;
        int match1 = -1;
        int dif1 = -1;
        int q = 0;
        int temp;
        
        for (i = 1; i <= B/2; ++i) {
            
            
            
            if (q > 0 && q % 10 == 0) {
                
                if (match1 > -1) {
                    System.out.printf("%d\n", match1);
                    temp = SCNR.nextInt();
                    ++q;
                    
                    if (arr[match1] != temp) {
                        for (j = 1; j < i; ++j) {
                            arr[j] ^= 1;
                            arr[B-j+1] ^= 1;
                        }
                    }
                    
                }
                
                if (dif1 > -1) {
                    System.out.printf("%d\n", dif1);
                    temp = SCNR.nextInt();
                    ++q;
                    
                    if (arr[dif1] != temp) {
                        for (j = 1; j < i; ++j) {
                            temp = arr[j];
                            arr[j] = arr[B-j+1];
                            arr[B-j+1] = temp;
                        }
                    }
                    
                }
                
                if (q % 2 == 1) {
                    System.out.printf("%d\n", 1);
                    temp = SCNR.nextInt();
                }
                
                
            }
            
            
            
            System.out.printf("%d\n", i);
            arr[i] = SCNR.nextInt();
            
            System.out.printf("%d\n", B - i + 1);
            arr[B - i + 1] = SCNR.nextInt();
            
            if (match1 < 0 && arr[i] == arr[B-i+1]) {
                match1 = i;
            }
            
            else if (dif1 < 0 && arr[i] != arr[B-i+1]) {
                dif1 = i;
            }
            
            ++q;
            ++q;
            
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (i = 1; i <= B; ++i) {
            sb.append(arr[i]);
        }

        
        return sb.toString();
    }
    
    
    public static void main (String [] args) {
        
        
        int T = SCNR.nextInt();
        int B = SCNR.nextInt();
        String R;
        int i;
        String num;
        
        for (i = 1; i <= T; ++i) {
            
            num = method1(B);
            System.out.printf("%s\n", num);
            R = SCNR.next();
            if (R.equals("N")) {
                System.exit(0);
            }
        }
        
        SCNR.close();
    }
}