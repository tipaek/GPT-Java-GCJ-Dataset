import java.util.*;

public class Solution {
	
	public static Scanner in = new Scanner(System.in);
	
	public static void cheese(){ //small case
		String ret = "";
		for(int i = 0; i < 10; i++){
			System.out.println(i+1);
			ret += in.nextInt();
		}
		System.out.println(ret);
	}
	
	public static String read(int start, int end){
		String ret = "";
		for(int i = start; i < end; i++){
			System.out.println(i+1);
			ret += in.nextInt();
		}
		return ret;
	}
	
	//1- Complemented
	//2- Reversed
	//3- Complemented and Reversed
	//4- Nothing Happened
	//-1 Invalid
	public static int compare(String s1, String s2){
		String rs1 = new StringBuilder(s1).reverse().toString();
		String cs1 = "";
		for(int i = 0; i < s1.length(); i++){
			if(s1.substring(i,i+1).equals("0"))
				cs1 += "1";
			else
				cs1 += "0";
		}
		String crs1 = new StringBuilder(s1).reverse().toString();
		crs1 = crs1.replaceAll("0", "A");
		crs1 = crs1.replaceAll("1", "0");
		crs1 = crs1.replaceAll("A", "1");
		if(s1.equals(s2))
			return 4;
		else if(cs1.equals(s2))
			return 1;
		else if(rs1.equals(s2))
			return 2;
		else if(crs1.equals(s2))
			return 3;
		else
			return -1;
	}
	
	public static String adjust(int mode, String s){
		if(mode == 1){
			s = s.replaceAll("0", "A");
			s = s.replaceAll("1", "0");
			s = s.replaceAll("A", "1");
		}else if(mode == 2){
			s = new StringBuilder(s).reverse().toString();
		}else if(mode == 3){
			s = new StringBuilder(s).reverse().toString();
			s = s.replaceAll("0", "A");
			s = s.replaceAll("1", "0");
			s = s.replaceAll("A", "1");
		}
		return s;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int t = in.nextInt();
		int b = in.nextInt();
		for(int i = 0; i < t; i++){
			if(b == 10){
				cheese();
				in.nextLine();
				if(in.nextLine().equals("N"))
					break;
				continue;
			}
			String g1 = read(0,5);
			String g4 = read(15,20);
			//change
			String og1 = g1;
			g1 = read(0,5);
			int mode = Math.max(compare(g1,og1),compare(g1,g4));
			if(mode == 2){
				g4 = adjust(mode, g1);
			}else
				g4 = adjust(mode,g4);
			String g2 = read(5,10);
			//change
			og1 = g1;
			g1 = read(0,5);
			mode = Math.max(compare(g1,og1),compare(g1,g4));
			String g3;
			if(mode == 2){
				g3 = adjust(mode, g2);
				g4 = adjust(mode, og1);
				g2 = read(5,10);
			}else{
				g2 = adjust(mode, g2);
				g4 = adjust(mode, g4);
				g3 = read(10,15);
			}
			System.out.println(g1+g2+g3+g4);
			in.nextLine();
			if(in.nextLine().equals("N"))
				break;
		}
	}
}
