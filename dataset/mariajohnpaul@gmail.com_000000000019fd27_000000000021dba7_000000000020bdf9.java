import java.util.*;
public class Solution{
    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t=1;t<=T;t++)
        {
            int N = sc.nextInt();
            ArrayList<int []> arl = new ArrayList<>();
            for(int i=0;i<N;i++)
            {
                int Si = sc.nextInt();
                int Ei = sc.nextInt();
                arl.add(new int [] {Si, Ei, i});
            }
            Collections.sort(arl,(a,b)->{
                if(a[0]!=b[0])return a[0]-b[0];
                return a[1]-b[1];
            });
            char [] arr = new char[N];
            int Jav=0;
            int Cav=0;
            boolean imp = false;
            for(int i=0;i<arl.size();i++)
            {
                int [] curr = arl.get(i);
                if(Jav<=curr[0])
                {
                    Jav = curr[1];
                    arr[curr[2]]='J';
                }else if(Cav<=curr[0])
                {
                    Cav = curr[1];
                    arr[curr[2]]='C';
                }else{
                    imp = true;
                    break;
                }
            }
            if(imp)
            {
            System.out.println("Case #"+t+": "+"IMPOSSIBLE");
            }else{
                StringBuilder sb = new StringBuilder();
                for(char c : arr)sb.append(c);
                System.out.println("Case #"+t+": "+sb.toString());
            }
        }
    }
}