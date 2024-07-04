import java.util.*;
class Solution{
    public static void main(String args[]){
        Scanner kb=new Scanner(System.in);
        int t=kb.nextInt();
        for(int i=0;i<t;i++){
            String s=kb.next();
            String str=new String();
            int a[]=new int[s.length()];
           String c[]= s.split("");
            for(int j=0;j<s.length();j++){
                a[j]=Integer.parseInt(c[j]);
            }
            int count=0;
            for(int j=0;j<a[0];j++){
                str+="(";
                count++;
            }
            str+=c[0];
            for(int j=0;j<s.length()-1;j++){
                if(a[j+1]==0){
                    
                    for(int k=0;k<count;k++)
                        str+=")";
                     count=0;
                     str+="0";
                     continue;
                }
                if(a[j]>a[j+1]){
                    for(int k=0;k<(a[j]-a[j+1]);k++){
                        str+=")";
                        count--;
                                
                    }
                    str+=c[j+1];    
                }
                else if(a[j]<a[j+1]){
                    for(int k=0;k<(a[j+1]-a[j]);k++){
                        str+="(";
                        count++;
                                
                    }
                    str+=c[j+1]; 
                }
                else
                    str+=c[j+1];
            }
            for(int k=0;k<count;k++)
                        str+=")";
            System.out.println("Case #"+(i+1)+": "+str);
            
            
        }
    }
}