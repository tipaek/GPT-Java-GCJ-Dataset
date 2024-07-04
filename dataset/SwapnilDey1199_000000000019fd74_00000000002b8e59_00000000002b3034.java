import java.util.*;
import java.io.*;
public class Solution{
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        StringBuffer sb = new StringBuffer();
        int t = sc.nextInt();
        int z = 1;
        while(t-->0){
            int n = sc.nextInt();
            String[]arr = new String[n];
            for(int i = 0;i<n;i++){
                arr[i]=sc.next();
            }
            String temp="";
            for(String s:arr){
                if(s.length()>temp.length()) temp = s;
            }
            
            
            int index = temp.indexOf("*");
            String left = temp.substring(0,index);
            String right = temp.substring(index+1,temp.length());
            
            String total = left+right;
            boolean f = true;
            outer:
            for(String s:arr){
                if(s.equals(temp)) continue;
                int i = s.indexOf("*");
                String ls = s.substring(0,i);
                String rs = s.substring(i+1,s.length());
                
                String totals = left+right;
                
                
                if(ls.equals("")){
                    if(!total.endsWith(rs)){
                        f = false;
                        break outer;
                    }
                }else if(rs.equals("")){
                    if(!total.startsWith(ls)){
                        f = false;
                        break outer;
                    }
                }else if(!(ls.equals("") && rs.equals(""))){
                    if(right.length()>=rs.length()){
                        if(!right.endsWith(rs)){
                            f = false;
                            break outer;
                        }
                    }else{
                        if(!rs.endsWith(right)){
                            f = false;
                            break outer;
                        }
                    }
                    if(left.length()>=ls.length()){
                        if(!left.startsWith(ls)){
                            f = false;
                            break outer;
                        }
                    }else{
                        if(!ls.startsWith(left)){
                            f = false;
                            break outer;
                        }
                    }
                }
            }
            if(!f) sb.append("Case #"+z+": "+"*"+"\n");
            else sb.append("Case #"+z+": "+temp.substring(1)+"\n");
            z++;
        }
        System.out.print(sb);
    }
}