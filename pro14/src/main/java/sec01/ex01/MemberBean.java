package sec01.ex01;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MemberBean {
	
	private int mno;
	private String id;
	private String pwd;
	private String name;
	private String email;
	private Date joinDate;
	
//	public String getId() {
//		System.out.println("getId()호출");
//		return id;
//	}
	

}
