import java.util.*;
class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt(),t1=0;
        while(t1<t){
            int n=sc.nextInt();
            ArrayList<ArrayList<Integer>> a=new ArrayList<ArrayList<Integer>>();
            for(int i=0;i<n;i++){
                ArrayList<Integer> temp=new ArrayList<Integer>();
                temp.add(0);
                a.add(temp);
            }
            int c=0,r=0,k=0;
            Set<Integer> hr=new HashSet<Integer>(),hc=new HashSet<Integer>();
            for(int i=0;i<n;i++){
                ArrayList<Integer> temp=new ArrayList<Integer>();
                for(int j=0;j<n;j++){
                    int x=sc.nextInt();
                    if(temp.contains(x))
                        hr.add(i);
                    else
                        temp.add(x);
                    if(a.get(j).contains(x))
                        hc.add(j);
                    else
                        a.get(j).add(x);
                    if(i==j)
                        k+=x;
                }
            }
            System.out.println("Case #"+(t1+1)+": "+k+" "+hr.size()+" "+hc.size());
            t1++;
        }
    }
}