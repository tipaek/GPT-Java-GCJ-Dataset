import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution{
	public static void main(String args[])throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		for (int i=1; i<=tc; i++){
			int n = Integer.parseInt(br.readLine());
			String[] arrEl = new String[n];
			String maxString = "";
			for (int x=0; x<n; x++){
				arrEl[x] = br.readLine().substring(1);
				if (arrEl[x].length()>maxString.length())
					maxString = arrEl[x];
			}
			boolean allMatch = true;
			for (String str: arrEl){
				// str += "(.*)";
				// if (!Pattern.matches(maxString.substring(1), str)){
				if (!maxString.contains(str)){
					allMatch = false;
					break;
				}
			}
			// System.out.println(Arrays.toString(arrEl) + ":: " + maxString);
			if (allMatch)
				sb.append("Case #" + i + ": " + maxString + "\n");
			else 
				sb.append("Case #" + i + ": *" + "\n");
		}
		System.out.print(sb);
	}
}