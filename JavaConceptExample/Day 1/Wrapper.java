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
		Integer b = 10, c = 20;		//AutoBoxing 
		// Internally: Integer b = Integer.valueOf(10); ie 10 (int) -> boxing -> Integer object	
		
		System.out.println(b);		
		System.out.println(b+c);	//30 => Unboxing ie b.intValue() + c.intValue() => 10+20=30	
		add(10,20);			//return add(int,int)

		// add(b.intValue(),c.intValue()); // Running add(int x, int y)
		// add(b,c);						// Running add(INT x, INT y)
		// add(b.intValue(),c);			// Running add(int x, INT y)
		// add(b,c.intValue());			// Running add(INT x, int y)
				
	}
}

/*
 add(int, Integer), add(Integer, int)
 * For:
 * Integer a = 10;
 * Integer b = 20;
 * add(a, b);
 * Both overloads require one unboxing conversion:
 
 * add(int, Integer)  -> a unboxed
 * add(Integer, int)  -> b unboxed
 * Therefore: Compile-time error: ambiguous method call.
 
 But: add(Integer, Integer), add(Integer, int)
 *For: add(a, b);
 * add(Integer, Integer) -> exact match
 * add(Integer, int)     -> requires unboxing
 * Therefore: add(Integer, Integer) is selected.
 
 * int
 * -> primitive type
 * -> represents a 32-bit integer value

 * Integer
 * -> wrapper/reference type
 * -> represents an Integer object
 * -> may involve boxing/unboxing
 */