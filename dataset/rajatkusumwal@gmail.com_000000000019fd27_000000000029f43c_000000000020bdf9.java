import java.util.*;
import java.io.*;


public class Solution {


    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            //0 means J , 1 means C on index 2
            ArrayList<Boolean> isJamAvail=new ArrayList<Boolean>();
            ArrayList<Boolean> isCamAvail=new ArrayList<Boolean>();
            String result="";
            Boolean resultFlag = Boolean.TRUE;
            for(int x=0;x<=(24*60)+1;x++){
                isJamAvail.add(Boolean.TRUE);
                isCamAvail.add(Boolean.TRUE);
            }
            int n = in.nextInt();
            for(int x=0;x<n;x++) {
                int st = in.nextInt();
                int et = in.nextInt();
                if(resultFlag){
                    Boolean jamFlag = Boolean.TRUE;
                    Boolean camFlag = Boolean.TRUE;
                    for(int y=st;y<=et;y++){
                        if(isJamAvail.get(y)==Boolean.FALSE)
                            jamFlag=Boolean.FALSE;
                        if(isCamAvail.get(y)==Boolean.FALSE)
                            camFlag=Boolean.FALSE;
                    }
                    if(jamFlag){
                        for(int y=st;y<et;y++){
                            isJamAvail.set(y,Boolean.FALSE);
                        }
                        result=result + 'J';
                    } else if(camFlag){
                        for(int y=st;y<et;y++){
                            isCamAvail.set(y,Boolean.FALSE);
                        }
                        result=result + 'C';
                    } else {
                        resultFlag = Boolean.FALSE;
                    }
                }
            }
            if(resultFlag){
                System.out.println("Case #" + i + ": " +result);
            } else {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            }
        }
    }

}
