
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.HashSet;

public class Solution {
    static int test_case=1;
    public static void main(String[] args) {
        Scanner in = createScanner();
        int t = in.nextInt();
        ArrayList<timeSlot> schedule= new ArrayList<>();

	    for(int i=0; i<t; ++i){
	        int num_slots = in.nextInt();
            for(int j=0;j<num_slots;++j){
                int beg = in.nextInt();
                int end = in.nextInt();
                timeSlot slot = new timeSlot(beg,end);
                schedule.add(slot);
            }
            calender cal = new calender();
            cal.solve(schedule,test_case++);
            schedule.clear();
        }
    }

    public static Scanner createScanner(){
        return new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    }

}
class timeSlot{
     int begin;
     int end;
     timeSlot(int be, int en){
         begin = be;
         end = en;
     }



}

class calender{
     String casy = "C";
     String jamie = "J";

    //IF STARTING TIME IS NOT LESS THAN ANYTHINGS ENDING TIME and greater than its staring time
    //arr[i].beg > = arr[x].end
    public void solve(ArrayList<timeSlot> schedule,int test_case) {
        StringBuilder duties = new StringBuilder();
        ArrayList<timeSlot> cSchedule= new ArrayList<>();
        ArrayList<timeSlot> jSchedule= new ArrayList<>();


        for(int i=0; i<schedule.size();++i){
            if(casyFree(cSchedule,schedule.get(i))){
                duties.append(casy);
                cSchedule.add(new timeSlot(schedule.get(i).begin,schedule.get(i).end));
            }
            else if(jamieFree(jSchedule,schedule.get(i))){
                duties.append(jamie);
                jSchedule.add(new timeSlot(schedule.get(i).begin,schedule.get(i).end));
            }
            else{
                System.out.println("Case #" + test_case + ": IMPOSSIBLE"  );
                return;
            }

        }
        System.out.println("Case #" + test_case + ": " + duties.toString() );

    }
    public boolean jamieFree(ArrayList<timeSlot> jSchedule,timeSlot time) {
        for (int i = 0; i < jSchedule.size(); ++i) {
            if ( (time.begin < jSchedule.get(i).end && time.begin > jSchedule.get(i).begin) || (time.end < jSchedule.get(i).end && time.end > jSchedule.get(i).begin) ){
                return false;
            }
        }
         return true;
    }
    public boolean casyFree(ArrayList<timeSlot> cSchedule,timeSlot time) {
        for (int i = 0; i < cSchedule.size(); ++i) {
            if ( (time.begin < cSchedule.get(i).end && time.begin > cSchedule.get(i).begin) || (time.end < cSchedule.get(i).end && time.end > cSchedule.get(i).begin) ){
                return false;
            }
        }
        return true;
    }
}