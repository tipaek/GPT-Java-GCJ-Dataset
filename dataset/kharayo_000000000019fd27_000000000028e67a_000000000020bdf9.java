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
                pq.add(new Node(startTime,endTime,v));
            }

            System.out.println("Case #" + i + ": " + solve(pq));
        }
    }

    private static String solve(PriorityQueue<Node> pq) {

        StringBuilder sb = new StringBuilder();
        boolean isJamieFree=true;
        boolean isCamieFree=true;
        int jamieEndTime=-1;
        int camieEndTime=-1;
        Queue<Node> nodes = new PriorityQueue<Node>((a,b)->a.index-b.index);
        while(!pq.isEmpty()){
            Node n = pq.poll();
            int startTime =  n.start;
            int endTime = n.end;
            if(isJamieFree ){
                jamieEndTime=endTime;
                isJamieFree=false;
                n.setChar('J');
            }
            else if(isCamieFree ){
                camieEndTime=endTime;
                isCamieFree=false;
                n.setChar('C');
            }else{

                if(startTime>=jamieEndTime){
                    jamieEndTime=endTime;
                    n.setChar('J');
                }else if(startTime>=camieEndTime){
                    camieEndTime=endTime;
                    n.setChar('C');
                }
                else{
                    return "IMPOSSIBLE";
                }
            }
            nodes.add(n);
        }

        while(!nodes.isEmpty()){
            sb.append(nodes.poll().getChar());
        }
        return  sb.toString();
    }


}

class Node{
    int start;
    int end;
    int index;
    char c;
    Node(int start, int end, int index){
        this.start = start;
        this.end = end;
        this.index = index;
    }

    void setChar(char c){
        this.c=c;
    }

    public char getChar(){
        return c;
    }


    @Override
    public String toString() {
        return start+" "+end+" "+c+" "+ index;
    }
}

//----------
//----    ---
// ---  -----
//----------
//----    ---
// ---  -----