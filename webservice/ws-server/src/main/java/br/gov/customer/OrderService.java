package br.gov.customer;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.jboss.logging.Logger;

@WebService
public class OrderService {

	private Logger logger = Logger.getLogger(this.getClass());
	
	@WebMethod
	public String geraOrder(@WebParam(name="order",targetNamespace="http://customer.gov.br/") List<Order> orders) {
		logger.info("[SOAP] invoking webservice");
		return orders.size() + " ok";
	}
}
