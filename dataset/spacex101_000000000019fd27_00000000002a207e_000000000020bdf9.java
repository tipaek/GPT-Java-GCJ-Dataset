import java.util.*;
import java.io.*;

public class Solution {
    static Scanner scanner;
    public static void main(String[] args) {
        scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tests = scanner.nextInt();

        for(int i = 0; i <tests; i++){
            String schedule = "";
            int n = scanner.nextInt();
            People C = new People(n);
            People J = new People(n);
            int cIndex = 0;
            int jIndex = 0;
            boolean canScheduleC = true;
            boolean canScheduleJ = true;

            Timezones times[]= new Timezones[n];
            for(int j = 0; j< times.length;j++){
                times[0] = new Timezones();
            }
            for(int j = 0; j < times.length; j++){
                times[j].beginning = scanner.nextInt();
                times[j].end = scanner.nextInt();
            }
            for(int j = 0; j< times.length;j++){
                C.personSchedule[j] = new Timezones();
            }
            for(int j = 0; j< times.length;j++){
                J.personSchedule[j] = new Timezones();
            }

            C.personSchedule[0].beginning = times[0].beginning;
            C.personSchedule[0].end = times[0].end;
            schedule+="C";

            System.out.println(1);
            System.out.println(times.length);
            for(int j = 1; j < times.length; j++){
                System.out.println(2);
                for(int k = 0;k < C.personSchedule.length; k++){
                    if(times[j].beginning>=C.personSchedule[k].end){
                    
                    }
                    else if(times[j].beginning<=C.personSchedule[k].end && times[j].beginning>=C.personSchedule[k].beginning){
                        canScheduleC = false;
                    }
                    else if(times[j].beginning<=C.personSchedule[k].end && times[j].end>=C.personSchedule[k].end){
                        canScheduleC = false;
                    }
                    else if(times[j].beginning>=C.personSchedule[k].end && times[j].end<=C.personSchedule[k].end){
                        canScheduleC = false;
                    }
                    else if(times[j].end<=C.personSchedule[k].beginning){
                    }
                }
                if (canScheduleC = false){
                    for(int k = 0;k < J.personSchedule.length; k++){
                        if(times[j].beginning>J.personSchedule[k].end){
                        
                        }
                        else if(times[j].beginning<J.personSchedule[k].end && times[j].beginning>J.personSchedule[k].beginning){
                            canScheduleC = false;
                        }
                        else if(times[j].beginning<J.personSchedule[k].end && times[j].end>J.personSchedule[k].end){
                            canScheduleC = false;
                        }
                        else if(times[j].beginning>J.personSchedule[k].end && times[j].end<J.personSchedule[k].end){
                            canScheduleC = false;
                        }
                        else if(times[j].end<J.personSchedule[k].beginning){
                        }
                    }
                }
                if (canScheduleC == true){
                    C.personSchedule[cIndex].beginning = times[j].beginning;
                    C.personSchedule[cIndex].end = times[j].end;
                    schedule +="C";
                }
                else if (canScheduleJ == true){
                    J.personSchedule[jIndex].beginning = times[j].beginning;
                    C.personSchedule[jIndex].end = times[j].end;
                    schedule +="J";
                }
                else if(canScheduleC == false && canScheduleJ == false){
                    schedule = "IMPOSSIBLE";
                }
                else{
                    schedule = "IMPOSSIBLE";
                }
                System.out.println("Case #" + (j+1)+": " +schedule);
            }
        }
    }
}
class Timezones{
    int beginning;
    int end;
    public Timezones(){
    }
}

class People{
    Timezones timezones;
    Timezones personSchedule[];
    int n;
    // Scanner scanner;

    public People(int n){
        // scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        this.n = n;
        personSchedule = new Timezones[n];
        // for(int i = 0; i < personSchedule.length; i++){
        //     personSchedule[i].beginning = scanner.nextInt();
        //     personSchedule[i].end = scanner.nextInt();
        // }
    }

}