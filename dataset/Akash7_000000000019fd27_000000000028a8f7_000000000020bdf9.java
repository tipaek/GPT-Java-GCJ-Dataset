import java.io.*;
import java.util.*;
class Solution{

    static void schedulingTasks(ArrayList<Integer> start, ArrayList<Integer> end, int testNo, int n){

        char[] assignTask = new char[start.size()];
        int[] s = new int[start.size()];
        ArrayList<Integer> remaining = new ArrayList<Integer>();
        int eTime = 0;
        String ans = new String();

        for(int i=0;i<start.size();i++)
           s[i]=start.get(i);
        Arrays.sort(s);
        
        eTime = end.get(start.indexOf(s[0]));
        assignTask[start.indexOf(s[0])] = 'C';
        for(int j=1;j<s.length;j++){
            if(eTime<=s[j]){
                eTime=end.get(start.indexOf(s[j]));
                assignTask[start.indexOf(s[j])] = 'C';
            }
            else
               remaining.add(s[j]);
        }

        if(!remaining.isEmpty()){
            eTime = end.get(start.indexOf(remaining.get(0)));
            assignTask[start.indexOf(remaining.get(0))] = 'J';
            for(int j=1;j<remaining.size();j++){
                if(eTime<=remaining.get(j)){
                    eTime=end.get(start.indexOf(remaining.get(j)));
                    assignTask[start.indexOf(remaining.get(j))] = 'J';
                }
            }
        }

        for(int i=0;i<assignTask.length;i++)
            if(assignTask[i]=='C' ||assignTask[i]=='J')
               ans+=assignTask[i];

        PrintWriter writer = new PrintWriter(System.out);  
        if(ans.length()<n){   
            writer.write("Case #"+testNo+": IMPOSSIBLE\n");
            writer.flush();
        }
        else if(ans.length()==n){
            writer.write("Case #"+testNo+": "+ans+"\n");
            writer.flush();
        }
           
    }

    public static void main(String args[])throws IOException{

        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        int t = Integer.parseInt(br.readLine());
        for(int k=1;k<=t;k++){
            int n = Integer.parseInt(br.readLine());
            ArrayList<Integer> startTime = new ArrayList<Integer>(n); 
            ArrayList<Integer> endTime = new ArrayList<Integer>(n); 
            for(int i=0;i<n;i++){
                 String[] taskTimes = br.readLine().split(" ");
                 startTime.add(Integer.parseInt(taskTimes[0]));
                 endTime.add(Integer.parseInt(taskTimes[1]));
            }            
            schedulingTasks(startTime, endTime, k, n);
        }
    }
}