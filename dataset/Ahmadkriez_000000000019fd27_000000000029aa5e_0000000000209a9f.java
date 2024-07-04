import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        //File inFile = new File("input.in");
        //Scanner sc = new Scanner(inFile);

        //ArrayList<Character> aList = new ArrayList<Character>();

        int T = sc.nextInt();
        String N = "";
        

        int dig;

        for (int t = 1; t <= T; t++) {
            N = sc.next();
            int lDig = 0;
            int rDig = 0;
            String y = "";
            for (int i = 0; i < N.length(); i++) {
                dig = Integer.parseInt(N.charAt(i) + "");
                
                if(i == 0){
                    for (int j = 1; j <= dig; j++) {
                        y = y + '(';
                    }
                }else{
                    
                    dig = dig - Integer.parseInt(N.charAt(i-1) + "");
                    for (int j = 1; j <= dig; j++) {
                        y = y + '(';
                    }
                }
                
                
                y = y + N.charAt(i);
                dig = Integer.parseInt(N.charAt(i) + "");

                if (i == N.length() - 1) {
                    for (int j = 1; j <= dig; j++) {
                        y = y + ')';
                    }
                }else{
                    
                    dig = dig - Integer.parseInt(N.charAt(i+1) + "");
                    for (int j = 1; j <= dig; j++) {
                        y = y + ')';
                    }
                }
                

                
            }
            
            
            System.out.printf("Case #%d: %s\n",t,y);
        }

        sc.close();
    }
}