
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HASAN
 */
public class Solution {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(b.readLine().trim());
        for(int i=0; i<tc; i++){
            int tasks = Integer.parseInt(b.readLine().trim());
            
            List<List<Integer>> times = new ArrayList<>();
            for(int j=0;j<tasks;j++){
                List<Integer> time = new ArrayList<>();
                String[] s = b.readLine().split("\\s+");
                time.add(Integer.parseInt(s[0]));
                time.add(Integer.parseInt(s[1]));
                times.add(time);
            }
            System.out.println("Case #"+(i+1)+": "+processOutput(times));
        }
    }
    
    public static String processOutput(List<List<Integer>> times){
        String output = "";
        List<List<Integer>> timmings = new ArrayList<>();
        for(int i=0; i<times.size();i++){
            List<Integer> temp = new ArrayList<>();
            if(cAvailable(timmings,times,i,1)==true){
                temp.add(times.get(i).get(0));
                temp.add(times.get(i).get(1));
                temp.add(1);
                timmings.add(temp);

            }else if(cAvailable(timmings,times,i,1)==false && cAvailable(timmings,times,i,2)==true){
                temp.add(times.get(i).get(0));
                temp.add(times.get(i).get(1));
                temp.add(2);
                timmings.add(temp);

            }else if(cAvailable(timmings,times,i,1)==false && cAvailable(timmings,times,i,2)==false){
                return "IMPOSSIBLE";
            }
        }
        
        for(int i=0; i<timmings.size(); i++){
            if(timmings.get(i).get(2)==1)
                output += "C";
            else if(timmings.get(i).get(2)==2)
                output += "J";
        }
        return output;
    }
    
    public static Boolean cAvailable(List<List<Integer>> timmings, List<List<Integer>> times, int loop,int c){
        if(loop==0)
            return true;
        for(int i=0;i<loop;i++){
            if(timmings.get(i).get(2)==c){
                int min =timmings.get(i).get(0),max=timmings.get(i).get(1);
                if(times.get(loop).get(0)>=min && times.get(loop).get(0)<max)
                    return false;
                else if(times.get(loop).get(1)>min && times.get(loop).get(1)<=max)
                    return false;
                else if(times.get(loop).get(0)<=min && times.get(loop).get(1)>=max)
                    return false;
            }
        }
        
    return true;
    }
    
}
