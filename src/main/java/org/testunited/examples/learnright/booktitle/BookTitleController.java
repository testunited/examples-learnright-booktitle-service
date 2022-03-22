package org.testunited.examples.learnright.booktitle;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookTitleController {

	@Autowired
	BookTitleService bookTitleService;

	@GetMapping("/booktitles")
	public ArrayList<BookTitle> getAll() {
		return this.bookTitleService.getAll();
	}

	@GetMapping("/booktitles/{id}")
	public ResponseEntity<BookTitle> getById(@PathVariable int id) {
		var bookTitle = this.bookTitleService.getById(id);

		if (bookTitle == null)
			return new ResponseEntity<BookTitle>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<BookTitle>(bookTitle, HttpStatus.OK);
	}

	@PostMapping("/booktitles")
	@ResponseStatus(HttpStatus.CREATED)
	public BookTitle add(@Valid @RequestBody BookTitle bookTitle) {
		this.bookTitleService.Save(bookTitle);
		return bookTitle;
	}

}
