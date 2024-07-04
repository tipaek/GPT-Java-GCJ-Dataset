import java.util.*;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		int b = sc.nextInt();
		for(int z = 0 ;z < t ; z++ )
		{
		
			String s = "";
			String [] all =new String[16];
			for(int i = 0 ; i< 150; i++ )
			{
				
				if(i % b == 0 && i/10 !=0)
				{
					all[(i/10)-1] = s;
					s= "";
				}
				System.out.println(((i%b) +1));
		
				s+= sc.next().charAt(0);
				if(i == 149)
				{
					all[14] = s; 
				}
			}
			System.out.println(all[14]);
			char res = sc.next().charAt(0);
			if(res == 'Y')
				continue;
			else
				break;
		}
		sc.close();
	}

}