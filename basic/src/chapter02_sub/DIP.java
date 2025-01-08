	package chapter02_sub;

class Controller {
	
//	Service service = new Service();
	
	Service service;
	Controller(Service service) {
		this.service = service;
	}
	
	void ControllerMethod() {
		System.out.println("Controller A");
		service.serviceMethod();
	}
	void ControllerMethod2() {
		System.out.println("Controller A2");
		service.serviceMethod2();
	}
}

class Service{
	
//	Repository repository = new Repository(); // 이는 클래스 내부주입, 안좋음
	
	IRepository repository;
	Service(IRepository repository){
		this.repository = repository;
	} // 이게 외부주입 -> 이렇게 해야됨.
	
	void serviceMethod() {
		System.out.println("Service A");
		repository.repositoryMethod();
	}
	
	void serviceMethod2() {
		System.out.println("Service A2");
		repository.repositoryMethod2();
	}
	
}

interface IRepository {
	void repositoryMethod();
	void repositoryMethod2();
} // Repository가 기능들로만 있기에 인터페이스를 사용함.

class Repository implements IRepository{
	
	public void repositoryMethod() { //접근 제어자가 default로 되어있는데 interface는 public abstract 이기에 public 접근제어자 붙이기!
		System.out.println("Repository A");
	}
	
	public void repositoryMethod2() {
		System.out.println("Repository A2");
	}
	
}

class Repository2 implements IRepository{
	
	public void repositoryMethod() {
		System.out.println("Repository B");
	}
	
	public void repositoryMethod2() {
		System.out.println("Repository A2");
	}
	
}

public class DIP {

	public static void main(String[] args) {
		Repository repository = new Repository();
		Repository2 repository2 = new Repository2();
		
		Service service = new Service(repository2); // 여기 repository의 타입은 IRepository임!
		// Service service = new Service(repository2); // 여기 repository2의 타입은 IRepository임!
		Controller controller = new Controller(service);
		controller.ControllerMethod();
		
		
	}

}
