import java.util.*;
import java.io.*;

class Pair{
    int a;
    int b;
    char c;
    int idx;
    Pair(int i,int j,char k,int l){
        a = i;
        b = j;
        c = k;
        idx = l;
    }
}

class sortbytime implements Comparator<Pair> 
{ 
    public int compare(Pair aa, Pair bb) 
    { 
        if(aa.a == bb.a){
            return (aa.b-bb.b);
        }else{
            return aa.a-bb.a;
        }
    }
} 
class sortbyid implements Comparator<Pair> 
{ 
    public int compare(Pair aa, Pair bb) 
    { 
        return aa.idx - bb.idx;
    }
} 

class Solution{

    public static int func(ArrayList<Pair> arr, int n){
        int iter1 = 0;
        int iter2 = 1;
        int toreturn=0;
        if(n == 0){
            return -1;
        }
        arr.get(0).c = 'C';
        int clast = arr.get(0).b;
        int jlast = 0;
        while(true){
            if(iter2 == n){
                break;
            }
            Pair p = arr.get(iter2);
            if(p.a >= clast){
                p.c = 'C';
                iter2++;
                clast = p.b;
            }else if(p.a >= jlast){
                p.c='J';
                iter2++;
                jlast = p.b;
            }else{
                return -1;
            }
        }
        return 1;
    }
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int T = Integer.parseInt(s.nextLine());
        for(int t=0;t<T;t++){
            int n = s.nextInt();
            ArrayList<Pair> arr = new ArrayList<Pair>(n);
            for(int i=0;i<n;i++){
                int a = s.nextInt();
                int b = s.nextInt();
                arr.add(new Pair(a,b,'a',i));
            }
            Collections.sort(arr,new sortbytime());
            // for(Pair p:arr){
            //     System.out.print(Integer.toString(p.a)+" ");
            //     System.out.println(p.b);
            // }
            int res = func(arr,n);
            StringBuffer sb = new StringBuffer("");
            if(res == -1){
                sb.append("IMPOSSIBLE");
            }else{
                Collections.sort(arr, new sortbyid());
                for(Pair p:arr){
                    sb.append(Character.toString(p.c));
                }
            }
            String tp = "Case #"+Integer.toString(t+1)+": "+sb.toString();
            System.out.println(tp);
        }

    }
}