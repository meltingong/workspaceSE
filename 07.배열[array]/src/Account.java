/*
 * 	계좌객체를 생성하기 위한 클래스(틀,타입)
 */
public class Account implements Comparable<Account> {
	/*
	 * 	1. 속성[멤버필드(변수)]
	 */
	
	private int no;			// 계좌번호
	private String owner; 	// 계좌주 이름
	private int balance; 	// 계좌잔고
	private double iyul;	// 이율
	
	public Account() {
		
	}
	
	public Account(int no, String owner, int balance, double iyul) {
		this.no = no;
		this.owner = owner;
		this.balance = balance;
		this.iyul = iyul;
	}


	/*
	 * 	2. 기능[멤버메쏘드] - 계좌객체가 가지고 있는 기능
	 */
	/*
	 * 계좌데이터를 초기값으로 대입하는 메소드
	 */
	public void setAccountData(int no,String owner, int balance, double iyul) {
		this.no = no;
		this.owner = owner;
		this.balance = balance;
		this.iyul = iyul;
	}
	/*
	 * 입금
	 */
	public void deposit(int money) {
		this.balance += money;
	}
	
	/*
	 * 출금
	 */
	public void withDraw(int money) {
		this.balance -= money;
	}
	/*
	 * 계좌 헤더 출력
	 */
	public static void headerPrint() {
		System.out.println("==============계좌정보==============");
		System.out.printf(" %s      %s    %s    %4s   %n", "번호", "이름", "잔고", "이율");
		System.out.println("------------------------------------");
	}
	/*
	 * 계좌객체 정보출력
	 */
	public void print() {
		System.out.printf(" %d      %s    %5d       %.1f \n", this.no, this.owner, this.balance, this.iyul);
	}
	
	@Override
	public String toString() {
		return "Account [no=" + no + ", owner=" + owner + ", balance=" + balance + ", iyul=" + iyul + "]";
	}

	public int getNo() {
		return no;
	}
	public String getOwner() {
		return owner;
	}
	public int getBalance() {
		return balance;
	}
	public double getIyul() {
		return iyul;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}

	/*
	 * public void setBalance(int balance) { 
			this.balance = balance; 
		}
	 */
	public void setIyul(double iyul) {
		this.iyul = iyul;
	}
	@Override
	public int compareTo(Account nextAccount) {
		/*
		 * << 오름차순 >>
		 *  - Array.sort(accountArray) 메쏘드가 이메쏘드를 호출한후 반환된결과를 받아서정렬(교환)한다
		 *  - 현재Account객체와 다음Account객체를 잔고를비교해서 앞의것이 더크다면 교환을해서 뒤로보내야한다.
		 *  - 그래서 현재Account객체의 잔고가 다음Account객체의 잔고보다 크다면 양수1 을 반환해준다.
		 *  - 양수1을 반환받은 Arrays.sort()메쏘드는 현재Account객체와 다음Account객체의 주소교환작업을할것이다. 
		 */
		/*
		 * << 내림차순 >>
		 *  - Arrays.sort(accountArray) 메쏘드가 이메쏘드를 호출한후 반환된결과를 받아서정렬한다
		 *  - 현재Account객체와 다음Account객체를 비교해서 앞의것이 더작다면 교환을해서 뒤로보내야한다.
		 *  - 그래서 현재Account객체의 잔고가 다음Account객체의 잔고보다 작다면 양수1 을 반환해준다.
		 *  - 양수1을 반환받은 Collection.sort()메쏘드는 현재Account객체와 다음Account객체의 주소교환작업을할것이다. 
		 */
		/***잔고 오름차순**
		if(this.getBalance() > nextAccount.getBalance()) {
			return -1;
		}else {
			return 1;
			}
				
		}
		 *********************/
		/***이름으로 오름차순***/
		String ownerCurrent = this.getOwner();
		String ownerNext = nextAccount.getOwner();
		if(ownerCurrent.compareTo(ownerNext) > 0) {
			return 1;
		}else {
			return -1;
		}
	
	}
}
