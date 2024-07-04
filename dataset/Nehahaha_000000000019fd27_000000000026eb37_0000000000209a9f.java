import java.util.*;
class Solution{
    private static void displayResult(List<String> res) {
		for(int i=0;i<res.size();i=i+2)
			System.out.println("Case #"+res.get(i)+": "+res.get(i+1));
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		List<String> list = new ArrayList<>();
		for(int i=1;i<=t;i++) {
			String s = sc.next();
			int n = s.length();
			String res="";
			
			for(int j=0;j<n;j++) {
				char ele = s.charAt(j);
				int eleInt = Character.getNumericValue(ele);
				//System.out.println(eleInt+"eleInt");
				String brackets="";
				for(int k=0;k<eleInt;k++) {
					brackets += "(";
				}
				res+=brackets+String.valueOf(eleInt);
				int l =j+1;
				if(l==n)
					for(int p=0;p<eleInt;p++) {
						res += ")";
					}
					
				while(l<n) {
					char ele1 = s.charAt(l);
					eleInt =  Character.getNumericValue(s.charAt(l-1));
					if(ele1 == eleInt) {
						res+=Character.toString(ele1);
						l++;
						j=l;
					}else if(eleInt>Character.getNumericValue(ele1))  {
						int diff = eleInt-Character.getNumericValue(ele1);
						for(int m=0;m<diff;m++)
							res+=")";
						res+=Character.toString(ele1);
						l++;
						j=l;
						
					}else {
						int dif =Character.getNumericValue(ele1)- eleInt;
						for(int m=0;m<dif;m++)
							res+="(";
						res+=Character.toString(ele1);
						l++;
						j=l;
					}

				}
				if(j>=n) {
					char le = s.charAt(n-1);
					int left = Character.getNumericValue(le);
					for(int o=0;o<left;o++)
						res+=")";
				}
			}
			//System.out.println(res);
			list.add(Integer.toString(i));
			list.add(res);
			
		}
		displayResult(list);

	}

}