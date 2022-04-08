package org.testunited.examples.learnright.booktitle;

import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.context.WebApplicationContext;

import org.testunited.examples.learnright.booktitle.BookTitle;
import org.testunited.examples.learnright.booktitle.BookTitleController;
import org.testunited.examples.learnright.booktitle.BookTitleService;

import io.restassured.module.mockmvc.RestAssuredMockMvc;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
public class BookTitleBase {

	// private MockMvc mockMvc;
	@Autowired
	private WebApplicationContext context;

	@InjectMocks
	private BookTitleController bookTitleCont;

	@Mock
	private BookTitleService bookTitleSvc;

	@BeforeEach
	void setup() {
		var bookTitle1 = new BookTitle(1, "Sams Teach Yourself Java in 21 Days", "Rogers Cadenhead");
		var bookTitle2 = new BookTitle(2, "Spring in Action, Fifth Edition", "Craig Walls");
		var bookTitle3 = new BookTitle(3,
				"Mastering Spring Boot 2.0: Build modern, cloud-native, and distributed systems using Spring Boot",
				"Dinesh Rajput");

		var bookTitleList = new ArrayList<BookTitle>();
		bookTitleList.add(bookTitle1);
		bookTitleList.add(bookTitle2);
		bookTitleList.add(bookTitle3);

		// RestAssuredMockMvc.webAppContextSetup(this.context);
		when(this.bookTitleSvc.getAll()).thenReturn(bookTitleList);
		when(this.bookTitleSvc.getById(1)).thenReturn(bookTitle1);
		when(this.bookTitleSvc.getById(2)).thenReturn(bookTitle2);
		when(this.bookTitleSvc.getById(3)).thenReturn(bookTitle3);
		when(this.bookTitleSvc.getById(11)).thenReturn(null);

		// when(this.bookTitleSvc.Save(bookTitle1)).
		RestAssuredMockMvc.standaloneSetup(this.bookTitleCont);
	}
}
