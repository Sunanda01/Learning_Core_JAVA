class MainMethod{
	public static void main(){
		System.out.println("Running main()");
	}

	public static void main(int x){
		System.out.println("Running main(int)");
	}
	
	public static void main(int[] x){
		System.out.println("Running main(int[])");
	}

	public static void main(String[] x){
		System.out.println("\nRunning main(String[])");

		main();
		main(10);

		int marks[] = {10,20,30};
		main(marks);
	}

}