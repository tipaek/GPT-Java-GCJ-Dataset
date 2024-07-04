import java.util.ArrayList;

import java.util.Scanner;

public class Solution {
    
    public static void main(String[] args){
        
        Scanner in = new Scanner(System.in);
        
        int t=in.nextInt();
        
        for(int k=0;k<t;k++){
        
        String x = in.next();
        char c[] = x.toCharArray();
        ArrayList<String> set = new ArrayList();
        String y="";
        for(int i=0;i<c.length-1;i++){
                if(c[i]==c[i+1]){
                    if(y.length()==0){
                    y+=c[i];
                    y+=c[i+1];
                    }
                    else{
                        y+=c[i+1];
                    }
                    
                } 
                else{
                    if(y.length()==0)
                    set.add(c[i]+"");
                    else{
                    set.add(y);
                    }
                    
                    y="";
                }
        }
       
        if(y.contains(c[c.length-1]+"")){

            set.add(y);
        }
        else{
            set.add(c[c.length-1]+"");
        }
        ArrayList<String> ans[] = new ArrayList[100];
        int count=-1;
        ans[0]=new ArrayList();
        for(int i=0;i<set.size();i++){
            int s = Integer.parseInt(String.valueOf(set.get(i).charAt(0)));
            String kabadi="";
            if(s!=0){
                for(int j=0;j<s;j++){
                    kabadi+='(';
                }
                kabadi+=set.get(i);
                for(int j=0;j<s-1;j++){
                    kabadi+=')';
                }
                count++;
                ans[count].add(kabadi);
                break;
            }
            else{
                count++;
                ans[count].add(set.get(i));
                ans[count+1]=new ArrayList();
                
            }
        }
        
        for(int i=count+1;i<set.size();i++){
            int s = Integer.parseInt(String.valueOf(set.get(i).charAt(0)));
            String kabadi="";
             if(s!=0){
                for(int j=0;j<s-1;j++){
                    kabadi+='(';
                }
                kabadi+=set.get(i);
                for(int j=0;j<s-1;j++){
                    kabadi+=')';
                }
                
                ans[count].add(kabadi);
               
            }
           else{
                ans[count].add(")"); 
                
                count++;
               
                ans[count]=new ArrayList();
                if(i!=set.size()-1)
                ans[count].add(set.get(i)+"(");
                else{
                ans[count].add(set.get(i));  
                }
                
                
            }
        }
        if(c[c.length-1]!='0'){
            ans[count].add(")");
        }  
        String kabadi="";
        for(int i=0;i<=count;i++){
            for(int j=0;j<ans[i].size();j++){
                kabadi+=(ans[i].get(j)).trim();
            }
        }
        System.out.println("Case #"+(k+1)+": "+kabadi);
        }
    }
    
}
