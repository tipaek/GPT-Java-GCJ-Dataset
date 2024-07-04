import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sin = new Scanner(System.in);
        int tcases = sin.nextInt();
        for(int k = 0; k < tcases; k++){
            String inp = sin.next();
            StringBuffer outr = new StringBuffer();
            for(int i = 0; i < inp.length(); i++){
                int tchar = inp.charAt(i);
                tchar-=48;
                for(int j = 0; j < tchar; j++){
                    char cr=40;
                    outr.append(cr);
                }
                outr.append(tchar);
                for(int j = 0; j < tchar; j++){
                    char cr=41;
                    outr.append(cr);
                }
            }
            System.out.println("Case #"+(k+1)+": "+outr.toString());
        }
    }
}
