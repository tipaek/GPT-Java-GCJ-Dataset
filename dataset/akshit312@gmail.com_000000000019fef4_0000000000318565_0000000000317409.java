					import java.io.BufferedReader;
							import java.io.FileReader;
							import java.io.IOException;
							import java.io.InputStreamReader;
							import java.io.PrintWriter;
					import java.lang.reflect.Array;
					import java.math.BigInteger;
							import java.util.*;
					
								   class Solution{
									    void pre() throws Exception{}
									    void solve(int TC) throws Exception{
									    	int t=ni();
									    	for(int ii=1;ii<=t;ii++) {
									    		int x=ni();
									    		int y=ni();
									    		String s=n();
									    		int curL=0;
									    		int curR=0;
									    		int ans=0;
									    		int flag=-1;
									    		for(int i=0;i<s.length();i++) {
									    			char d=s.charAt(i);
									    			if(d=='S') {
									    				y--;
									    			}
									    			else if(d=='N')
									    				y++;
									    				else if(d=='E')
										    				x++;
										    				else if(d=='W')
											    				x--;
									    			if(Math.abs(x) + Math.abs(y) <= (i+1)) {
									    				ans=i+1;
									    				flag=1;
									    				break;
									    			}
									    		}
									    		if(flag==1)pn("Case #" + ii + ": " + 	ans);
									    		else pn("Case #" + ii + ": " +"IMPOSSIBLE");
									    	}
									    }
									    		
									    	
									    	
									    		
									    		
									    		
									    	
									    	
									    
									    		
									    		    	
								 
									    static boolean multipleTC = false, memory = false;
									    FastReader in;PrintWriter out;
									    void run() throws Exception{
									        in = new FastReader();
									        out = new PrintWriter(System.out);
									        int T = (multipleTC)?ni():1;
									        pre();for(int t = 1; t<= T; t++)solve(t);
									        out.flush();
									        out.close();
									    }
									    public static void main(String[] args) throws Exception{
									        if(memory)new Thread(null, new Runnable() {public void run(){try{new Solution().run();}catch(Exception e){e.printStackTrace();}}}, "1", 1 << 28).start();
									        else new Solution().run();
									    }
									    void p(Object o){out.print(o);}
									    void pn(Object o){out.println(o);}
									    void nd(Object o){out.println(o);}
									    void pni(Object o){out.println(o);out.flush();}
									    String n()throws Exception{return in.next();}
									    String nln()throws Exception{return in.nextLine();}
									    int ni()throws Exception{return Integer.parseInt(in.next());}
									    long nl()throws Exception{return Long.parseLong(in.next());}
									    double nd()throws Exception{return Double.parseDouble(in.next());}
									    
									    class FastReader{
									        BufferedReader br;
									        StringTokenizer st;
									        public FastReader(){
									            br = new BufferedReader(new InputStreamReader(System.in));
									        }
									
									        public FastReader(String s) throws Exception{
									            br = new BufferedReader(new FileReader(s));
									        }
									
									        String next() throws Exception{
									            while (st == null || !st.hasMoreElements()){
									                try{
									                    st = new StringTokenizer(br.readLine());
									                }catch (IOException  e){
									                    throw new Exception(e.toString());
									                }
									            }
									            return st.nextToken();
									        }
									
									        String nextLine() throws Exception{
									            String str = "";
									            try{   
										                str = br.readLine();
										            }catch (IOException e){
									                throw new Exception(e.toString());
									            }  
									            return str;
									        }
									    }
									}
