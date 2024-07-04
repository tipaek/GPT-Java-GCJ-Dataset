import java.awt.*;
import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        StringBuilder sb=new StringBuilder();
        int z=1;
        int t=sc.nextInt();
        while(t-->0){
            sb=new StringBuilder();
            int n=sc.nextInt();
            int[] arr=new int[1441];
            char[] c=new char[n];
            Node[] node=new Node[n];
            for(int i=0;i<n;i++){
                int x=sc.nextInt(),y=sc.nextInt();
                arr[x]++;
                if(y<1440)arr[y+1]--;
                node[i]=new Node(i,x,y);
            }
            for(int i=1;i<=1440;i++)arr[i]+=arr[i-1];
            boolean f=false;
            for(int i=0;i<=1440;i++){
                if(arr[i]>2){
                    f=true;
                    break;
                }
            }
            if(f)sb.append("Case #"+(z++)+": IMPOSSIBLE");
            else{
                Arrays.sort(node, new Comparator<Node>() {
                    @Override
                    public int compare(Node o1, Node o2) {
                        return o1.x-o2.x;
                    }
                });
                int l=node[0].y;
                c[node[0].i]='C';
                char x='C';
                for(int i=1;i<n;i++){
                    if(node[i].y<l){
                        if(x=='C')c[node[i].i]='J';
                        else c[node[i].i]='C';
                    }
                    else{
                        l=node[i].y;
                        if(x=='C')x='J';
                        else x='C';
                        c[node[i].i]=x;
                    }
                }
                sb.append("Case #"+(z++)+": ");
                for(int i=0;i<n;i++)sb.append(c[i]);
            }
            System.out.println(sb);
        }
    }
}
class Node{
    int i,x,y;
    public Node(int i,int x,int y){
        this.i=i;
        this.x=x;
        this.y=y;
    }
}