package com.van1300.underscoretesting.base.model;
import com.vs.rappit.base.workflow.model.BaseWorkflowModel;
import com.vs.rappit.base.annotations.Table;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Id;
import com.van1300.underscoretesting.base.model.Tabel2field1;
import jakarta.persistence.EnumType;
import com.vs.rappit.base.annotations.Searchable;
import com.vs.rappit.base.annotations.NotBlank;
import com.vs.rappit.base.util.ValidationErrorConstants;
import jakarta.persistence.Enumerated;
import jakarta.persistence.UniqueConstraint;


@Table(name="Tabel2", keys={"sid"})
@MappedSuperclass
@jakarta.persistence.Table(name = "Tabel2",
				uniqueConstraints = {
			@UniqueConstraint(name = "SIDUnique", columnNames = {"sid"} )})
public class Tabel2Base extends BaseWorkflowModel {

	@Enumerated(EnumType.STRING)
	@Searchable(index = false)
	private Tabel2field1 field1;
	@Id
	@NotBlank(message = ValidationErrorConstants.BLANK_VALUE)
	@Searchable(index = true)
	private String field2;

	public void setField1(Tabel2field1 field1) {
		this.field1 = field1;
	}

	public Tabel2field1 getField1() {
		return field1;
	}

	public void setField2(String field2) {
		this.field2 = field2;
	}

	public String getField2() {
		return field2;
	}



}