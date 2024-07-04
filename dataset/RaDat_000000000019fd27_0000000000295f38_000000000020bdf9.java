
import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        in.nextLine();
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int timetable[][]=new int[n][2];
            int cp[][]=new int[n][2];
            int jp[][]=new int[n][2];
            for (int j = 0; j < n; ++j) {
                int num1=in.nextInt(),num2=in.nextInt();
                        timetable[j][0] = num1;
                        timetable[j][1] = num2;
            }
            int cpcounter=0;
            for (int j = 0; j < n; ++j) {
                if(j==0){
                    cp[j][0]=timetable[j][0];
                    cp[j][1]=timetable[j][1];
                    cpcounter++;
                }else {
                    for (int k = 0; k < j;k++){
                        if((timetable[j][0]>=cp[k][0] && timetable[j][0]< cp[k][1]) || (timetable[j][1]>=cp[k][0] && timetable[j][1]< cp[k][1])){
                           break;
                        }
                        if(k+1==j){
                            cp[j][0]=timetable[j][0];
                            cp[j][1]=timetable[j][1];
                            cpcounter++;
                        }
                    }
                }
            }
            int jpcounter=0;
            for (int j = 0; j < n; ++j) {
                if(cp[j][0]==0&&cp[j][1]==0) {
                    for (int k = 0; k < j; k++) {
                        if ((timetable[j][0] >= jp[k][0] && timetable[j][0] < jp[k][1]) || (timetable[j][1] >= jp[k][0] && timetable[j][1] < jp[k][1])) {
                            break;
                        }
                        if (k + 1 == j) {
                            jp[j][0] = timetable[j][0];
                            jp[j][1] = timetable[j][1];
                            jpcounter++;
                        }
                    }
                }

            }


if(jpcounter+cpcounter!=n){
    System.out.println("Case #" + i + ": " + "IMPOSSIBLE");
}
else {
    String output="";
    for(int tests=0;tests<n;tests++){
        if(cp[tests][0]!=0&&cp[tests][1]!=0){
            output=output+"C";
        }else {
            output=output+"J";
        }

    }

    System.out.println("Case #" + i + ": " + output);
}
        }
    }

}