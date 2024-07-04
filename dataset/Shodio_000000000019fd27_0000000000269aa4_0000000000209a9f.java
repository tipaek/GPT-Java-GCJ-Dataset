import java.io.BufferedReader;
import java.io.InputStreamReader;

public class jam1{
	public static void main(String[] args)throws Exception {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		

		for (int i=1;i<=t ;i++ ) {
			String str=br.readLine();
			int c=0;
			int len=str.length();
			
			System.out.print("Case #"+i+": ");
			for(int j=0;j<len;j++)
        	{
        	char ch=str.charAt(j);
            int num = Integer.parseInt(String.valueOf(ch));
            if(num<c)
            {
                while(num!=c){
                System.out.print(")");
                c--;
                }
                System.out.print(num);
            }
            else if(num==c)
            {
                System.out.print(num);
            }
            else if(c<num)
            {
                while(c!=num)
                {
                    System.out.print("(");
                    c++;
                }
                System.out.print(num);
            }
        	}
        while(c!=0)
        {
            System.out.print(")");
            c--;
        }
        System.out.println();
    }
	}	
}
