package dao.user;

public class UserDaoTestMain {

	public static void main(String[] args) throws Exception {
		UserDao userDao = new UserDao();
		
		System.out.println("1. user 추가");
		int rowCount = userDao.insert(new User("aaaa","aaaa","짱구",null));
		rowCount = userDao.insert(new User("bbbb","bbbb","유리",null));
		System.out.println(">> " + rowCount);
		
		System.out.println("2. user 수정");
		rowCount = userDao.update(new User("aaaa","ssss","철수","cheolsoo@gmail.com"));
		
		
		
	}

}
