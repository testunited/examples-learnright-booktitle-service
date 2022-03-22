package org.testunited.examples.learnright.booktitle;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import java.util.ArrayList;

import org.hamcrest.Matchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
@Tag("microservice:booktitle")
public class BookTitleControllerTests {

	private MockMvc mockMvc;

	private final String jsonSingleBookTitleGood = "{\n" + "    \"id\": 1,\n" + "    \"name\": \"my new book title\",\n"
			+ "    \"author\": \"who else, its me\"\n" + "}";

	private final String jsonSingleBookTitleBad = "{23232\n" + "    \"bookTitleId\": 1,\n"
			+ "    \"bookTitleName\": \"my new book title\",\n" + "    \"bookTitleAuthor\": \"who else, its me\"\n"
			+ "}";

	private final BookTitle singleBookTitleResponse1 = new BookTitle(1, "my new book title", "who else, its me");
	private final BookTitle singleBookTitleResponse2 = new BookTitle(2, "my new book title 2", "who else, its me");

	private final ArrayList<BookTitle> bookTitleList = new ArrayList<BookTitle>();

	@InjectMocks
	private BookTitleController controller;

	@Mock
	private BookTitleService serviceMock;

	@BeforeAll
	public void setUp() throws Exception {
		mockMvc = standaloneSetup(controller).build();

	}

	@Test
	@Tag("method:GET")
	@Tag("route:/booktitles/{id}")
	@Tag("group:statuscode")
	@Tag("expected:contentmatch")
	public void testGetById() throws Exception {
		when(serviceMock.getById(1)).thenReturn(this.singleBookTitleResponse1);

		this.mockMvc.perform(get("/booktitles/1").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("$.id", Matchers.is(1)))
				.andExpect(jsonPath("$.name", Matchers.is("my new book title")))
				.andExpect(jsonPath("$.author", Matchers.is("who else, its me")));

	}

	@Test
	@Tag("method:GET")
	@Tag("route:/booktitles")
	@Tag("group:statuscode")
	@Tag("expected:contentmatch")
	@DisplayName("Get All BookTitles")
	public void testGetAll() throws Exception {

		this.bookTitleList.add(this.singleBookTitleResponse1);
		this.bookTitleList.add(this.singleBookTitleResponse2);

		when(serviceMock.getAll()).thenReturn(this.bookTitleList);

		this.mockMvc.perform(get("/booktitles").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("$.*", Matchers.hasSize(2)));

	}

	@Test
	public void testAdd() throws Exception {
		this.mockMvc
				.perform(post("/booktitles").content(jsonSingleBookTitleGood).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated());
	}

	@Test
	@Tag("method:GET")
	@Tag("route:/booktitles")
	@Tag(TestTags.GROUP_REQUEST_VALIDATION)
	@Tag("case:bad_json")
	@DisplayName("Validate status code when bad JSON is sent")
	public void testAddBadRequestBadJson() throws Exception {
		this.mockMvc
				.perform(post("/booktitles").content(jsonSingleBookTitleBad).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isBadRequest());
	}

	@Test
	public void testAddBadRequestNotJson() throws Exception {
		this.mockMvc.perform(post("/booktitles").content("NotJason").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isBadRequest());
	}

}
