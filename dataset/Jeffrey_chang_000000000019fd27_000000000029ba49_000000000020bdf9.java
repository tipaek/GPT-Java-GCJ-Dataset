import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class Solution {
    
    static String TestC(int J, Scanner scan){
        String[] end = new String[J];  
        ArrayList<Integer> tempC = new ArrayList<>();     
        ArrayList<Integer> tempJ = new ArrayList<>();     
        int[] chores = new int[2 * J];                    
        int check = 0;  

        for (int i = 0; i < 2 * J; i++) {
            chores[i] = scan.nextInt();
        }

        for (int i = 0; i < J; i++) { 

            for (int K = 0; K < tempC.size(); K += 2) {
                
                if ( tempC.get(K) >= chores[2*i + 1] || tempC.get(K + 1) <= chores[2*i] ){
                    continue;
                }
                    for (int K2 = 0; K2 < tempJ.size(); K2 += 2) {
                        if ( tempJ.get(K2) >= chores[2*i + 1] || tempJ.get(K2 + 1) <= chores[2*i]){
                            continue;
                        }
                        return "IMPOSSIBLE";
                    }
                    tempJ.add(chores[2*i]);
                    tempJ.add(chores[2*i + 1]);

                    end[i] = "J";
                    check++;
                    break;

            }
            if(check > 0){
                check = 0;
                continue;
            }

            tempC.add(chores[2*i]);
            tempC.add(chores[2*i + 1]);
            end[i] = "C";
        }

        StringBuffer sb = new StringBuffer();  
        for (int i = 0; i < end.length; i++) {
            sb.append(end[i]);
        }
        String str = sb.toString();

        return str;
    }


    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int X = 1; 

        for (int i = 0; i < N; i++) {
            int J = scan.nextInt();


            System.out.println("Case #" + X + ":  " + TestC(J, scan));  
            X++;
        }

        scan.close();

        }

}
