import java.io.*;
import java.util.*;
public class Solution implements Comparable<Solution>{
    int start,end;
    boolean visited;
    boolean ended;
    int index;
    public Solution(){}
    public Solution(int a,int b,int in){
        this.start = a;
        this.end = b;
        this.index = in;
        visited = false;
        ended = false;
    }
    public int compareTo(Solution o){
        if(this.start!=o.start){
            return (this.start - o.start);
        }
        return (this.end - o.end);
    }
    
    public static void main(String args[]){
        int T,N,max=Integer.MIN_VALUE;
        Scanner sc= new Scanner(System.in);
        ArrayList<String> result = new ArrayList<String>();
        T = sc.nextInt();
        for(int i=0;i<T;i++){
            N = sc.nextInt();
            Solution[] p=new Solution[N];
            for(int j=0;j<N;j++){
                int a = sc.nextInt();
                int b = sc.nextInt();
                if(b>max){
                    max=b;
                }
                p[j] = new Solution(a,b,j);
            }
            Arrays.sort(p);
            String s="";
            for(int l=0;l<N;l++){
                s+="0";
            }
            StringBuilder s1=new StringBuilder(s);
            ArrayList<Character> free = new ArrayList<Character>();
            char c1 = 'J',c2 = 'C';
            free.add('J');
            free.add('C');
            int current1=0,current2=1,next=2;
            for(int j=p[0].start;j<=max;j++){
                if(current1<N && p[current1].end==j){
                    free.add(c1);
                    current1 = next;
                    next++;
                }
                if(current2<N && p[current2].end==j){
                    free.add(c2);
                    current2 = next;
                    next++;
                }
                if(current1<N && p[current1].start == j){
                        if(!free.isEmpty()){
                            int z=p[current1].index;
                            s1.replace(z,z+1,""+free.get(0));
                            c1 = free.get(0);
                            free.remove(0);
                        }
                        else{
                            s1 = new StringBuilder("IMPOSSIBLE");
                            break;
                        }
                }
                if(current2<N && p[current2].start == j){
                        if(!free.isEmpty()){
                        int z1=p[current2].index;
                        s1.replace(z1,z1+1,""+free.get(0));
                        c2 = free.get(0);
                        free.remove(0);
                        }
                        else{
                            s1 = new StringBuilder("IMPOSSIBLE");
                            break;
                        }
                }
                if(next<N && p[next].start==j){
                    s1 = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }
            result.add(s1.toString());
        }
        for(int i=0;i<result.size();i++){
            System.out.println("Case #"+ (i+1) +": " + result.get(i));
        }
    }
}