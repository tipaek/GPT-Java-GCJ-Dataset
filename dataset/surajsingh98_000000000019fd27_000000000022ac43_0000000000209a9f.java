import java.util.*;
public class Solution{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int j=0;j<t;j++){
            String s=sc.next();
            char[] ch = new char[s.length()];
            String modified = "";
            for(int i=0;i<ch.length;i++){
                if(i==0 && ch.length ==1){
                    modified += new String(new char[s.charAt(i)-'0']).replace("\0", "(");
                    modified+=s.charAt(i);
                    modified += new String(new char[s.charAt(i)-'0']).replace("\0", ")");
                }
                else if(i==0){
                    modified+=new String(new char[(s.charAt(i)-'0')]).replace("\0", "(");
                    modified+=s.charAt(i);
                }
                
                else{
                    if((s.charAt(i)-'0')>(s.charAt(i-1)-'0')){
                        modified+=new String(new char[(s.charAt(i)-'0')-(s.charAt(i-1)-'0')]).replace("\0", "(");
                        modified+=s.charAt(i);
                    }
                    else if((s.charAt(i)-'0')<(s.charAt(i-1)-'0')){
                        modified+=new String(new char[(s.charAt(i-1)-'0')-(s.charAt(i)-'0')]).replace("\0", ")");
                        modified+=s.charAt(i);
                    }
                    else if((s.charAt(i)-'0')==(s.charAt(i-1)-'0')){
                        modified+=s.charAt(i);
                    }
                    if(i==ch.length-1){
                        
                        modified+=new String(new char[(s.charAt(i)-'0')]).replace("\0", ")");
                    }   
                }
            }
            System.out.println("Case #"+(j+1)+": "+modified);
        }
    }
}