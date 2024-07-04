import java.util.*;
class Interval{
    int s;
    int e;
    int pos=0;
    Interval(int a,int b,int i){
        s=a;
        e=b;
        pos=i;
    }
}

class MySort implements Comparator<Interval>{
    public int compare(Interval i,Interval j){
        if(i.s<j.s)
            return -1;
        if(i.s>j.s)
            return 1;
        if(i.e<j.e)
            return -1;
        if(i.e>j.e)
            return 1;
        return 0;
        
    }
}
class Solution{
    static boolean J;
    static boolean C;
    static int j=-1;
    static int c=-1;

    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        int k=0;
        while(t-->0){
            k++;
            J=true;
            C=true;
            j=-1;
            c=-1;
            int n=sc.nextInt();
            ArrayList<Interval> list=new ArrayList<>();
            
            for(int i=0;i<n;i++){
                int s=sc.nextInt();
                int e=sc.nextInt();
                Interval x=new Interval(s,e,i);
                list.add(x);
            }
            String ans=Compute(list);
            System.out.println("Case #"+k+": "+ans);
          
        }
    }
    
    public static String Compute( ArrayList<Interval> list){
        PriorityQueue<Interval> q=new PriorityQueue<>(new MySort());
        char a[]=new char[list.size()];
        StringBuilder ans=new StringBuilder(list.size());
        for(Interval i : list){
            q.add(i);
        }
        
        while(!q.isEmpty()){
            Interval cur=q.poll();
            int start=cur.s;
            int end=cur.e;
            int pos=cur.pos;
            System.out.println(start+ " "+end);
            if(start>=j){
                j=end;
               a[pos]='J';
                
            }
            else if(start>=c){
                c=end;
                // ans.insert(pos,'C');
                a[pos]='C';
            }
            else {
                return "IMPOSSIBLE";
            }
        }
        return new String(a);
        
    }
        
        
        
        
        
        
        
        
        
        
        
    }
    
