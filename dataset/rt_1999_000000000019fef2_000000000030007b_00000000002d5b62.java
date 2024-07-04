import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		for(int q = 1;q<=t ;q++){
			long x = in.nextLong();
			long y = in.nextLong();
			int ind = -1;
			long total = 0;
			TreeMap<Long,Integer> hm = new TreeMap<>();
			TreeMap<Long,Integer> hm1 = new TreeMap<>();
			for(int i=0;i<=40;i++){
				hm.put((long)Math.pow(2,i),i);
				hm1.put((long)Math.pow(2,i),i);
			}
			ArrayList<Character> ans = new ArrayList<>();
			for(int i=0;i<40;i++)
				ans.add(' ');
			
			
			char y1 = ' ';
			if(x<0){
				y1='W';
				x*=-1;
			}else y1='E';
			
			
			while(total<=x){
				ind++;
				total+=Math.pow(2,ind);
				ans.set(ind,y1);
				hm.remove((long)Math.pow(2,ind));
			}
			while(total>x){
				long val = (long)Math.pow(2,ind);
				if(total-val==x){
					hm.put(val,ind);
					ans.set(ind,' ');
					break;
				}else if(total-val<x){
					
				}else{
					hm.put(val,ind);
					total-=val;
					ans.set(ind,' ');
				}
				ind--;
				if(ind==-1)
					break;
			}
			
			ArrayList<Long> al = new ArrayList<>(hm.keySet());
			int siz = al.size();
			boolean b = false;
			total = 0;
			ind = -1;
			char y2 = ' ';
			char rev = ' ';
			if(y>=0){
				y2 = 'N';
				rev = 'S';
			}else{ 
				y*=-1;
				y2 ='S';
				rev = 'N';
			}
			while(total < y){
				ind++;
				long val = al.get(ind);
				ans.set(hm.get(val),y2);
				total += val;
				hm.remove(val);
			}
		
			while(total>y){
				long val = al.get(ind);
				if(total-(2*val)==y){
					ans.set(hm1.get(val),rev);
					total-=(2*val);
					break;
				}else if(total-(2*val)<y){
					
				}else{
					total-=(2*val);
					ans.set(hm1.get(val),rev);
				}
				ind--;
				if(ind==-1)
					break;
			}
			if(total!=y){
				System.out.println("Case #"+q+": "+"IMPOSSIBLE");
				continue;
			}
			StringBuilder sb = new StringBuilder();
			for(int i=0;i<=40;i++){
				if(ans.get(i)!=' ')
					sb.append(ans.get(i));
				else break;
			}
			
			System.out.println("Case #"+q+": "+sb.toString());
		}
	}   
}