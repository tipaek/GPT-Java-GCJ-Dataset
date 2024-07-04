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
    public static int activity_selection(Solution[] p1,int j,HashMap<Integer,Integer> list, int N){
        int count=0;
        list.put(p1[j].index,0);
        for(int k=j+1;k<N;k++){
            if(p1[k].start>=p1[j].end && p1[k].visited==false){
                list.put(p1[k].index,0);
                j=k;
                p1[k].visited = true;
            }
            else if(count==0){
                count = k;
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
            HashMap<Integer,Integer> pa1 = new HashMap<Integer,Integer>();
            HashMap<Integer,Integer> pa2 = new HashMap<Integer,Integer>();
            int d = activity_selection(p,0,pa1,N);
            if(pa1.size()!=N)
            {int e = activity_selection(p,d,pa2,N);}
            for(Map.Entry ele : pa1.entrySet()){
                int z = ((int)ele.getKey());
                s1.replace(z,(z+1),"J");
            }
            for(Map.Entry ele : pa2.entrySet()){
                int z1 = ((int)ele.getKey());
                s1.replace(z1,(z1+1),"C");
            }
            if(!s1.toString().contains("0")){
                result.add(s1.toString());
            }
            else{
                result.add("IMPOSSIBLE");
            }
        }
        for(int i=0;i<result.size();i++){
            System.out.println(result.get(i));
        }
    }
}