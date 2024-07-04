import java.io.*; 
import java.util.*; 
public class Solution {
    static ArrayList<Integer> adj_lst[];
    static boolean vis[];
    static int color[];
    public static void main(String args[]){
        Scanner input=new Scanner(System.in);
        int test=input.nextInt();
        for(int t=1;t<=test;t++) {
            //No of nodes
            int n=input.nextInt();
            int strt[]=new int[n];
            int end[]=new int[n];
            for(int i=0;i<n;i++) {
                strt[i]=input.nextInt();
                end[i]=input.nextInt();
            }
            adj_lst=new ArrayList[n];
            vis=new boolean[n];
            color=new int[n];
            for(int i=0;i<n;i++) {
                adj_lst[i]=new ArrayList<Integer>();
                color[i]=-1;
            }
            //No of edges
            for(int i=0;i<n;i++) {
                for(int j=i+1;j<n;j++) {
                    if(!(end[i]<=strt[j] || strt[i]>=end[j])) {
                        adj_lst[i].add(j);
                        adj_lst[j].add(i);
                    }
                }
            }
//            for(int i=0;i<adj_lst.length;i++) {
//                System.out.print(i+"->");
//                for(int j=0;j<adj_lst[i].size();j++) {
//                    System.out.print(adj_lst[i].get(j)+" ");
//                }
//                System.out.println();
//            }
            for(int i=0;i<n;i++) {
                if(!vis[i]) {
                    mod_DFS(i);
                }
            }
            boolean is_pos=true;
            StringBuilder ans=new StringBuilder("");
            for(int i=0;i<n;i++) {
                if(color[i]==-1) {
                    is_pos=false;
                    break;
                }
                if(color[i]==0) {
                    ans.append('C');
                }
                else {
                    ans.append('J');
                }
            }
            if(!is_pos) {
                System.out.println("Case #"+t+": "+"IMPOSSIBLE");
                continue;
            }
            System.out.println("Case #"+t+": "+ans);
        }
        
    }
    
    public static void mod_DFS(int root) {
//        System.out.println(root);
        boolean zero=false,one=false;
        for(int i=0;i<adj_lst[root].size();i++) {
            if(adj_lst[root].get(i)==0) {
                zero=true;
            }
            else if(adj_lst[root].get(i)==1) {
                one=true;
            }
        }
        if(!zero && !one) {
            color[root]=0;
        }
        else if(!zero && one) {
            color[root]=0;
        }
        else if(zero && !one) {
            color[root]=1;
        }
        vis[root]=true;
        for(int i=0;i<adj_lst[root].size();i++) {
            if(!vis[adj_lst[root].get(i)]) {
                mod_DFS(adj_lst[root].get(i));
            }
        }
    }
}
