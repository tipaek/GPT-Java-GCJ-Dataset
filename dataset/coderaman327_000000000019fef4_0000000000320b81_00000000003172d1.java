import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws java.io.IOException{
	// write your code here
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int j=1;j<=t;j++){
           int n=sc.nextInt();
           int d=sc.nextInt();
            ArrayList<Long> slices=new ArrayList<>();
            for(int i=0;i<n;i++)
                slices.add(sc.nextLong());
            Collections.sort(slices);
            if(d==2)
            {
                int ans=1;
                for(int i=0;i<n-1;++i)
                {
                    if(slices.get(i)==slices.get(i+1)) {
                        ans = 0;
                        break;
                    }
                }
                System.out.println("Case #"+j+": "+ans);
            }
            else
            {
                int ans=2;
                for(int i=0;i<n-2;++i)
                {
                    if(slices.get(i)==slices.get(i+1)&&slices.get(i)==slices.get(i+2)) {
                        ans = 0;
                        break;
                    }
                }
                if(ans==2)
                {
                    for(int i=0;i<n-1;++i)
                    {
                        if(slices.get(i)==slices.get(i+1)) {
                            if(slices.get(n-1)>=2*slices.get(i))
                            {
                                ans=1;
                                break;
                            }
                        }
                    }
                }
                if(ans==2)
                {
                    for(int i=0;i<n-1;++i)
                    {
                        boolean cond=false;
                        long cur_size=slices.get(i);
                        for(int k=0;k<n;++k)
                        {
                            if(slices.get(k)==2*cur_size) {
                                cond=true;
                                break;
                            }
                        }
                        if(cond==true)
                        {
                            ans=1;
                            break;
                        }
                    }
                }
                System.out.println("Case #"+j+": "+ans);
            }
        }
    }
}
