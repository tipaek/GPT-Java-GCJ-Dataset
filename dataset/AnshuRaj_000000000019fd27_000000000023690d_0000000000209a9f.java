
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int testCases = scn.nextInt();
        for(int i=0;i<testCases;i++){
            String problemD = scn.next();
            getSol((i+1),problemD);
        }
    }
    static void getSol(int testCaseN,String data){
        int OPEN_P=0;
        String SOL="";
        for(int i=0;i<data.length();i++){
            int curI = (data.charAt(i)-48);
            if(curI > OPEN_P){
                while(OPEN_P!=curI){
                    OPEN_P++;
                    SOL+="(";
                }
            }else if(curI < OPEN_P){
                while(OPEN_P!=curI){
                    OPEN_P--;
                    SOL+=")";
                }
            }
            SOL+=String.valueOf(curI);
        }
        while(OPEN_P>0){
            OPEN_P--;
            SOL+=")";
        }
        System.out.println("Case #"+testCaseN+": "+SOL);
    }
}