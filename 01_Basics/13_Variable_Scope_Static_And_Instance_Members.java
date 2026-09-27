class Student
{
	static String cName 	= "DSI";
	static String cAddress	= "Bangalore";

	//non-static variables
	int regNo;
	String name;
	double cgpa;

	public static void displayCollegeDetails()
	{
        System.out.println("Inside DisplayCollegeDetails()");
		int b = 20;
		System.out.println(b);						//20
		
		//access static members		
		System.out.println(cName);					//DSI

		//conflict :: local and static
		String cName = "Reva University";
		System.out.println(cName);					//Reva University
		System.out.println(Student.cName);			//DSI => ClassName.staticField

		//access local variable of caller method
		//System.out.println(a);					//CTE => the callee cannot access the local variable of caller because of LIFO principle of Stack Pointer	
	}

	public void displayStudentDetails()
	{
        System.out.println("Inside DisplayStudentDetails()");
		//access local members
		int d = 40;
		System.out.println(d);						//40

		//access Non-static members
		System.out.println(regNo);					//101

		//conflict :: local and non-static
		int regNo = 1000;
		System.out.println(regNo);					//1000	
		System.out.println(this.regNo);				//101

		//access static members
		System.out.println(cName);					//DSI

		//conflict :: local and static
		String cName = "DSU";
		System.out.println(cName);					//DSU
		System.out.println(Student.cName);  		//DSI
	
	}

	public static void main(String[] args)
	{
		//access local members
		System.out.println("Inside MAIN()");			
		int a = 10;
		System.out.println(a);						//10

		//access static members		
		System.out.println(cName);					//DSI

		//conflict :: local and static
		String cName = "DSCASC";
		System.out.println(cName);					//DSCASC
		System.out.println(Student.cName);			//DSI

		displayCollegeDetails();

		// System.out.println(b);		//CTE => access local variable of callee method

		Student s1 = new Student();
		Student s2 = new Student();
		Student s3 = new Student();

		s1.regNo = 101;
		s2.regNo = 102;
		s3.regNo = 103;

		s1.displayStudentDetails();

	}
}
/*
    We can call main method inside another function, but that will again the function in which it is declared and this will go on, this is called as StackOverflowError

    Ex:
        String cities[] = {"Hassan","Mysuru"};
		main(cities);
		it leads to RTE :: StackOverflowError

*/ 


