import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
		String[] inp = scan.readLine().split(" ");
		int T = Integer.parseInt(inp[0]);
		
		for(int t = 1; t<=T; t++){
			
			int mid = 500000000;
			String s1 = "0 0";
			String s2 = mid+ " " + mid;
			String s3 = -mid+ " " + mid;
			String s4 = mid+ " " + -mid;
			String s5 = -mid+ " " + -mid;
			
			String[] s = {s1, s2, s3, s4, s5};
			int x = 0;
			int y = 0;
			boolean done = false;
			for(int i = 0; i<5; i++){
				System.out.println(s[i]);
				System.out.flush();
				String l = scan.readLine();
				if(l.equals("CENTER")){
					done = true;
					break;
					
				} else if(l.equals("HIT")){
					String[] bla = s[i].split(" ");
					x = Integer.parseInt(bla[0]);
					y = Integer.parseInt(bla[1]);
					break;
				}
					
					
			}
			if(done){
				continue;
			}
			
			long minx = x;
			long maxx = 2*mid;
			while(maxx-minx>1){
				long mid2 = (minx + maxx)/2;
				System.out.println(mid2 + " " + y);
				System.out.flush();
				String l = scan.readLine();
				if(l.equals("CENTER")){
					done = true;
					break;
					
				} else if(l.equals("HIT")){
					minx = mid2;
				}else{
					maxx = mid2;
				}
				
				
			}
			long rightx = (int) minx;
			
			if(done){
				continue;
			}
			
			maxx = x;
			minx = -2*mid;
			while(maxx-minx>1){
				long mid2 = (minx + maxx)/2;
				System.out.println(mid2 + " " + y);
				System.out.flush();
				String l = scan.readLine();
				if(l.equals("CENTER")){
					done = true;
					break;
					
				} else if(l.equals("HIT")){
					maxx = mid2;
				}else{
					minx = mid2;
				}
				
				
			}
			long leftx = (int) maxx;
			
			if(done){
				continue;
			}
			
			
			long miny = y;
			long maxy = 2*mid;
			while(maxy-miny>1){
				long mid2 = (miny + maxy)/2;
				System.out.println(x + " " + mid2);
				System.out.flush();
				String l = scan.readLine();
				if(l.equals("CENTER")){
					done = true;
					break;
					
				} else if(l.equals("HIT")){
					miny = mid2;
				}else{
					maxy = mid2;
				}
				
				
			}
			long topy = (int) miny;
			
			if(done){
				continue;
			}
			
			miny = -2*mid;
			maxy = y;
			while(maxy-miny>1){
				long mid2 = (miny + maxy)/2;
				System.out.println(x + " " + mid2);
				System.out.flush();
				String l = scan.readLine();
				if(l.equals("CENTER")){
					done = true;
					break;
					
				} else if(l.equals("HIT")){
					maxy = mid2;
				}else{
					miny = mid2;
				}
				
				
			}
			long boty = (int) maxy;
			
			if(done){
				continue;
			}
			
			
			
			
			long centerx = (rightx+leftx)/2;
			
			long centery = (topy+boty)/2;
			
			System.out.println(centerx + " " + centery);
			System.out.flush();
			String l = scan.readLine();
			if(l.equals("CENTER")){
				done = true;
				continue;
				
			} else {
				break;
			}
			
		}
		
		
	}
}
