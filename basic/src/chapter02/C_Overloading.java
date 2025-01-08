package chapter02;

class NewMath{
	// 오버로딩(Overloading) : 같은 클래스 내부에서 같은 이름의 메서드를 여러개 작성할 수 있도록 하는 방법론
	// 오버로딩 조건
	// 1. 메서드의 이름을 중복해서 작성하고 매개변수 타입의 조합 (개수, 타입의순서)를 다르게 작성
	// 2. 메서드의 반환타입과 매개변수의 이름은 영향을 주지 않음.
	
	
	int add(int a, int b) {
		return a + b;
	}
	
	// 오버로딩 사용 안했을 때 문제점
	// 1. 메서드의 이름이 불규칙적임
	// 2. 사용시에 불편함을 초래함
	double add2(double a, double b) {
		return a + b;
	}
	// 오버로딩 : 매개변수의 타입을 다르게 한 경우
	double add(double a, double b) { 
		return a + b;
	}
	// 오버로딩 : 매개변수의 개수를 다르게 한 경우
	int add(int a, int b, int c) {
		return a+b+c;
	}
	// 오버로딩 : 매개변수의 조합이 다를 때
	double add(int a, double b) {
		return a + b;
	}
	/*
	// 반환 타입만 다를 떈 오버로딩 불가능
	double add(int a, int b) {
		return a+b;
	}
	// 매개 변수 이름만 다를 땐 오버로딩 불가능
	int add(int x, int y) {
		return x + y;
	}
	둘다 이거 뜸! Duplicate method add(int, int) in type NewMath
	반환타입은 안보고 매개변수명도 안보지만 메서드명과 매개변수의 타입만 가지고 구분을 함!!!*/ 
}

public class C_Overloading {


	
	
	public static void main(String[] args) {
		NewMath newMath = new NewMath();
		// newMath.add2(0, 0);
		newMath.add(1.2, 1.4);
		newMath.add(1, 2, 3);
		// newMath.add("0","0"); 지정해준 타입으로 적어야함.
		
		
	}

}
