import java.util.*;
import java.io.*;
class Solution{
	public static String buildString(char c, int n) {
        char[] arr = new char[n];
        Arrays.fill(arr, c);
        return new String(arr);
    }
	public static String change(String str){
		int i,st=0;
		Integer[] ari = new Integer[str.length()];
		for(i=0;i<str.length();i++){
			ari[i]=Character.getNumericValue(str.charAt(i));
		}
		int min = 10;
		for(i=0;i<str.length();i++){
			if(ari[i]<min)
			min=ari[i];
		}
		for(i=0;i<str.length();i++){
			ari[i]-=min;
		}
		StringBuffer sb=new StringBuffer("");  
		for(i=0;i<str.length();i++){
			sb.append(ari[i]);
		}
		for(i=0;;i++){
			if(sb.charAt(i)=='0'){
				if(st==i){

				}
				else{
					int os = sb.substring(st,i).length();
					String chs = change(sb.substring(st,i));
					int ns = chs.length();
					sb.replace(st,i,chs);
					i+=ns-os;
					// System.out.println(sb);
				}
				st=i+1;
			}
			else if(i==sb.length()-1){
				sb.replace(st,i+1,change(sb.substring(st,i+1)));
				// System.out.println("akil");
				break;
			}
			if(i+1>=sb.length())
					break;
		}
		sb.insert(0,buildString('(',min));
		sb.append(buildString(')',min));
		return sb.toString();
	} 
	public static void main(String[] args) {
		Scanner s = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = s.nextInt();
		int it;
		for(it=1;it<=t;it++){
			String str = s.next();
			StringBuffer sb=new StringBuffer(str);
			int i,st=0;
			for(i=0;;i++){
				if(sb.charAt(i)=='0'){
					if(st==i){

					}
					else{
						int os = sb.substring(st,i).length();
						String chs = change(sb.substring(st,i));
						int ns = chs.length();
						sb.replace(st,i,chs);
						i+=ns-os;
						// System.out.println(i);
						// sb.replace(st,i,change(sb.substring(st,i)));
					}
					st=i+1;
				}
				else if(i==sb.length()-1){
					// System.out.println("akil");
					sb.replace(st,i+1,change(sb.substring(st,i+1)));
					break;
				}
				if(i+1>=sb.length())
					break;
			}
			int ik=0;
			for(i=0;i<sb.length();i++){
				if(Character.isDigit(sb.charAt(i))){
					sb.replace(i,i+1,Character.toString(str.charAt(ik)));
					ik++;
				}
			}
			System.out.println("Case #" + it + ": " + sb);
		}
		s.close();
	}
}