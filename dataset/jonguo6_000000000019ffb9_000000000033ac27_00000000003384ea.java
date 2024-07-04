import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int tests = Integer.parseInt(in.nextLine());
		for(int test=0;test<tests;test++) {
			String answer = "";
			String[] inp = in.nextLine().split(" ");
			long l = Long.parseLong(inp[0]);
			long r = Long.parseLong(inp[1]);
			long difference = Math.abs(l-r);
			long index = 0;
			if(difference > 0) {
				long testindex = (long)Math.sqrt(2*difference);
				index = testindex;
				long sub = testindex*(testindex+1)/2;
				if(l > r) {
					l -= sub;
				} else {
					r -= sub;
				}
			}
			//long min = 0;
			long customer = 0;
			if(l >= r) {
				if(index % 2 == 0) {
					//left gets odd
					long totalleft = l + (index)/2*(index)/2;
					long maxindex = (long)Math.sqrt(totalleft);
					totalleft -= maxindex*maxindex;
					maxindex = maxindex*2-1;
					l = totalleft;
					
					//right gets even
					long addright = (index/2)*(index/2+1);
					long totalright = r + addright;
					long maxindexr = (long)Math.sqrt(totalright);
					if(maxindexr*(maxindexr+1) > totalright) maxindexr -= 1;
					totalright -= (maxindexr)*(maxindexr+1);
					maxindexr *= 2;
					r = totalright;
					customer = Math.max(maxindex, maxindexr);
					
					
				} else {
					//left gets even
					long addleft = (index/2)*(index/2+1);
					//System.out.println(l+" "+index+" "+addleft);
					long totalleft = l + addleft;
					long maxindexl = (long)Math.sqrt(totalleft);
					if(maxindexl*(maxindexl+1) > totalleft) maxindexl -= 1;
					totalleft -= (maxindexl)*(maxindexl+1);
					maxindexl*=2;
					l = totalleft;
					
					//right gets odd
					long totalright = r + (index+1)/2*(index+1)/2;
					long maxindexr = (long)Math.sqrt(totalright);
					//System.out.println(r+" "+totalright+" "+maxindexr);
					totalright -= maxindexr*maxindexr;
					maxindexr = maxindexr*2-1;
					r = totalright;
					
					customer = Math.max(maxindexl, maxindexr);
					
					//System.out.println(l+" "+r+" "+maxindexl+" "+maxindexr);
				}
			} else {
				if(index % 2 == 0) {
					//right gets odd
					long totalright = r + (index)/2*(index)/2;
					long maxindexr = (long)Math.sqrt(totalright);
					totalright -= maxindexr*maxindexr;
					maxindexr = maxindexr*2-1;
					r = totalright;
					
					//left gets even
					long addleft = (index/2)*(index/2+1);
					long totalleft = l + addleft;
					long maxindexl = (long)Math.sqrt(totalleft);
					if(maxindexl*(maxindexl+1) > totalleft) maxindexl -= 1;
					totalleft -= (maxindexl)*(maxindexl+1);
					maxindexl*=2;
					l = totalleft;
					
					customer = Math.max(maxindexl, maxindexr);
					
					

				} else {
					//right gets even
					
					long addright = (index/2)*(index/2+1);
					long totalright = r + addright;
					long maxindexr = (long)Math.sqrt(totalright);
					if(maxindexr*(maxindexr+1) > totalright) maxindexr -= 1;
					totalright -= (maxindexr)*(maxindexr+1);
					maxindexr *= 2;
					r = totalright;					
					
					//left gets odd
					long totalleft = l + (index+1)/2*(index+1)/2;
					long maxindex = (long)Math.sqrt(totalleft);
					totalleft -= maxindex*maxindex;
					maxindex = maxindex*2-1;
					l = totalleft;
					
					customer = Math.max(maxindex, maxindexr);
				}
			}
			answer = customer+" "+l+" "+r;
			System.out.println("Case #"+(test+1)+": "+answer);
		}
		in.close();
	}
}