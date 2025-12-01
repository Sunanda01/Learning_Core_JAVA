public class Variable_Declaration 
{
	public static int a = 30;
	public static int b;			//decl + not init => NO ERROR

	public static void main(String[] args)
	{
		int c = 10;
		System.out.println(c);		//10
		System.out.println(a);		//30
		System.out.println(b);		//0
		int d;						//decl + not init :: NO ERROR
		// System.out.println(d);	//CTE => var 'd' might not be initialized
	}
}
