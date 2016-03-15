package com.yodlee.oldio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class TxnFilter {

	public static void main(String[] args) {
		List<TransactionLog> txns = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			txns.add(new TransactionLog(new Date(), String.valueOf(i), (i % 3 == 0) ? "CREDIT" : "DEBIT",
					i * Math.random() * 100, "txn " + i));
		}
		
		Predicate<TransactionLog> txnType = (t) -> { return t.getTxnType().equals("DEBIT");};
		
		/*
		txnType = new Predicate<TransactionLog>() {
			public boolean test(TransactionLog t) {
				return t.getTxnType().equals("DEBIT");
			}
		};
		*/
		txns.stream().filter(txnType).forEach((e) -> System.out.println(e));
		
		TxnMapper mapper = (t) -> t.getAmount();
		
		TxnMapper typeBasedMapper = (t) -> ((t.getTxnType().equals("DEBIT")) ? (-1 * t.getAmount()) : (t.getAmount()));
		
		
		System.out.println(txns.stream().filter(txnType).map(mapper).count());
	}
	
	@FunctionalInterface
	static interface TxnMapper extends Function<TransactionLog, Double> {
		
	}

}
