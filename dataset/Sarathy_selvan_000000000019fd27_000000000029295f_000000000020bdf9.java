import java.util.*;
class Solution
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int test=sc.nextInt();
        int ii=1;
        while(test>0)
        {
            int size=sc.nextInt();
            int cs[]=new int[size];
            int ce[]=new int[size];
            int js[]=new int[size];
            int je[]=new int[size];
            int ic=0;
            int ij=0;
            int nil=0;
            int bla=0;
            String bb="";
            while(size>0)
            {
                int ra=sc.nextInt();
                int ba=sc.nextInt();
                if(ic==0)
                {
                    cs[ic]=ra;
                    ce[ic]=ba;
                    ic++;
                    bb+="C";
                }
                else
                {
                    for(int i=0;i<ic;i++)
                    {
                        if((ra>cs[i] && ra<ce[i]) ||(ba>cs[i] && ba<ce[i]))
                        {
                            
                                if(ij==0)
                                {
                                    bla=9;
                                    i=ic;
                                    js[ij]=ra;
                                    je[ij]=ba;
                                    ij++;
                                    bb+="J";
                                }
                                else
                                {
                                    for(int j=0;j<ij;j++)
                                    {
                                        //System.out.println("bb");
                                        if((ra>js[j] && ra<je[j]) ||(ba>js[j] && ba<je[j]))
                                        {
                                            bla=9;
                                            i=ic;
                                            nil=9;
                                            size=0;//System.out.println("bb");
                                            break;
                                        }
                                    }
                                    if(nil==0)
                                    {
                                        bla=9;
                                        js[ij]=ra;
                                        je[ij]=ba;
                                        i=ic;
                                        ij++;
                                        bb+="J";
                                    }
                                }
                            
                        }
                        
                    }
                    if(bla==0)
                    {
                         cs[ic]=ra;
                         ce[ic]=ba;
                         ic++;
                         bb+="C";
                    }
                    bla=0;
                    
                    
                }
                
                size--;
            }
            if(nil!=9)
                {
                  System.out.println("Case #"+ii+": "+bb);  
                }
                else
                {
                    System.out.println("Case #"+ii+": IMPOSSIBLE");
                }
            ii++;
            test--;
        }
    }
}