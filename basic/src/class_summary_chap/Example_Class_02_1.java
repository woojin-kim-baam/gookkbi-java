package class_summary_chap;

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
		// return arg1 * attribute1; // 클래스 메서드에서는 인스턴스 변수 사용 및 인스턴스 메서드 호출이 불가능!!!!
		return arg1 * classVariable;
	}
	
}

public class Example_Class_02_1 {

	public static void main(String[] args) {
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

	}

}
