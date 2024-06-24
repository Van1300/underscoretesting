package com.van1300.underscoretesting.base.service;

import com.vs.rappit.base.authentication.IAppUserPrivilegeBL;
import com.vs.rappit.base.dal.Filter;
import com.van1300.underscoretesting.base.model.ApplicationUserBase;
import com.vs.rappit.base.mail.model.EmailAddress;
import java.util.List;
import com.vs.rappit.base.model.wrapper.UserPrivilegePerimeter;
import java.util.Map;


public interface IApplicationUserBaseService<T extends ApplicationUserBase> extends IAppUserPrivilegeBL<T> {
	

	public List<EmailAddress> getUsersByRole(UserPrivilegePerimeter rolePerimeterInfo, Integer page, Integer pageSize);

	public Map<String,String> getAllRolesMap();
}