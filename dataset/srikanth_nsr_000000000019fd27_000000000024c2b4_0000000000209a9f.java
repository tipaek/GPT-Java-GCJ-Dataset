import java.util.*;  
class Solution{  
 public static void main(String args[]){  
    
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    
    for(int i=0;i<t;i++){
        String s = sc.next();
        String out = "";
        int depth = 0;
        if(s.length()>0){
            String temp = ""+s.charAt(0);
            int a1 = Integer.parseInt(temp);
            for(int le=0;le<a1;le++)out+="(";
            out+=temp;
            depth = a1;
            
            for(int p=1;p<s.length();p++){
                temp = ""+s.charAt(p);
                int a = Integer.parseInt(temp);
                
                if(depth<a){
                    for(int le=0;le<a-depth;le++){
                        out+="(";
                    }
                }
                else if(depth>a){
                    for(int le=0;le<depth-a;le++){
                        out+=")";
                    }
                }
                depth = a;
                out+=temp;
                
            }
            for(int k=0;k<depth;k++){
                out+=")";
            }
        }
        System.out.println("Case #"+(i+1)+": "+out);
    }
     
 }  
} 