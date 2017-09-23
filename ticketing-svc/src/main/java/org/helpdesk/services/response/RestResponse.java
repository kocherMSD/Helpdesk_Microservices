package org.helpdesk.services.response;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.helpdesk.db.model.ContractEntity;
import org.helpdesk.db.model.ProductEntity;
import org.helpdesk.db.model.UsersEntity;


@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "Response")
public class RestResponse extends StatusResponse {
	
	private List<UsersEntity> userList;
	private List<ContractEntity> contractList;
	private List<ProductEntity> products;

	@XmlElement
	public List<UsersEntity> getUserList() {
		return userList;
	}

	public void setUserList(List<UsersEntity> userList) {
		this.userList = userList;
	}

	@XmlElement
	public List<ContractEntity> getContractList() {
		return contractList;
	}

	public void setContractList(List<ContractEntity> contractList) {
		this.contractList = contractList;
	}

	@XmlElement
	public List<ProductEntity> getProducts() {
		return products;
	}

	public void setProducts(List<ProductEntity> products) {
		this.products = products;
	}

}
