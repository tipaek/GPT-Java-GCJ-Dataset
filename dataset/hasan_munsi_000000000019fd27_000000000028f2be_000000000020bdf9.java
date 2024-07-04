
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author HASAN
 */
public class Solution {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(b.readLine().trim());
        for(int i=0; i<tc; i++){
            int tasks = Integer.parseInt(b.readLine().trim());
            int[][] times = new int[tasks][2];
            for(int j=0;j<tasks;j++){
                String[] s = b.readLine().trim().split("\\s+");
                times[j][0] = Integer.parseInt(s[0]);
                times[j][1] = Integer.parseInt(s[1]);

            }
            System.out.println("Case #"+(i+1)+": "+processOutput(times));
        }
    }
    
    public static String processOutput(int[][] times){
        String output = "";
        int[][] timmings = new int[times.length][3];
        for(int i=0; i<times.length;i++){
            if(cAvailable(timmings,times,i,1)==true){
                timmings[i][0] = times[i][0];
                timmings[i][1] = times[i][1];
                timmings[i][2] = 1;

            }else if(cAvailable(timmings,times,i,1)==false && cAvailable(timmings,times,i,2)==true){
                timmings[i][0] = times[i][0];
                timmings[i][1] = times[i][1];
                timmings[i][2] = 2;

            }else if(cAvailable(timmings,times,i,1)==false && cAvailable(timmings,times,i,2)==false){
                return "IMPOSSIBLE";
            }
        }
        
        for(int i=0; i<timmings.length; i++){
            if(timmings[i][2]==1)
                output += "C";
            else if(timmings[i][2]==2)
                output += "J";
        }
        return output;
    }
    
    public static Boolean cAvailable(int[][] timmings, int[][] times, int loop,int c){
        if(loop==0)
            return true;
        for(int i=0;i<loop;i++){
            if(timmings[i][2]==c){
                int min =timmings[i][0],max=timmings[i][1];
                if(times[loop][0]>=min && times[loop][0]<max)
                    return false;
                else if(times[loop][0]<=min && times[loop][1]>=max)
                    return false;
                else if(times[loop][1]>min && times[loop][1]<=max)
                    return false;
            }
        }
        
    return true;
    }
    
}
