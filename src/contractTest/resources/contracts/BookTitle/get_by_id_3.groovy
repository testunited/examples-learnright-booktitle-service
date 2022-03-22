package org.testunited.examples.learnright.booktitle.test.contract

import org.springframework.cloud.contract.spec.Contract
// import org.springframework.http.HttpStatus

Contract.make {
	request {
	    method 'GET'
	    url '/booktitles/3'
	    headers {
	    }
	}
	response {
		status 200
		headers {
			header('Content-Type': 'application/json')
		}
		body (
			 id: 3,
			 name: "Mastering Spring Boot 2.0: Build modern, cloud-native, and distributed systems using Spring Boot",
			 author: "Dinesh Rajput"
		)
	}
}