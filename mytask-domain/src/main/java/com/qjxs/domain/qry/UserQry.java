package com.qjxs.domain.qry;

import com.qjxs.common.jpapage.PageParam;
import com.qjxs.domain.User;


public class UserQry extends User{

	private PageParam prama;

	public PageParam getPrama() {
		return prama;
	}

	public void setPrama(PageParam prama) {
		this.prama = prama;
	}
	
	
	

}
