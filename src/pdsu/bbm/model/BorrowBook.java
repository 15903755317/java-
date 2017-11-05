package pdsu.bbm.model;

import java.util.Date;

public class BorrowBook {
	private String readerid; // ���߱��
	private String ISBN; // ͼ��isbn���
	private Date borrowdate; // ��������
	private Date returndate; // ��������
	private int fine; // ����
	private String bookname;
	private String author;
	private String publish;
	private Date publishDate;
	private String typename;
	private int price;
	private int publishtime;

	public int getPublishtime() {
		return publishtime;
	}

	public void setPublishtime(int publishtime) {
		this.publishtime = publishtime;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public String getTypename() {
		return typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public String getReaderid() {
		return readerid;
	}

	public void setReaderid(String readerid) {
		this.readerid = readerid;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public Date getBorrowdate() {
		return borrowdate;
	}

	public void setBorrowdate(Date borrowdate) {
		this.borrowdate = borrowdate;
	}

	public Date getReturndate() {
		return returndate;
	}

	public void setReturndate(Date returndate) {
		this.returndate = returndate;
	}

	public int getFine() {
		return fine;
	}

	public void setFine(int fine) {
		this.fine = fine;
	}

	
	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublish() {
		return publish;
	}

	public void setPublish(String publish) {
		this.publish = publish;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "BorrowBook [readerid=" + readerid + ", ISBN=" + ISBN
				+ ", borrowdate=" + borrowdate + ", returndate=" + returndate
				+ ", fine=" + fine + "]";
	}
	
}
