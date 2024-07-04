import java.util.Scanner;

/**
 *
 * @author pc
 */
public class Solution {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        
        int t=scan.nextInt();
        
        for(int i=0;i<t;i++){
              int n=scan.nextInt();
              String s[]=new String[n];
              int length=0;
              String reString="";
              
              for(int j=0;j<n;j++){
                  s[j]=scan.next();
                  char ch[]=s[j].toCharArray();
                  String sa="";
                  for(int k=0;k<ch.length;k++){
                      if(ch[k]!='*'){
                          sa=sa+ch[k];
                      }
                  
                  }
                  s[j]=sa;
                  if(s[j].length()>length){
                      length=s[j].length();
                      reString=s[j];
                  }
              }
              int flag=0;
              for(int j=0;j<n;j++){
                  int l=s[j].length();
                  String subString=reString.substring(length-l);
                  if(!subString.equals(s[j])){
                          flag=1;
                          break;
                  }
              }
              System.out.print("Case #"+(i+1)+": ");
              if(flag==0){
                  System.out.println(reString);
              }
              else
              {
                  System.out.println("*");
              }
        }
    }
}
