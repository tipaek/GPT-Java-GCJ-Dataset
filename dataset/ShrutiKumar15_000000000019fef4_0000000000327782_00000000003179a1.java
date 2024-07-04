//package competitive;
import java.util.*;
import java.io.*;
//" only if the class is public. */
class DateCode
{
	
	
	public static void main (String[] args) throws Exception
	{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    PrintWriter out = new PrintWriter(System.out);
	    
		   
		String test =(br.readLine());
		    
		if(test!=null) {
			int t = Integer.parseInt(test);
			for(int k=0; k<t; k++) {
				int u = Integer.parseInt(br.readLine());
				if(u==2) {
					List<List<String>> l = new ArrayList<>();
					Map<Integer, Set<String>> m = new HashMap<>();
					for(int i=0; i<=(10); i++) {
						//l.add(i, new ArrayList<>());
						m.put(i,new HashSet<>());
					}
					for(int i=0;i<10000; i++) {
						String[] line = br.readLine().split(" ");
						if(line[0].length()<=2) {
							int no = Integer.parseInt(line[0]);
							String s = line[1];
							if(no<=10) {
								m.get(no).add(s);
							}
						}
						
						
						
					}
					Set<String> done = new HashSet<>();
					String ans ="";
					String fans="";
					for(int i=1; i<=10; i++) {
						if(i==10) {
							for( String st : m.get(i)) {
								if(st.length()==2) {
									for(int j=0; j<st.length(); j++) {
										if(!done.contains(st.charAt(j)+"")) {
											ans=st.charAt(j)+ans;
											//out.println(ans+"ans");
											done.add(st.charAt(j)+"");
											break;
										}
									}
								}
							}
						}
						else {
							for( String st : m.get(i)) {
								if(!done.contains(st)) {
									ans+=st;
									done.add(st);
									break;
								}
							}
						}
						
					}
					//out.println(m);
					out.println("Case #"+(k+1)+": "+ans);
				}
				else {
					Set<String> done = new HashSet<>();
					String ans ="";
					List<List<String>> l = new ArrayList<>();
					Map<Integer, Set<String>> m = new HashMap<>();
					int count=0;
					boolean[] f = new boolean[10];
					for(int i=0; i<=(10); i++) {
						//l.add(i, new ArrayList<>());
						m.put(i,new HashSet<>());
					}
					for(int i=0;i<10000; i++) {
						String[] line = br.readLine().split(" ");
						if(line[0].length()<=2) {
							int no = Integer.parseInt(line[0]);
							String s = line[1];
							if(no<=10) {
								m.get(no).add(s);
								if(m.get(no).size()==no) {
									count+=1;
									f[no-1]=true;
								}
							}
						}
						else {
							int n = Integer.parseInt(line[0].charAt(0)+"");
							String s = line[1];
							if(f[n]==false) {
								for(int j=1; j<=n; j++) {
									if(f[j]==false) {
										m.get(n).add(s);
										if(m.get(n).size()==n) {
											count+=1;
											f[n-1]=true;
										}
									}
								}
							}
						}
						if(count==10) {
							break;
						}
						
						for(int ii=1; ii<=10; ii++) {
							if(ii==10) {
								for( String st : m.get(ii)) {
									if(st.length()==2) {
										for(int j=0; j<st.length(); j++) {
											if(!done.contains(st.charAt(j)+"")) {
												ans=st.charAt(j)+ans;
												//out.println(ans+"ans");
												done.add(st.charAt(j)+"");
												break;
											}
										}
									}
								}
							}
							else {
								for( String st : m.get(ii)) {
									if(!done.contains(st)) {
										ans+=st;
										done.add(st);
										break;
									}
								}
							}
							
						}
					}
					out.println("Case #"+(k+1)+": "+ans);
				}
				
				
				//out.println("Case #"+(k+1)+": IMPOSSIBLE");
				
				
			}
		}
		out.flush();
	}
		   
	
}
