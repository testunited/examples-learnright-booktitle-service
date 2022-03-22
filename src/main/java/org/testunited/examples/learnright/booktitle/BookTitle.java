package org.testunited.examples.learnright.booktitle;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class BookTitle {

//	public BookTitle(int id, String name, String author, String edition, String year) {
//		super();
//		this.id = id;
//		this.name = name;
//		this.author = author;
//		this.edition = edition;
//		this.year = year;
//	}
	public BookTitle() {
		super();
	}

	public BookTitle(int id, String name, String author) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * @return the edition
	 */
//	public String getEdition() {
//		return edition;
//	}
//	/**
//	 * @param edition the edition to set
//	 */
//	public void setEdition(String edition) {
//		this.edition = edition;
//	}
//	/**
//	 * @return the year
//	 */
//	public String getYear() {
//		return year;
//	}
//	/**
//	 * @param year the year to set
//	 */
//	public void setYear(String year) {
//		this.year = year;
//	}

	@Id
	private int id;

	@NotEmpty
	private String name;

	@NotEmpty
	private String author;
//	private String edition;
//	private String year;
}
