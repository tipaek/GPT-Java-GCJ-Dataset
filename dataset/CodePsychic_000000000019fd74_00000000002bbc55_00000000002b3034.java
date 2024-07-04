import java.util.*;
import java.io.*;
public class Solution {
  
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int x = 1; x <= t; ++x) {
      List<String> patterns = new ArrayList<String>();
      int p=in.nextInt();
      for(int y=1; y<= p; y++){
          patterns.add(in.next());
      }
      //System.out.println("pattern list= "+patterns);
      solve(x, patterns);
    }
  }
  
  
  public static void solve(int x, List<String> patterns){
      
      StringBuilder start = new StringBuilder();
      StringBuilder end = new StringBuilder();
      
      boolean possible=true;
      
      
      for(String pattern : patterns){
        //System.out.println("pattern="+pattern); 
        String[] parts=new String[2];
        
        if(pattern.startsWith("*")){
            parts[0]="";
            parts[1]=pattern.substring(1,pattern.length());
            //System.out.println("pattern="+pattern + "parts[0]= "+parts[0]+ "parts[1]= "+parts[1]);
        }else if(pattern.endsWith("*")){
            parts[0]=pattern.substring(0,pattern.length()-1);
            parts[1]="";
            //System.out.println("pattern="+pattern + "parts[0]= "+parts[0]+ "parts[1]= "+parts[1]);
        }else{
            //String[] inp_parts = pattern.split("\\*");   
            parts[0]= pattern.split("\\*")[0];
            parts[1]= pattern.split("\\*")[1];
            //System.out.println("pattern="+pattern + "parts[0]= "+parts[0]+ "parts[1]= "+parts[1]);
        }  
  
        
        
        if(start.length()==0 || parts[0].length()==0)
           start.append(parts[0]);
        else{
            if(parts[0].length() >= start.length()){
                if(parts[0].startsWith(start.toString())){
                    start.setLength(0);
                    start.append(parts[0]);
                }else{
                    possible=false;
                    break;
                }
            }else{
                if(start.toString().startsWith(parts[0]))
                  continue;
                else{
                    possible=false;
                    break;
                }  
            }
        }
        
        if(end.length()==0 || parts[1].length()==0)
           end.append(parts[1]);
        else{
            if(parts[1].length() >= end.length()){
                if(parts[1].endsWith(end.toString())){
                    end.setLength(0);
                    end.append(parts[1]);
                }else{
                    possible=false;
                    break;
                }
            }else{
                if(end.toString().endsWith(parts[1]))
                  continue;
                else{
                    possible=false;
                    break;
                }  
            }
        }

      }
      
    //System.out.println("Case #" + x + ": " +patterns);    
    
    System.out.println("Case #" + x + ": "+(possible?start.toString()+end.toString():"*") );  
    
    
  }
  
  
  
  
}