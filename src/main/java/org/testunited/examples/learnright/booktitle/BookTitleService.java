package org.testunited.examples.learnright.booktitle;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookTitleService {

	@Autowired
	private BookTitleRepository bookTitleRepository;

	public void Save(BookTitle bookTitle) {
		this.bookTitleRepository.save(bookTitle);
	}

	public ArrayList<BookTitle> getAll() {
		return (ArrayList<BookTitle>) bookTitleRepository.findAll();
	}

	public BookTitle getById(int id) {
		return this.bookTitleRepository.findById(id).get();
	}

}
