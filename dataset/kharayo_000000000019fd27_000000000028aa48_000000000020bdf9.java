import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author adarshbhattarai on 2020-04-04
 * @project untitled
 */
public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testcases = sc.nextInt();
        for(int i=1;i<=testcases;i++) {
            int N = sc.nextInt();
            PriorityQueue<Node> pq = new PriorityQueue<Node>((a,b)->{
                if(a.start==b.start){
                    return a.end-b.end;
                }
                return a.start-b.start;
            });
            for(int v=0;v<N;v++){
                int startTime = sc.nextInt();
                int endTime = sc.nextInt();
                pq.add(new Node(startTime,endTime));
            }
            System.out.println("Case #" + i + ": " + solve(pq));
        }
    }

    private static String solve(PriorityQueue<Node> pq) {

        StringBuilder sb = new StringBuilder();
        int noOfRunningJob=0;
        boolean isJamieFree=true;
        boolean isCamieFree=true;
        int jamieEndTime=-1;
        int camieEndTime=-1;
        while(!pq.isEmpty()){
            Node n = pq.poll();
            System.out.println(n);
            int startTime =  n.start;
            int endTime = n.end;
            if(isJamieFree ){
                jamieEndTime=endTime;
                sb.append("J");
                isJamieFree=false;
            }
            else if(isCamieFree ){
                camieEndTime=endTime;
                sb.append("C");
                isCamieFree=false;
            }else{

                if(startTime>=jamieEndTime){
                    sb.append("J");
                    jamieEndTime=endTime;
                }else if(startTime>=camieEndTime){
                    sb.append("C");
                    camieEndTime=endTime;
                }
                else{
                    return "IMPOSSIBLE";
                }
            }
        }
        return  sb.toString();
    }


}

class Node{
    int start;
    int end;
    Node(int start, int end){
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return start+" "+end;
    }
}

//----------
//----    ---
// ---  -----