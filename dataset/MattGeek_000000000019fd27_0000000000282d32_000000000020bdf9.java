import java.util.HashMap;
import java.util.Scanner;

/**
 * @author Mattia D'ambrosio
 * Created on 04/04/2020.
 */
public class Solution {
    static class Kid{
        private HashMap<Integer, Boolean> agenda;

        public Kid() {
            this.agenda = new HashMap<>();
            init();
        }

        private void init(){
            for (int i = 0; i < 1441; i++) {
                this.agenda.put(i, true);
            }
        }

        public boolean isFree(int start, int end){
            for (int i = start; i <= end ; i++)
                if(!this.agenda.get(i))
                    return false;

            return true;
        }

        public void scheduleActivity(int start, int end){
            for (int i = start; i < end ; i++)
                this.agenda.put(i, false);
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        byte testCases = scanner.nextByte();

        for (byte i = 1; i <= testCases; i++) {
            StringBuilder out = new StringBuilder();
            Kid Cameron = new Kid();
            Kid James = new Kid();
            boolean possible = true;

            int activities = scanner.nextInt();
            scanner.nextLine();

            for (int j = 0; j < activities; j++) {
                String[] x = scanner.nextLine().split(" ");
                int start = Integer.parseInt(x[0]);
                int end = Integer.parseInt(x[1]);

                if(Cameron.isFree(start, end)){
                    Cameron.scheduleActivity(start, end);
                    out.append('C');
                } else if(James.isFree(start, end)){
                    James.scheduleActivity(start,end);
                    out.append('J');
                } else{
                    possible = false;
                    scanner.reset();
                    break;
                }
            }

            String r;

            if(possible)
                r = out.toString();
            else
                r = "IMPOSSIBLE";

            System.out.println("Case #"+i+": "+r);
        }
    }
}
