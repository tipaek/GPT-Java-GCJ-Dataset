import java.util.*;
class Solution{
    private static void displayResult(List<String> res) {
		for(int i=0;i<res.size();i=i+2)
			System.out.println("Case #"+res.get(i)+": "+res.get(i+1));
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		List<String> result = new ArrayList<>();
		for(int i=1;i<=t;i++) {
			String s = sc.next();
			String res="";
			List<String> list = new ArrayList<>();
			int j=0;
			int n =s.length();
			while(j<n) {
				if(s.charAt(j)=='1') {
					res+="(1";
					int k=j+1;
					while(k<n && s.charAt(k)=='1') {
						res+="1";
						k++;
					}
					res+=")";
					list.add(res);
					res="";
					j=k;
				}else {
					list.add("0");
					j++;
				}
			}
			String finalRes ="";
			for(int z=0;z<list.size();z++)
				finalRes +=list.get(z);
			result.add(Integer.toString(i));
			result.add(finalRes);
			
		}
		displayResult(result);
		sc.close();

	}
}