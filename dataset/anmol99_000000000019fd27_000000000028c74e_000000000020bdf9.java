import java.util.*;
import java.io.*;
public class Solution{
    
    static class helper{
        int st;
        int en;
        int in;
        char ans;
        
        helper(int st,int en,int in)
        {
            this.st = st;
            this.en = en;
            this.in = in;
            this.ans = '/';
        }
    }
    public static void main(String[] args)
    {
        Scanner s = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = s.nextInt();
        int U = T;
        while(T>0)
        {
            
            int N = s.nextInt();
            helper arr[] = new helper[N];
            for(int i = 0;i<N;++i)
            {
                arr[i] = new helper(s.nextInt(),s.nextInt(),i);
            }
            
            Arrays.sort(arr,new Comparator<helper>(){
                @Override
                public int compare(helper h1,helper h2)
                {
                    if(h1.st < h2.st)
                    {
                        return -1;
                    }
                    else if(h1.st > h2.st)
                    {
                        return 1;
                    }
                    else
                    {
                        return 0;
                    }
                }
            });
            int flag = 0;
            arr[0].ans = 'C';
            for(int i = 1;i<N;++i)
            {
                char lastans = arr[i-1].ans;
                if((i+1 < N) && (arr[i+1].st < arr[i-1].en) && arr[i+1].st < arr[i].en)
                {
                    flag = 1;
                    break;
                }
                else
                {
                    if(arr[i].st < arr[i-1].en)
                    {
                        if(lastans == 'C')
                            arr[i].ans = 'J';
                        else
                            arr[i].ans = 'C';
                    }
                    else
                    {
                        arr[i].ans = lastans;
                    }
                }
            }
            
            Arrays.sort(arr,new Comparator<helper>(){
                @Override
                public int compare(helper h1,helper h2)
                {
                    if(h1.in < h2.in)
                    {
                        return -1;
                    }
                    else if(h1.in > h2.in)
                    {
                        return 1;
                    }
                    else
                    {
                        return 0;
                    }
                }
            });
            String answer = "";
            for(int i = 0;i<N;++i)
            {
                answer += arr[i].ans;
            }
            
            if(flag == 1)
            {
                System.out.println("Case #" + (U-T+1) + ": IMPOSSIBLE");
            }
            else
            {
                System.out.println("Case #" + (U-T+1) + ": " + answer);
            }
            T--;
        }
    }
}