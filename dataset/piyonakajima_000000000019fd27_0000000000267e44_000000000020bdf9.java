import java.util.Scanner;
import java.util.ArrayList;

public class Solution {
    public static Scanner sc;
    public static void main(String[] args){
        sc = new Scanner(System.in);
        int quizNumber = sc.nextInt(); // quiz number
        for(int i=0;i<quizNumber;i++){
            int actNum = sc.nextInt();
            solveTasks(i+1,actNum);
            /*
            int[][] taskTable = new int[taskNumber][2];
            int[][] cTable = new int[taskNumber][2];
            int[][] jTable = new int[taskNumber][2];

            for(int j=0;j<taskNumber;j++){
                taskTable[j][0] = sc.nextInt();
                taskTable[j][1] = sc.nextInt();
                cTable[j][0]=-1;
                cTable[j][1]=-1;
                jTable[j][0]=-1;
                jTable[j][1]=-1;
                
            }
            result ="";
            for(int j=0;j<taskNumber;j++){

                int startTime  = taskTable[j][0];
                int endTime = taskTable[j][1];
                //println(startTime + "to" + endTime);
                boolean cCanDo = true;
                boolean jCanDo = true;
                for(int k=0;k<taskNumber;k++){
                    if((cTable[k][0] <= startTime && startTime < cTable[k][1])
                    ||
                    (cTable[k][0] < endTime && endTime <= cTable[k][1])
                    ||
                    (startTime <= cTable[k][0] && cTable[k][1] <= endTime) ){
                        //set flag c cant this task
                        cCanDo = false;
                    }
                    if((jTable[k][0] <= startTime && startTime < jTable[k][1])
                    ||
                    (jTable[k][0] < endTime && endTime <= jTable[k][1])
                    ||
                    (startTime <= jTable[k][0] && jTable[k][1] <= endTime)){
                        //set flag c cant this task
                        jCanDo = false;
                    }
                }
                pt = 0;
                if(cCanDo == true){
                    result += "C";
                    for(int m=0;m<taskNumber;m++){
                        if(cTable[m][0] == -1){
                            pt = m;
                        }
                    }
                    cTable[pt][0] = startTime;
                    cTable[pt][1] = endTime;
                    pt = 0;
                }else if(jCanDo == true){
                    result += "J";
                    for(int m=0;m<taskNumber;m++){
                        if(jTable[m][0] == -1){
                            pt = m;
                        }
                    }
                    jTable[pt][0] = startTime;
                    jTable[pt][1] = endTime;
                    pt = 0;
                }else{//c&j cant do 
                    result = "IMPOSSIBLE";
                    j += 10000;
                }
            }
            */
            //println("Case #"+(i+1)+": "+ result);
            //result ="";
        }
    }
    public static void solveTasks(int quizId,int actNum){

        String result = "";
        ArrayList<Activity> actArray = new ArrayList<Activity>(); 
        for(int i=0; i<actNum; i++){
            int startTime = sc.nextInt();
            int endTime = sc.nextInt();
            Activity act = new Activity(startTime,endTime); 
            actArray.add(act);
        }
        ArrayList<Activity> jamieActArray = new ArrayList<Activity>();
        ArrayList<Activity> cameronActArray = new ArrayList<Activity>();
        for(int i=0;i<actNum;i++){
            Boolean jamieCanDo = true;
            Boolean cameronCanDo = true;    
            // i want to insert activity
            Activity insertAct = actArray.get(i);            
            int j=0;
            //CameronCheck
            while(j<cameronActArray.size()){
                cameronCanDo = cameronCanDo && isInsertable(insertAct,cameronActArray.get(j));
                j++;
            }

            j=0;
            //JamieCheck
            while(j<jamieActArray.size()){
                jamieCanDo = jamieCanDo && isInsertable(insertAct,jamieActArray.get(j));
                j++;
            }

            //println(jamieCanDo + " " + cameronCanDo);
            if(cameronCanDo == true){
                cameronActArray.add(actArray.get(i));
                result += "C";
            }else if(jamieCanDo == true){
                jamieActArray.add(actArray.get(i));
                result += "J";
            }else{
                result = "IMPOSSIBLE";
                actNum=0;
            }
        }
        println("Case #"+ quizId +": "+result);

    }

    public static boolean isInsertable(Activity insert,Activity already){
        //println("isInsertable? already["+ 
        //    already.startTime +  ","+already.endTime +"]"+
        //    " vs. insert[" + insert.startTime + ","+ insert.endTime + "]");
        if((insert.endTime <= already.startTime) || (already.endTime <= insert.startTime)){
        //    println("-> true");
            return true;
        }else{
        //    println("-> false");
            return false;
        }
    }

    public static void println(String str){
        System.out.println(str);
    }
}

class Activity{
    public int startTime = 0;
    public int endTime = 0;
    public Activity(){
        startTime = 0;
        endTime = 0;
    }
    public Activity(int start,int end){
        startTime = start;
        endTime = end;
    }
}
