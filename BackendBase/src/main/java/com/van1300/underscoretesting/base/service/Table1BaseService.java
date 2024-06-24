package com.van1300.underscoretesting.base.service;

import com.vs.rappit.base.dal.providers.PersistenceType;
import com.vs.rappit.base.dal.providers.SearchOptions;
import com.vs.rappit.base.workflow.logic.BaseJPAWorkflowBusinessLogic;

import com.vs.rappit.base.exception.ValidationError;
import com.vs.rappit.base.workflow.util.WorkflowMetaInfo;
import com.vs.rappit.base.workflow.util.WorkflowUser;
import com.vs.rappit.base.authentication.logic.AppUserPrivilegeCache;
import com.vs.rappit.base.authentication.logic.IAppUserPrivilegeCache;
import com.van1300.underscoretesting.base.service.IApplicationUserBaseService;
import com.van1300.underscoretesting.base.model.ApplicationUserBase;
import com.vs.rappit.base.cache.CacheManager;
import com.vs.rappit.base.service.changelog.ChangelogBLBaseImpl;
import com.vs.rappit.base.exception.NoAuthenticatedUserException;
import com.vs.rappit.base.workflow.util.WorkflowBasicInfo;
import java.util.Map;
import java.util.HashMap;
import com.vs.rappit.base.model.wrapper.UserPrivilegePerimeter;
import com.vs.rappit.base.mail.model.EmailAddress;
import com.van1300.underscoretesting.base.model.Table1Base;
import org.springframework.beans.factory.annotation.Autowired;
import com.vs.rappit.base.acl.IWorkflowPerimeterManager;
import com.vs.rappit.base.dal.Sort;
import com.vs.rappit.base.dal.Sort.Direction;
import com.van1300.underscoretesting.base.model.ApplicationUserBase;
import com.vs.rappit.base.util.Constants;
import com.vs.rappit.base.exception.EntityReferenceExistsException;
import java.util.List;

import com.van1300.underscoretesting.base.model.Table1field1;

import org.apache.commons.lang3.StringUtils;

import java.util.Map;

import com.vs.rappit.base.mail.model.EmailDetails;

import com.vs.rappit.base.workflow.config.util.WorkflowNextActor;

import com.vs.rappit.base.util.ErrorCode;

import com.vs.rappit.base.util.MapUtil;

import com.vs.rappit.base.exception.EntityNotFoundException;

import java.util.Collections;

import java.util.ArrayList;

import com.vs.rappit.base.dal.providers.DBOptions;

import com.vs.rappit.base.dal.providers.DeleteOptions;

import com.vs.rappit.base.dal.Filter;

import com.vs.rappit.base.dal.Filter.Operator;

import com.vs.rappit.base.dal.SimpleFilter;

public class Table1BaseService<T extends Table1Base> extends BaseJPAWorkflowBusinessLogic<T>
		implements ITable1BaseService<T> {
	private static final String ACTION_COMMENTS = "comments";
	
	private ChangelogBLBaseImpl changelogService;
	

	@Autowired
	private IApplicationUserBaseService<? extends ApplicationUserBase> userPrivilegeService;
				
	@Autowired
	private AppUserPrivilegeCache<ApplicationUserBase> userprivilegeCache;
	
	protected Table1PerimeterBaseImpl table1PerimeterBaseImpl;
			
	public Table1BaseService(Class<T> modelClass) {
		super(modelClass);
		addPersistenceOption(DBOptions.DELETE_OPTION, DeleteOptions.PERMANENT_DELETE);
	}

	@Override
	public PersistenceType[] getOtherPersistenceTypes() {
		return null;
	}
	@Override
	public final void onBeforeSave(PersistenceType type, T modelObj) {
		switch (type) {
			case DB:
				onBeforeSaveDB(modelObj);
				break;
			
			default:
				break;
		}
		super.onBeforeSave(type, modelObj);
	}

	public void onBeforeSaveDB(T modelObj) {
		isObjectExists(modelObj,false);
		
	}

	@Override
	public final void onBeforeUpdate(PersistenceType type, T modelObj) {
		switch (type) {
			case DB:
				onBeforeUpdateDB(modelObj);
				break;
			default:
				break;
		}
		super.onBeforeUpdate(type, modelObj);
	}

	public void onBeforeUpdateDB(T modelObj) {
		isObjectExists(modelObj,true);
	}
	
	
	protected void isObjectExists(T modelObj, boolean isUpdate) {
	}

	@Override
	public final void onBeforeDelete(PersistenceType type, T modelObj) {
		switch (type) {
		case DB:
			onBeforeDeleteDB(modelObj);
			break;
		default:
			break;
		}
		super.onBeforeDelete(type, modelObj);
	}

	public void onBeforeDeleteDB(T modelObj) {
		isReferenceExists(modelObj);
	}

	public void isReferenceExists(T modelObj) {
		List<Filter> filters = new ArrayList<>();
		filters.add(new SimpleFilter(Filter.GLOBAL_SEARCH, modelObj.getSid()));
		List<String> projectedFields = new ArrayList<>(1);
		projectedFields.add("sid");
		addPersistenceOption(SearchOptions.GLOBAL_SEARCH, true);
		List<?> results = getAllByPage(PersistenceType.SEARCH, filters, null, 0, 0, projectedFields);
		removePersistenceOption(SearchOptions.GLOBAL_SEARCH);
		if (results.size() > 1) {
			throw new EntityReferenceExistsException(ErrorCode.ENTITY_REFERENCE_EXISTS, new String[] {});
		}
	}
	

	@Override
	public final void onAfterSave(PersistenceType type, Object modelObj) {
		super.onAfterSave(type, modelObj);
		switch (type) {
			case DB:
				onAfterSaveDB((T)modelObj);
				break;			
			default:
				break;
		}		
	}

	public void onAfterSaveDB(T modelObj) {
	  changelogService.createChangeLog("Table1", modelObj.getSid().toString(), "Saved", modelObj);
	}
	
	@Override
	public final void onAfterUpdate(PersistenceType type, Object modelObj) {		
		switch (type) {
			case DB:
				onAfterUpdateDB((T)modelObj);
				break;			
			default:
				break;
		}	
		super.onAfterUpdate(type, modelObj);	
	}

	public void onAfterUpdateDB(T modelObj) {
	  changelogService.createChangeLog("Table1", modelObj.getSid().toString(), "Updated", modelObj);
	}
	
	@Override
	public final void onAfterDelete(PersistenceType type, Object modelObj) {		
		switch (type) {
			case DB:
				onAfterDeleteDB((T)modelObj);
				break;			
			default:
				break;
		}
		super.onAfterDelete(type, modelObj);		
	}

	public void onAfterDeleteDB(T modelObj) {
	  changelogService.createChangeLog("Table1", modelObj.getSid().toString(), "Deleted", modelObj);
	}	
	
	@Override
	public List<String> onBeforeGeneratedValidation() {
		// TODO Auto-generated method stub
	return null;
	}
	@Override
	public void onAfterGeneratedValidation(List<ValidationError> validationErrors) {
		// TODO Auto-generated method stub
	}
	
	
	


	
			
	@Override
	public T openflow(Object id, Map<String, Object> additionalInfo) {
		setWorkflowName(underscoreFlow);
		T model = getById(id);
		if(model == null) {
			throw new EntityNotFoundException(ErrorCode.WORKFLOW_MODEL_NOT_FOUND, new Object[] {id});
		}
		WorkflowMetaInfo metaInfo = createWorkflowMetaInfo(model, model.getField1().name().toLowerCase(), null,
				openflow,MapUtil.readValueAsString(ACTION_COMMENTS, additionalInfo));
		metaInfo.addAllAdditionalInfo(additionalInfo);		
		metaInfo.setCurrentUser(getCurrentUser(model, metaInfo));
		metaInfo.setCurrentStepObj(validateStep(model, metaInfo));
		onbeforeOpenflow(model,metaInfo);
		onOpenflow(model,metaInfo);
		onAfterOpenflow(model,metaInfo);
		return model;
	}
	
	@Override
	public void onbeforeOpenflow(T model, WorkflowMetaInfo metaInfo){
		
	}
	
	@Override
	public void onOpenflow(T model, WorkflowMetaInfo metaInfo){
		metaInfo.setNextStep(resolveNextStep(model, metaInfo));
		metaInfo.setNextActors(resolveNextActor(model, metaInfo));
		setWorkflowFieldsInModel(model, metaInfo);
		update(model);
	}
	
	@Override
	public void onAfterOpenflow(T model, WorkflowMetaInfo metaInfo){
		createWorkflowHistory(model, metaInfo);
		sendEmail(model, metaInfo);
	}


	@Override
	protected WorkflowUser getCurrentUser(T model, WorkflowMetaInfo metaInfo) {
		ApplicationUserBase userPrivilege = userprivilegeCache.getCurrentUser(false);
		if (userPrivilege == null || StringUtils.isBlank(userPrivilege.getEmail())) {
			throw new NoAuthenticatedUserException(ErrorCode.CURRENT_USER_NOT_FOUND);
		}
		WorkflowUser user = new WorkflowUser(userPrivilege);
		metaInfo.setCurrentUser(user);
		user.setUserTypes(getWorkflowPerimeterManager().getUserTypesForWorkflow(userPrivilege, model, metaInfo));
		return user;
	}
	
	@Override
	protected void setWorkflowFieldsInModel(T model, WorkflowMetaInfo metaInfo) {
				model.setField1(Table1field1.valueOf(metaInfo.getNextStep().toUpperCase()));
		model.setNextActor(metaInfo.getNextActors());
	}
	
	@Override
	protected String resolveCustomNextStep(T model, WorkflowMetaInfo metaInfo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected List<WorkflowNextActor> resolveCustomNextActor(T model, WorkflowMetaInfo metaInfo) {
		// TODO Auto-generated method stub
		return Collections.emptyList();
	}

	@Override
	protected void setEmailContentMap(T model, WorkflowMetaInfo metaInfo, Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
	}

	@Override
	protected void setEmailDetails(T model, WorkflowMetaInfo metaInfo, EmailDetails emailDetails) {
		// TODO Auto-generated method stub
	}
	
	@Override
	protected List<EmailAddress> resolveCustomActorForEmail(T model, WorkflowMetaInfo metaInfo,MailRecipientType recipientType) {
		// TODO Auto-generated method stub
		return Collections.emptyList();
	}
	
	@Override
	public T getTable1WorkflowModelBySid(Object id) {
		T model = getById(id);
		if (model != null) {
			ApplicationUserBase userPrivilege = userprivilegeCache.getCurrentUser(false);
			if (userPrivilege == null || StringUtils.isBlank(userPrivilege.getEmail())) {
				throw new NoAuthenticatedUserException(ErrorCode.CURRENT_USER_NOT_FOUND);
			}
			Map<String, WorkflowBasicInfo> workflowInfo = new HashMap<>();
			if(model.getField1() != null){
				workflowInfo.put(underscoreFlow, new WorkflowBasicInfo(StringUtils.lowerCase(model.getField1().name()),
					getWorkflowPerimeterManager().getUserTypesForWorkflow(userPrivilege, model, null)));
			}
			model.setWorkflowInfo(workflowInfo);
		}
		return model;
	}

	
	@Override
	protected List<EmailAddress> resolveActorForEmailFromAppRole(T model, WorkflowMetaInfo metaInfo,
			UserPrivilegePerimeter perimeterInfo) {
	switch (perimeterInfo.getRoleShortName()) {
		case "devadmin":
			break;
		case "r1":
			break;
		case "app admin":
			break;
	}
	return userPrivilegeService.getUsersByRole(perimeterInfo,0,0);
	}
	
	public void setChangelogService(ChangelogBLBaseImpl changelogService) {
		this.changelogService=changelogService;
	}
	
	public void setUserPrivilegeService(IApplicationUserBaseService<? extends ApplicationUserBase> userPrivilegeService) {
	    this.userPrivilegeService = userPrivilegeService;
	}
	
	public void setPerimeter(IWorkflowPerimeterManager<T> table1PerimeterImpl) {
		this.table1PerimeterBaseImpl = (Table1PerimeterBaseImpl) table1PerimeterImpl;
	}
	

	@Override
	protected IWorkflowPerimeterManager<T> getPerimeterManager() {
		return this.table1PerimeterBaseImpl;
	} 
}
