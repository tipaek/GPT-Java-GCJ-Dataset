import java.util.*;

class Solution{

public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    
    int t=sc.nextInt();
    int b=sc.nextInt();
    
    for(int j=0;j<t;j++){
        char[] bits=new char[b];
        int count=1;
        
        int que=1;
        
        while(pos<=b){
            
            
            System.out.println(pos);
            System.out.flush();
            char bit=sc.next();
        
            
               
                bits[pos-1]=bit;    
            
            que++;
            
        }
        String result=new String(bits);
        System.out.println(result);
        char output=sc.next();
        if(output=='Y')
            continue;
        else if(result.charAt(0)=='1'){
            System.out.println("0"+result.substring(1));
            continue;
        }
        else if(result.charAt(0)=='0'){
            System.out.println("1"+result.substring(1));
            continue;
        }
            
        
    }
    
}


}