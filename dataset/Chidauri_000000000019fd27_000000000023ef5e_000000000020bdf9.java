import java.util.*;

class Solution{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for(int q=0;q<t;q++){
			int n = in.nextInt();
			int[] s = new int[n];
			int[] e = new int[n];
			int[] index = new int[n];
			for(int i=0;i<n;i++){
				s[i] = in.nextInt();
				e[i] = in.nextInt();
				index[i] = i+1;
			}
			for(int i=1;i<n;i++){
				for(int j=i;j<n;j++){
					if(s[j] < s[j-1]){
						int temp = s[j];
						s[j] = s[j-1];
						s[j-1] = temp;
						temp = e[j];
						e[j] = e[j-1];
						e[j-1] = temp;
						temp = index[j];
						index[j] = index[j-1];
						index[j-1] = temp;
					}
				}
			}
			// Finding first jammie
			boolean is_possible = true;
			int cameron = e[0];
			int jammie = 0;
			int i;
			char[] result = new char[n+1];
			result[index[0]] = 'C';
			for(i=1;i<n;i++){
				if(s[i] < cameron){
					jammie = e[i];
					result[index[i]] = 'J';
					break;
				} else{
					cameron = e[i];
					result[index[i]] = 'C';
				}
			}
			//finding if impossible or not
			i++;
			while(i<n){
				if(s[i] < cameron && s[i] < jammie){
					is_possible = false;
					break;
				} else if(s[i] >= cameron && s[i] >=jammie){
					if(s[i] - cameron <= s[i] - jammie){
						cameron = e[i];
						result[index[i]] = 'C';
					} else {
						jammie = e[i];
						result[index[i]] = 'J';
					}
				} else if(s[i] >= cameron && s[i] < jammie){
					cameron = e[i];
					result[index[i]] = 'C';
				} else if(s[i] >= jammie && s[i] < cameron){
					jammie = e[i];
					result[index[i]] = 'J';
				}
				i++;
			}
			if(!is_possible){
				System.out.println("Case #" + (q+1) + ": IMPOSSIBLE");
			}else {
				System.out.print("Case #" + (q+1) + ": ");
				for(i=1;i<n+1;i++){
					System.out.print(result[i]);
				}
				System.out.println();
			}
		}
	}
}