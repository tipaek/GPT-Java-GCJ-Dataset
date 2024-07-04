import java.io.*;
import java.util.*;
class sol{
    public static void main(String args[]) throws IOExceptions{
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        int test=1;
        while(test<=t){
            String s=sc.nextLine();
            ArrayList<String> str = new ArrayList<String>(); 
            for(int i=0;i<s.length();i++){
                if(s.charAt(i)=='1'){
                    str.add("0");
                }
                else if(s.charAt(i)=='1'){
                    str.add("(");
                    str.add("1");
                    str.add(")");
                }
            }
            
            
            System.out.println("Case #"+test+":"+str);
            test++;
        }        
        
    }
}