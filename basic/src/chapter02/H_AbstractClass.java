package chapter02;

// 추상 클래스: 추상 메서드를 포함할 수 있는 클래스
// 추상 클래스 자체로는 인스턴스를 생성할 수 없음. 반드시 추상 클래스를 상속받은 하위 클래스로 인스턴스를 생성해야 함(업캐스팅해서 넣어라는 뜻)
// abstract class 추상클래스명 { ... }

// 추상 메서드: 선언부만 존재하고 구현부는 존재하지 않는 메서드
// 반드시 추상 클래스 내부에서만 선언할 수 있음(클래스 중에서는)
// 반드시 추상 클래스를 상속받은 하위 클래스에서 재정의하여(오버라이딩)하여 구현해야 함.
// abstract 반환타입 추상메서드명(매개변수, ...); -> 중괄호 안오는거 기억!

// abstract: 추상 클래스 혹은 추상 메서드를 정의하는 제어자
// abstract가 붙은 클래스는 인스턴스를 생성할 수 없음
// abstract가 붙은 메서드는 구현부를 가질 수 없음.

abstract class Occupation {
	int annual;
	int income;
	
	// 추상클래스에서 생성자는 인스턴스를 생성하는 목적이 아님(생성할 수 없기에)
	// 하위클래스에서 호출하여 사용할 수 있도록 제공하는 목적
	// 단, 기본 생성자가 없는 상태에서 생성자를 정의한다면 하위클래스에 생성자 작성을 강요

	Occupation(int annual, int income){
		this.annual = annual;
		this.income = income;
	}
	
	// 추상 메서드는 하위 클래스에서 오버라이딩을 강요함.
	abstract void work(); // 중괄호 없다!
	
	// 추상 클래스도 일반 메서드를 가질 수 있음.
	// 일반 메서드는 오버라이딩을 강요하지는 않음.
	void sleep() {
		System.out.println("잠을 잡니다.");
	}
}

// 추상클래스도 단일 상속만 가능
class Developer extends Occupation {
	String position;
	
	Developer(int annual, int income, String position){
		super(annual, income);
		this.position = position;
	}
	
	@Override
	void work() {
		System.out.println("프로그램을 개발합니다.");	
	}
	
	void eat(String food) {
		System.out.println(food + "을 먹습니다");
	}
}

class TourGuide extends Occupation{
	
	String country;
	
TourGuide(int annual, int income, String country){
		super(annual, income);
		this.country = country;
	}

	@Override
	void work() {
		System.out.println(country + "에서 관광을 설명합니다.");
	}
	
	@Override
	void sleep() {
		System.out.println("관광지에서 잠을 잡니다.");
	}
}

public class H_AbstractClass {

	public static void main(String[] args) {

//		 Occupation occupation = new Occupation(10, 1000);
		Developer developer = new Developer(10, 100, "백엔드");
		TourGuide tourGuide = new TourGuide(1, 20, "대한민국");
		developer.work();
		System.out.println(tourGuide.annual);
		tourGuide.work();
	}

}

// 제어자 조합
// static이 붙은 변수: 일반적으로 public 제어자 자주 사용 + static이 붙으며 + final 이 붙는 이 형태를 자주 사용
//  => public + static + final
// private + final이 붙은 변수 : 생성자에서 필수로 초기화함을 의미
// private + final이 붙는 메서드 : final이 의미가 없음 => private은 자기 자신 클래스만 접속이 가능하며 final은 오버라이드가 안되는 거기에 접근도 안되고 오버라이드도 안됨.
// private + abstract가 붙은 메서드 : 반드시 오버라이드 해야되는데 private때문에 접근이 안되어 오버라이드가 안됨 => 불가능한 조합.
// final + abstract가 붙은 클래스와 메서드 : 
// 클래스 final: 상속이 불가능	abstract: 반드시 상속
// 메서드 final: 오버라이드 불가능	abstract: 반드시 오버라이드

