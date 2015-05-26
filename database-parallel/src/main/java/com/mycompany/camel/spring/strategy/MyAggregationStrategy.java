package com.mycompany.camel.spring.strategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.camel.Exchange;
import org.apache.camel.processor.aggregate.AggregationStrategy;

public class MyAggregationStrategy implements AggregationStrategy{

	@Override
	public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
		if (oldExchange == null) {
            return newExchange;
        }
		
		List<Map> sql1 = oldExchange.getIn().getBody(List.class);
		List<Map> sql2 = newExchange.getIn().getBody(List.class);
		
		String id = sql1.get(0).get("ID").toString();
		String nome = sql1.get(0).get("NOME").toString();		
		String sobrenome = sql1.get(0).get("SOBRENOME").toString();
		String idade = sql2.get(0).get("idade").toString();
		
		List<String> resultado = new ArrayList<String>();
		
		resultado.add(id);
		resultado.add(nome);
		resultado.add(sobrenome);
		resultado.add(idade);

		oldExchange.getIn().setBody(resultado);
        return oldExchange;
	}

}
