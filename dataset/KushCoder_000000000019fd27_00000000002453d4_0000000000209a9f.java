import java.util.Scanner;

/**
 *
 * @author pc
 */
class NestingDepth {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int t=scan.nextInt();
        for(int i=0;i<t;i++){
             String ss=scan.next();
             char ch[]=ss.toCharArray();
             String s="";
             int flag=0;
             
             for(int j=0;j<ch.length;j++){
                 char a=ch[j];
                     if(flag==0){
                               if(a=='1'){
                                     flag=1;
                                     s=s+"(";
                               }
                     }
                     else{
                               if(a=='0'){
                                    if(flag==1){
                                    flag=0;
                                    s=s+")";
                                    }
                               }
                     }
                     s=s+ch[j];
                     
                     
             }
             if(ch[ch.length-1]=='1'){
                      s=s+")";
             }
             System.out.println("Case #"+(i+1)+": "+s);
        }
    }
}
