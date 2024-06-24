package com.van1300.underscoretesting.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import com.vs.rappit.base.logger.Logger;
import com.vs.rappit.base.logger.LoggerFactory;
import org.springframework.http.ResponseEntity;
import com.vs.rappit.base.factory.InstanceFactory;
import com.van1300.underscoretesting.base.controller.Tabel2BaseController;
import com.van1300.underscoretesting.service.ITabel2Service;
import com.van1300.underscoretesting.service.Tabel2Service;
import com.van1300.underscoretesting.model.Tabel2;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "rest/tabel2s/", produces = "application/json")
public class Tabel2Controller extends Tabel2BaseController<ITabel2Service<Tabel2>, Tabel2> {
	private static final Logger LOGGER = LoggerFactory.getLogger(Tabel2Controller.class.getName());
	public Tabel2Controller(Tabel2Service tabel2Service) {
		super(tabel2Service);
	}
}
