package study.designpattern;

public class SingletonManger {
	private static SingletonManger instance;
	
	// 기본생성자를 private으로 선언
	private SingletonManger () {}
	
	// 인스턴스를 얻기 위해 노출된 method
	public static SingletonManger getInstance () {
		if ( instance == null )
			instance = new SingletonManger();
		return instance;
	}
	
	public void print () {
		System.out.println("It's print() method in EagerInitialization instance.");
		System.out.println("instance hashCode > " + instance.hashCode());
		try {
			test();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void test () throws Exception {
		
	}
}
