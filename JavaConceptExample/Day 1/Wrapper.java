public class Wrapper 
{
	public static void add(int x, int y)				//Highest priority
	{
		System.out.println("Running add(int x, int y)");
	}

	public static void add(int x, Integer y)
	{
		System.out.println("Running add(int x, INT y)");
	}

	public static void add(Integer x, int y)
	{
		System.out.println("Running add(INT x, int y)");
	}

	public static void add(Integer x, Integer y)
	{
		System.out.println("Running add(INT x, INT y)");
	}

	public static void main(String[] args)
	{
		Integer b = 10, c=20;		//Boxing
		System.out.println(b);		//10 => Unboxing
		System.out.println(b+c);	//30 => Unboxing
		add(10,20);			//return add(int,int)
				
	}
}

/*
	add(int a , Integer b)
	add(Integer a , int b)
	=> Will throw CTE => Ambiguous Error
	=> Same for add(Integer a , Integer b) and add(Integer a , int b)
- int a => stores less memory as irt stores the value
- Integer a => stores the memory address of a, hence it takes more time
 */