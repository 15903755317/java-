package pdsu.bbm.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MainWindow extends JFrame implements ActionListener {
	JMenuBar MenuBar;
	JMenu menu, menu2, menu3, menu4, menu5;
	JMenuItem item1, item2, item3, item4, item5, item6, item8_1,item7, item8, item9,
			item0, item00;
	Dimension dimension = new Dimension(800, 500);
	ImageIcon image = new ImageIcon("image/mainbg.jpg");
	Image icon = new ImageIcon("image/icon.png").getImage();
	JLabel label;
	public MainWindow() {
		init();
		setSize(dimension);
		setIconImage(icon);
		setForeground(Color.yellow);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	void init() {
		setTitle("ͼ�����ϵͳ");
		setBackground(new Color(212,232,248));
		label=new JLabel(image);
		
		MenuBar = new JMenuBar();
		MenuBar.setBackground(new Color(212,232,248));
		menu = new JMenu("������Ϣ���� ");
		menu.setFont(new Font("����",Font.PLAIN,16));
		item1 = new JMenuItem("������Ϣ���");
		item1.setFont(new Font("����",Font.PLAIN,16));
		item2 = new JMenuItem("������Ϣ��ѯ���޸�");
		item2.setFont(new Font("����",Font.PLAIN,16));
		item1.addActionListener(this);
		item2.addActionListener(this);
		menu.add(item1);
		menu.add(item2);

		menu2 = new JMenu("ͼ����Ϣ����");
		menu2.setFont(new Font("����",Font.PLAIN,16));
		item3 = new JMenuItem("ͼ�����");
		item4 = new JMenuItem("ͼ���ѯ���޸�");
		item3.setFont(new Font("����",Font.PLAIN,16));
		item3.addActionListener(this);
		item4.setFont(new Font("����",Font.PLAIN,16));
		item4.addActionListener(this);

		menu2.add(item3);
		menu2.add(item4);

		menu3 = new JMenu("ͼ����Ĺ���");
		menu3.setFont(new Font("����",Font.PLAIN,16));
		item5 = new JMenuItem("ͼ�����");
		item6 = new JMenuItem("ͼ��黹");
		item5.setFont(new Font("����",Font.PLAIN,16));
		item6.setFont(new Font("����",Font.PLAIN,16));
		item5.addActionListener(this);
		item6.addActionListener(this);

		menu3.add(item5);
		menu3.add(item6);

		menu4 = new JMenu("������Ϣά��");
		menu4.setFont(new Font("����",Font.PLAIN,16));
		item7 = new JMenuItem("�������͹���");
		item8 = new JMenuItem("ͼ�����͹���");
		item8_1=new JMenuItem("��������");
		item7.setFont(new Font("����",Font.PLAIN,16));
		item8.setFont(new Font("����",Font.PLAIN,16));
		item8_1.setFont(new Font("����",Font.PLAIN,16));
		item7.addActionListener(this);
		item8.addActionListener(this);
		item8_1.addActionListener(this);

		menu4.add(item7);
		menu4.add(item8);
		menu4.add(item8_1);

		menu5 = new JMenu("�û�����");
		menu5.setFont(new Font("����",Font.PLAIN,16));
		item9 = new JMenuItem("����û�");
		item0 = new JMenuItem("�޸�����");
		item00 = new JMenuItem("ɾ���û�");
		item9.setFont(new Font("����",Font.PLAIN,16));
		item0.setFont(new Font("����",Font.PLAIN,16));
		item00.setFont(new Font("����",Font.PLAIN,16));
		item9.addActionListener(this);
		item0.addActionListener(this);
		item00.addActionListener(this);

		menu5.add(item9);
		menu5.add(item0);
		menu5.add(item00);

		MenuBar.add(menu);
		MenuBar.add(menu2);
		MenuBar.add(menu3);
		MenuBar.add(menu4);
		MenuBar.add(menu5);
		add(label);
		setJMenuBar(MenuBar);
	}

	public static void main(String[] args) {
		new MainWindow();
	}


	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == item1) {
			dispose();
			new AddReader();
		}
		if (e.getSource() == item2) {
			dispose();
			new ReaderSelectAndUpdate();
		}
		if (e.getSource() == item3) {
			dispose();
			new AddBook();
		}
		if (e.getSource() == item4) {
			dispose();
			new BookSelectandModify();
		}
		if (e.getSource() == item5) {
			dispose();
			new BorrowBookView();
		}
		if (e.getSource() == item6) {
			dispose();
			new ReturnBookView();
		}
		if (e.getSource() == item7) {
			dispose();
			new ReaderTypeManger();
		}
		if (e.getSource() == item8) {
			dispose();
			new BookTypeManager();
		}
		if(e.getSource()==item8_1){
			dispose();
			new Fine();
		}
		if (e.getSource() == item9) {
			dispose();
			new AddUser();
		}
		if (e.getSource() == item0) {
			dispose();
			new RegistPassword();
		}
		if (e.getSource() == item00) {
			dispose();
			new DeleteUser();
		}
	}
}
