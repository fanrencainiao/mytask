package com.qjxs.domain.qry;

import com.qjxs.common.jpapage.PageParam;
import com.qjxs.domain.Permission;


public class PermissionQry extends Permission{

	private PageParam prama;

	public PageParam getPrama() {
		return prama;
	}

	public void setPrama(PageParam prama) {
		this.prama = prama;
	}
	
	
	

}
