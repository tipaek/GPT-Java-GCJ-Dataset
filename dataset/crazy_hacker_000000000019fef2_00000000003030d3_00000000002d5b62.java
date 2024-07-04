
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        PrintWriter out = new PrintWriter(System.out);
        StringBuilder str = new StringBuilder("");
        for (int h = 1; h <= t; h++) {
            System.out.print("Case #" + h + ": ");
            String[] in = br.readLine().split(" ");
            long x = Integer.parseInt(in[0]);
            long y = Integer.parseInt(in[1]);
           // long l =0, r=0;
            long x1 = Math.abs(x);
            long y1 = Math.abs(y);

            if((x1%2==0 && y1%2==0) || (x1%2!=0 && y1%2!=0)){
                System.out.println("IMPOSSIBLE");
            } else {
                List<StringBuilder> ans = new ArrayList<>();
                Queue<State> q = new LinkedList<>();
                int count =0;
                StringBuilder a = new StringBuilder();
                q.add(new State(Math.abs(x), Math.abs(y)));
                while(count<64){
                    Queue<State> temp = q;
                    q=new LinkedList<>();
                    while(!temp.isEmpty()){
                        State curr = temp.poll();
                        if(curr.l==0 && curr.r==0){
                            a = curr.moves;
                            break;
                        }
                        long val = (long)Math.pow(2,count);
                        if((curr.r<val && curr.r>0) || (curr.l<val && curr.l>0)){
                            continue;
                        }
                        long val1 = curr.l-val;
                        if((val1 & val)==0){
                            State newState = new State(val1, curr.r);
                            newState.moves.append(curr.moves);
                            newState.moves.append("E");
                            q.add(newState);
                        }

                        long val2 = curr.l+val;
                        if((val2 & val)==0){
                            State newState = new State(val2, curr.r);
                            newState.moves.append(curr.moves);
                            newState.moves.append("W");
                            q.add(newState);
                        }

                        long val3 = curr.r-val;
                        if((val3 & val)==0){
                            State newState = new State(curr.l, val3);
                            newState.moves.append(curr.moves);
                            newState.moves.append("N");
                            q.add(newState);
                        }

                        long val4 = curr.r+val;
                        if((val4 & val)==0){
                            State newState = new State(curr.l, val4);
                            newState.moves.append(curr.moves);
                            newState.moves.append("S");
                            q.add(newState);
                        }

                    }
                    count++;
                }
                if(a.length()==0){
                    System.out.println("IMPOSSIBLE");
                } else {
                    if(y<0){
                        for(int i=0;i<a.length();i++){
                            if(a.charAt(i)=='N'){
                                a.setCharAt(i, 'S');
                            } else if(a.charAt(i)=='S'){
                                a.setCharAt(i, 'N');
                            }
                        }
                    }
                    if(x<0){
                        for(int i=0;i<a.length();i++){
                            if(a.charAt(i)=='E'){
                                a.setCharAt(i, 'W');
                            } else if(a.charAt(i)=='W'){
                                a.setCharAt(i, 'E');
                            }
                        }
                    }
                    System.out.println(a.toString());
                }
            }
        }
       // out.print(str);
        out.flush();
        br.close();
    }

}

class State{
    long l;
    long r;
    StringBuilder moves = new StringBuilder();
    public State(long l, long r){
        this.l=l;
        this.r=r;
    }
}



