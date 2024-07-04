import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int numOfCases = in.nextInt();
        int current_c = 1;


        while(in.hasNextInt()) {
            int numOfActs = in.nextInt();

            boolean impossibleSwitch = false;
            char[] outChar = new char[1000]; // MAX NUM

            List<Tasks> tasksList = new ArrayList<Tasks>();
            List<Tasks> orderedTasksList = new ArrayList<Tasks>();


            List<Tasks> c_tasksList = new ArrayList<Tasks>();
            List<Tasks> j_tasksList = new ArrayList<Tasks>();

            //Read Tasks
            for (int i = 0; i < numOfActs ; i++){
                int startingTime = in.nextInt();
                int endTime = in.nextInt();

                Tasks t = new Tasks(startingTime,endTime,i,'u');
                tasksList.add(t);
            }

            //int tasksSize = tasksList.size();
            // Tasks ordering ...

            orderedTasksList = tasksList;

            for (int i = 0; i < orderedTasksList.size(); i++) {
                for (int j= 0; j < orderedTasksList.size() -1 ; j++) {
                    if (orderedTasksList.get(j).startingTime > orderedTasksList.get(j+1).startingTime)
                    {
                        Collections.swap(orderedTasksList, j,j+1);
                    }
                }
            }

            int j_currentWorkEnding = 0;
            int c_currentWorkEnding = 0;

            //Task assgining ...
            for (Tasks t : orderedTasksList) {

                //both are empty >> assign to C
                if (c_tasksList.size() ==0  && j_tasksList.size() ==0) {
                    t.assigned = 'C';
                    c_tasksList.add(t);
                    c_currentWorkEnding = t.endTime;
                }

                // only J empty
                else if (c_tasksList.size() != 0 && j_tasksList.size() == 0){
                    t.assigned = 'J';
                    j_tasksList.add(t);
                    j_currentWorkEnding = t.endTime;
                }

                // only C empty
                else if (j_tasksList.size() != 0 && c_tasksList.size() == 0){
                    t.assigned='C';
                    c_tasksList.add(t);
                    c_currentWorkEnding = t.endTime;
                }


                //only C possible
                else if ( j_currentWorkEnding > t.startingTime && c_currentWorkEnding <= t.startingTime ){
                    t.assigned='C';
                    c_tasksList.add(t);
                    c_currentWorkEnding = t.endTime;
                }

                //only J possible
                else if ( c_currentWorkEnding > t.startingTime && j_currentWorkEnding <= t.startingTime ){
                    t.assigned='J';
                    j_tasksList.add(t);
                    outChar[t.taskNum] = 'J';
                    j_currentWorkEnding = t.endTime;
                }

                //both possible >> assign to J
                else if ( c_currentWorkEnding <= t.startingTime && j_currentWorkEnding <= t.startingTime ){

                    //if c ends early
                    if (c_currentWorkEnding < j_currentWorkEnding ){
                        t.assigned='C';
                        c_tasksList.add(t);
                        outChar[t.taskNum] = 'C';
                        c_currentWorkEnding = t.endTime;
                    }
                    else {
                        t.assigned='J';
                        j_tasksList.add(t);
                        outChar[t.taskNum] = 'J';
                        j_currentWorkEnding = t.endTime;
                    }
                }

                //both impossible
                else {
                    impossibleSwitch = true;
                    break;
                }

            }

            if (impossibleSwitch == true){
                System.out.println("Case #" + current_c + ": IMPOSSIBLE");
            }

            else {
                StringBuilder builder = new StringBuilder();

                for (int i = 0 ; i < tasksList.size(); i++) {
                    for (Tasks t : tasksList) {
                        if (t.taskNum == i)
                            builder.append(t.assigned);
                    }
                }

                String outputString = builder.toString();

                System.out.println("Case #" + current_c + ": " + outputString);
            }

            current_c++;
        }

    }
}

class Tasks {
    int startingTime;
    int endTime;
    int taskNum;
    char assigned;

    public Tasks(int startingTime, int endTime, int taskNum, char assigned) {
        this.startingTime = startingTime;
        this.endTime = endTime;
        this.taskNum = taskNum;
        this.assigned = assigned;
    }
}
