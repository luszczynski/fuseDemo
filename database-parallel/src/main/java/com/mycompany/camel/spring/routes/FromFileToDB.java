package com.mycompany.camel.spring.routes;

import org.apache.camel.builder.RouteBuilder;

import com.mycompany.camel.spring.strategy.MyAggregationStrategy;

public class FromFileToDB extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		from("file:src/data?noop=true&include=.*.txt")
			.transform().simple("${bodyAs(String)}")
			.multicast(new MyAggregationStrategy()).parallelProcessing()
				.to("sql:select * from PESSOA_MYSQL where nome=#?dataSourceRef=MySQL", 
						"sql:select idade from pessoa_postgres where nome=#?dataSourceRef=Postgres")
			.end()
			.to("sql:INSERT INTO PESSOA_COMPLETA (ID, NOME, SOBRENOME, IDADE) VALUES (#, #, #, #)?dataSourceRef=MySQL");
	}

}
