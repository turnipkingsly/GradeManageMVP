package com.student.grademanagermvp.model.response;

import com.student.grademanagermvp.model.entity.SnsPersonInfo;

public class SnsPersonInfoRes extends BaseRes {
	
	private SnsPersonInfo message;
	
	public SnsPersonInfo getMessage() {
		return message;
	}
	
	public void setMessage(SnsPersonInfo message) {
		this.message = message;
	}
	
}
