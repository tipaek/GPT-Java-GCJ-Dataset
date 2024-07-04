import java.util.*;
public class Solution {
    public static void main(String args[]) {
      Scanner sc = new Scanner(System.in);
      int t = sc.nextInt();
      int tcase = 0;
      while(t-- > 0){
        tcase++;
        int n = sc.nextInt();
        sc.nextLine();
        ArrayList<String> list = new ArrayList<>();
        int max = 0;
        int starmax = 0,starmaxindex=0;
        int endstarL = Integer.MIN_VALUE;
        int startstarL = Integer.MIN_VALUE;
        String endstar ="";
        String startstar = "";
        boolean starflag=false;
        for(int i=0;i<n;i++){
            String str = sc.nextLine();
            list.add(str);
            max = str.length() > list.get(max).length() ? i : max;
            int index = str.indexOf('*');
            
            if(str.length() - index > starmax ){
                starmax = str.length() - index;
                starmaxindex = i;
            }
            
            
            if(str.charAt(0) != '*')
                starflag=true;
            
            if(str.startsWith("*")){
                if(str.length() > startstarL){
                    startstar = str;
                    startstarL = str.length();
                }
            }
            
            if(str.endsWith("*")){
                if(str.length() > endstarL){
                    endstar = str;
                    endstarL = str.length();
                }
            }
            
        }
        
        if(starflag)
        {
            // System.out.println();
            // continue;
            String longStr = list.get(starmaxindex);
            boolean flag = false;
            
            
            String res ="";
            if( endstar.equals("") || startstar.equals("")){
                res = longStr;
            }
            else{
                res =  endstar + startstar;
            }
            
            
            
            
            for(int i=0;i<longStr.length();i++){
            
            if(i == longStr.length()-1){
                System.out.printf("Case #%d: %s",tcase,longStr.substring(1));
                System.out.println();
                break;
            }
            
            String pattern = longStr.substring(longStr.length()-1-i,longStr.length());
            
            int traverse = pattern.length();
            
            //System.out.println(pattern);
            
            for(int j=0;j<n;j++){
                if(j == starmax)
                    continue;
                
                String s = list.get(j);
                
                if(s.length() <= pattern.length())
                    continue;
                else if(s.charAt(s.length()-traverse)=='*'){
                    list.set(j,"");
                    continue;
                }
                    
                boolean conclusion = s.endsWith(pattern);
                if(!conclusion)
                {
                    flag = true;
                    break;
                }
                
                
                
            }
            
            if(flag)
                break;
            
        }
        
        if(flag){
            System.out.printf("Case #%d: *",tcase);
            System.out.println();
        }
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            continue;
        }
        
        
       // System.out.println(list.get(max));
        String longStr = list.get(max);
        boolean flag = false;
        for(int i=0;i<longStr.length();i++){
            
            if(i == longStr.length()-1){
                System.out.printf("Case #%d: %s",tcase,longStr.substring(1));
                System.out.println();
                break;
            }
            
            String pattern = longStr.substring(longStr.length()-1-i,longStr.length());
            
            //System.out.println(pattern);
            
            for(int j=0;j<n;j++){
                if(j == max)
                    continue;
                
                String s = list.get(j);
                if(s.length() <= pattern.length())
                    continue;
                    
                boolean conclusion = s.endsWith(pattern);
                if(!conclusion)
                {
                    flag = true;
                    break;
                }
                
                
                
            }
            
            if(flag)
                break;
            
        }
        
        if(flag){
            System.out.printf("Case #%d: *",tcase);
            System.out.println();
        }
        
      }
      
    }
}
