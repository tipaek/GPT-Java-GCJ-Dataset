import java.util.*;

class Interval implements Comparable<Interval>{
    int start;
    int end;

    public int compareTo(Interval i2){
        if(this.end<i2.end){
            return -1;
        }
        else if(this.end>i2.end){
            return 1;
        }
        else{
            if(this.start<i2.start){
                return -1;
            }
            else{
                return 1;
            }
        }
        // return 0;
    }

    Interval(int s,int e){
        start=s;
        end=e;
    }
    public String toString(){
        return start+"-->"+end;
    }

} 

class Parenting {
    static Scanner sc=new Scanner(System.in);
    static int N;
    static ArrayList<Interval> ar;
    public static void main(String[] args){
        int T=sc.nextInt();
        for(int t=1;t<=T;t++){
            N=sc.nextInt();
            ar=new ArrayList<Interval>(N);
            for(int n=0;n<N;n++){
                ar.add(n,new Interval(sc.nextInt(),sc.nextInt()));
            }
            Collections.sort(ar);

            char[] ans=new char[N];

            // Iterator<Interval> it=ar.iterator();
            // while(it.hasNext()) System.out.println(it.next());


            int p1=-1;
            int p2=-1;
            boolean isp1=true;
            boolean oneFlip=false;
            boolean impossible=false;
            int idx=0;
            while(true){
                // System.out.println(isp1+" "+p1+" "+p2);
                if(isp1){
                    if(p1<0 || (ar.get(p1).end <= ar.get(idx).start)){
                        ans[idx]='J';
                        p1=idx;
                        idx++;
                        oneFlip=false;
                    }
                    else{
                        if(oneFlip){
                            impossible=true;
                            break;
                        }
                        isp1=false;
                        oneFlip=true;
                    }
                }
                else{
                    if(p2<0 || (ar.get(p2).end <= ar.get(idx).start)){
                        ans[idx]='C';
                        p2=idx;
                        idx++;
                        oneFlip=false;
                    }
                    else{
                        if(oneFlip){
                            impossible=true;
                            break;
                        }
                        isp1=true;
                        oneFlip=true;
                    }
                }
                if(idx==N)break;
            }

            System.out.print("Case #"+t+": ");
            if(impossible)System.out.print("IMPOSSIBLE");
            else for(int i=0;i<N;i++)System.out.print(ans[i]);
            System.out.println("");




        }
    }
}