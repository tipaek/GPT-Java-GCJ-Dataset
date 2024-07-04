import java.util.*;
public class Solution{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        int ra=1;
        while(ra<=t){
            int i;
            int n=sc.nextInt();
            sc.nextLine();
            String s[]=new String[n];
            for (i=0;i<n;i++){
                s[i]=sc.nextLine();
            }
            String q;
            int f=0;
            String res;
            
            String ma;
            res=s[0].substring(0,s[0].indexOf('*'));
            for (i=1;i<n;i++){
                q=s[i].substring(0,s[i].indexOf('*'));
                if  (q.length()!=0){
                    if (q.length()<res.length()){
                        if (!res.startsWith(q)){
                            f=1;
                            break;
                        }
                    }
                    else{
                        if (q.startsWith(res))
                        res=q;
                        else
                            {
                                f=1;
                                break;
                            }
                    }
                        }
                }
                if (f==1){
                    System.out.println("Case #"+ra+": "+"*");
                   
                    
                }
                else{
                    f=0;
                ma=new String(res);
                
            res=s[0].substring(s[0].lastIndexOf('*')+1,s[0].length());
          
            for (i=1;i<n;i++){
                q=s[i].substring(s[i].lastIndexOf('*')+1,s[i].length());
                if  (q.length()!=0){
                    if (q.length()<res.length()){
                        if (!res.endsWith(q)){
                            f=1;
                            break;
                        }
                    }
                    else{
                        if (q.endsWith(res))
                        res=q;
                        else
                            {
                                f=1;
                                break;
                            }
                    }
                }
            }
                    if (f==1){
                        System.out.println("Case #"+ra+": "+"*");
                   
                        
                    }
                    else{
                        String qy="";
                        for (i=0;i<n;i++){
                            int pq,qr;
                            pq=s[i].indexOf("*");
                            qr=s[i].lastIndexOf("*");
                            for (int ja=pq+1;ja<qr;ja++){
                                if (s[i].charAt(ja)!='*')
                                    qy+=s[i].charAt(ja);
                            }
                        }
                        System.out.println("Case #"+ra+": "+ma+qy+res);
                    }
                
              
            }
            ra++;
        }
    }
}