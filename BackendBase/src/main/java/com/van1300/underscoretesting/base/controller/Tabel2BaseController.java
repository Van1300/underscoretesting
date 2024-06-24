package com.van1300.underscoretesting.base.controller;

import org.apache.commons.lang3.StringUtils;

import com.vs.rappit.base.rest.APIConstants;
import com.vs.rappit.base.dal.providers.PersistenceType;
import com.vs.rappit.jersey.base.webservice.BaseWebService;
import com.van1300.underscoretesting.base.service.ITabel2BaseService;
import com.van1300.underscoretesting.base.model.Tabel2Base;
import java.util.Date;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import com.vs.rappit.base.util.FieldUtils;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.PathVariable;

import com.vs.rappit.base.model.Primary;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.DeleteMapping;

import com.vs.rappit.base.model.PaginationRequest;

import com.vs.rappit.jersey.webservice.mapper.DatatableJson;

import com.vs.rappit.base.model.PaginationResponse;

import java.util.ArrayList;

import com.vs.rappit.base.dal.Filter;

import org.springframework.util.MultiValueMap;

import java.util.Map;

import com.vs.rappit.base.model.wrapper.ModelWrapper;

public abstract class Tabel2BaseController<SERVICE extends ITabel2BaseService<M>, M extends Tabel2Base>
		extends BaseWebService<SERVICE, M> {
	
	
	public Tabel2BaseController(SERVICE logic) {
		super(logic);
	}
	
	
	@GetMapping(path = "/autosuggest", produces = "application/json")
	public List<Object> autoSuggestService(@RequestParam("query") String searchText,@RequestParam(name = "sortColumn", required = false) String sortColumn,@RequestParam(name = "sortOrder", required = false) String sortOrder,@RequestParam("pgNo") int pgNo,@RequestParam("pgLen") int length) {
		return logic.autosuggest(searchText,sortColumn,sortOrder,pgNo,length);
	}


	@PutMapping
	public M update(@RequestBody M modelObj) {
		return super.update(modelObj);
	}



	@GetMapping(path = "/{sid}", produces = "application/json")
	public M getById(@PathVariable("sid") Primary sid) {
		M model = logic.getTabel2WorkflowModelBySid(sid.get());
		if (model == null) {
			RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
			if (requestAttributes instanceof ServletRequestAttributes) {
				HttpServletResponse response = ((ServletRequestAttributes) requestAttributes).getResponse();
				if (response != null) {
					response.setStatus(HttpServletResponse.SC_NO_CONTENT);
				}
			}
		}
		return model;
	}


	@PostMapping
	public M create(@RequestBody M modelObj) {
		return super.save(modelObj);
	}


	@DeleteMapping("/{ids}")
	public ResponseEntity deleteRecords(@PathVariable("ids") String ids) {
		boolean isDeleted = super.delete(ids);
		if (isDeleted)
			return ResponseEntity.ok().build();
		else
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}


	@PostMapping("/datatable")
	public PaginationResponse getDatatableData(@RequestBody DatatableJson datatableJson)
	{
		PaginationRequest dataTable = convertToPaginationRequest(datatableJson);
	 	return logic.getAllByPage(PersistenceType.SEARCH, dataTable);
	}
	


	
		//@PreAuthorize("hasAccess('/tabel2s/blanksname/createopentab2/{id}')")
	@PutMapping("blanksname/createopentab2/{id}")
	public M blanksNameCreateopentab2(@PathVariable("id") Primary id, @RequestBody Map<String, Object> additionalInfo)
	{
	 	return logic.createopentab2(id.get(),additionalInfo);
	}	

	
}
