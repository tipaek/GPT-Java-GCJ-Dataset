import java.util.*;
import java.io.*;

class Pair implements Comparable{
    int st,end,ord;

    public Pair(int s, int e,int o){
        st=s;
        end=e;
        ord = o;
    }

    @Override
    public int compareTo(Object o) {
        int ost = ((Pair)o).st;
        return this.st - ost;
    }
}

public class Solution {




    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.

        for (int z = 1; z <= t; ++z) {
            int x = in.nextInt();
            int y = in.nextInt();
			if ( Math.abs(x)%2 ==1 && Math.abs(y)%2==1){
				
				System.out.println("Case #" + z + ": IMPOSSIBLE"); 
				continue;
			}	
			String xs = Integer.toBinaryString(Math.abs(x));
				String ys = Integer.toBinaryString(Math.abs(y));
			StringBuilder rev;
			rev= new StringBuilder(ys);			
			rev.reverse();
			ys=rev.toString();
			rev = new StringBuilder(xs);
rev.reverse();
xs=rev.toString();
			StringBuilder h=new StringBuilder();
			StringBuilder zero = new StringBuilder();
			if (x==0)xs="00";
			if (x==1)xs="10";
			if (y==0)ys="00";
			if (y==1)ys="10";
			int diff= Math.abs(xs.length()-ys.length());
			for (int i=0;i<diff;i++){
				zero.append("0");
			}
			if (xs.length()>ys.length()){
				ys =  ys+zero.toString() ;			
			}
			else{
				xs =xs+ zero.toString() ;
			}
			int px=0;int py=0;
		if (Math.abs(x)%2==1 || Math.abs(y)%2==1){
				for (int i=0;i<xs.length();i++){
					if (xs.charAt(i)=='1' && ys.charAt(i)=='1'){
						if (Math.abs(x)%2==1){xs="0" + xs.substring(1);h.append("W");ys=ys.substring(1)+"0";px=-1;}
						if (Math.abs(y)%2==1){ys="0" + ys.substring(1);h.append("S");xs=xs.substring(1)+"0";py=-1;}

							break;
					}
				}		
			}
		
			
					//	System.out.println(xs + " " + ys);
			boolean failed=false;		   
			for (int i=0; i<xs.length();i++){
				if (xs.charAt(i)=='1' && ys.charAt(i)=='0'){
					h.append("E");					
					continue;
				}
				if (ys.charAt(i)=='1' && xs.charAt(i)=='0'){
					h.append("N");
					continue;
				}
				if (xs.charAt(i)=='0'){
					//ys[i] is one. need to push everything left
					if (px==0 && py==0){System.out.println("Case #" + z + ": IMPOSSIBLE");failed=true; break;}
					if (px==1 || px==-1){
						h.deleteCharAt(i-1);
						if (px==1){h.append("W");h.append("E");px=1;}
						else{ h.append("E");h.append("W");px=-1;}
					}
					else {
						h.deleteCharAt(i-1);
						if (py==1){h.append("S");h.append("N");py=1;}
						else {h.append("N");h.append("S");py=-1;}
					}
				}
				else{
						
					if (px==0 && py==0){System.out.println("Case #" + z + ": IMPOSSIBLE");failed=true;break;} 
				}

			}
if (failed)continue;
			if (x<0){
				for (int i=0;i<h.length();i++){
					if (h.charAt(i)=='E'){h.deleteCharAt(i);h.insert(i,'W');}
					else if (h.charAt(i)=='W') {h.deleteCharAt(i);h.insert(i,'E');}
				}
			}
		
			if (y<0){
				for (int i=0;i<h.length();i++){
					if (h.charAt(i)=='N'){h.deleteCharAt(i);h.insert(i,'S');}
					else if (h.charAt(i)=='S'){h.deleteCharAt(i);h.insert(i,'N');}
				}
			}
			
		
		
		
			System.out.println("Case #" + z + ": "+ h.toString());
            




            //read 2 bits for verification
            //read 8 bits
            //repeat



        }
    }
}