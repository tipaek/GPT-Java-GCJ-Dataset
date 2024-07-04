import java.io.*;
import java.util.*;
class Pair
{
    int first;
    char second;
    Pair(int first,char second){
        this.first=first;
        this.second=second;
    }
}
class PairPair implements Comparable<PairPair>
{
    Pair first;
    int second;
    PairPair(Pair first,int second){
        this.first=first;
        this.second=second;
    }
    public int compareTo(PairPair pp){
        if(first.first==pp.first.first){
            if(first.second==pp.first.second) return 0;
            else if(first.second<pp.first.second) return -1;
            else return 1;
        }
        else if(first.first<pp.first.first) return -1;
        else return 1;
    }
}
public class Solution
{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int z=1;z<=t;z++){
            int n=sc.nextInt();
            ArrayList<PairPair>st=new ArrayList<>();
            for(int i=0;i<n;i++){
                int x=sc.nextInt();
                int y=sc.nextInt();
                st.add(new PairPair(new Pair(x,'s'),i));
                st.add(new PairPair(new Pair(y,'e'),i));
            }
            Collections.sort(st);
            TreeMap<Integer,Character>tm=new TreeMap<>();
            int c=0,ci=-1,j=0,ji=-1,flag=0;
            for(PairPair it:st){
                if(it.first.second=='s'){
                    if(c==0){
                        c=1;
                        ci=it.second;
                        tm.put(ci,'C');
                    }
                    else if(j==0){
                        j=1;
                        ji=it.second;
                        tm.put(ji,'J');
                    }
                    else{
                        flag=1;
                        break;
                    }
                }
                else{
                    if(c==1 && j==1){
                        if(it.second==ci){
                            c=0;
                            ci=-1;
                        }
                        else{
                            j=0;
                            ji=-1;
                        }
                    }
                    else if(c==1){
                        c=0;
                        ci=-1;
                    }
                    else{
                        j=0;
                        ji=-1;
                    }
                }
            }
            if(flag==1) System.out.println("Case #"+z+": IMPOSSIBLE");
            else{
                System.out.print("Case #"+z+": ");
                for(int key:tm.keySet()) System.out.print(tm.get(key));
                System.out.println();
            }
        }
    }   
}