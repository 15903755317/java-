package pdsu.bbm.model;

import java.util.Date;

public class Book {
	private String ISBN; // ͼ��isbn��
	private String typeid; // ͼ����������
	private String bookname; // ͼ����
	private String author; // ����
	private String publish; // ������
	private Date publishdate; // ��������
	private int publishtime; // ӡˢ����
	private int unitprice; // ͼ�鵥��
	private String typename;
	public String getISBN() {
		return ISBN;
	}

	
	public String getTypename() {
		return typename;
	}


	public void setTypename(String typename) {
		this.typename = typename;
	}


	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getTypeid() {
		return typeid;
	}

	public void setTypeid(String typeid) {
		this.typeid = typeid;
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

	public Date getPublishdate() {
		return publishdate;
	}

	public void setPublishdate(Date date) {
		this.publishdate = date;
	}

	public int getPublishtime() {
		return publishtime;
	}

	public void setPublishtime(int publishtime) {
		this.publishtime = publishtime;
	}

	public int getUnitprice() {
		return unitprice;
	}

	public void setUnitprice(int unitprice) {
		this.unitprice = unitprice;
	}

	@Override
	public String toString() {
		return "Book [ISBN=" + ISBN + ", typeid=" + typeid + ", bookname="
				+ bookname + ", author=" + author + ", publish=" + publish
				+ ", publishdate=" + publishdate + ", publishtime="
				+ publishtime + ", unitprice=" + unitprice + "]";
	}

}
