import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class PascalWalk {
	public static void main(String[] args) {
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
			int t = Integer.parseInt(br.readLine());
			ArrayList<int[]> pascal = new ArrayList<>();
		//	constructPascal(pascal);
			for(int c = 1; c <= t; ++c) {
				ArrayList<int[]> ans = new ArrayList<>();
				int looking = Integer.parseInt(br.readLine());
				int add[] = {1,1};
				int adding[] = {2,1};
				ans.add(add);
				ans.add(adding);
				if(looking==1) {
					System.out.println("Case #"+ c+":");
					System.out.println("1 1");
					continue;
				}
				else if(looking == 2) {
					System.out.println("Case #"+ c+":");
					System.out.println("1 1\n2 1");
					continue;
				}
				else if(looking == 3) {
					System.out.println("Case #"+ c+":");
					System.out.println("1 1\n2 1\n2 2");
					continue;
				}
				int sum = 2;
				if(looking > 3 && looking <=1000){
					for(int i = 2; true; ++i) {
						if(sum+i>looking) {
							
							int newAdd[] = {i,1};
							ans.add(newAdd);
							++sum;
						}
						else {
							int newAdd[] = {i+1,2};
							ans.add(newAdd);
							sum+=i;
						}
						//System.out.println(sum+ " sumando  "+ i);
						if(sum==looking) {
							//System.out.println(sum+ " sumando "+ i);
							break;
						}
					}
					System.out.println("Case #"+c+":");
					for(int i = 0; i < ans.size();++i) {
						System.out.println(ans.get(i)[0]+" "+ ans.get(i)[1]);
					}
					
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	static void constructPascal(ArrayList<int[]> pascal) {
		int add[] = {1};
		pascal.add(add);
		int add2[] = {1,1};
		pascal.add(add2);
		
		for(int i = 1; i < 29; ++i ) {
			int[] adding = new int[pascal.get(i).length+1];
			adding[0] = 1;
			adding[pascal.get(i).length] = 1;
			for(int j = 1 ; j < pascal.get(i).length; ++j) {
				adding[j] = pascal.get(i)[j]+pascal.get(i)[j+1];
			}
			pascal.add(adding);
		}
	}
}
