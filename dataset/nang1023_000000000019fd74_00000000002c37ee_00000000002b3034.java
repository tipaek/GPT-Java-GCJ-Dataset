import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Solution {
		static int tc, n;
		static String input, ans="", oneInput, twoInput;
		static char tmp;
		static boolean isAppear, isNoAns;
		static ArrayList<Object> one= new ArrayList<>(), two= new ArrayList<>(), arr = new ArrayList<>();
		static BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));

		public static void main(String[] args) throws NumberFormatException, IOException {
			BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
			tc=Integer.parseInt(br.readLine());
			
			for (int t = 1; t <= tc; t++) {
				n=Integer.parseInt(br.readLine());
				isNoAns=false; 
				one.clear(); two.clear(); ans="";
				
				for (int i = 0; i < n; i++) {
					input=br.readLine();
					if (isNoAns) continue;
					arr.clear();
					isAppear=false;

					for (int j = 0; j < input.length(); j++) {
						if(isAppear) {
							isAppear=false; 
							break;
						}
						
						tmp=input.charAt(j);
						
						if(tmp=='*') isAppear=true;
						else isAppear=false;
						
						if(!isAppear) { 
							if(j>=one.size())
								one.add(tmp);
							else {
								if(tmp==(char)one.get(j)) continue;
								else {
									isNoAns=true;
									break;
								}
							}

						} else { 
							twoInput = input.substring(j+1, input.length());
							if(twoInput.length()==0) continue;

							for (int k = twoInput.length()-1; k >=0; k--)
								arr.add(twoInput.charAt(k));
							
							if(arr.size()>two.size()) {
								for (int l = 0; l < two.size(); l++) {
									if((char)two.get(l) == (char)arr.get(l))
										continue;
									else {
										isNoAns=true;
										break;
									}
								}
								for (int j2 = two.size(); j2 < arr.size(); j2++) {
									two.add(arr.get(j2));
								}
							} else {
								for (int l = 0; l < arr.size(); l++) {
									if((char)two.get(l) == (char)arr.get(l))
										continue;
									else {
										isNoAns=true;
										break;
									}
								}
							}
						}
					}
				}
			
				if(isNoAns)
					bw.append("Case #"+ t +": *\n");
				else {
					for (int i = 0; i < one.size(); i++)
						ans+= one.get(i);
					for (int i = two.size()-1; i >=0; i--)
						ans+= two.get(i);
					bw.append("Case #"+ t +": "+ans+"\n");
				}
			} //tc end
			
			bw.flush();
			bw.close();
	}
}
