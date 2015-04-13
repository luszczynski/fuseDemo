package br.gov.customer;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import org.jboss.logging.Logger;

@RequestScoped
@Path("order")
public class OrderResource {
	
	private Logger logger = Logger.getLogger(this.getClass());
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public String geraSLR(List<Order> orders) {
		logger.info("[REST] invoking webservice");
		return orders.size() + " ok";
	}
}
