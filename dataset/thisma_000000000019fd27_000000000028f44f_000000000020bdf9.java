import java.util.ArrayList;
import java .util.Scanner;

public class Solution {
    public static void main(String[] args) {
        readLineParseIntArray();
    }

    public static void readLineParseIntArray() {
        int activitiesIndex = 0;

        Scanner scan = new Scanner(System.in);
        int testCases = scan.nextInt();
        for (int i = 0; i<testCases; i++){

            int activitiesN = scan.nextInt();
            schedule[] fullSchedulesEntries = new schedule[activitiesN];
            boolean impossible = false;
            timeTable cameron = new timeTable();
            timeTable james = new timeTable();

            for (int j = 0; j<activitiesN; j++) {
                int start = scan.nextInt();
                int end = scan.nextInt();
                schedule sc = new schedule(start, end);
                fullSchedulesEntries[j] = sc;


                if (cameron.clashWithTimeTable(sc)) {
                    if (james.clashWithTimeTable(sc)) {
                        impossible = true;
                    } else {
                        james.addToTimeTable(sc);
                        sc.addName("J");
                    }
                } else {
                    cameron.addToTimeTable(sc);
                    sc.addName("C");
                }

            }
            String outputString ="";
            if (impossible){
                outputString = "IMPOSSIBLE";
            }
            else{

                for (schedule sc: fullSchedulesEntries){
                    outputString+=sc.getName();
                }
            }
            System.out.println("Case #"+(i+1)+": "+outputString);

        }
    }

}
class schedule {
    private int start;
    private int end;
    private String nameTaker;
    public schedule(int minStart, int minEnd){
        this.nameTaker="";
        this.end = minEnd;
        this.start=minStart;
    }

    public boolean clashSchedules(schedule s){
        return (s.end>this.start && s.end<this.end) || (s.start>this.start && s.start<this.end)
                || (s.start <= this.start && s.end>= this.end);
    }

    //could use an enum instead of name so its either J or C but w/e
    public void addName(String name){
        this.nameTaker=name;
    }

    public String getName(){
        return this.nameTaker;
    }
}

class timeTable {
    private ArrayList<schedule> scheduleList;

    public timeTable(){
        this.scheduleList = new ArrayList<schedule>();
    }

    public void addToTimeTable(schedule s){
        this.scheduleList.add(s);
    }

    public boolean clashWithTimeTable(schedule s){
        for (int i = 0; i<scheduleList.size(); i++){
            if (scheduleList.get(i).clashSchedules(s)) {
                return true;
            }
        }
        return false;
    }
}


