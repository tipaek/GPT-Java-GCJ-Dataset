import java.util.*;
public class Solution{

    public static void main(String[] args)throws Exception{
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int k=t;
        while(t-->0){
            ArrayList<Integer> a = new ArrayList<>();
            ArrayList<Integer> b = new ArrayList<>();
            int r = sc.nextInt();
            int s =sc.nextInt();
            int rr=r;
            int ss = s;
            int done =1;
            while(r!=1){
                int extra =0;
                for(int i=s-1;i>=1;i--){
                    int x =r*i+extra;
                    int y = rr*ss - x - done;
                    extra = y;
                    a.add(x);
                    b.add(y);
                    done++;
                }
                r = r-1;
                done =1;
                rr = r;
            }
            System.out.println("Case #"+(k-t)+": "+a.size());
            for(int i=0;i<a.size();i++) {
                System.out.println(a.get(i)+" "+b.get(i));
            }

        }
    }
}

