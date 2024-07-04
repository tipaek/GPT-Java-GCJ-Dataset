import java.io.*; 
import java.util.*; 
public class Solution {
    static ArrayList<Integer> adj_lst[];
    static boolean vis[];
    public static void main(String args[]){
        Scanner input=new Scanner(System.in);
        int test=input.nextInt();
        for(int t=1;t<=test;t++) {
            //No of nodes
            int n=input.nextInt();
            int k=input.nextInt();
            adj_lst=new ArrayList[n+1];
            vis=new boolean[n+1];
            for(int i=1;i<=n;i++) {
                adj_lst[i]=new ArrayList<Integer>();
            }
            //No of edges
            for(int i=1;i<=n;i++) {
                for(int j=i+1;j<=n;j++) {
                    adj_lst[i].add(j);
                    adj_lst[j].add(i);
                }
            }
            arrli=new ArrayList<>();
            comb_arr=new int[fact(n)][n];
            comb_arr_indx=0;
    //        for(int i=0;i<adj_lst.length;i++) {
    //            System.out.print(i+"->");
    //            for(int j=0;j<adj_lst[i].size();j++) {
    //                System.out.print(adj_lst[i].get(j)+" ");
    //            }
    //            System.out.println();
    //        }
            for(int i=1;i<=n;i++) {
                mod_DFS(i,n);
            }
            int arr[];
            if(n==2) {
               arr=permutation_2(n,k); 
            }
            else if(n==3) {
               arr=permutation_3(n,k); 
            }
            else if(n==4) {
               arr=permutation_4(n,k); 
            }
            else {
                if(k==6 || k==24) {
                    arr=new int[]{-1};
                }
                else {
                    arr=permutation_5(n,k); 
                }
            }
            if(arr.length==1) {
                System.out.println("Case #"+t+": "+"IMPOSSIBLE");
                continue;
            }
            System.out.println("Case #"+t+": "+"POSSIBLE");
            for(int i=0;i<n;i++) {
                for(int j=0;j<n;j++) {
                    System.out.print(comb_arr[arr[i]][j]+" ");
                }
                System.out.println();
            }
            System.out.println();
            }
    }
    static ArrayList<Integer> arrli;
    static int comb_arr[][],comb_arr_indx;
    public static void mod_DFS(int root,int n) {
        arrli.add(root);
        if(arrli.size()==n) {
            for(int i=0;i<n;i++) {
                comb_arr[comb_arr_indx][i]=arrli.get(i);
            }
            comb_arr_indx++;
            arrli.remove(arrli.size()-1);
            vis[root]=false;
            return;
        }
        vis[root]=true;
        for(int i=0;i<adj_lst[root].size();i++) {
            if(!vis[adj_lst[root].get(i)]) {
                mod_DFS(adj_lst[root].get(i),n);
            }
        }
        vis[root]=false;
        arrli.remove(arrli.size()-1);
    }
    public static int fact(int n) {
        int fact=1;
        for(int i=2;i<=n;i++) {
            fact*=i;
        }
        return fact;
    }
    public static boolean check_diag_sum(int arr[],int n,int k) {
        int sum=0;
        for(int i=0;i<n;i++) {
            sum+=comb_arr[arr[i]][i];
        }
        if(sum==k) {
            return true;
        }
        return false;
    }
    public static boolean check_latin_sq(int arr[],int n) {
        boolean all_exist[]=new boolean[n+1];
        for(int i=0;i<n;i++) {
            all_exist=new boolean[n+1];
            for(int j=0;j<n;j++) {
                all_exist[comb_arr[arr[j]][i]]=true;
            }
            for(int j=1;j<=n;j++) {
                if(!all_exist[j]) {
                    return false;
                }
            }
        }
        return true;
    }
    static int[] permutation_5(int n,int sum) {
        int lim=fact(n)/n;
        int arr[]=new int[n],tmp_arr[]=new int[n];
        for(int i=0;i<lim;i++) {
            arr[0]=i;
            for(int j=lim;j<2*lim;j++) {
                arr[1]=j;
                for(int k=2*lim;k<3*lim;k++) {
                    arr[2]=k;
                    for(int l=3*lim;l<4*lim;l++) {
                        arr[3]=l;
                        for(int m=4*lim;m<5*lim;m++) {
                            arr[4]=m;
                            for(int p=0;p<comb_arr.length;p++) {
                                for(int q=0;q<n;q++) {
                                    tmp_arr[q]=arr[comb_arr[p][q]-1];
                                }
                                if(check_diag_sum(tmp_arr,n,sum) && check_latin_sq(tmp_arr,n)) {
                                    return arr;
                                }
                            }
                        }
                    }
                }
            }
        }
        return new int[]{-1};
    }
    static int[] permutation_4(int n,int sum) {
        int lim=fact(n);
        int arr[]=new int[n];
        for(int i=0;i<lim;i++) {
            arr[0]=i;
            for(int j=0;j<lim;j++) {
                arr[1]=j;
                for(int k=0;k<lim;k++) {
                    arr[2]=k;
                    for(int l=0;l<lim;l++) {
                        arr[3]=l;
                        if(check_diag_sum(arr,n,sum) && check_latin_sq(arr,n)) {
                            return arr;
                        }
                    }
                }
            }
        }
        return new int[]{-1};
    }
    
    static int[] permutation_3(int n,int sum) {
        int lim=fact(n);
        int arr[]=new int[n];
        for(int i=0;i<lim;i++) {
            arr[0]=i;
            for(int j=0;j<lim;j++) {
                arr[1]=j;
                for(int k=0;k<lim;k++) {
                    arr[2]=k;
                    if(check_diag_sum(arr,n,sum) && check_latin_sq(arr,n)) {
                        return arr;
                    }
                }
            }
        }
        return new int[]{-1};
    }
    
    static int[] permutation_2(int n,int sum) {
        int lim=fact(n)/n;
        int arr[]=new int[n];
        for(int i=0;i<lim;i++) {
            arr[0]=i;
            for(int j=0;j<lim;j++) {
                arr[1]=j;
                if(check_diag_sum(arr,n,sum) && check_latin_sq(arr,n)) {
                    return arr;
                }
            }
        }
        return new int[]{-1};
    }
}
