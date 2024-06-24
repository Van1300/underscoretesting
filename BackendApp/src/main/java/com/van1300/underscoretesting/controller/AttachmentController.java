package com.van1300.underscoretesting.controller;

import com.vs.rappit.base.factory.InstanceFactory;
import com.van1300.underscoretesting.service.AttachmentServiceImpl;
import com.van1300.underscoretesting.base.controller.AttachmentBaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
@RestController
@RequestMapping(path = "/rest/attachments/", produces = "application/json")
public class AttachmentController extends AttachmentBaseController<AttachmentServiceImpl> {
	public AttachmentController(AttachmentServiceImpl attachmentService) {
		super(attachmentService);
    }
}
