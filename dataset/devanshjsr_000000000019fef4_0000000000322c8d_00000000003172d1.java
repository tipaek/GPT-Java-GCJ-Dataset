import java.util.*;
import java.io.*;
import java.lang.*;

public class Solution  {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY

    public static void main(String args[]) throws java.lang.Exception
    {
        Scanner sc=new Scanner(System.in);

        int t=sc.nextInt();
        int st=1;

        while(t>0)
        {
            int n=sc.nextInt();
            int d=sc.nextInt();

               int ans=-1;
            ArrayList<Long> arr=new ArrayList<Long>();
            ArrayList<Long> cnt=new ArrayList<Long>();

            for(int i=0;i<n;i++)
            {
                long ang=sc.nextLong();
                int ind=arr.indexOf(ang);

                if(ind<0)
                {
                    arr.add(ang);
                    cnt.add((long)1);
                }
                else
                {
                    cnt.set(ind,cnt.get(ind)+1);
                    if(cnt.get(ind)==d)
                    {
                        ans=0;
                        break;
                    }
                }
            }





            if(ans==0)
            {
                System.out.println("Case #"+st+": "+ans);
            }
            else
            {
                if(d==2)
                {
                    System.out.println("Case #"+st+": "+1);
                }
                else
                {
                    ArrayList<Long> tmp=new ArrayList<Long>();
                    for(int i=0;i<arr.size();i++)
                    {
                        if(cnt.get(i)==2)
                        {
                            tmp.add(arr.get(i));
                        }
                    }

                    for(int i=0;i<tmp.size();i++)
                    {
                        for(int j=0;j<arr.size();j++)
                        {
                            if(arr.get(j)>tmp.get(i))
                            {
                                ans=1;
                                break;
                            }
                        }

                        if(ans==1)
                        {
                            break;
                        }
                    }

                    if(ans==1)
                    {
                        System.out.println("Case #"+st+": "+1);
                    }
                    else
                    {
                        Collections.sort(arr);
                        int s=arr.size();
                        long q=arr.get(s-1);
                        long div=0;
                        if(arr.get(0)>0)
                        {
                         div=(q/arr.get(0));
                        }

                        if(div>=2)
                        {
                            System.out.println("Case #"+st+": "+1);
                        }
                        else
                        {
                            System.out.println("Case #"+st+": "+2);
                        }
                        
                        //System.out.println("Case #"+st+": "+2);
                    }

                }
                
            }
            
            t--;
            st++;

        }
    }
}
