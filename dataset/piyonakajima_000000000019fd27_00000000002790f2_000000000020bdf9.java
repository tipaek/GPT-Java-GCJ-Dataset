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
        int i=0;
        while(i<actNum){
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
            if((false == cameronCanDo)&&(false == jamieCanDo)){
                result = "IMPOSSIBLE";
                break;
            }else if(cameronCanDo == true){
                cameronActArray.add(actArray.get(i));
                result += "C";
            }else if(jamieCanDo == true){
                jamieActArray.add(actArray.get(i));
                result += "J";
            }else{
                result = "IMPOSSIBLE";
                break;
            }
            i++;
        }
        println("Case #"+ quizId +": "+result);

    }

    public static boolean isInsertable(Activity insert,Activity already){
        //println("isInsertable? already["+ 
        //    already.startTime +  ","+already.endTime +"]"+
        //    " vs. insert[" + insert.startTime + ","+ insert.endTime + "]");
        if((insert.endTime > already.startTime) && (already.endTime > insert.startTime)){
            return false;
        }else{
            return true;
        }
        /*
        if((insert.endTime <= already.startTime) || (already.endTime <= insert.startTime)){
        //    println("-> true");
            return true;
        }else{
        //    println("-> false");
            return false;
        }
        */
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
