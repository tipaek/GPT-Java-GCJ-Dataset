import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;




public class Solution {

    public static class Tuple {
        private short r1, r2;
        public Tuple(short x, short y) {
            this.r1 = x;
            this.r2 = y;
        }

        public short getX(){
            return this.r1;
        }
        public short getY(){
            return this.r2;
        }
    }

    public static boolean isActorAvailable(List<Tuple> hours, Tuple newHour){
        if (hours.isEmpty()) {
            return true;
        }
        for (Tuple hour : hours) {
//            if (hour.getX() <= newHour.getX() && hour.getY() >= newHour.getY()){
//                // Then there is overlap
//                return false;
//            }
            if (newHour.getX() < hour.getY() && newHour.getX() >= hour.getX())
                return false;
            if (newHour.getY() > hour.getX() && newHour.getY() <= hour.getY())
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        short testSize = scan.nextShort();
        scan.nextLine();
        short numActivities = -1;
//        System.out.println(testSize);
        for (short i=1; i<testSize+1; i++) {
            numActivities = scan.nextShort();
            scan.nextLine();
            String out = "";
            List<Tuple> jamie = new ArrayList<>();
            List<Tuple> cameron = new ArrayList<>();
            for (short j=0; j<numActivities; j++){
                String[] inp = scan.nextLine().split(" ");
                try {
                    Tuple newHour = new Tuple(Short.parseShort(inp[0]), Short.parseShort(inp[1]));
                    if (isActorAvailable(jamie, newHour)){
                        jamie.add(newHour);
                        out += "J";
                        continue;
                    }
                    if (isActorAvailable(cameron, newHour)) {
                        cameron.add(newHour);
                        out += "C";
                        continue;
                    }
                    out = "IMPOSSIBLE";
                    break;
                } catch (NumberFormatException e){
                    out = "";
                    break;
                }
            }
            System.out.println("Case #" + i + ": " + out);
        }
    }
}
