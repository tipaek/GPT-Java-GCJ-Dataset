import java.util.*;

class Solution
{
    public static void main(String args[])
    {
        Scanner cin=new Scanner(System.in);
        int test,n;
        test=cin.nextInt();
        String ans;
        int c,j,imp;
        for(int t=1;t<=test;t++)
        {
            n=cin.nextInt();
            float arr[]=new float[2*n];
            for(int i=0;i<2*n;i++)
            {
                if(i%2==0)
                    arr[i]=cin.nextFloat();
                else
                    arr[i]=(float)(cin.nextFloat()-0.1);
            }
            float sortedarr[]=arr.clone();
            Arrays.sort(sortedarr);
            c=-1;
            j=-1;
            imp=0;
            ans="";
            for(int i=0;i<2*n;i++)
            {
                for(int k=0;k<2*n;k++)
                {
                    if(sortedarr[i]==arr[k])
                    {
                        arr[k]=-1;
                        if(c==-1)
                        {
                            
                            if(j==-1)
                            {
                                c=k;
                                ans+="C";
                                // System.out.println("Hello1.1");
                            }
                            else if(k==j+1)
                            {
                                j=-1;
                                // System.out.println("Hello1.2");
                            }
                            else
                            {
                                c=k;
                                ans+="C";
                                // System.out.println("Hello1.3 "+j);
                            }
                        }
                        else if(k==c+1)
                        {
                            // System.out.println("Hello2");
                            c=-1;
                        }
                        else
                        {
                            if(j==-1)
                            {
                                j=k;
                                ans+="J";
                                // System.out.println("Hello3.1");
                            }
                            else if(k==j+1)
                            {
                                j=-1;
                                // System.out.println("Hello3.2");
                            }
                            else
                            {
                                imp=1;
                                // System.out.println("Hello3.3");
                            }
                        }
                        break;
                    }
                }
                if(imp==1)
                    break;
            }
            
            //Printing
            if(imp==1)
            {
                System.out.println("Case #"+t+": IMPOSSIBLE");
            }
            else
            {
                System.out.println("Case #"+t+": "+ans);
            }
        }
    }
}