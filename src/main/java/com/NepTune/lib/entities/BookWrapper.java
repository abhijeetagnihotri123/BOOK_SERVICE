package com.NepTune.lib.entities;

public class BookWrapper {
	
	private String BookTitle;
	private String BookISBN_Number;
	
	public BookWrapper()
	{
		super();
	}
	
	public BookWrapper(String bookTitle , String bookISBN_Number)
	{
		this.BookTitle = bookTitle;
		this.BookISBN_Number = bookISBN_Number;
	}
	
	public String getBookTitle() {
		return BookTitle;
	}
	public void setBookTitle(String bookTitle) {
		BookTitle = bookTitle;
	}
	public String getBookISBN_Number() {
		return BookISBN_Number;
	}
	public void setBookISBN_Number(String bookISBN_Number) {
		BookISBN_Number = bookISBN_Number;
	}
	
	
	
}
