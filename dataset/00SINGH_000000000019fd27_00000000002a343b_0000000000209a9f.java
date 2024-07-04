import java.io.*;

class abc
{
    public static void main(String args[])throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        String SS = "";
        for(int t=1; t<=T ; t++)
		{
            SS = br.readLine();
			int ln = SS.length();
			int pos = 0;
			String S2 = "";
			for(int i=0; i<ln; i++)
			{
				if(i < pos)
					continue;
				else if(SS.charAt(i) == '0')
				{
					S2 = S2 + "0";
				}
				else
				{
					pos = i+1;
					while(i < (ln-1))
					{
						if(SS.charAt(pos) == '1')
							pos += 1;
						else
							break;
					};
					S2 = S2 + "(" + SS.substring(i, pos) + ")";
				}
			}
			System.out.println("Case #"+t+": "+ S2);
		}		
    }	
}