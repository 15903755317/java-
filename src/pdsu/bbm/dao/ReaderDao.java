package pdsu.bbm.dao;

import java.net.CookieHandler;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import pdsu.bbm.model.Reader;
public class ReaderDao {
	//¼�������Ϣ
	public static int insertReader(Reader reader){
		int result=0;
		CommonDao  dao =new CommonDao();
		String sql="insert into reader values(?,?,?,?,?,?,?,?)";
		try {
			result=dao.update(sql, reader.getReaderid(),reader.getType(),reader.getName(),reader.getAge(),reader.getSex(),reader.getPhone(),reader.getDept(),reader.getRegDate());
		} catch (Exception e) {
			e.printStackTrace();
		}
		dao.close();
		return result;
	}
	//��ѯ���ж���
//	public static List<Reader> selectReader(){
//		List<Reader> list=null;
//		CommonDao dao =new CommonDao();
//		String sql="select * from reader";
//
//		ResultSet rs=dao.query(sql);
//		list =new ArrayList<Reader>();
//		try {
//			while(rs.next()){
//				Reader reader=new Reader();
//				reader.setReaderid(rs.getString("readerid").trim());
//				reader.setType(rs.getInt("type"));
//				reader.setName(rs.getString("name").trim());
//				reader.setAge(rs.getInt("age"));
//				reader.setSex(rs.getString("sex").trim());
//				reader.setPhone(rs.getString("phone").trim());
//				reader.setDept(rs.getString("dept").trim());
//				reader.setRegDate(rs.getDate("regdate"));
//				list.add(reader);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		dao.close();
//
//		return list;
//	}
	
	// �鿴������Ϣ
		public static List<Reader> selectReader() {
			List<Reader> list = new ArrayList<Reader>();
			CommonDao dao = new CommonDao();
			String sql = "select readerid,type,name,age,sex,phone,dept,regdate,typename,maxborrownum,limit  from reader join readertype on reader.type=readertype.id";
			ResultSet rs = dao.query(sql);
			try {
				while (rs.next()) {
					Reader reader = new Reader();
					reader.setReaderid(rs.getString("readerid"));
					reader.setType(rs.getInt("type"));
					reader.setName(rs.getString("name"));
					reader.setAge(rs.getInt("age"));
					reader.setSex(rs.getString("sex"));
					reader.setPhone(rs.getString("phone"));
					reader.setDept(rs.getString("dept"));
					reader.setRegDate(rs.getDate("regdate"));
					reader.setTypename(rs.getString("typename"));
					reader.setMaxborrownum(rs.getInt("maxborrownum"));
					reader.setLimit(rs.getInt("limit"));
					list.add(reader);
				}
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			dao.close();
			return list;
		}
	
	//ͨ������id��ѯ
//	public static List<Reader> selectReaderById(String id){
//		 List<Reader> list =null;
//		Reader reader=null;
//		CommonDao dao=new CommonDao();
//		String sql="select * from reader where readerid=?";
//		list=new ArrayList<Reader>();
//		ResultSet rs=dao.query(sql, id);
//		try {
//			if(rs.next()){
//				reader=new Reader();
//				reader.setReaderid(rs.getString("readerid").trim());
//				reader.setType(rs.getInt("type"));
//				reader.setName(rs.getString("name").trim());
//				reader.setAge(rs.getInt("age"));
//				reader.setSex(rs.getString("sex").trim());
//				reader.setPhone(rs.getString("phone").trim());
//				reader.setDept(rs.getString("dept").trim());
//				reader.setRegDate(rs.getDate("regdate"));
//				list.add(reader);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		dao.close();
//		return list;
//	}
		public static List<Reader> selectReaderById(String id) {
			List<Reader> list = new ArrayList<Reader>();
			CommonDao dao = new CommonDao();
			String sql = "select readerid,type,name,age,sex,phone,dept,regdate,typename,maxborrownum,limit  from reader join readertype on reader.type=readertype.id where readerid='"
					+ id + "'";
			ResultSet rs = dao.query(sql);
			try {
				while (rs.next()) {
					Reader reader = new Reader();
					reader.setReaderid(rs.getString("readerid"));
					reader.setType(rs.getInt("type"));
					reader.setName(rs.getString("name").trim());
					reader.setAge(rs.getInt("age"));
					reader.setSex(rs.getString("sex"));
					reader.setPhone(rs.getString("phone"));
					reader.setDept(rs.getString("dept"));
					reader.setRegDate(rs.getDate("regdate"));
					reader.setTypename(rs.getString("typename"));
					reader.setMaxborrownum(rs.getInt("maxborrownum"));
					reader.setLimit(rs.getInt("limit"));
					list.add(reader);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			dao.close();
			return list;
		}
		
		public static Reader selectReaderById2(String readerid){
			
			Reader reader=null;
			String sql="select * from reader where readerid=? ";
			CommonDao dao=new CommonDao();
			ResultSet rs=dao.query(sql,readerid);   
			try {
				while (rs.next()) {
					reader=new Reader();
					
					reader.setReaderid(rs.getString("readerid"));
					reader.setType(rs.getInt("type"));
					reader.setTypename(rs.getString("name"));
					reader.setAge(rs.getInt("age"));
					reader.setSex(rs.getString("sex"));
					reader.setPhone(rs.getString("phone"));
					reader.setDept(rs.getString("dept"));
					reader.setRegDate(rs.getDate("regdate"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
			return reader;
		}
	//ͨ����������ģ����ѯ
//	public static List<Reader> selectReaderByName(String name){
//		List<Reader> list =null;
//	
//		String sql="select * from reader where name like ?";
//		CommonDao dao =new CommonDao();
//		String rname ="%"+name+"%";
//		ResultSet rs=dao.query(sql,rname);
//		list =new ArrayList<Reader>();
//		try {
//			while(rs.next()){
//			Reader reader = new Reader();
//			reader.setReaderid(rs.getString("readerid").trim());
//			reader.setType(rs.getInt("type"));
//			reader.setName(rs.getString("name").trim());
//			reader.setAge(rs.getInt("age"));
//			reader.setSex(rs.getString("sex").trim());
//			reader.setPhone(rs.getString("phone").trim());
//			reader.setDept(rs.getString("dept").trim());
//			reader.setRegDate(rs.getDate("regdate"));
//			list.add(reader);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		dao.close();
//		return list;
//	}
	
	public static List<Reader> selectReaderByName(String name) {
		List<Reader> list = new ArrayList<Reader>();
		CommonDao dao = new CommonDao();
		String sql = "select readerid,type,name,age,sex,phone,dept,regdate,typename,maxborrownum,limit  from reader join readertype on reader.type=readertype.id and name like ?";
				
		ResultSet rs = dao.query(sql,"%"+name+"%");
		try {
			while (rs.next()) {
				Reader reader = new Reader();
				reader.setReaderid(rs.getString("readerid"));
				reader.setType(rs.getInt("type"));
				reader.setName(rs.getString("name"));
				reader.setAge(rs.getInt("age"));
				reader.setSex(rs.getString("sex"));
				reader.setPhone(rs.getString("phone"));
				reader.setDept(rs.getString("dept"));
				reader.setRegDate(rs.getDate("regdate"));
				reader.setTypename(rs.getString("typename"));
				reader.setMaxborrownum(rs.getInt("maxborrownum"));
				reader.setLimit(rs.getInt("limit"));
				list.add(reader);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		dao.close();
		return list;
	}
	
	//ͨ����������ģ����ѯ
	public static List<Reader> selectReaderByType(String type) {
		List<Reader> list = new ArrayList<Reader>();
		CommonDao dao = new CommonDao();
		String sql = "select readerid,type,name,age,sex,phone,dept,regdate,typename,maxborrownum,limit from reader join readertype on reader.type=readertype.id and readertype.typename like ?";
		ResultSet rs = dao.query(sql,"%"+type+"%");
		try {
			while (rs.next()) {
				Reader reader = new Reader();
				reader.setReaderid(rs.getString("readerid"));
				reader.setType(rs.getInt("type"));
				reader.setName(rs.getString("name"));
				reader.setAge(rs.getInt("age"));
				reader.setSex(rs.getString("sex"));
				reader.setPhone(rs.getString("phone"));
				reader.setDept(rs.getString("dept"));
				reader.setRegDate(rs.getDate("regdate"));
				reader.setTypename(rs.getString("typename"));
				reader.setMaxborrownum(rs.getInt("maxborrownum"));
				reader.setLimit(rs.getInt("limit"));
				list.add(reader);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		dao.close();
		return list;
	}
	
	//����Ժϵ��ѯ

	public static List<Reader> selectReaderByDept(String dept) {
		List<Reader> list = new ArrayList<Reader>();
		CommonDao dao = new CommonDao();
		String sql = "select readerid,type,name,age,sex,phone,dept,regdate,typename,maxborrownum,limit  from reader join readertype on reader.type=readertype.id and dept like ?";
		
		ResultSet rs = dao.query(sql,"%"+dept+"%");
		try {
			while (rs.next()) {
				Reader reader = new Reader();
				reader.setReaderid(rs.getString("readerid"));
				reader.setType(rs.getInt("type"));
				reader.setName(rs.getString("name"));
				reader.setAge(rs.getInt("age"));
				reader.setSex(rs.getString("sex"));
				reader.setPhone(rs.getString("phone"));
				reader.setDept(rs.getString("dept"));
				reader.setRegDate(rs.getDate("regdate"));
				reader.setTypename(rs.getString("typename"));
				reader.setMaxborrownum(rs.getInt("maxborrownum"));
				reader.setLimit(rs.getInt("limit"));
				list.add(reader);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		dao.close();
		return list;
	}
	//�޸Ķ�����Ϣ
//	public static int updateReader(Reader reader){
//		int result=0;
//		String sql="update reader set readerid=?,type=?,name=?,age=?,sex=?,phone=?,dept=?,regdate=?";
//		CommonDao dao =new CommonDao();
//		result=dao.update(sql, reader.getReaderid(),reader.getType(),reader.getName(),reader.getAge(),reader.getSex(),reader.getPhone(),reader.getDept(),reader.getRegDate());
//		dao.close();
//		return result;
//		
//		
//	}
	
	//�޸Ķ�����Ϣ
	public static int updateReader(Reader reader) {
		int typeid = 0, i = 0;
		CommonDao dao = new CommonDao();
		try {
			String sql1 = "select * from readertype where typename=?";
			ResultSet rs = dao.query(sql1,reader.getTypename());
			try {
				while (rs.next()) {
					typeid = rs.getInt("id");
					reader.setType(typeid);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			String sql = "update reader set type=?,name=?,age=?,sex=?,phone=?,dept=?,regdate=? where readerid=?";
		//	System.out.println(sql);
			//�����ݿ����������Ҫ���ɲ�����Ϣ������Щ��Ϣ����һ��������ʹ��������
			Object[] objs = new Object[8];
			
			objs[0] = reader.getType();
			objs[1] = reader.getName();
			objs[2] = reader.getAge();
			objs[3] = reader.getSex();
			objs[4] = reader.getPhone();
			objs[5] = reader.getDept();
			
			//�Ѷ��ߵ�ע������ת��Ϊ�ַ�������
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String regDateString = sdf.format(reader.getRegDate());
			
			objs[6] = Dao.getDateToString(reader.getRegDate());
			objs[7] = reader.getReaderid();
			
			i = dao.update(sql,objs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		dao.close();
		return i;
	}
	public static void main(String[] args) {
		System.out.println(ReaderDao.selectReaderById("101"));
	}
}


