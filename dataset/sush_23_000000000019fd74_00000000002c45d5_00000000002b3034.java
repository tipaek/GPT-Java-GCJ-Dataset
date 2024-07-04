import java.util.*;
import java.util.stream.*;
class Solution{
static boolean flag = true;
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        out :for(int t=1;t<=T;t++){
             int n = sc.nextInt();
			boolean ans = true;
             String start = "",end="",mid="";
             while(n--!=0){
                 String str = sc.next();
                 int first = str.indexOf("*"),second=-1;
				 if(first==-1)first=str.length(); 
				 String match = str.substring(0,first);
				 flag = false;
				  start = isMatch(start,match);
				 // System.out.println("start "+start);
                 if(!flag){ans = false;}
				 
                 for(int i=str.length()-1;i>first;i--){
            		if(str.charAt(i) == '*'){second = i;break;}
                 }
                 if(second!=-1){
				 second+=1;
                   mid += str.substring(first,second);  
                 }else 
				 {
				 if(first!=str.length())second = first+1;
				 else second=0;
				 }
				 	match = str.substring(second);
					flag = false;
					 end = isMatch(end,match);
				//	 System.out.println("end "+end);
					if(!flag){ans = false;}
				 }
				 if(!ans)System.out.println("Case #"+t+": *");
				 else  System.out.println("Case #"+t+": "+start+mid+end);
             }
             
           
			}
			
			static String isMatch(String start,String match){
				if(start.indexOf(match)!=-1 || match.indexOf(start)!=-1){
				 	String newstr = start.length()>match.length() ? start : match;
					flag = true;
					return newstr;
				 }
				 return "";
			}
			}