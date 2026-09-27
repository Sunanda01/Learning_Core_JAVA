class A{
	public int regNo;
	public String name;
	public static int x;
	static{
		//application level start-up code
		//check whether :: HDFC/ICICI
		bName = "ICICI";
		System.out.println("Static unnamed block");
		String[] cities = {"Mysuru", "Hassan"};
		main(cities);

		System.out.println(x);
	}

	public static String bName;
	{
	      System.out.println("\nNon-static unnamed block");
	}

	A(){
		System.out.println("Running constructor A()");
	}

	public static void m1(){
		System.out.println("Running static m1()");
	}

	public void m2(){
		System.out.println("Running non-static m2()");
	}

	public static void main(String[] args){
		System.out.println("\nRunning main");
		m1();
		A obj1 = new A();
		obj1.m2();
	}
}

/*Class A is loaded.
    Static variables are initialized.
    Static block executes.
    Static block calls main(cities).
    Internal main starts.
    Static method m1() executes.
    Object is created → instance block executes.
    Constructor executes.
    Internal main ends.
    Static block completes.
    JVM calls real main(args).
    Real main starts.
    Static method m1() executes.
    Object is created → instance block executes.
    Constructor executes.
    Real main ends.
*/