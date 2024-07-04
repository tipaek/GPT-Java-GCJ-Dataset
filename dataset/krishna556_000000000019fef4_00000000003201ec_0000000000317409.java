import java.util.*;
public class Solution {
    public static void main(String args[]) {
    Scanner sc=new Scanner(System.in);
    int cc=1;
    int t=sc.nextInt();
    while(t-->0)
    {   int i,y1,x1,ti,le;
        int x=sc.nextInt();
        int y=sc.nextInt();
        String st=sc.next();
        ArrayList<Integer> qu1=new ArrayList<Integer>();
        ArrayList<Integer> qu2=new ArrayList<Integer>();
        ArrayList<Integer> time=new ArrayList<Integer>();
        int[][] p =new int[st.length()+1][2];
        p[0][0]=x;
        p[0][1]=y;
        le=st.length();
        for(i=1;i<=st.length();i++)
        {   if(st.charAt(i-1)=='N')
            {y++;
                p[i][1]=y;
                p[i][0]=x;
            }else if(st.charAt(i-1)=='S')
            {
             y--;
             p[i][0]=x;
             p[i][1]=y;
            }else if(st.charAt(i-1)=='E')
            {
                x++;
                p[i][0]=x;
                p[i][1]=y;  
                }
                else
                {
                    x--;
                  p[i][0]=x;
                p[i][1]=y;   
                }
        }
        
        qu1.add(0);
        qu2.add(0);
        time.add(0);
        boolean fg=false;
        while(qu1.size()!=0 && time.get(0)<=le)
        {
            x1=qu1.get(0);
            y1=qu2.get(0);
            ti=time.get(0);
            if(x1==p[ti][0] && y1==p[ti][1])
            {   fg=true;
                System.out.println("Case #"+cc+": "+time.get(0));
                
                cc++;
                
                break;
            }
            else
            {
                qu1.add(x1+1);
                qu2.add(y1);
                                time.add(ti+1);
                if((ti+1) <=le)                
                if(x1+1==p[ti+1][0] && y1==p[ti+1][1])
            {   fg=true;
                System.out.println("Case #"+cc+": "+(ti+1));
                
                cc++;
                
                break;
            }
                                
                
                qu1.add(x1-1);
                qu2.add(y1);
                                time.add(ti+1);
               if((ti+1) <=le) 
             if(x1-1==p[ti+1][0] && y1==p[ti+1][1])
            {   fg=true;
                System.out.println("Case #"+cc+": "+(ti+1));
                
                cc++;
                
                break;
            }
                
                qu1.add(x1);
                qu2.add(y1+1);
                                time.add(ti+1);
                if((ti+1) <=le)  
            if(x1==p[ti+1][0] && y1+1==p[ti+1][1])
            {   fg=true;
                System.out.println("Case #"+cc+": "+(ti+1));
                
                cc++;
                
                break;
            }                    

                qu1.add(x1);
                qu2.add(y1-1);
                                time.add(ti+1);
                 if((ti+1) <=le)                 
            if(x1==p[ti+1][0] && y1-1==p[ti+1][1])
            {   fg=true;
                System.out.println("Case #"+cc+": "+(ti+1));
                
                cc++;
                
                break;
            }                    

                
                qu1.add(x1);
                qu2.add(y1);
                                time.add(ti+1);
                  if((ti+1) <=le) 
                if(x1==p[ti+1][0] && y1==p[ti+1][1])
            {   fg=true;
                System.out.println("Case #"+cc+": "+(ti+1));
                
                cc++;
                
                break;
            }     
                
                
            }
            qu1.remove(0);
            qu2.remove(0);
            time.remove(0);
            
            
        }
        if(!fg)
         {System.out.println("Case #"+cc+": Impossible");
             cc++;
         }
        
        
    }

     
    }
}