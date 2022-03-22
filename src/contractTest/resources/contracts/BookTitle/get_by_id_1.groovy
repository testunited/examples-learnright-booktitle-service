package org.testunited.examples.learnright.booktitle.test.contract

import org.springframework.cloud.contract.spec.Contract
// import org.springframework.http.HttpStatus

Contract.make {
	request {
		method 'GET'
		url '/booktitles/1'
		headers {
		}
	}
	response {
		status 200
		headers {
			header('Content-Type': 'application/json')
		}
		body (
			id: 1,
			name: 'Sams Teach Yourself Java in 21 Days',
			author: 'Rogers Cadenhead'
		)
	}
}