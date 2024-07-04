import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
class Solution {

    public static void main(String[] args)throws Exception 
    { 
      Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    //   Scanner sc = new Scanner(new FileReader(new File("test.txt")));
      
      int n = sc.nextInt();
      boolean[][] arr = new boolean[26][11];
      
      for (int index = 1; index <= n; index++) {
            for (int a = 0; a < 26; ++a) {
                for (int b =0; b < 11; ++b){
                    arr[a][b] = true;
                }
            }
            int u = sc.nextInt();
            for (int i = 0; i < 10000; ++i) {
                int m = sc.nextInt();
                String r = sc.next();
                
                int sizeM = 0;
                int newM = m;
                while (newM > 0) {
                    newM /= 10;
                    sizeM++;
                }
                if (sizeM != r.length()) continue;
                newM = m;
                boolean isConHopLe = true;
                for (int j = 0; j < r.length(); ++j) {
                    int curM = sizeM > 1 ? (m / (10 * (sizeM-1))) : m;
                    if (sizeM > 1) 
                    m = m % (10 * (sizeM-1));
                    sizeM--;
                    char curR = r.charAt(j);
                    arr[curR-'A'][10] = false;

                    if (isConHopLe) {
                        for (int k=0; k <= curM; k++) {
                            if (k == 0 && j == 0) {
                                arr[curR-'A'][k] = false;
                            }
                        }
                        for (int k=curM+1; k <= 9; k++) {
                            arr[curR-'A'][k] = false;
                        }
                    }
                    
                    if ( (j == 0 && curM != 1) || curM != 0) isConHopLe = false;
                }
            }

            StringBuilder res = new StringBuilder("0123456789");
            for (int a = 0; a < 26; ++a) {
                if (arr[a][10] == false) {
                    int b = 9;
                    if (arr[a][0] == true) b = 0;
                    while (arr[a][b] == false) b--;
                    res.setCharAt(b, (char)('A' + a));
                }
            }
            
            System.out.println("Case #" + index + ": " + res.toString());
        }
    }
}