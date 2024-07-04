import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

class Node{
    int start;
    int end;
    int index;
    Node(int start, int end, int index){
        this.start = start;
        this.end = end;
        this.index = index;
    }
}

class Parenting{
    private ArrayList<Node> nodes;
    char ans[];

    Parenting(ArrayList<Node> nodes){
        this.nodes = nodes;
        ans = new char[nodes.size()];
    }

    public String solve(){
        Collections.sort(nodes,(a,b)->a.start -b.start);
        int c_end = -1;
        int j_end = -1;
        for(int i=0; i<nodes.size(); i++){
            int start = nodes.get(i).start;
            int end = nodes.get(i).end;
            int index = nodes.get(i).index;
            if(start>=c_end){
                ans[index] = 'C';
                c_end = end;
            }
            else if(start>=j_end){
                ans[index] = 'J';
                j_end = end;
            }
            else
                return "IMPOSSIBLE";
            //System.out.println(ans[index]);
        }
        return new String(ans);
    }
}

class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int k=1;
        while(k<=t){
            int n = sc.nextInt();
            ArrayList<Node> nodes = new ArrayList<Node>();
            for(int i=0; i<n; ++i){
                nodes.add(new Node(sc.nextInt(), sc.nextInt(), i));
            }
            Parenting p = new Parenting(nodes);
            String ans = p.solve();
            System.out.println("Case #"+k+": "+ans);
            k++;
        }
        sc.close();
    }
}