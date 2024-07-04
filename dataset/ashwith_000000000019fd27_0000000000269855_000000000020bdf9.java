import java.util.*;
import java.io.*;
class Solution{
    public static void main(String[] args) throws Exception
    {
        Myscanner ms=new Myscanner();
        PrintWriter out=new PrintWriter(System.out);
        int t=ms.nextInt();
        int k=1;
		String a="";
        while(t>0)
        {
            int n=ms.nextInt();
           long[] arr1=new long[n];
           long[] arr2=new long[n];
            for(int i=0;i<n;i++)
			{
				arr1[i]=ms.nextInt();
				arr2[i]=ms.nextInt();
			}
            a=sort(arr1,arr2);
        out.println("Case #"+k+": "+a);
        k++;
        t--;
        out.flush();
		}  
        }
    static class Myscanner{
        private BufferedReader br;
        private StringTokenizer tr;
        
        public Myscanner()
        {
            br=new BufferedReader(new InputStreamReader(System.in));
        }
        
        public String next()
        {
            try{
                while(tr==null||!tr.hasMoreTokens())
                {
                    tr=new StringTokenizer(br.readLine());
                }
            }
            catch(Exception e){
                e.printStackTrace();
            }
            return tr.nextToken();
        }
        
        public int nextInt(){
            return Integer.parseInt(next());
        }
         public long nextLong(){
            return Long.parseLong(next());
        }
	}
        static String sort(long arr1[],long arr2[])
        {
            String str="";
			int n=arr1.length;
			char ch[]=new char[n];
			ch[0]='C';
			ch[1]='C';
            for(int i=0;i<n-1;i++)
            {
				int count=0;
                for(int j=i+1;j<n;j++)
				{
					//System.out.println("-------"+arr1[i]+"-----");
					if(((arr1[j]<arr2[i])&&(arr1[i]<arr2[j]))||((arr1[j]<arr2[i])&&(arr1[j]<arr1[i])))
					{
						count++;
						if(ch[i]=='C')
						{
						ch[j]='J';
						}
						else
						{
							ch[j]='C';
						}
					}
					else{
						if(ch[i]=='C')
						{
					      ch[j]='J';	
						}
						else
							ch[j]='C';	
						
					}	
                }
				//System.out.println(count);
				if(count==(n-1)){
				str="IMPOSSIBLE";
				break;
			}
			else{
				str=String.valueOf(ch);
			}
			
			}
		return str;
    }  
}
