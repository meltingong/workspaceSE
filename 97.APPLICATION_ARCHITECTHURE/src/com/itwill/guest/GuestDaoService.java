package com.itwill.guest;

import java.util.*;

public class GuestDaoService {
	private GuestDao guestDao;
	
	public GuestDaoService() throws Exception {
		guestDao = new GuestDao();
	}
	
	public int guestDaoWrite(Guest guest) throws Exception {
		return guestDao.insert(guest);
	}
	
	public Guest guestDaoDetail(int no) throws Exception {
		return guestDao.findByGuest(no);
	}
	
	public int guestDaoUpdate(Guest guest) throws Exception {
		return guestDao.update(guest);
	}
	
	public int guestDaoDelete(int no) throws Exception {
		return guestDao.delete(no);
	}
	
	public List<Guest> guestDaoAll() throws Exception{
		return guestDao.findByAllGuest();
	}
	
}

