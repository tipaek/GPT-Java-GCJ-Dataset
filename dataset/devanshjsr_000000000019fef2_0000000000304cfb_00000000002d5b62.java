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
            long x=sc.nextLong();
            long y=sc.nextLong();

            long x1=Math.abs(x);
            long y1=Math.abs(y);

            long max=0;
            String s="";

            if(x1>y1)
            {
                max=2*x1;
            }
            else
            {
                max=2*y1;
            }

            ArrayList<Long> a1=new ArrayList<Long>();
            ArrayList<Long> a2=new ArrayList<Long>();
            ArrayList<Long> a3=new ArrayList<Long>();

        

            for(long i=0;Math.pow(2,i)<=max;i++)
            {
                long tmp=(long)Math.pow(2,i);
                a2.add(tmp);
                a1.add(tmp+1);
                a3.add(2*tmp-1);
                
            }

           // System.out.println(max);

            if((a2.contains(x1)==false && a2.contains(y1)==false) || x1==0 || y1==0)
            {
                    if(x1==0 && a3.contains(y1)==false)
                    {
                            //f=0;
                            System.out.println("Case #"+st+": "+"IMPOSSIBLE");
                    }
                    else
                    {
                        if(y1!=0)
                        {

                        
                        if(y<0)
                        {
                            int index=a3.indexOf(y1);

                            for(int i=0;i<index+1;i++)
                            {
                                s+="S";
                            }

                            System.out.println("Case #"+st+": "+s);
                        }
                        else
                        {
                            
                            int index=a3.indexOf(y1);

                            for(int i=0;i<index+1;i++)
                            {
                                s+="N";
                            }

                            System.out.println("Case #"+st+": "+s);
                        }
                        }
                    }
                    
                    if(y1==0 && a3.contains(x1)==false)
                    {
                            //f=0;
                            System.out.println("Case #"+st+": "+"IMPOSSIBLE");
                    }
                    else
                    {
                        if(x1!=0)
                        {

                        
                        if(x<0)
                        {
                            int index=a3.indexOf(x1);

                            for(int i=0;i<index+1;i++)
                            {
                                s+="W";
                            }

                            System.out.println("Case #"+st+": "+s);
                        }
                        else
                        {
                            
                            int index=a3.indexOf(x1);

                            for(int i=0;i<index+1;i++)
                            {
                                s+="E";
                            }

                            System.out.println("Case #"+st+": "+s);
                        }
                        }
                    }
            }
            else
            {
                if(a2.contains(x1)==true)
                {
                    int index=a2.indexOf(x1);
                    if(y1==a1.get(index))
                    {
                        if(y<0)
                        {
                            for(int i=0;i<index;i++)
                            {
                                s+="N";
                            }

                            if(x<0)
                            {
                                s+="WS";
                            }
                            else
                            {
                                s+="ES";
                            }

                            System.out.println("Case #"+st+": "+s);
                        }
                        else
                        {
                            for(int i=0;i<index;i++)
                            {
                                s+="S";
                            }

                            if(x<0)
                            {
                                s+="WN";
                            }
                            else
                            {
                                s+="EN";
                            }

                            System.out.println("Case #"+st+": "+s);
                        }
                    }
                    else
                    {
                        if((index-1)>0)
                        {

                        
                        if(y1==a3.get(index-1))
                        {
                            if(y<0)
                        {
                            for(int i=0;i<index+1;i++)
                            {
                                s+="S";
                            }

                            if(x<0)
                            {
                                s+="W";
                            }
                            else
                            {
                                s+="E";
                            }

                            System.out.println("Case #"+st+": "+s);
                        }
                        else
                        {
                            for(int i=0;i<index+1;i++)
                            {
                                s+="N";
                            }

                            if(x<0)
                            {
                                s+="W";
                            }
                            else
                            {
                                s+="E";
                            }

                            System.out.println("Case #"+st+": "+s);
                        }
                        }
                        }
                        else
                        {
                            //f=0;
                            System.out.println("Case #"+st+": "+"IMPOSSIBLE");
                        }
                    }
                }
                else
                {
                    if(a2.contains(y1)==true)
                    {
                        int index=a2.indexOf(y1);
                    if(x1==a1.get(index))
                    {
                        if(x<0)
                        {
                            for(int i=0;i<index;i++)
                            {
                                s+="E";
                            }

                            if(y<0)
                            {
                                s+="SW";
                            }
                            else
                            {
                                s+="NW";
                            }

                            System.out.println("Case #"+st+": "+s);
                        }
                        else
                        {
                            for(int i=0;i<index;i++)
                            {
                                s+="W";
                            }

                            if(y<0)
                            {
                                s+="SE";
                            }
                            else
                            {
                                s+="NE";
                            }

                            System.out.println("Case #"+st+": "+s);
                        }
                    }
                    else
                    {
                        if(x1==a3.get(index-1))
                        {
                            if(x<0)
                        {
                            for(int i=0;i<index+1;i++)
                            {
                                s+="W";
                            }

                            if(y<0)
                            {
                                s+="S";
                            }
                            else
                            {
                                s+="N";
                            }

                            System.out.println("Case #"+st+": "+s);
                        }
                        else
                        {
                            for(int i=0;i<index+1;i++)
                            {
                                s+="E";
                            }

                            if(y<0)
                            {
                                s+="S";
                            }
                            else
                            {
                                s+="N";
                            }

                            System.out.println("Case #"+st+": "+s);
                        }
                        }
                        else
                        {
                           // f=0;
                           System.out.println("Case #"+st+": "+"IMPOSSIBLE");
                        }
                    }
                    }
                    else
                    {
                        //f=0;
                        System.out.println("Case #"+st+": "+"IMPOSSIBLE");
                    }
                }
            }


            t--;
            st++;

        }
    }
}
