package com.van1300.underscoretesting.base.model;
import com.vs.rappit.base.workflow.model.BaseWorkflowModel;
import com.vs.rappit.base.annotations.Table;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Id;
import jakarta.persistence.EnumType;
import jakarta.validation.constraints.NotNull;
import com.vs.rappit.base.annotations.Searchable;
import com.vs.rappit.base.util.ValidationErrorConstants;
import com.van1300.underscoretesting.base.model.Table1field1;
import jakarta.persistence.Enumerated;
import jakarta.persistence.UniqueConstraint;


@Table(name="Table1", keys={"sid"})
@MappedSuperclass
@jakarta.persistence.Table(name = "Table1",
				uniqueConstraints = {
			@UniqueConstraint(name = "SIDUnique", columnNames = {"sid"} )})
public class Table1Base extends BaseWorkflowModel {

	@Enumerated(EnumType.STRING)
	@Id
	@NotNull(message = ValidationErrorConstants.NULL_VALUE)
	@Searchable(index = true)
	private Table1field1 field1;

	public void setField1(Table1field1 field1) {
		this.field1 = field1;
	}

	public Table1field1 getField1() {
		return field1;
	}



}