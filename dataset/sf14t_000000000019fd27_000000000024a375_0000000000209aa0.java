import java.io.*; 
import java.util.*; 
public class Solution {
    static ArrayList<Integer> adj_lst[];
    static boolean vis[];
    public static void main(String args[]) {
        Scanner input=new Scanner(System.in);
        int test=input.nextInt();
        for(int t=1;t<=test;t++) {
            int n=input.nextInt();
            int k=input.nextInt();
            solve(n,k,t);
        }
    }
    public static StringBuilder rotate(StringBuilder str) {
        StringBuilder tmp_str=new StringBuilder(str);
        tmp_str.insert(0, tmp_str.charAt(tmp_str.length()-1));
        tmp_str.deleteCharAt(tmp_str.length()-1);
        return tmp_str;
    }
    
    public static void solve(int n,int k,int test) {
        //No of nodes
        adj_lst=new ArrayList[n+1];
        vis=new boolean[adj_lst.length];
        for(int i=0;i<adj_lst.length;i++) {
            adj_lst[i]=new ArrayList<Integer>();
        }
        //No of edges
        for(int i=1;i<=n;i++) {
            for(int j=i+1;j<=n;j++) {
                adj_lst[i].add(j);
                adj_lst[j].add(i);
            }
        }
//        for(int i=0;i<adj_lst.length;i++) {
//            System.out.print(i+"->");
//            for(int j=0;j<adj_lst[i].size();j++) {
//                System.out.print(adj_lst[i].get(j)+" ");
//            }
//            System.out.println();
//        }
        comb=0;
        combinations=new ArrayList<>();
        sum_combs=new ArrayList<>();
        for(int i=1;i<=n;i++) {
            sum_comb=new StringBuilder("");
            sum_combs(i,n,k,0,1);
        }
//        for(int i=0;i<sum_combs.size();i++) {
//            System.out.println(sum_combs.get(i));
//        }
//        System.exit(0);
        mod_DFS(1);
        boolean is_pos=false;
        int place[]=new int[n],comb_indx=-1;
        StringBuilder ans=new StringBuilder();
        for(int q=0;q<sum_combs.size();q++) {
            if(sum_combs.get(q).length()!=n) {
                continue;
            }
            for(int i=0;i<combinations.size();i++) {
                ans=new StringBuilder();
                place=new int[n];
                StringBuilder str[]=new StringBuilder[n];
                str[0]=new StringBuilder(""+combinations.get(i));
                place[0]=-1;
                for(int j=1;j<n;j++) {
                    place[j]=-1;
                    str[j]=rotate(str[j-1]);
                }
                boolean str_taken[]=new boolean[n];
                String sum_comb_tmp=sum_combs.get(q);
                for(int p=0;p<sum_comb_tmp.length();p++) {
                    for(int j=0;j<n;j++) {
                        if(str_taken[j]) {
                            continue;
                        }
                        boolean done=false;
                        for(int m=0;m<n;m++) {
                            if(place[m]!=-1) {
                                continue;
                            }
                            if(str[j].charAt(m)==sum_comb_tmp.charAt(p)) {
                                ans.append(str[j]+"\n");
                                place[m]=j;
                                str_taken[j]=true;
                                done=true;
                                break;
                            }
                        }
                        if(done) {
                            break;
                        }
                    }
                }
                is_pos=true;
                for(int j=0;j<n;j++) {
                    if(place[j]==-1) {
                        is_pos=false;
                        break;
                    }
                }
                if(is_pos) {
                    comb_indx=i;
                    break;
                }
            }
            if(is_pos) {
                break;
            }
        }
        
//        System.out.println(combinations.get(comb_indx));
//        for(int j=0;j<n;j++) {
//            System.out.print(place[j]+" ");
//        }
//        System.out.println();
        if(comb_indx==-1) {
            System.out.println("Case #"+test+": "+"IMPOSSIBLE");
            return;
        }
        StringBuilder str[]=new StringBuilder[n];
        str[0]=new StringBuilder(""+combinations.get(comb_indx));
        for(int j=1;j<n;j++) {
            str[j]=rotate(str[j-1]);
        }
        System.out.println("Case #"+test+": "+"POSSIBLE");
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                System.out.print(str[place[i]].charAt(j)+" ");
            }
            System.out.println();
        }
    }
    static ArrayList<Integer>combinations;
    static int count=0,comb;
    public static void mod_DFS(int root) {
        comb=(comb*10)+root;
        vis[root]=true;
        for(int i=1;i<vis.length;i++) {
            if(!vis[i]) {
                break;
            }
            if(i==vis.length-1) {
                count++;
                combinations.add(comb);
                comb/=10;
                vis[root]=false;
                return;
            }
        }
        for(int i=0;i<adj_lst[root].size();i++) {
            if(!vis[adj_lst[root].get(i)]) {
                mod_DFS(adj_lst[root].get(i));
            }
        }
        comb/=10;
        vis[root]=false;
    }
    static ArrayList<String> sum_combs;
    static StringBuilder sum_comb;
    public static void sum_combs(int root,int n,int k,int sum,int count) {
        sum+=root;
        sum_comb.append(root);
        if(sum==k && count==n) {
            sum_combs.add(""+sum_comb);
            sum_comb.deleteCharAt(sum_comb.length()-1);
            return;
        }
        if(sum>k) {
            sum_comb.deleteCharAt(sum_comb.length()-1);
            return;
        }
        if(count>=n) {
            sum_comb.deleteCharAt(sum_comb.length()-1);
            return;
        }
        for(int i=1;i<=n;i++) {
            sum_combs(i,n,k,sum,count+1);
        }
        sum_comb.deleteCharAt(sum_comb.length()-1);
    }
}
