import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

	public static void main(String[] rgs)
	{
		Scanner s=new Scanner(System.in);
     long[] dp=new long[50];
     dp[0]=1;
     for(int i=1;i<50;i++) {
    	 dp[i]=2*dp[i-1];
     }
		int t=s.nextInt();
		for(int ie=0;ie<t;ie++) {
			long x=s.nextLong();
			long y=s.nextLong();
			String str="";
			if(Math.abs(x)==0) {
				if(y==1) {
					str="N";
				}else if(y==-1) {
					str="S";
				}else if(y==2||y==-2) {
					str="IMPOSSIBLE";
				}else if(y==3) {
					str="NN";
				}else if(y==-3) {
					str="SS";
				}else if(y==4||y==-4) {
					str="IMPOSSIBLE";
				}
			}else if(Math.abs(y)==0) {
				if(x==1) {
					str="E";
				}else if(x==-1) {
					str="W";
				}else if(x==2||x==-2) {
					str="IMPOSSIBLE";
				}else if(x==3) {
					str="EE";
				}else if(x==-3) {
					str="WW";
				}else if(x==4||x==-4) {
					str="IMPOSSIBLE";
				}
				
				
				
			}
			
			
			
			if(x==1) {
				if(y==1) {
					str="IMPOSSIBLE";
				}else if(y==-1) {
					str="IMPOSSIBLE";
				}else if(y==2) {
					str="EN";
				}else if(y==3) {
					str="IMPOSSIBLE";
				}else if(y==-3) {
					str="IMPOSSIBLE";
				}else if(y==4) {
					str="WEN";
				}else if(y==-2) {
					str="ES";
				}else if(y==-4) {
					str="WES";
				}
			}else if(y==1) {
				if(x==1) {
					str="IMPOSSIBLE";
				}else if(x==-1) {
					str="IMPOSSIBLE";
				}else if(x==2) {
					str="NE";
				}else if(x==3) {
					str="IMPOSSIBLE";
				}else if(x==-3) {
					str="IMPOSSIBLE";
				}else if(x==4) {
					str="SNE";
				}else if(x==-2) {
					str="NW";
				}else if(x==-4) {
					str="SNW";
				}
			}else if(x==-1) {
				if(y==1) {
					str="IMPOSSIBLE";
				}else if(y==-1) {
					str="IMPOSSIBLE";
				}else if(y==2) {
					str="WN";
				}else if(y==3) {
					str="IMPOSSIBLE";
				}else if(y==-3) {
					str="IMPOSSIBLE";
				}else if(y==4) {
					str="EWN";
				}else if(y==-2) {
					str="WS";
				}else if(y==-4) {
					str="EWS";
				}
			}else if(y==-1) {
				if(x==1) {
					str="IMPOSSIBLE";
				}else if(x==-1) {
					str="IMPOSSIBLE";
				}else if(x==2) {
					str="SE";
				}else if(x==3) {
					str="IMPOSSIBLE";
				}else if(x==-3) {
					str="IMPOSSIBLE";
				}else if(x==4) {
					str="NSE";
				}else if(x==-2) {
					str="SW";
				}else if(x==-4) {
					str="NSW";
				}
			}
			
			//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
			if(x==2) {
				if(y==1) {
					str="NE";
				}else if(y==-1) {
					str="SE";
				}else if(y==2) {
					str="IMPOSSIBLE";
				}else if(y==3) {
					str="SEN";
				}else if(y==-3) {
					str="NES";
				}else if(y==4||y==-4) {
					str="IMPOSSIBLE";
				}else if(y==-2) {
					str="IMPOSSIBLE";
				}
			}else if(y==2) {
				if(x==1) {
					str="EN";
				}else if(x==-1) {
					str="WN";
				}else if(x==2) {
					str="IMPOSSIBLE";
				}else if(x==3) {
					str="WNE";
				}else if(x==-3) {
					str="ENW";
				}else if(x==4||x==-4) {
					str="IMPOSSIBLE";
				}else if(x==-2) {
					str="IMPOSSIBLE";
				}
			}else if(x==-2) {
				if(y==1) {
					str="NW";
				}else if(y==-1) {
					str="SW";
				}else if(y==2) {
					str="IMPOSSIBLE";
				}else if(y==3) {
					str="SWN";
				}else if(y==-3) {
					str="NWS";
				}else if(y==4||y==-4) {
					str="IMPOSSIBLE";
				}else if(y==-2) {
					str="IMPOSSIBLE";
				}
			}else if(y==-2) {
				if(x==1) {
					str="ES";
				}else if(x==-1) {
					str="WS";
				}else if(x==2) {
					str="IMPOSSIBLE";
				}else if(x==3) {
					str="WSE";
				}else if(x==-3) {
					str="ESW";
				}else if(x==4||x==-4) {
					str="IMPOSSIBLE";
				}else if(x==-2) {
					str="IMPOSSIBLE";
				}
			}
			//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
			if(x==3) {
				if(y==1) {
					str="IMPOSSIBLE";
				}else if(y==-1) {
					str="IMPOSSIBLE";
				}else if(y==2) {
					str="WNE";
				}else if(y==3) {
					str="IMPOSSIBLE";
				}else if(y==-3) {
					str="IMPOSSIBLE";
				}else if(y==4) {
					str="EEN";
				}else if(y==-2) {
					str="WSE";
				}else if(y==-4) {
					str="EES";
				}
			}else if(y==3) {
				if(x==1) {
					str="IMPOSSIBLE";
				}else if(x==-1) {
					str="IMPOSSIBLE";
				}else if(x==2) {
					str="SEN";
				}else if(x==3) {
					str="IMPOSSIBLE";
				}else if(x==-3) {
					str="IMPOSSIBLE";
				}else if(x==4) {
					str="NNE";
				}else if(x==-2) {
					str="SWN";
				}else if(x==-4) {
					str="NNW";
				}
			}else if(x==-3) {
				if(y==1) {
					str="IMPOSSIBLE";
				}else if(y==-1) {
					str="IMPOSSIBLE";
				}else if(y==2) {
					str="ENW";
				}else if(y==3) {
					str="IMPOSSIBLE";
				}else if(y==-3) {
					str="IMPOSSIBLE";
				}else if(y==4) {
					str="WWN";
				}else if(y==-2) {
					str="ESW";
				}else if(y==-4) {
					str="WWS";
				}
			}else if(y==-3) {
				if(x==1) {
					str="IMPOSSIBLE";
				}else if(x==-1) {
					str="IMPOSSIBLE";
				}else if(x==2) {
					str="NES";
				}else if(x==3) {
					str="IMPOSSIBLE";
				}else if(x==-3) {
					str="IMPOSSIBLE";
				}else if(x==4) {
					str="SSE";
				}else if(x==-2) {
					str="NWS";
				}else if(x==-4) {
					str="SSW";
				}
			}
			//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
			if(x==4) {
				if(y==1) {
					str="SNE";
				}else if(y==-1) {
					str="NSE";
				}else if(y==2) {
					str="IMPOSSIBLE";
				}else if(y==3) {
					str="NNE";
				}else if(y==-3) {
					str="SSE";
				}else if(y==4) {
					str="IMPOSSIBLE";
				}else if(y==-2) {
					str="IMPOSSIBLE";
				}else if(y==-4) {
					str="IMPOSSIBLE";
				}
			}else if(y==4) {
				if(x==1) {
					str="WEN";
				}else if(x==-1) {
					str="EWN";
				}else if(x==2) {
					str="IMPOSSIBLE";
				}else if(x==3) {
					str="EEN";
				}else if(x==-3) {
					str="WWN";
				}else if(x==4) {
					str="IMPOSSIBLE";
				}else if(x==-2) {
					str="IMPOSSIBLE";
				}else if(x==-4) {
					str="IMPOSSIBLE";
				}
			}else if(x==-4) {
				if(y==1) {
					str="SNW";
				}else if(y==-1) {
					str="NSW";
				}else if(y==2) {
					str="IMPOSSIBLE";
				}else if(y==3) {
					str="NNW";
				}else if(y==-3) {
					str="SSW";
				}else if(y==4) {
					str="IMPOSSIBLE";
				}else if(y==-2) {
					str="IMPOSSIBLE";
				}else if(y==-4) {
					str="IMPOSSIBLE";
				}
			}else if(y==-4) {
				if(x==1) {
					str="NES";
				}else if(x==-1) {
					str="ENS";
				}else if(x==2) {
					str="IMPOSSIBLE";
				}else if(x==3) {
					str="EES";
				}else if(x==-3) {
					str="WWS";
				}else if(x==4) {
					str="IMPOSSIBLE";
				}else if(x==-2) {
					str="IMPOSSIBLE";
				}else if(x==-4) {
					str="IMPOSSIBLE";
				}
			}
			System.out.println("Case"+" #"+(ie+1)+": "+str);
		}
		
	}
}