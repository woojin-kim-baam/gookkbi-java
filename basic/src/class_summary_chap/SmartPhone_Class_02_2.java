package class_summary_chap;

//스마트폰
//- 운영 체제
//- 전화 번호(String으로 하기 편함, -가 있기도 하고 정수로 010을 표현하면 10만 나옴)
//- 전원 상태
//- 전원 상태 변경 작업 -> 독립적으로, 인스턴스
//- 정보를 보여주는 작업 -> 인스턴스
//- 전화를 거는 작업 -> 인스턴스
class SmartPhone1 { // 클래스에 선언된걸 글로벌(전역) 변수
	String os;
	String telNumber;
	boolean power; // boolean 기본값 false
	// 이게 살짝 구조체 느낌.
	void onOff(){
		power = !power; 
		// power 기본값 false, 로컬 변수일 경우에 초기화 하지 않으면 사용이 불가능하지만, 
		// 초기화하지 않을때 참조변수일때는 null 값들이 들어감(string).
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

public class SmartPhone_Class_02_2 {

	public static void main(String[] args) {
					
				SmartPhone1 iPhone16 = new SmartPhone1();
				SmartPhone1 galaxyS24 = new SmartPhone1();
				
				iPhone16.os = "iOS";
				iPhone16.telNumber = "010-1111-1111";
				galaxyS24.os = "Android";
				galaxyS24.telNumber = "010-9999-9999";
				
				System.out.println("iPhone16.os");
				System.out.println(iPhone16.os);
				System.out.println(galaxyS24.os);
				
//				System.out.println(iPhone16.telNumber + "가");
//				System.out.println("010-2222-2222로 전화를 겁니다");
		//	
//				System.out.println(galaxyS24.telNumber + "가");
//				System.out.println("010-3333-2222로 전화를 겁니다");
				// iphone 16은 참조 변수고 인스턴스는 그 안에 들어간것(new SmartPhone1();) 이걸 해야됨.
				
				// 인스턴스가 가지고 있는 메서드 호출 방법
				// 인스턴스.메서드명(매개변수, ...);
				iPhone16.printInfo();
				iPhone16.onOff();
				iPhone16.printInfo();
				iPhone16.tel("010-2222-2222");

	}

}

