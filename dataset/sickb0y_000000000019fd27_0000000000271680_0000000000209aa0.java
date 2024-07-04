import java.util.*;
import java.io.*;

public class Solution{
	public static void main(String[] args) throws IOException{
		BufferedReader input = new BufferedReader(new InputStreamReader (System.in));
		int no_test;
		String notest;
		notest = input.readLine();
		String[] temp;
		if(notest == null)
			return;
		no_test = Integer.parseInt(notest);
		int kk=0;
		while(kk < no_test){
			temp = input.readLine().split(" ");
			int n = Integer.parseInt(temp[0]);
			int k = Integer.parseInt(temp[1]);
			if(n == 2){
				if(k != 2 && k != 4){
					System.out.println("Case #"+Integer.toString(kk+1) + ": IMPOSSIBLE");
				}
				else{
					if(k == 2){
						System.out.println("Case #"+Integer.toString(kk+1) + ": POSSIBLE");
						System.out.println("1 2");
						System.out.println("2 1");
					}
					else{
						System.out.println("Case #"+Integer.toString(kk+1) + ": POSSIBLE");
						System.out.println("2 1");
						System.out.println("1 2");
					}
				}
			}
			else if(n == 3){
				if(k == 6){
					System.out.println("Case #"+Integer.toString(kk+1) + ": POSSIBLE");
					System.out.println("1 2 3");
					System.out.println("2 3 1");
					System.out.println("3 1 2");
				}
				else if (k%3 == 0 && k/3 < 4){
					System.out.println("Case #"+Integer.toString(kk+1) + ": POSSIBLE");
					int x = k/3;
					String line = "";
					for(int j=0;j<n;j++){
						int xx = x;
						line = "";
						for(int i=0;i<n;i++){
							if(xx > n){
								xx = 1;
							}
							line += Integer.toString(xx) + " ";
							xx++;
						}
						x--;
						if(x == 0){
							x = n;
						}
						line = 	line.substring(0, line.length() - 1);
						System.out.println(line);
					}

				}
				else{
					System.out.println("Case #"+Integer.toString(kk+1) + ": IMPOSSIBLE");
				}
			}
			else if(n == 4){
				if(k == 10){
					System.out.println("Case #"+Integer.toString(kk+1) + ": POSSIBLE");
					System.out.println("1 3 4 2");
					System.out.println("4 2 1 3");
					System.out.println("2 4 3 1");
					System.out.println("3 1 2 4");
				}
				if(k == 11){
					System.out.println("Case #"+Integer.toString(kk+1) + ": POSSIBLE");
					System.out.println("4 3 2 1");
					System.out.println("2 1 4 3");
					System.out.println("3 2 1 4");
					System.out.println("1 4 3 2");
				}
				if(k == 9){
					System.out.println("Case #"+Integer.toString(kk+1) + ": POSSIBLE");
					System.out.println("4 3 1 2");
					System.out.println("1 2 4 3");
					System.out.println("3 1 2 4");
					System.out.println("2 4 3 1");
				}
				else if (k%4 == 0 && k/4 < 5){
					System.out.println("Case #"+Integer.toString(kk+1) + ": POSSIBLE");
					int x = k/4;
					String line = "";
					for(int j=0;j<n;j++){
						int xx = x;
						line = "";
						for(int i=0;i<n;i++){
							if(xx > n){
								xx = 1;
							}
							line += Integer.toString(xx) + " ";
							xx++;
						}
						x--;
						if(x == 0){
							x = n;
						}
						line = 	line.substring(0, line.length() - 1);
						System.out.println(line);
					}
				}
				else if(k/2 < 8){
					int x = k/2;
					int a,b;
					if(x == 7){
						a = 3;
						b = 4;
					}
					else if(x > 4){
						a = 2;
						b = x -a;
					}
					else{
						a = 1;
						b = x-a;
					}
					int c,d;
					c = 5-a;
					d = 5-b;
					System.out.println("Case #"+Integer.toString(kk+1) + ": POSSIBLE");
					System.out.println(Integer.toString(a)+" "+Integer.toString(b)+" "+Integer.toString(c)+" "+Integer.toString(d));
					System.out.println(Integer.toString(b)+" "+Integer.toString(a)+" "+Integer.toString(d)+" "+Integer.toString(c));
					System.out.println(Integer.toString(c)+" "+Integer.toString(d)+" "+Integer.toString(b)+" "+Integer.toString(a));
					System.out.println(Integer.toString(d)+" "+Integer.toString(c)+" "+Integer.toString(a)+" "+Integer.toString(b));
				}
			}
			else if (n == 5) {
				if(k == 15){
					System.out.println("Case #"+Integer.toString(kk+1) + ": POSSIBLE");
					System.out.println("1 3 4 5 2");
					System.out.println("3 2 5 1 4");
					System.out.println("4 5 3 2 1");
					System.out.println("5 1 2 4 3");
					System.out.println("2 4 1 3 5");
				}
				else if (k%5 == 0 && k/5 < 6){
					System.out.println("Case #"+Integer.toString(kk+1) + ": POSSIBLE");
					int x = k/5;
					String line = "";
					for(int j=0;j<n;j++){
						int xx = x;
						line = "";
						for(int i=0;i<n;i++){
							if(xx > n){
								xx = 1;
							}
							line += Integer.toString(xx) + " ";
							xx++;
						}
						x--;
						if(x == 0){
							x = n;
						}
						line = 	line.substring(0, line.length() - 1);
						System.out.println(line);
					}
				}
				else{
					System.out.println("Case #"+Integer.toString(kk+1) + ": IMPOSSIBLE");
				}
			}
			kk++;
		}
	}
	//private static String solve(double a){
	//	return "";
	//}
}