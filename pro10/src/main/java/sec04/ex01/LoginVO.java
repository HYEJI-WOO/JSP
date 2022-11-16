package sec04.ex01;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class LoginVO implements HttpSessionBindingListener{
	
	private String user_id;
	
	public LoginVO(String user_id) {
		this.user_id = user_id;
	}

	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		System.out.println("세션객체에 데이터가 바인딩 됨");
	}
	
	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		System.out.println("세션객체에 데이터가 언바인딩 됨");
	}
	
}
