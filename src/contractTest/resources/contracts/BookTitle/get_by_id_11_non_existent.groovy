package org.testunited.examples.learnright.booktitle.test.contract

import org.springframework.cloud.contract.spec.Contract
// import org.springframework.http.HttpStatus

Contract.make {
	request {
		method 'GET'
		url '/booktitles/11'
		headers {
		}
	}
	response {
		status 404
	}
}