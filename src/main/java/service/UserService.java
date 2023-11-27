package service;

import Helper.AES;
import dao.UserDao;
import dto.UserDto;

public class UserService {
	public boolean saveUser(UserDto dto) {
		if (dto.getAge() < 18) {
			return false;
		} else {
			UserDao dao=new UserDao();
			UserDto dto1=dao.findByEmail(dto.getEmail());
			if(dto1!=null) {
				return false;
			}
			else {
				dto.setPassword(AES.encrypt(dto.getPassword(),"123"));
			dao.saveUser(dto);
			return true;
			}
		}
	}
	public boolean login(String email,String password) {
		UserDao dao=new UserDao();
		UserDto dto1=dao.findByEmail(email);
		if(dto1==null) {
			return false;
		}else {
			if(password.equals(AES.decrypt(dto1.getPassword(),"123"))) {
				return true;
			}else {
				return false;q	
			}
		}
		
	}
}
