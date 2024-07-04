import java.util.*;
class Solution{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int no_of_prob = sc.nextInt();
		String ans[]=new String[no_of_prob];
		for(int a=0;a<no_of_prob;a++)
		{
			//Scanner sc = new Scanner(System.in);
			String string = sc.next();
			StringBuffer s = new StringBuffer();
			int bracket=0;
			for(int i=0;i<string.length();i++){
				int z = Character.getNumericValue(string.charAt(i));
				if(bracket>z && bracket!=0){
					int b=bracket;
					for(int j=1;j<=b-z;j++){
						bracket--;
						s.append(')');
					}
					s.append(z);
				}
				else if(bracket<z && bracket!=0){
					int b=bracket;
					for(int j=1;j<=z-b;j++){
						bracket++;
						s.append('(');
					}
					s.append(z);
				}
				else if(bracket==z && bracket!=0){
					s.append(z);
				}
				
				else{
					for(int j=0;j<z;j++){
						s.append('(');
						bracket++;
					}
					s.append(z);
				}
			}
			if(bracket!=0)
				for(int i=1;i<=bracket;i++)
					s.append(')');
			//System.out.println(s);
			ans[a]=s.toString();
		}
		for(int a=0;a<no_of_prob;a++)
			System.out.println("Case #"+(a+1)+": "+ans[a]);
	}
}