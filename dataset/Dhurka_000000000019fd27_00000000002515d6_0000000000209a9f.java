import java.util.*;
public class Solution{
    public static void main(String args[]){
        Scanner s=new Scanner(System.in);
       int t=s.nextInt();
       int cas=1;
       while(t-->0){
           String str=s.next();
           int num=Integer.parseInt(str);
           int max=0;
           char c[]=str.toCharArray();
           int n=c.length;
           int top=0;
            ArrayList<String> res = new ArrayList<String>(4);
           for(int i=0;i<n;i++){
               int temp=(int)c[i];
               temp-=48;
               int te=temp;
               if(i==0){
                   if(temp==0){
                       top+=1;
                   }
                   else{
                   top=temp+1;
                   }
               while(te>0){
                   res.add("(");
                   te--;
               }
               res.add(Character.toString(c[i]));
               te=temp;
               while(te>0){
                   res.add(")");
                   te--;
               }
               }
               else{
                    
                    int f=(int)c[i-1];
                    f-=48;
                     if(temp>=f){
                         int rem=temp-f;
                         int re=rem;
                         int pot=top;
                         
                         while(re>0){
                             res.add(top++,"(");
                             re--;
                         }
                        
                         res.add(top++,Character.toString(c[i]));
                         re=rem;
                         pot=top;
                         while(re>0){
                             res.add(pot++,")");
                             re--;
                         }
                     }
                     else{
                         int rem=f-temp;
                         top+=(rem);
                         res.add(top++,Character.toString(c[i]));
                         
                     }
                     
               }
               
           }
            StringBuffer sb = new StringBuffer();
      
      for (String stri : res) {
         sb.append(stri);
         sb.append("");
      }
      String stri = sb.toString();
           System.out.println("Case #"+cas+": "+stri);
           cas++;
       }
    }
}