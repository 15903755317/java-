package pdsu.bbm.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pdsu.bbm.model.BookType;
import pdsu.bbm.model.ReaderType;

public class ReaderTypeDao {
	// ����������ð�����ѯ���ж���������Ϣ
	public static List<ReaderType> selectReaderType() {
		List<ReaderType> list = null;
		CommonDao dao = new CommonDao();
		String sql = "select * from readertype";
		ResultSet rs = dao.query(sql);
		list = new ArrayList<ReaderType>();
		try {
			while (rs.next()) {
				ReaderType bt = new ReaderType();
				bt.setId(rs.getInt("id"));
				bt.setTypename(rs.getString("typename"));
				bt.setMaxborrownum(rs.getInt("maxborrownum"));
				bt.setLimit(rs.getInt("limit"));
				list.add(bt);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		dao.close();
		return list;
	}
	

	public static ReaderType selectReaderType2(int id){
		ReaderType ci = null;
		String sql = "select * from readertype where id=? ";
		CommonDao dao = new CommonDao();
		ResultSet rs = dao.query(sql, id);
		try {
			if(rs.next()){
				ci = new ReaderType();
				
				ci.setId(rs.getInt("id"));
				ci.setTypename(rs.getString("typename"));
				ci.setMaxborrownum(rs.getInt("maxborrownum"));
				ci.setLimit(rs.getInt("limit"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ci;
	}
	//��ѯָ���������Ķ���������Ϣ
	public static List<ReaderType> selectReaderType(String type){
		List<ReaderType> list =null;
		CommonDao dao =new CommonDao();
		String sql="select * from readertype where typename like ?";
		ResultSet rs=dao.query(sql,"%"+type+"%");
		list=new ArrayList<ReaderType>();
		try {
			while(rs.next()){
				ReaderType bt = new ReaderType();
				bt.setId(rs.getInt("id"));
				bt.setTypename(rs.getString("typename"));
				bt.setMaxborrownum(rs.getInt("maxborrownum"));
				bt.setLimit(rs.getInt("limit"));
				list.add(bt);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		dao.close();
		return list;
		
	}
	//�������ͱ�Ų���
	public static List<ReaderType> selectReaderTypeByNUm(Integer num){
		List<ReaderType> list =null;
		CommonDao dao =new CommonDao();
		String sql="select * from readertype where id=?";
		ResultSet rs=dao.query(sql,num);
		list=new ArrayList<ReaderType>();
		try {
			while(rs.next()){
				ReaderType bt = new ReaderType();
				bt.setId(rs.getInt("id"));
				bt.setTypename(rs.getString("typename"));
				bt.setMaxborrownum(rs.getInt("maxborrownum"));
				bt.setLimit(rs.getInt("limit"));
				list.add(bt);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		dao.close();
		return list;
		
	}
	
	
//	public static String selectByTypename(String string){
//		String s=null;
//		CommonDao dao =new CommonDao();
//		String sql="select * from readertype where typename =?";
//		
//		
//		
//		return s;
//		
//		
//	}
	//��Ӷ�������
//	public static int insertReaderType(Integer id, String typename, Integer num, Integer limit){
//		int result=0;
//		CommonDao dao =new CommonDao();
//		String sql="insert into redertype values(?,?,?,?,?)";
//		result=dao.update(sql, id,typename,num,limit);
//		dao.close();
//		return result;
//		
//	}
	public static int insertReaderType(ReaderType reader){
		int result=0;
		String sql="insert into readertype values(?,?,?,?) ";
		CommonDao dao=new CommonDao();
		
		int id=reader.getId();
		String typeName=reader.getTypename();
		int maxborrownum=reader.getMaxborrownum();
		int limit=reader.getLimit();
		
		result=dao.update(sql, id,typeName,maxborrownum,limit);
		
		dao.close();
		return result;
		
	}
	//�޸�ָ����ŵĶ���������Ϣ
	public static int updateReaderType(Integer id, String typename, Integer num, Integer limit){
		int result=0;
		CommonDao dao =new CommonDao();
		String sql="update readertype set typename=?,maxborrownum=?,limit=?where id=?";
		result=dao.update(sql, typename,num,limit,id);
		dao.close();
		return result;
		
	}
	
	//�޸Ķ��ߵ�������Ϣ
	public static int updateReaderType(ReaderType reader){
			int result=0;
			String sql="update readertype set typename=?,maxborrownum=?,limit=? where id=?";
			CommonDao dao=new CommonDao();
			
			int id=reader.getId();
			String typeName=reader.getTypename();
			int maxborrownum=reader.getMaxborrownum();
			int limit=reader.getLimit();
			
			result=dao.update(sql,typeName,maxborrownum,limit,id);
			
			dao.close();
			return result;
			
		}
	//ɾ��ָ�����ͱ�ŵĶ������͡�
	public static int deleteReaderType(Integer id){
		int result=0;
		CommonDao dao =new CommonDao();
		String sql="delete  from readertype where id=?";
		result=dao.update(sql,id);
		dao.close();
		return result;
	}
	
}
