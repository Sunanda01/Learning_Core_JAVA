interface Product{
	//public,final,static
	String name = "Laptop";

	//public, abstract :: non-static
	void display();		
	void keyboard();	
	void nav();		
}


abstract class Samsung implements Product{
	public void display(){
		System.out.println("LED");
	}
	public void keyboard(){
		System.out.println("BL");
	}
}

class ProductImpl extends Samsung{
	public void nav(){
		System.out.println("Trackpad");
	}
}

class InterfaceEx{
	public static void main(String[] args){
		System.out.println("Releasing the product :: "+Product.name);

		// Product c1 = new Product();
		// CTE :: interface Product cannot be instantiated

		//Method 1 :: Anonymous Inner class
		Product c2 = new Product(){
			public void display(){
				System.out.println("LED");
			}
			public void keyboard(){
				System.out.println("BL");
			}
			public void nav(){
				System.out.println("Trackpad");
			}
		};
        c2.display();
        c2.keyboard();
        c2.nav();


		//Method 2 :: creating object implementing class
		Product c4 = new ProductImpl();
        c4.display();
        c4.keyboard();
        c4.nav();
	}
}