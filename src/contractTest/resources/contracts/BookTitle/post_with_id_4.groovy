package org.testunited.examples.learnright.booktitle.test.contract

import org.springframework.cloud.contract.spec.Contract
//import org.springframework.http.HttpStatus

Contract.make {
	request {
		method 'POST'
		url '/booktitles'
		headers {
			header('Content-Type': 'application/json')
		}
		body (
			id: $(p(4),c(anyNumber())),
			name: $(p("Cloud Native Java: Designing Resilient Systems with Spring Boot, Spring Cloud, and Cloud Foundry"),c(nonEmpty())),
			author: $(p("Josh Long, Kenny Bastani"),c(nonEmpty()))
		)
	}
	response {
		status 201
		headers {
			header("Content-Type": "application/json")
		}
		body (
			id: fromRequest().body('$.id'),
			name: fromRequest().body('$.name'),
			author: fromRequest().body('$.author')
		)
	}
}