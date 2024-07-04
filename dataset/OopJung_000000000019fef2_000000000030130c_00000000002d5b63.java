import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br;
	static BufferedWriter bw;

	public static void main(String[] args) throws IOException{
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		for(int t = 1; t<=T; t++) {
			long temp = (long)Math.pow(10, 9);
			long leftx = 0;
			long rightx = 0;
			long lefty = 0;
			long righty = 0;
			
			bw.write(-temp/2 + " " + 0 + "\n");
			bw.flush();
			String reply = br.readLine();
			if(reply.equals("HIT")) {
				leftx = findminx(-temp, -temp/2);
				rightx = findmaxx(-temp/2, temp);
			}
			else if(reply.equals("MISS")){
				bw.write(temp/2 + " " + 0 + "\n");
				bw.flush();
				reply = br.readLine();
				if(reply.equals("HIT")) {
					leftx = findminx(-temp, temp/2);
					rightx = findmaxx(temp/2, temp);
				}
				else if (reply.equals("MISS")){
					leftx = findminx(-temp/2, temp/2);
					rightx = findmaxx(-temp/2, temp/2);
				}
				else {
					continue;
				}
			}
			else {
				continue;
			}
			
			if(leftx == Long.MAX_VALUE || rightx == Long.MAX_VALUE) {
				continue;
			}
			
			bw.write(0 + " " + -temp/2 + "\n");
			bw.flush();
			reply = br.readLine();
			if(reply.equals("HIT")) {
				lefty = findminy(-temp, -temp/2);
				righty = findmaxy(-temp/2, temp);
			}
			else if(reply.equals("MISS")){
				bw.write(0 + " " + temp/2 +  "\n");
				bw.flush();
				reply = br.readLine();
				if(reply.equals("HIT")) {
					lefty = findminy(-temp, temp/2);
					righty = findmaxy(temp/2, temp);
				}
				else if (reply.equals("MISS")){
					lefty = findminy(-temp/2, temp/2);
					righty = findmaxy(-temp/2, temp/2);
				}
				else {
					continue;
				}
			}
			else {
				continue;
			}
			
			if(lefty == Long.MAX_VALUE || righty == Long.MAX_VALUE) {
				continue;
			}
			
			else {
				bw.write((leftx+rightx)/2 + " " + (lefty+righty)/2 + "\n");
				bw.flush();
				reply = br.readLine();
			}
			
			
			
			

		}


		bw.flush();
		br.close();
		bw.close();
	}
	
	public static long findmaxx(long left, long right) throws IOException{
		
		if(left == right) {
			return left;
		}
		else if(left+1 == right) {
			bw.write(right+ " " + 0 + "\n");
			bw.flush();
			String reply = br.readLine();
			if(reply.equals("HIT")) {
				return right;
			}
			else if(reply.equals("MISS")){
				return left;
			}
			else {
				return Long.MAX_VALUE;
			}
		}
		else {
			long mid = (left+right)/2;
			bw.write(mid + " " + 0 + "\n");
			bw.flush();
			String reply = br.readLine();
			if(reply.equals("HIT")) {
				return findmaxx(mid, right);
			}
			else if(reply.equals("MISS")) {
				return findmaxx(left, mid);
			}
			else {
				return Long.MAX_VALUE;
			}
		}
	}
	public static long findmaxy(long left, long right) throws IOException{
		
		if(left == right) {
			return left;
		}
		else if(left+1 == right) {
			bw.write(0 + " " + right+ "\n");
			bw.flush();
			String reply = br.readLine();
			if(reply.equals("HIT")) {
				return right;
			}
			else if(reply.equals("MISS")){
				return left;
			}
			else {
				return Long.MAX_VALUE;
			}
		}
		else {
			long mid = (left+right)/2;
			bw.write(0 + " " + mid  + "\n");
			bw.flush();
			String reply = br.readLine();
			if(reply.equals("HIT")) {
				return findmaxy(mid, right);
			}
			else if(reply.equals("MISS")) {
				return findmaxy(left, mid);
			}
			else {
				return Long.MAX_VALUE;
			}
		}
	}
	
	public static long findminx(long left, long right) throws IOException{
		
		if(left == right) {
			return left;
		}
		else if(left+1 == right) {
			bw.write(left+ " " + 0 + "\n");
			bw.flush();
			String reply = br.readLine();
			if(reply.equals("HIT")) {
				return left;
			}
			else if(reply.equals("MISS")){
				return right;
			}
			else {
				return Long.MAX_VALUE;
			}
		}
		else {
			long mid = (left+right)/2;
			bw.write(mid + " " + 0 + "\n");
			bw.flush();
			String reply = br.readLine();
			if(reply.equals("HIT")) {
				return findminx(left, mid);
			}
			else if(reply.equals("MISS")) {
				return findminx(mid, right);
			}
			else {
				return Long.MAX_VALUE;
			}
		}
	}
	
	public static long findminy(long left, long right) throws IOException{
		
		if(left == right) {
			return left;
		}
		else if(left+1 == right) {
			bw.write(0 + " " + left+ "\n");
			bw.flush();
			String reply = br.readLine();
			if(reply.equals("HIT")) {
				return left;
			}
			else if(reply.equals("MISS")){
				return right;
			}
			else {
				return Long.MAX_VALUE;
			}
		}
		else {
			long mid = (left+right)/2;
			bw.write(0 + " " + mid + "\n");
			bw.flush();
			String reply = br.readLine();
			if(reply.equals("HIT")) {
				return findminy(left, mid);
			}
			else if(reply.equals("MISS")) {
				return findminy(mid, right);
			}
			else {
				return Long.MAX_VALUE;
			}
		}
	}
}


