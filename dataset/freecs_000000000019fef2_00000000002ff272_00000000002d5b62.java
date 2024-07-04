import java.util.*;
import java.io.*;

public class Solution{
	long rem = 1000000000L;
	InputReader sc;
	boolean singleTest = false;
	
	public void solve(int test){
		int x = nextInt();
		int y = nextInt();
		if((x%2) == (y%2)){
			println("Case #"+test + ": " + "IMPOSSIBLE");
			return;
		}
		int x1 = x;
		int y1 = y;
		
		x = Math.max(x, -x);
		y = Math.max(y, -y);
		
		int sum = x+y;
		
		int maxI = 0;
		int temp = sum;
		while(temp > 0){
			temp = temp>>1;
			maxI++;
		}
		maxI--;
		
		boolean[] pos = new boolean[maxI+1];
		
		for(int i=maxI; i>=0; i--){
			if(sum > 0){
				pos[i] = true;
				sum -= (1<<i);
			}
			else if(sum < 0){
				pos[i] = false;
				sum += (1<<i);
			}
			else{
				println("Case #"+test + ": " + "IMPOSSIBLE");
				return;
			}
		}
		
		boolean[] horPart = new boolean[maxI+1];
		
		boolean toggle = false;
		
		while(x > 0){
			int msb = 0;
			int num = x;
			while(num > 0){
				msb++;
				num = num>>1;
			}
			msb--;
			if(pos[msb] && !toggle){
				horPart[msb] = true;
				x -= (1<<msb);
			}
			else if(!pos[msb] && !toggle){
				horPart[msb+1] = true;
				x = ((1<<(msb+1))-x);
				toggle = true;
			}
			else if(pos[msb]){
				horPart[msb+1] = true;
				x = ((1<<(msb+1))-x);
				toggle = false;
			}
			else{
				horPart[msb] = true;
				x -= (1<<msb);
			}
		}
		
		String res = "";
		for(int i=0; i<=maxI; i++){
			if(horPart[i]){
				if(pos[i]){
					if(x1 < 0){
						res += "W";
					}
					else{
						res += "E";
					}
				}
				else{
					if(x1 < 0){
						res += "E";
					}
					else{
						res += "W";
					}
				}
			}
			else{
				if(pos[i]){
					if(y1 < 0){
						res += "S";
					}
					else{
						res += "N";
					}
				}
				else{
					if(y1 < 0){
						res += "N";
					}
					else{
						res += "S";
					}
				}
			}
		}
		
		println("Case #"+test + ": " + res);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	public int[] initialize(int[] arr, int len, int val){
		for(int i=0; i<len; i++){
			arr[i] = val;
		}
		return arr;
	}
	public long[] initialize(long[] arr, int len, long val){
		for(int i=0; i<len; i++){
			arr[i] = val;
		}
		return arr;
	}
	public boolean[] initialize(boolean[] arr, int len, boolean val){
		for(int i=0; i<len; i++){
			arr[i] = val;
		}
		return arr;
	}
	public int[] initialize(int[] arr, int val){
		return initialize(arr, arr.length, val);
	}
	public long[] initialize(long[] arr, long val){
		return initialize(arr, arr.length, val);
	}
	public boolean[] initialize(boolean[] arr, boolean val){
		return initialize(arr, arr.length, val);
	}
	
	public int nextInt(){
		return sc.nextInt();
	}
	public long nextLong(){
		return sc.nextLong();
	}
	public String next(){
		return sc.next();
	}
	public String nextLine(){
		return sc.nextLine();
	}
	public int[] nextArrInt(int n){
		int[] arr = new int[n];
		for(int i=0; i<n; i++){
			arr[i] = nextInt();
		}
		return arr;
	}
	public long[] nextArrLong(int n){
		long[] arr = new long[n];
		for(int i=0; i<n; i++){
			arr[i] = nextLong();
		}
		return arr;
	}
	public String[] nextArrWord(int n){
		String[] arr = new String[n];
		for(int i=0; i<n; i++){
			arr[i] = next();
		}
		return arr;
	}
	
	public void println(String str){
		System.out.println(str);
	}
	public void println(int num){
		System.out.println(num);
	}
	public void println(long num){
		System.out.println(num);
	}
	public void print(String str){
		System.out.print(str);
	}
	public void print(int num){
		System.out.print(num);
	}
	public void print(long num){
		System.out.print(num);
	}
	public void printArr(int[] arr){
		int n = arr.length;
		for(int i=0; i<(n-1); i++){
			print(arr[i] + " ");
		}
		println(arr[n-1]);
	}
	public void printArr(int[] arr, int n){
		print(n+" ");
		for(int i=0; i<(n-1); i++){
			print(arr[i] + " ");
		}
		println(arr[n-1]);
	}
	public void printArr(long[] arr){
		int n = arr.length;
		for(int i=0; i<(n-1); i++){
			print(arr[i] + " ");
		}
		println(arr[n-1]);
	}
	public void printArr(long[] arr, int n){
		print(n+" ");
		for(int i=0; i<(n-1); i++){
			print(arr[i] + " ");
		}
		println(arr[n-1]);
	}
	
	public Solution(){
		sc = new InputReader();
		
		int tests = 1;
		if(!singleTest){
			tests = sc.nextInt();
		}
        
        for(int t=1; t<=tests; t++){
			solve(t);
        }
	}
	
	public static void main(String[] args){
		new Solution();
	}
}

class InputReader {
    public BufferedReader reader;
    public StringTokenizer tokenizer;
	
	public InputReader(){
		InputStream stream = System.in;
        reader = new BufferedReader(new InputStreamReader(stream), 32768);
        tokenizer = null;
    }
	
    public InputReader(InputStream stream){
        reader = new BufferedReader(new InputStreamReader(stream), 32768);
        tokenizer = null;
    }
 
    public String next(){
        while(tokenizer == null || !tokenizer.hasMoreTokens()) {
            try{
                tokenizer = new StringTokenizer(reader.readLine());
            }catch(IOException e){
                throw new RuntimeException(e);
            }
        }
        return tokenizer.nextToken();
    }
 
    public int nextInt(){
        return Integer.parseInt(next());
    }
	
	public long nextLong(){
		return Long.parseLong(next());
	}
	
	public String nextLine(){
		try{
			return reader.readLine();
		}catch(IOException e){
			throw new RuntimeException(e);
		}
	}
}