import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    private boolean islastTestCase=false;
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int cases = 1; cases <= testCases; cases++) {
            int timingList = scanner.nextInt();
            List<Timing> cameron = new ArrayList<>();
            List<Timing> jamie = new ArrayList<>();
            boolean shouldContinue=false;
            StringBuilder answer =new StringBuilder();
            for (int timing = 0; timing < timingList; timing++) {
                String input = scanner.nextLine();
                if (input.equals("")) {
                    timing--;
                    continue;
                }
                if(shouldContinue){
                    continue;
                }
                String inp[] = input.split(" ");
                Timing time=new Timing(Integer.parseInt(inp[0]), Integer.parseInt(inp[1]));
                if(!isOccupied(cameron,time)){
                    cameron.add(time);
                    answer.append("C");
                }else if(!isOccupied(jamie,time)){
                    jamie.add(time);
                    answer.append("J");
                }else{
                    shouldContinue=true;
                    answer=new StringBuilder();
                    answer.append("IMPOSSIBLE");
                }

            }
            System.out.println("Case #"+cases+": "+answer.toString());


        }
    }

    private static boolean isOccupied(List<Timing> list, Timing time) {
        boolean isOccupied = false;
        for (Timing item : list) {
            if (
                    (time.getStartTime() > item.getStartTime() && time.getStartTime() < item.getEndTime())
                    || (time.getEndTime() > item.getStartTime() && time.getEndTime() < item.getEndTime())
                    ||  (item.getEndTime() > time.getStartTime() && item.getEndTime() < time.getEndTime())
                    || item.getStartTime()==time.getStartTime() && item.getEndTime()==time.getEndTime()
            ) {
                isOccupied=true;
            }
        }
        return isOccupied;
    }

}

class Timing {
    private int startTime;
    private int endTime;

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public Timing(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
