import java.util.*;
class mycode{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        
        int t= scan.nextInt();
        String[] st = new String[t];
        for(int i=0;i<t;i++)
        {
            int flag =0;
            int sum=0;
            int n= scan.nextInt();
            Integer[] s = new Integer[n+1];
            Integer[] e = new Integer[n+1];
            char[] ch = new char[n];
            for(int k=0;k<n;k++)
            {
                s[k] = scan.nextInt();
                e[k] = scan.nextInt();
            }
            
            for(int j=0;j<n;j++)
            {
              ch[0] = 'C';
              if(s[j+1]<e[j]&& e[j+1]>e[j])
              {
              ch[j+1] = 'J';
            }
            else if(s[j+1]==e[j]||s[j+1]>e[j]){
            ch[j+1] = 'C';
            }
            else if(s[j+1]<e[j]&& e[j+1]<e[j]){
                flag=1;
            }
    }
            if(flag==0){
          st[i]=ch.toString();
            }else if(flag==1){
                st[i] ="Impossible";
            }
   }
        for(int i=0;i<t;i++){
              System.out.println("Case #" + i+1 +": "+ st[i] );
        }
}}
    