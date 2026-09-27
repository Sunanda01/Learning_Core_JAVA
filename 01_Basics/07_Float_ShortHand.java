public class Float_ShortHand 
{
	public static void main(String[] args)
	{
		int a = 10;
		System.out.println(a);			//10

		float f1 = a;					//implicit	
		System.out.println(f1);			//10.0

		//float f2 = 10.0;				//CTE => Incompatible type => double to float
		
		//float f2 = (float)10.0;  		//explicit
		float f2 = 10.0f;	   			//short-hand notation
		System.out.println(f2);	   		//10.0
	}
}
