package org.testunited.examples.learnright.booktitle;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Optional;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.*;

@SpringBootTest
public class BookTitleServiceTests {

	@InjectMocks
	private BookTitleService service;

	@Mock
	private BookTitleRepository reposirotyMock;

	@Test
	public void testGetAll() {
		ArrayList<BookTitle> mockedResult = new ArrayList<BookTitle>();
		mockedResult.add(new BookTitle(1, "Unit Testing", "Anonymous"));
		mockedResult.add(new BookTitle(2, "Enterprise Applications", "Anonymous"));

		when(reposirotyMock.findAll()).thenReturn(mockedResult);

		assertEquals(2, service.getAll().size());
	}

	@Test
	public void testGetById() {
		BookTitle bookTitle = new BookTitle(1, "Unit Testing", "Anonymous");

		when(reposirotyMock.findById(1)).thenReturn(Optional.ofNullable(bookTitle));

		assertEquals("Unit Testing", service.getById(1).getName());
	}

	@Test
	public void testSave() {
		BookTitle bookTitle = new BookTitle(1, "Unit Testing", "Anonymous");
		this.service.Save(bookTitle);
	}
}
