import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args){
        String result = "";
        int pt = -1;
        Scanner sc = new Scanner(System.in);
        int quizNumber = sc.nextInt(); // quiz number
        for(int i=0;i<quizNumber;i++){
            int taskNumber = sc.nextInt();
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

                if(cCanDo == true){
                    result += "C";
                    for(int m=0;m<taskNumber;m++){
                        if(cTable[m][0] == -1){
                            pt = m;
                        }
                    }
                    cTable[pt][0] = startTime;
                    cTable[pt][1] = endTime;
                }else if(jCanDo == true){
                    result += "J";
                    for(int m=0;m<taskNumber;m++){
                        if(jTable[m][0] == -1){
                            pt = m;
                        }
                    }
                    jTable[pt][0] = startTime;
                    jTable[pt][1] = endTime;
                }else{//c&j cant do 
                    result = "IMPOSSIBLE";
                    j += 10000;
                }
            }

            println("Case #"+(i+1)+": "+ result);
            result ="";
        }
    }

    public static void println(String str){
        System.out.println(str);
    }

}