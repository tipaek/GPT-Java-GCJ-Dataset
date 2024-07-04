
import java.io.*;
import java.util.*;

public class Solution {
	public static int solve (BufferedReader br, int stage, int Xleft, int XRight, int Ydown, int Yup, int low, int high, int x, int y) throws IOException{
		if(stage ==1){
			System.out.println("0 0");
			String s = br.readLine();
			if(s.equals("CENTER")) return 0;
			else if(s.equals("HIT")){
				stage =6;
				x=0;
				y=0;
				low = x;
				high = 1000000000;
				return solve(br, stage, Xleft, XRight, Ydown, Yup, low, high, x, y);
			}
			else{
				stage++;
				return solve(br, stage, Xleft, XRight, Ydown, Yup, low, high, x, y);
			}
		}
		else if(stage ==2){
			System.out.println("-500000000 500000000");
			String s = br.readLine();
			if(s.equals("CENTER")) return 0;
			else if(s.equals("HIT")){
				stage =6;
				x=-500000000;
				y=500000000;
				low = x;
				high = 1000000000;
				return solve(br, stage, Xleft, XRight, Ydown, Yup, low, high, x, y);
			}
			else{
				stage++;
				return solve(br, stage, Xleft, XRight, Ydown, Yup, low, high, x, y);
			}
		}
		else if(stage ==3){
			System.out.println("500000000 500000000");
			String s = br.readLine();
			if(s.equals("CENTER")) return 0;
			else if(s.equals("HIT")){
				stage =6;
				x=500000000;
				y=500000000;
				low = x;
				high = 1000000000;
				return solve(br, stage, Xleft, XRight, Ydown, Yup, low, high, x, y);
			}
			else{
				stage++;
				return solve(br, stage, Xleft, XRight, Ydown, Yup, low, high, x, y);
			}
		}
		else if(stage ==4){
			System.out.println("-500000000 -500000000");
			String s = br.readLine();
			if(s.equals("CENTER")) return 0;
			else if(s.equals("HIT")){
				stage =6;
				x=-500000000;
				y=-500000000;
				low = x;
				high = 1000000000;
				return solve(br, stage, Xleft, XRight, Ydown, Yup, low, high, x, y);
			}
			else{
				stage=6;
				x=500000000;
				y=-500000000;
				low = x;
				high = 1000000000;
				return solve(br, stage, Xleft, XRight, Ydown, Yup, low, high, x, y);
			}
		}
		else if(stage==6){
			if(high==1000000000){
				System.out.println("1000000000 "+y);
				String s = br.readLine();
				if(s.equals("CENTER")) return 0;
				else if(s.equals("HIT")){
					stage=7;
					high = x;
					low = -1000000000;
					XRight = 1000000000;
					return solve(br, stage, Xleft, XRight, Ydown, Yup, low, high, x, y);
				}
				else{
					high = 1000000000-1;
					return solve(br, stage, Xleft, XRight, Ydown, Yup, low, high, x, y);
				}
			}
			else if(low<high){
				int mid = (high+low+1)/2;
				System.out.println(mid +" " +y);
				String s = br.readLine();
				if(s.equals("CENTER")) return 0;
				else if(s.equals("HIT")){
					low = mid;
					return solve(br, stage, Xleft, XRight, Ydown, Yup, low, high, x, y);
				}
				else{
					high = mid-1;
					return solve(br, stage, Xleft, XRight, Ydown, Yup, low, high, x, y);
				}
			}
			else{
				stage=7;
				XRight = low;
				high = x;
				low = -1000000000;
				return solve(br, stage, Xleft, XRight, Ydown, Yup, low, high, x, y);
			}
		}
		else if(stage==7){
			if(low==-1000000000){
				System.out.println("-1000000000 "+y);
				String s = br.readLine();
				if(s.equals("CENTER")) return 0;
				else if(s.equals("HIT")){
					stage=8;
					high = 1000000000;
					low = y;
					Xleft = -1000000000;
					return solve(br, stage, Xleft, XRight, Ydown, Yup, low, high, x, y);
				}
				else{
					low = -1000000000+1;
					return solve(br, stage, Xleft, XRight, Ydown, Yup, low, high, x, y);
				}
			}
			else if(low<high){
				int mid = (high+low-1)/2;
				System.out.println(mid+" " +y);
				String s = br.readLine();
				if(s.equals("CENTER")) return 0;
				else if(s.equals("HIT")){
					high = mid;
					
					return solve(br, stage, Xleft, XRight, Ydown, Yup, low, high, x, y);
				}
				else{
					low = mid+1;
					return solve(br, stage, Xleft, XRight, Ydown, Yup, low, high, x, y);
				}
			}
			else{
				stage=8;
				Xleft = high;
				high = 1000000000;
				low = y;
				return solve(br, stage, Xleft, XRight, Ydown, Yup, low, high, x, y);
			}
		}
		else if(stage==8){
			if(high==1000000000){
				System.out.println(x+" 1000000000");
				String s = br.readLine();
				if(s.equals("CENTER")) return 0;
				else if(s.equals("HIT")){
					stage=9;
					high = y;
					low = -1000000000;
					Yup = 1000000000;
					return solve(br, stage, Xleft, XRight, Ydown, Yup, low, high, x, y);
				}
				else{
					high = 1000000000-1;
					return solve(br, stage, Xleft, XRight, Ydown, Yup, low, high, x, y);
				}
			}
			else if(low<high){
				int mid = (high+low+1)/2;
				System.out.println(x+" "+mid);
				String s = br.readLine();
				if(s.equals("CENTER")) return 0;
				else if(s.equals("HIT")){
					low = mid;
					return solve(br, stage, Xleft, XRight, Ydown, Yup, low, high, x, y);
				}
				else{
					high = mid-1;
					return solve(br, stage, Xleft, XRight, Ydown, Yup, low, high, x, y);
				}
			}
			else{
				stage=9;
				Yup= low;
				high = y;
				low = -1000000000;
				return solve(br, stage, Xleft, XRight, Ydown, Yup, low, high, x, y);
			}
		}
		else if(stage==9){
			if(low==-1000000000){
				System.out.println(x+ " -1000000000");
				String s = br.readLine();
				if(s.equals("CENTER")) return 0;
				else if(s.equals("HIT")){
					stage=10;
					high = 1000000000;
					low = y;
					Ydown = -1000000000;
					return solve(br, stage, Xleft, XRight, Ydown, Yup, low, high, x, y);
				}
				else{
					low = -1000000000+1;
					return solve(br, stage, Xleft, XRight, Ydown, Yup, low, high, x, y);
				}
			}
			else if(low<high){
				int mid = (high+low-1)/2;
				System.out.println(x+" " +mid);
				String s = br.readLine();
				if(s.equals("CENTER")) return 0;
				else if(s.equals("HIT")){
					high = mid;
					return solve(br, stage, Xleft, XRight, Ydown, Yup, low, high, x, y);
				}
				else{
					low = mid+1;
					return solve(br, stage, Xleft, XRight, Ydown, Yup, low, high, x, y);
				}
			}
			else{
				stage=10;
				Ydown = high;
				high = 1000000000;
				low = y;
		
				return solve(br, stage, Xleft, XRight, Ydown, Yup, low, high, x, y);
			}
		}
		else{
			System.out.println((Xleft+XRight)/2 + " "+ (Yup + Ydown)/2);
			String s = br.readLine();
			return 0;
		}
		
		
	}
	public static void main (String[]args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for(int test =1; test<=T;test++){
			solve(br, 1, 0,0,0,0,0,0,0,0);
			
//			System.out.println("Case #" + test + ": " + solve(x,y));
			
		}	
	}
			
		
}
