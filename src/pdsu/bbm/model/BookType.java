package pdsu.bbm.model;

public class BookType {
	private int id; // ͼ�����ͱ��
	private String typename;// ͼ����������
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTypename() {
		return typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

	@Override
	public String toString() {
		return "BookType [id=" + id + ", typename=" + typename + "]";
	}



	
}
