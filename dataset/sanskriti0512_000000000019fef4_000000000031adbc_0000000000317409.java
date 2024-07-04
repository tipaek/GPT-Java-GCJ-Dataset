import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.StringTokenizer; 
import java.util.*;
 
public class Solution 
{ 
 
   public static int ans(int x,int y,String m){
int sx=0,sy=0;
int t=0;
int i=0;
   while(i<m.length() && sx<x){
       char dir=m.charAt(i);
       if(dir=='N')
       y++;
       else
       y--;
       sx++;
       i++;
       t++;
   }
   //System.out.println(sx+" "+y+" "+t);
   while(i!=m.length()){
    if(sy==y){
    break;
    }
   else if(sy==y-1 && m.charAt(i)=='S')
    y--;
    else if(sy==y+1 && m.charAt(i)=='N')
    y++;
    else if(sy<y){
        if(m.charAt(i)=='N')
        y++;
        else
        y--;
        sy++;
    }else if(sy>y){
        if(m.charAt(i)=='N')
        y++;
        else
        y--;
        sy--;
    }
    i++;
    t++;   
   }
   if(sy==y)
    return t;
    return -1;
    
   }
   
    public static void main(String[] args) throws IOException 
    { 
  
       BufferedReader br = new BufferedReader( 
                              new InputStreamReader(System.in));
            int t=Integer.parseInt(br.readLine());
            
            for(int i=0;i<t;i++){
                StringTokenizer st=new StringTokenizer(br.readLine());
               int x=Integer.parseInt(st.nextToken());
               int y=Integer.parseInt(st.nextToken());
               String moves=st.nextToken();
              int answer=ans(x,y,moves);
              if(answer==-1)
              System.out.println("Case #"+(i+1)+": "+"IMPOSSIBLE");
              else
               System.out.println("Case #"+(i+1)+": "+answer);
        }
        
    }
    }

    