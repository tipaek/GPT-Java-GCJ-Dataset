import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner io = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testcases = io.nextInt();
        io.nextLine();
        for (int i = 1; i <= testcases; i++) {
            String s = io.nextLine();
            String[] streng = s.split("");
            int para = 0;
            String answer = "Case #" + i + ": ";
            int paraDuMåskrive = 0;
            int paraDuMåTaBort=0;
            for (int j = 0; j < s.length(); j++) {
                int thisInt = Integer.parseInt(streng[j]);
                if (para == thisInt) {
                    answer =answer+thisInt;
                    continue;
                } else if (para < thisInt) {
                    paraDuMåskrive = thisInt - para;
                    String parant = "";
                    while (paraDuMåskrive != 0) {
                        parant = parant + "(";
                        paraDuMåskrive--;
                        para++;
                    }
                    answer = answer + parant + thisInt;
                }else if(para>thisInt){
                    paraDuMåTaBort=para-thisInt;
                    String lukkeParant="";
                    while (paraDuMåTaBort!=0){
                        lukkeParant =lukkeParant+")";
                        paraDuMåTaBort--;
                        para--;
                    }
                    answer= answer+lukkeParant+thisInt;
                }
            }
            while (para!=0){
                answer = answer+")";
                para--;
            }
            System.out.println(answer);
        }
    }
}
