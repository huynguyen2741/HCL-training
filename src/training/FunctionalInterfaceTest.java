package training;

interface Calculator{
	int add (int a, int b);
}


public interface FunctionalInterfaceTest{
	void call1();
	default void call2() {
		System.out.println("calling call2 ");
	}
	static void call3() {
		System.out.println("calling static ");
	}
}

class CalculatorImpl {

	public static void main(String[] args) {
		Calculator c = (x,y) -> {return x+y;};
		System.out.println(c.add(2,3));

	}

}
