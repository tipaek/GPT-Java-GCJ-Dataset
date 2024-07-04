import java.io.*; 
import java.util.*; 
public class NestingDepth {
    
 public static void main(String args[]) {
      Scanner sc=new Scanner(System.in);
       int t=sc.nextInt();
       for(int id=1;id<=t;id++){
              String s=sc.nextLine();
              String res="",s0="0";
              s=s0+s+s0;
              String s2="";
              for(int i=s.length()-1;i>0;i--)
              {   
                  
                  if(s.charAt(i)!=s.charAt(i-1)){
                      res=s.charAt(i) + res;
                      int x=(s.charAt(i)-'0')-(s.charAt(i-1)-'0');
                      if(x>0)
                      {
                          for(int j=0;j<x;j++)
                          {
                              res = '('+ res;
                          }
                      }
                      if(x<0){
                          for(int j=0;j<Math.abs(x);j++)
                          {
                              res = ')'+ res;
                          }
                      }
                  }
                  else{
                      
                      res=s.charAt(i)+res;
                  }
              }
              for(int i=0;i<res.length()-1;i++)
              {
                 s2+=res.charAt(i);
              }
              System.out.println("Case #"+(id)+": "+s2);
           }
       }
       
    }
