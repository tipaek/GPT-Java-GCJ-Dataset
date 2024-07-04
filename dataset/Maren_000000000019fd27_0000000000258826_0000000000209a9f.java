import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner io = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testcases = io.nextInt();
        io.nextLine();
        for (int i = 1; i <= testcases; i++) {
            String s = io.nextLine();
            String[] streng = s.split("");
            int para = 0;
            String answer = "Case #" + i + ": ";
            int skrive = 0;
            int taBort=0;
            for (int j = 0; j < s.length(); j++) {
                int thisInt = Integer.parseInt(streng[j]);
                if (para == thisInt) {
                    answer =answer+thisInt;
                    continue;
                } else if (para < thisInt) {
                    skrive = thisInt - para;
                    String parant = "";
                    while (skrive != 0) {
                        parant = parant + "(";
                        skrive--;
                        para++;
                    }
                    answer = answer + parant + thisInt;
                }else if(para>thisInt){
                    taBort=para-thisInt;
                    String lukkeParant="";
                    while (taBort!=0){
                        lukkeParant =lukkeParant+")";
                        taBort--;
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
