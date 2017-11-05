package pdsu.bbm.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import pdsu.bbm.model.Book;
public class BookDao1 {
	// ��ѯ����ͼ����Ϣ
	public static List<Book> selectBook() {
		List<Book> list = null;
		list = new ArrayList<Book>();
		Book book =null;
		String sql = "select * from book";
		CommonDao dao = new CommonDao();
		ResultSet rs = dao.query(sql);
		try {
			while (rs.next()) {
				book = new Book();
				book.setISBN(rs.getString("ISBN"));//
				book.setTypeid(rs.getString("typeid"));//����
				book.setBookname(rs.getString("bookname"));//����
				book.setAuthor(rs.getString("author"));//����
				book.setPublish(rs.getString("publish"));//������
				book.setPublishdate(rs.getDate("publishdate"));//����
				book.setPublishtime(rs.getInt("publishtime"));//����
				book.setUnitprice(rs.getInt("unitprice"));//����
				list.add(book);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	//����ISBN��ѯͼ����Ϣ
	public static Book selectBookByISBN(String ISBN){
		ResultSet rs=null;
		Book book=null;
		String sql="select * from book where ISBN=?";
		CommonDao dao=new CommonDao();
		rs=dao.query(sql,ISBN );
		try {
			while(rs.next()){//rs��next��Ϊ��,����rs��Զ����Ϊ��.���Բ��ܸ���rs�ж��Ƿ���ҳɹ�
				book = new Book();
				book.setISBN(rs.getString("ISBN"));
				book.setTypeid(rs.getString("typeid"));
				book.setBookname(rs.getString("bookname"));
				book.setAuthor(rs.getString("author"));
				book.setPublish(rs.getString("publish"));
				book.setPublishdate(rs.getDate("publishdate"));
				book.setPublishtime(rs.getInt("publishtime"));
				book.setUnitprice(rs.getInt("unitprice"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return book;//������������Ը���book�Ƿ�Ϊ�����ж��Ƿ���ҳɹ�
	}
	
	//����ͼ�����ֽ��в�ѯ,֧��ģ����ѯ
	public static List<Book> selectBookByName(String name){
		List<Book> list=null;
		String sql="select * from book where bookname like ?";
		CommonDao dao=new CommonDao();
		String cname="%"+name+"%";
		ResultSet rs=dao.query(sql,cname );
		list=new ArrayList<Book>();
		try {
			while(rs.next()){//rs��next��Ϊ��,����rs��Զ����Ϊ��.���Բ��ܸ���rs�ж��Ƿ���ҳɹ�
				Book	book = new Book();
				book.setISBN(rs.getString("ISBN"));
				book.setTypeid(rs.getString("typeid"));
				book.setBookname(rs.getString("bookname"));
				book.setAuthor(rs.getString("author"));
				book.setPublish(rs.getString("publish"));
				book.setPublishdate(rs.getDate("publishdate"));
				book.setPublishtime(rs.getInt("publishtime"));
				book.setUnitprice(rs.getInt("unitprice"));
				list.add(book);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;	
	}
	//����ͼ�����ͽ��в���
	public static List<Book> selectBookByType(String type){
		List<Book> list=null;
		String sql="select * from book where typeid= ?";
		CommonDao dao=new CommonDao();
		ResultSet rs=dao.query(sql,type );
		list=new ArrayList<Book>();
		try {
			while(rs.next()){//rs��next��Ϊ��,����rs��Զ����Ϊ��.���Բ��ܸ���rs�ж��Ƿ���ҳɹ�
				Book	book = new Book();
				book.setISBN(rs.getString("ISBN"));
				book.setTypeid(rs.getString("typeid"));
				book.setBookname(rs.getString("bookname"));
				book.setAuthor(rs.getString("author"));
				book.setPublish(rs.getString("publish"));
				book.setPublishdate(rs.getDate("publishdate"));
				book.setPublishtime(rs.getInt("publishtime"));
				book.setUnitprice(rs.getInt("unitprice"));
				list.add(book);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;	
	}
	//����ͼ�����߽��в���
	public static List<Book> selectBookByAuthor(String author){
		List<Book> list=null;
		String sql="select * from book where author= ?";
		CommonDao dao=new CommonDao();
		ResultSet rs=dao.query(sql,author );
		list=new ArrayList<Book>();
		try {
			while(rs.next()){//rs��next��Ϊ��,����rs��Զ����Ϊ��.���Բ��ܸ���rs�ж��Ƿ���ҳɹ�
				Book	book = new Book();
				book.setISBN(rs.getString("ISBN"));
				book.setTypeid(rs.getString("typeid"));
				book.setBookname(rs.getString("bookname"));
				book.setAuthor(rs.getString("author"));
				book.setPublish(rs.getString("publish"));
				book.setPublishdate(rs.getDate("publishdate"));
				book.setPublishtime(rs.getInt("publishtime"));
				book.setUnitprice(rs.getInt("unitprice"));
				list.add(book);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;	
	}
	
	
	//���ݳ�������в���
	public static List<Book> selectBookByPublish(String publish){
		List<Book> list=null;
		String sql="select * from book where publish= ?";
		CommonDao dao=new CommonDao();
		ResultSet rs=dao.query(sql,publish);
		list=new ArrayList<Book>();
		try {
			while(rs.next()){//rs��next��Ϊ��,����rs��Զ����Ϊ��.���Բ��ܸ���rs�ж��Ƿ���ҳɹ�
				Book book = new Book();
				book.setISBN(rs.getString("ISBN"));
				book.setTypeid(rs.getString("typeid"));
				book.setBookname(rs.getString("bookname"));
				book.setAuthor(rs.getString("author"));
				book.setPublish(rs.getString("publish"));
				book.setPublishdate(rs.getDate("publishdate"));
				book.setPublishtime(rs.getInt("publishtime"));
				book.setUnitprice(rs.getInt("unitprice"));
				list.add(book);
			//	System.out.println(list);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dao.close();
		return list;	
	}
	//�޸�ͼ����Ϣ
	public static int update(Book book ){//��book��������Դ�����(����ʹ��get�����õ�����)
		int result=0;
		//book =new Book();
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-WW-dd");
		
		String sql="update book set typeid=?,bookname=?,author=?,publish=?,publishdate=?,publishtime=?,unitprice=? where ISBN=?";
		CommonDao dao=new CommonDao();
result=dao.update(sql,book.getTypeid(),book.getBookname(),book.getAuthor(),book.getPublish(),simpleDateFormat.format(book.getPublishdate()),book.getPublishtime(),book.getUnitprice(),book.getISBN());
		System.out.println(result+"����Ӱ��!");
		dao.close();
		return result;	
		
	}
}
	
	
		
	






