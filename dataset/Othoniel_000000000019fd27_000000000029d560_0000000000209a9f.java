import java.util.*;

public class Solution {

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        input.nextLine();
        String s;
        StringBuilder sPrima;
        int numAnt;
        int numAct;
        for (int x = 1; x <= T; x++) {
            s = input.nextLine();
            sPrima = new StringBuilder();
            numAnt = 0;
            for (int i = 0; i < s.length(); i++){
                numAct = Integer.parseInt(Character.toString(s.charAt(i)));
                if (numAnt < numAct){
                    for (int j = 0; j < numAct - numAnt; j++){
                        sPrima.append('(');
                    }

                }
                if (numAnt > numAct){
                    for (int j = 0; j < numAnt - numAct; j++){
                        sPrima.append(')');
                    }
                }
                sPrima.append(numAct);
                numAnt = numAct;
            }
            for (int j = 0; j < numAnt; j++){
                sPrima.append(')');
            }
            System.out.println(String.format("Case #%s: %s", x, sPrima.toString()));
        }
    }
}
