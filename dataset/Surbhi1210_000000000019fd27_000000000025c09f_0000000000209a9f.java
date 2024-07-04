import java.util.*;
class Solution{
    public static void main(String args[]){
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        int p=1;
        while(p<=t){
            String st=s.next().trim();
            String ans="";
            if(st.length()==1){
               for(int j=0;j<(int)(st.charAt(0)-'0');j++){
                    ans+="(";
                } 
                ans+=st.charAt(0)+"";
                for(int j=0;j<(int)(st.charAt(0)-'0');j++){
                    ans+=")";
                }
                System.out.println("Case #"+p+": "+ans);
           p++;
           continue;
            }
            for(int i=0;i<st.length();i++){
                if(i==0){
                for(int j=0;j<(int)(st.charAt(i)-'0');j++){
                    ans+="(";
                }
                ans+=st.charAt(i)+"";
                    
                }
                else if(i<st.length()-1){
                    int k=(int)(st.charAt(i)-'0');
                    int l=(int)(st.charAt(i-1)-'0');
                    if(k>l){
                   for(int j=0;j<(k-l);j++) {
                       ans+="(";
                   }
                        
                    }
                    else{
                       for(int j=0;j<(l-k);j++) {
                       ans+=")"; 
                    }
                }
               ans+=st.charAt(i)+""; 
            }else{
                int k=(int)(st.charAt(i)-'0');
                    int l=(int)(st.charAt(i-1)-'0');
                    if(k>l){
                   for(int j=0;j<(k-l);j++) {
                       ans+="(";
                   }
                        
                    }
                    else{
                       for(int j=0;j<(l-k);j++) {
                       ans+=")"; 
                    }
                }
                ans+=st.charAt(i)+"";
                for(int j=0;j<(int)(st.charAt(i)-'0');j++){
                    ans+=")";
                }
            }
         
        }
        System.out.println("Case #"+p+": "+ans);
           p++;
    }
    }

}