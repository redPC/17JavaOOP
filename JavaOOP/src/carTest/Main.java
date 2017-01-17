package carTest;

public class Main {

		public static void main(String[] args){
			Car car1 = new Car(); //0x22334
			Car car2 = new Car(); //0x54336
			car1.setOwner("홍길동");
			car2.setOwner("홍길동");
			
			int i=10;
			int k[] = new int[5]; //java에서 배열사용하는 방법
								 //가능하면 배열보다는 collection을 이용
			
			//기본적으로 상속받는 equals()의 기능은 "=="와 같다.
			if (car1.equals(car2)){
				System.out.println("equal");
			}
			else{
				System.out.println("different");
			}
			
			//String 특이한 class
			//String은 기본 data type이 아니다
			//원래는 아래처럼 instance를 만들어야함
			String a=new String("안녕하세요");
			String c=new String("안녕하세요");
			
			//빈번하게 사용되니 아래처럼
			String b="소리없는 아우성";
			String d="소리없는 아우성";
			//new해서 만드는 string과 =해서 만드는 string은 다르다
			//문자열 만들때 new해서 만들면 일반 heap 영역에 instance가 생성
			//만약 =로 문자열만들면 heap영역에 string pool영역이 있는데 이안으로 들어감.
			
			//a와 c는 새로운 instance를만들지만 b와 d는 새로만들지 않는다.
			
		}
}
