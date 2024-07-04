
//package code.jam;

import java.util.*;

public class ESABATAD {
    
    public static void main(String args[]){
        
        Scanner sc=new Scanner(System.in);
        int t,b;
        t=sc.nextInt();
        b=sc.nextInt();
        ArrayList<String> s=new ArrayList<String>();
        ArrayList<String> f=new ArrayList<String>();
        boolean exit1=false;
        for(int i=0;i<t;i++)
        {
            int k=1;
            for(int j=1;j<150;j++)
            {
                System.out.println(k);
                if(j%10==1)
                {
                    f.add(sc.nextLine());
                }
                else
                {
                    s.add(sc.nextLine());
                    k++;
                }
                
                if(s.size()==b)
                {
                    String val="";
                    for(int x=0;x<b;x++)
                    {
                        val=val+s.get(x);
                    }
                    System.out.println(val);
                    String ans="";
                    ans=sc.nextLine();
                    if(ans=="N")
                    {
                        exit1=true;
                        break;
                    }
                    else if(ans=="Y")
                    {
                        exit1=false;
                        break;
                    }
                    
                }
            }
            
            if(exit1)
            {
                break;
            }
        }
    }
}
