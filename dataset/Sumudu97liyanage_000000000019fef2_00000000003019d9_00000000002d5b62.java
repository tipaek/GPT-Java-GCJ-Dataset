import java.util.*;
import java.io.*;
import java.lang.Math; 


public class Solution {
    
     public static void solve(int x, int y,int t)
     {
        int steps = Math.abs(x)+Math.abs(y);
        
        double s = (Math.log(steps) / Math.log(2));
        int val = (int)Math.floor(s);
        int condition=0;
        List<Integer> list = new ArrayList<Integer>();
        String s1="";
        while(true){
            int v = (int)Math.pow(2,val);
            
            if (steps>0){
                steps=steps-v;
            }
            else if (steps<0){
                steps=steps+v;
            }
            
            if (steps==0){
                if(val==0){
                   condition=1;
                   list.add(val);
                   break;
                }
                else{
                    break;
                }
            }
            else{
                if (val<0){
                    break;
                }
            }
            list.add(val);
            val=val-1;
            
        }
        
        if (condition==0){
            System.out.println("Case #" + t + ": " + "IMPOSSIBLE");
        }
        else{
            int i=0;
            while(i<list.size()){
				
				if (Math.abs(x)>=Math.abs(y)){
					if (x>0){
						x=x-(int)(Math.pow(2,list.get(i)));
                        s1='E'+s1;
					}
					else if (x<0){
						x=x+(int)(Math.pow(2,list.get(i)));
                        s1='W'+s1;
					}
				}
				else{
					if (y>0){
						y=y-(int)(Math.pow(2,list.get(i)));
                        s1='N'+s1;
					}
					else if (y<0){
						y=y+(int)(Math.pow(2,list.get(i)));
                        s1='S'+s1;
					}
				}
                
                
               
                
                i=i+1;
                
            }
            
            System.out.println("Case #" + t + ": " + s1);
        }
     }
    
     public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); 
        for (int i = 1; i <= t; ++i) {
            
          int x = in.nextInt();
          int y = in.nextInt();
          
          solve(x,y,i);
          
          
          
        }
      }
}
