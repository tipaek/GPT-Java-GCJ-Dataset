import java.io.*;
import java.util.*;
public class Solution implements Comparable<Solution>{
    int start,end;
    boolean visited;
    int index;
    public Solution(int a,int b,int in){
        this.start = a;
        this.end = b;
        this.index = in;
        visited = false;
    }
    public int compareTo(Solution o){
        if(this.end!=o.end){
            return (this.end - o.end);
        }
        return (this.start - o.start);
    }
    public static int activity_selection(Solution[] p1,int j,StringBuilder s1, int N,String g){
        int count=0;
        if(p1[j].visited==false){
            int z = p1[j].index;
            s1.replace(z,z+1,g);
            p1[j].visited =true;
        }
        for(int l=j+1;l<N;l++){
            if((p1[l].start >= p1[j].end ) && p1[l].visited==false){
                int index=p1[l].index;
                s1.replace(index,index+1,g);
                j=l;
                p1[l].visited = true;
            }
            else if(count==0){
                count=l;
            }
        }
        return count;
    }
    public static void main(String args[]){
        int T,N;
        Scanner sc= new Scanner(System.in);
        ArrayList<String> result = new ArrayList<String>();
        T = sc.nextInt();
        for(int i=0;i<T;i++){
            N = sc.nextInt();
            Solution[] p=new Solution[N];
            for(int j=0;j<N;j++){
                int a = sc.nextInt();
                int b = sc.nextInt();
                p[j] = new Solution(a,b,j);
            }
            String s="";
            for(int a=0;a<N;a++){
                s+="0";
            }
            StringBuilder s1 = new StringBuilder(s);
            Arrays.sort(p);
            int d=activity_selection(p,0,s1,N,"J");
            int e=activity_selection(p,d,s1,N,"C");
            if(!s1.toString().contains("0")){
                result.add(s1.toString());
            }
            else{
                result.add("IMPOSSIBLE");
            }
        }
        for(int i=0;i<result.size();i++){
            System.out.println("Case #"+ (i+1) +": " + result.get(i));
        }
    }
}