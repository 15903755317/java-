package pdsu.bbm.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.TableModel;

import pdsu.bbm.dao.BookDao;
import pdsu.bbm.dao.BookTypeDao;
import pdsu.bbm.model.Book;
import pdsu.bbm.model.BookType;

public class BookSelectandModify extends JFrame implements ActionListener {
	// �������к�
	private static final long serialVersionUID = 1L;
	private JTabbedPane jtabbedPane; // ��ǩ���
	// selectJP��ѯ��� select_conditionJP�����б���� select_resultJP�����ť���updateJP�޸����
	// updateJP�޸����,bookJP�м���� buttonJP2��ť���
	private JPanel selectJP, select_conditionJP, select_resultJP, buttonJP1,
			bookJP, updateJP, buttonJP2;//
	private JTextField selectJTF, ISBNJTF, booknameJTF, authorJTF,
			printtimeJTF, publishJTF, publishdateJTF, unitpriceJTF;
	private JLabel ISBNJL, booknameJL, authorJL, categoryJL, printtimeJL,
			publishJL, publishdateJL, unitpriceJL;
	// �ص�!
	private JTable jtable;// ������
	private JComboBox choiceJCB, booktypeJCB;
	private JScrollPane jscrollPane;
	private JButton selectJB, exitJB, updateJB, resetJB;// ��ѯ��ť���˳���ť,�޸İ�ť���رհ�ť
	private TableModel getSelect;
	private String[] title = { "ISBN", "ͼ������", "ͼ������", "����", "     ������      ",
			"��������", "ӡˢ����", "����" };
	Image icon = new ImageIcon("image/icon.png").getImage();

	public BookSelectandModify() {
		super();
		setIconImage(icon);
		setTitle("ͼ���ѯ���޸�");
		setBounds(100, 100, 555, 400);
		setLocationRelativeTo(null);
		// JTabbedPaneѡ�
		jtabbedPane = new JTabbedPane();
		add(jtabbedPane);
		selectJP = new JPanel();
		selectJP.setLayout(new BorderLayout());
		jtabbedPane.add("ͼ����Ϣ��ѯ", selectJP);

		// ��ѯ�������
		select_conditionJP = new JPanel();
		choiceJCB = new JComboBox();
		String array[] = { "ISBN", "ͼ������", "ͼ������", "����", "������","����" };// ����Ϊһά����
		for (int i = 0; i < array.length; i++) {
			choiceJCB.addItem(array[i]);
		}
		select_conditionJP.add(choiceJCB);
		selectJTF = new JTextField(20);
		select_conditionJP.add(selectJTF);
		selectJP.add(select_conditionJP, BorderLayout.NORTH);
		// ��ѯ������
		select_resultJP = new JPanel();
		BookDao dao = new BookDao();
		List<Book> list = dao.selectBook();
		jtable = new JTable(getSelect(list), title);

		// !���ñ���С����
		jtable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		// !�����п�
		jtable.getColumnModel().getColumn(4).setPreferredWidth(175);
		jscrollPane = new JScrollPane(jtable);// �ѱ�����������
		// ��ʾ�������߿�
		jscrollPane.setPreferredSize(new Dimension(450, 170));
		select_resultJP.add(jscrollPane);
		selectJP.add(select_resultJP, BorderLayout.CENTER);
		// ��ѯ��ť���
		buttonJP1 = new JPanel();
		selectJB = new JButton("��ѯ");
		selectJB.setFont(new Font("����", Font.PLAIN, 20));

		selectJB.addActionListener(this);
		buttonJP1.add(selectJB);
		exitJB = new JButton("�˳�");
		exitJB.setFont(new Font("����", Font.PLAIN, 20));
		exitJB.addActionListener(this);
		buttonJP1.add(exitJB);
		selectJP.add(buttonJP1, BorderLayout.SOUTH);
		// ��Ϣ�޸�ҳ��
		updateJP = new JPanel();
		updateJP.setLayout(new BorderLayout());
		jtabbedPane.addTab("ͼ����Ϣ�޸�", updateJP);
		bookJP = new JPanel();
		final GridLayout gridLayout = new GridLayout(8, 2);
		// ���ñ߿��ľ���
		gridLayout.setVgap(8);
		gridLayout.setHgap(8);
		bookJP.setLayout(gridLayout);
		ISBNJL = new JLabel("ISBN:");
		ISBNJL.setFont(new Font("����",Font.PLAIN,20));
		ISBNJL.setHorizontalAlignment(SwingConstants.CENTER);
		bookJP.add(ISBNJL);
		ISBNJTF = new JTextField(20);
		ISBNJTF.addActionListener(this);
		bookJP.add(ISBNJTF);
		categoryJL = new JLabel("��  ��:");
		categoryJL.setFont(new Font("����",Font.PLAIN,20));
		categoryJL.setHorizontalAlignment(SwingConstants.CENTER);
		bookJP.add(categoryJL);
		// �����б�
		List<BookType> list1 = BookTypeDao.selectBookType();
		Iterator<BookType> it = list1.iterator();
		String ty[] = new String[list1.size()];
		int i = 0;
		booktypeJCB = new JComboBox();
		while (it.hasNext()) {
			ty[i] = it.next().getTypename();
			booktypeJCB.addItem(ty[i]);
			i++;
		}

		bookJP.add(booktypeJCB);

		booknameJL = new JLabel("��  ��:");
		booknameJL.setFont(new Font("����",Font.PLAIN,20));
		booknameJL.setHorizontalAlignment(SwingConstants.CENTER);
		bookJP.add(booknameJL);
		booknameJTF = new JTextField();
		booknameJTF.setColumns(20);
		bookJP.add(booknameJTF);

		authorJL = new JLabel("��  ��:");
		authorJL.setFont(new Font("����",Font.PLAIN,20));
		authorJL.setHorizontalAlignment(SwingConstants.CENTER);
		bookJP.add(authorJL);
		authorJTF = new JTextField();
		authorJTF.setColumns(20);
		bookJP.add(authorJTF);

		publishJL = new JLabel("������:");
		publishJL.setFont(new Font("����",Font.PLAIN,20));
		publishJL.setHorizontalAlignment(SwingConstants.CENTER);
		bookJP.add(publishJL);
		publishJTF = new JTextField();
		bookJP.add(publishJTF);

		publishdateJL = new JLabel("��������:");
		publishdateJL.setFont(new Font("����",Font.PLAIN,20));
		publishdateJL.setHorizontalAlignment(SwingConstants.CENTER);
		bookJP.add(publishdateJL);
		publishdateJTF = new JTextField();
		publishdateJTF.setHorizontalAlignment(SwingConstants.LEFT);
		bookJP.add(publishdateJTF);

		printtimeJL = new JLabel("ӡˢ����:");
		printtimeJL.setFont(new Font("����",Font.PLAIN,20));
		printtimeJL.setHorizontalAlignment(SwingConstants.CENTER);
		bookJP.add(printtimeJL);
		printtimeJTF = new JTextField();
		bookJP.add(printtimeJTF);

		unitpriceJL = new JLabel("��  ��:");
		unitpriceJL.setFont(new Font("����",Font.PLAIN,20));
		unitpriceJL.setHorizontalAlignment(SwingConstants.CENTER);
		bookJP.add(unitpriceJL);
		unitpriceJTF = new JTextField();
		bookJP.add(unitpriceJTF);
		// ��ť���
		// ��ť������
		buttonJP2 = new JPanel();
		updateJB = new JButton("�޸�");
		updateJB.setFont(new Font("����", Font.PLAIN, 20));

		updateJB.addActionListener(this);
		resetJB = new JButton("�ر�");
		resetJB.setFont(new Font("����", Font.PLAIN, 20));

		resetJB.addActionListener(this);
		buttonJP2.add(updateJB);
		buttonJP2.add(resetJB);
		updateJP.add(bookJP, BorderLayout.CENTER);
		updateJP.add(buttonJP2, BorderLayout.SOUTH);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	// ����ѯ���������
	private Object[][] getSelect(List<Book> list) {
		// TODO Auto-generated method stub
		Object[][] objects = new Object[list.size()][title.length];
		for (int i = 0; i < list.size(); i++) {
			Book book = list.get(i);
			objects[i][0] = book.getISBN();
			objects[i][1] = book.getTypeid();// ͼ������
			objects[i][2] = book.getBookname();// ͼ������
			objects[i][3] = book.getAuthor();// ͼ������
			objects[i][4] = book.getPublish();// ������
			objects[i][5] = book.getPublishdate();// ��������
			objects[i][6] = book.getPublishtime();// ӡˢ����
			objects[i][7] = book.getUnitprice();// ����
		}

		return objects;

	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==ISBNJTF){
			String isbn=ISBNJTF.getText();
			String typename=null;
			String id=BookDao.selectBookByISBN(isbn).getTypeid();
			
			typename=BookTypeDao.selectById(id);
			System.out.println(typename);
			booktypeJCB.setSelectedItem(typename);
			booknameJTF.setText(BookDao.selectBookByISBN(isbn).getBookname());
			authorJTF.setText(BookDao.selectBookByISBN(isbn).getAuthor());
			publishJTF.setText(BookDao.selectBookByISBN(isbn).getPublish());
			publishdateJTF.setText(BookDao.selectBookByISBN(isbn).getPublishdate()+"");
			printtimeJTF.setText(BookDao.selectBookByISBN(isbn).getPublishtime()+"");
			unitpriceJTF.setText(BookDao.selectBookByISBN(isbn).getUnitprice()+"");
			
		}
		if (e.getSource() == selectJB) {// ����ISBN�������
			int r = choiceJCB.getSelectedIndex();
			if (r == 0) {
				String name = selectJTF.getText().trim();
				// ǿ��ת��Ϊ���Ա�����
				List<Book> list = new ArrayList<Book>();
				Book book = BookDao.selectBookByISBN(name);
				if (book == null) {
					JOptionPane.showMessageDialog(this, "�ñ��벻����!");
				} else {
					list.add(book);
					Object[][] data = getSelect(list);
					jtable = new JTable(data, title);
					jtable.getColumnModel().getColumn(4).setPreferredWidth(175);
					jtable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

					jscrollPane.setViewportView(jtable);

				}
			}

			if (r == 1) {// ����ͼ�����Ʋ�ѯ��Ϣ
				String name = selectJTF.getText().toString();
				List<Book> list = BookDao.selectBookByName(name);
				// �ж����Ա��Ƿ�Ϊ��
				if (list == null || list.size() == 0) {
					JOptionPane.showMessageDialog(this, "��ͼ�鲻����!");
				} else {
					Object[][] data = getSelect(list);
					jtable = new JTable(data, title);
					tianjia();
				}
			}
			if (r == 2) {// ����ͼ�����в�ѯ��Ϣ
				String name = selectJTF.getText().toString();
				List<Book> list = BookDao.selectBookByType(name);
				// �ж����Ա��Ƿ�Ϊ��
				if (list == null || list.size() == 0) {
					JOptionPane.showMessageDialog(this, "��ͼ�鲻����!");
				} else {
					Object[][] data = getSelect(list);
					jtable = new JTable(data, title);
					tianjia();
				}
			}
			if (r == 3) { // �������߽��в���
				String name = selectJTF.getText().toString();
				// �������߽��в���
				List<Book> list = BookDao.selectBookByAuthor(name);
				// �ж����Ա��Ƿ�Ϊ��
				if (list == null || list.size() == 0) {
					JOptionPane.showMessageDialog(this, "��ͼ�鲻����!");
				} else {
					Object[][] data = getSelect(list);
					jtable = new JTable(data, title);
					tianjia();
				}
			}
			if (r == 4) {// ���ݳ�������в���
				String name = selectJTF.getText().toString();
				List<Book> list = BookDao.selectBookByPublish(name);
				if (list == null || list.size() == 0) {
					JOptionPane.showMessageDialog(this, "��ͼ�鲻����!");
				} else {
					Object[][] data = getSelect(list);
					jtable = new JTable(data, title);
					tianjia();

				}
			}
			if(r==5){
				List<Book> list =BookDao.selectBook();
			}
		}
		if (e.getSource() == updateJB) {
			String ISBN = ISBNJTF.getText().trim();
			String typename = ((String) booktypeJCB.getSelectedItem()).trim();
			String id = BookTypeDao.selectByTypename(typename);
			String bookname = booknameJTF.getText();
			String author = authorJTF.getText();
			String publish = publishJTF.getText();
			String publishdate = publishdateJTF.getText();

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date regDate = null;
			try {
				regDate = sdf.parse(publishdate);
			} catch (Exception e2) {
				e2.printStackTrace();
				JOptionPane.showMessageDialog(this, "��������ȷ�����ڸ�ʽ!");
			}
			if (regDate == null)
				return;
			int publishtime = Integer.parseInt(printtimeJTF.getText());
			int unitprice = Integer.parseInt(unitpriceJTF.getText());
			// ��װ����
			Book book = new Book();
			book.setISBN(ISBN);
			book.setTypeid(id);
			book.setBookname(bookname);
			book.setAuthor(author);
			book.setPublish(publish);
			book.setPublishdate(regDate);
			book.setPublishtime(publishtime);
			book.setUnitprice(unitprice);
			book.setTypename(typename);
			int result = BookDao.update(book);
			List<Book> list2 = new ArrayList<Book>();
			list2.add(book);

			// System.out.println(list2);

			if (result == 1) {
				JOptionPane.showMessageDialog(this, "�޸ĳɹ�!");
				BookDao bk=new BookDao();
				List<Book> list =bk.selectBook();
				jtable =new JTable(getSelect(list),title);
				tianjia();
				
			} else {
				JOptionPane.showMessageDialog(this, "�޸�ʧ��!");
			}
		}
		if (e.getSource() == resetJB) {
			dispose();
			new MainWindow();
		}
		if (e.getSource() == exitJB) {
			dispose();
			new MainWindow();
		}
	}

	private void tianjia() {
		jtable.getColumnModel().getColumn(4).setPreferredWidth(175);
		jtable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		jscrollPane.setViewportView(jtable);

	}

	public static void main(String[] args) {
		new BookSelectandModify();

	}
}
