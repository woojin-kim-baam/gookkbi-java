package chapter02;

// 클래스 : 공통된 속성과 긴능을 정의한 것
// [접근제어자] class 클래스명(Upper Camel Case이용) { 속성, 기능 }

class ExampleClass1{
	
	// 속성: 객체가 가지는 정보나 상태의 정의
	// 일반적으로 변수 형태로 표현
	int attribute1; // 값에 일반적으로 할당을 하지 않음, 정의만 하는 것이기에.
	double attribute2;
	
	// 인스턴스 변수 : 각 인스턴스마다 독립적으로 값을 가지는 변수
	// 반드시 인스턴스가 생성된 후에 사용 가능
	int instanceVariable;
	
	// 클래스 변수 : 해당 클래스로 생성된 모든 인스턴스가 공유하는 변수
	// 필드의 데이터 타입 앞에 static 키워드를 사용하여 지정
	// 인스턴스 생성 없이 사용 가능
	static int classVariable;
	
	// 기능 : 클래스가 가질 수 있는 행동이나 작업 (메서드)
	// [접근제어자] 반환타입 메서드명 (매개변수타입 매개변수명, ...) 이 줄을 메서드의 선언부
	// { 메서드의 기능 구현 } 이 코드 블럭은 메서드의 구현부
	void method1 () {
		System.out.println("메서드");
		// return : 메서드의 결과를 반환하는 역할 수행함
		// 일반적인 메서드는 반드시 제일 마지막에 return이 필수 (결과값도 같이 줘야함. void일때만 return뒤에 뭐 안적는거임.)
		// void 메서드에서는 필수가 아님
		// 메서드 중간에서 조건문 등을 활용하여 강제 메서드 종료에도 사용됨
		return;
	}
	
	// 인스턴스 메서드 : 인스턴스 생성 후 인스턴스를 통해 호출 가능한 메서드
	// 인스턴스, 클래스 변수 및 메서드를 모두 사용 가능
	int instanceMethod1(int arg1) {
		return arg1 * attribute1;
	}
	
	// 클래스 메서드 : 인스턴스 생성없이 클래스로 호출 가능한 메서드
	// 반환 타입 앞에 static 키워드를 붙여서 선언 가능
	// 클래스 메서드에서는 인스턴스 변수 사용 및 인스턴스 메서드 호출이 불가능!!!!
	// 인스턴수 변수 및 인스턴스 메서드를 사용하지 않는 기능에 대해서 주로 사용됨.
	static int classMethod1(int arg1) {
		// return arg1 * attribute1;
		return arg1 * classVariable;
	}
	
}

// 스마트폰
// - 운영 체제
// - 전화 번호(String으로 하기 편함, -가 있기도 하고 정수로 010을 표현하면 10만 나옴)
// - 전원 상태
// - 전원 상태 변경 작업 -> 독립적으로, 인스턴스
// - 정보를 보여주는 작업 -> 인스턴스
// - 전화를 거는 작업 -> 인스턴스
class SmartPhone1 { // 클래스에 선언된걸 글로벌(전역) 변수
	String os;
	String telNumber;
	boolean power;
	// 이게 살짝 구조체 느낌.
	void onOff(){
		power = !power; // 로컬 변수일 경우에 초기화 하지 않으면 사용이 불가능하지만, 초기화하지 않을때 참조변수일때는 null 값들이 들어감(string).
		// 정수나 숫자는 0, char은 빈 공백, boolean은 0일때 false
	}
	
	void printInfo() {
		if (!power) {
			System.out.println("전원이 꺼져있습니다.");
			return;
		}
		System.out.println("OS :"  + os);
		System.out.println("Tel Number : " + telNumber);
	}
	
	void tel(String to) {
		if (!power) {
			System.out.println("전원이 꺼져있습니다.");
			return;
		}
		
		System.out.println(telNumber + "가" + to + "에게 전화를 겁니다.");
	}
}

// 삼각형 관련 수학
// 빗변구하기 -> 클래스 메서드
// 둘레구하기 -> 클래스 메서드
// 넓이구하기 -> 클래스 메서드
class TriangleMath{
	
	// SPEED_OF_LIGHT은 TriangleMath 클래스의 단일 책임 원칙에 위배됨. (class TriangleMath이거랑 관련없어서 다른데다가 뺴는게 맞음.) 
	static final int SPEED_OF_LIGHT = 300_000_000;

	
	static double getHypoTenuse(double bottom, double height) {
		if (bottom <= 0 || height <= 0) {
			// 반환타입이 double이기에 return만 치면 안됨
			return 0;
		}		
		double hypoTenuse2 = Math.pow(bottom, 2) + Math.pow(height, 2);
		double hypoTenuse = Math.sqrt(hypoTenuse2);
		return hypoTenuse;
	}
	
	static double getCircumference(double bottom, double height, double hypoTenuse) {
		if(bottom <= 0 || height <= 0 || hypoTenuse <= 0) {
			return 0;
		}
		double circumference = bottom + height + hypoTenuse;
		return circumference;
	}
	static double getArea(double bottom, double height) {
		if (bottom <= 0 || height <= 0) {
			// 반환타입이 double이기에 return만 치면 안됨
			return 0;}
		double Area = bottom * height / 2;
		return Area;
	}
}

	
public class A_Class_Object {
	
	// 함수 : 특정한 기능에 대한 정의
	// 반환타입 함수명(매개변수타입 매개변수명, ...){ 함수의기능 }
	static int fx1(int x) {
		int y = x * x + 2 * x + 1;
		// return : 함수를 종료하면서 함수 결과를 반환하는 역할
		// 함수에서 반드시 return 작업이 수행되어야함
		// 단, void 반환타입 일때는 return이 필수는 아님
		// void : 반환 타입 없음
		return y;
	}
	
	// 변수의 목적 -> 데이터 저장, 이름 부여해서 기억하게 함
	
	// 함수의 목적
	// 1. 기능을 미리 정의해두고 사용할땐 호출하여 사용할 수 있도록 함
	// (코드 중복 제거, 유지 보수성 향상, 실제 구현내용을 알 필요 없음)
	// 2. 기능에 이름을 부여하여 사용할 수 있도록 함
	
	// 클래스 내부에 함수가 있으면 그건 메서드라고 함.

	static void printBMI() {
		double x = (173 * 173);
		double y = 83 / x;
		System.out.println("bmi: "+ y);
	}

	public static void main(String[] args) {// 메인 안에 있는 녀석을 지역변수
		
		// 인스턴스 : 특정 클래스로 정의된 것을 실체화한 것
		// 클래스명 참조변수명 = new 클래스명();
		ExampleClass1 instance1 = new ExampleClass1();
		ExampleClass1 instance2 = new ExampleClass1();
		
		System.out.println(instance1);
		System.out.println(instance2);
		
		// 인스턴스가 가지고 있는 속성 접근 방법
		// 인스턴스.속성명;
		instance1.attribute1 = 10;
		instance2.attribute1 = 20;
		new ExampleClass1().attribute1 = 30; // 기억을 못하기에 값을 부여해도 쓰지 못함.
		
		instance1.classVariable = 10;
		ExampleClass1.classVariable = 20;
		instance2.classVariable = 99;
		
		System.out.println(instance1.classVariable);
		System.out.println(instance2.classVariable);
		System.out.println(ExampleClass1.classVariable); // ->주소기에 값이 같음 값 체크해보쇼  
		
		// 클래스 변수를 사용할 때 주의할 점
		// 클래스 변수는 모든 인스턴스에 영향을 미치기 때문에
		// 클래스로 접근하길 권장함
		// 일반적으로 클래스 변수는 final 키워드와 함께 사용함 
	
		SmartPhone1 iPhone16 = new SmartPhone1();
		SmartPhone1 galaxyS24 = new SmartPhone1();
		
		iPhone16.os = "iOS";
		iPhone16.telNumber = "010-1111-1111";
		galaxyS24.os = "Android";
		galaxyS24.telNumber = "010-9999-9999";
		
		System.out.println(iPhone16.os);
		System.out.println(galaxyS24.os);
		
//		System.out.println(iPhone16.telNumber + "가");
//		System.out.println("010-2222-2222로 전화를 겁니다");
//	
//		System.out.println(galaxyS24.telNumber + "가");
//		System.out.println("010-3333-2222로 전화를 겁니다");
		// iphone 16은 참조 변수고 인스턴스는 그 안에 들어간것(new SmartPhone1();) 이걸 해야됨.
		
		// 인스턴스가 가지고 있는 메서드 호출 방법
		// 인스턴스.메서드명(매개변수, ...);
		iPhone16.printInfo();
		iPhone16.onOff();
		iPhone16.printInfo();
		iPhone16.tel("010-2222-2222");
		
		System.out.println(fx1(10));
		System.out.println(fx1(4)); 
		
//		double x = (173 * 173);
//		double x = 83 / x;
//		System.out.println("bmi: "+ y);
		
		printBMI();
		
		double result = TriangleMath.getHypoTenuse(3, 4);
		System.out.println(result);
	}

}

