import java.awt.Color;
import java.awt.Container;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class MainFrame extends JFrame implements ActionListener, ItemListener
{
	MainPanel panel;
	Sound sound;
	
	JLabel label;
	JButton button_renew;
	JButton button_last;
	JButton button_next;
	JButton button_choose;
	JButton button_first;
	JButton button_over;
	JButton button_music;
	JButton button_back;
	JComboBox comBoBox = new JComboBox();
	MenuItem renew = new MenuItem("    ���¿�ʼ");
	MenuItem back = new MenuItem("    ��һ��");
	MenuItem last = new MenuItem("    ��һ��");
	MenuItem next = new MenuItem("    ��һ��");
	MenuItem choose = new MenuItem("    ѡ��");
	MenuItem exit = new MenuItem("    �˳�");
	MenuItem qin = new MenuItem("    ��������");
	MenuItem po = new MenuItem("    ������");
	MenuItem guang = new MenuItem("    ��������");
	MenuItem nor = new MenuItem("    Ĭ��");
	MenuItem eye = new MenuItem("    eyes on me");
	MenuItem about = new MenuItem("    ����������...");
	
	
	public MainFrame()
	{
		super();//��ʼ��frame
		setSize(720, 720);
		setVisible(true);
		setResizable(false);
		setLocation(300, 20);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container container = getContentPane();//��ʼ����������������ӿؼ��õ�
		container.setLayout(null);
		container.setBackground(Color.black);
		
		Menu choice = new Menu("    ѡ��");
		choice.add(renew);
		choice.add(last);
		choice.add(next);
		choice.add(choose);
		choice.add(back);
		choice.addSeparator();
		choice.add(exit);
		renew.addActionListener(this);
		last.addActionListener(this);
		next.addActionListener(this);
		choose.addActionListener(this);
		exit.addActionListener(this);
		back.addActionListener(this);
		
		Menu setMusic = new Menu("    ��������");
		setMusic.add(nor);
		setMusic.add(qin);
		setMusic.add(po);
		setMusic.add(guang);
		setMusic.add(eye);
		nor.addActionListener(this);
		qin.addActionListener(this);
		po.addActionListener(this);
		guang.addActionListener(this);
		eye.addActionListener(this);
		
		Menu help = new Menu("    ����");
		help.add(about);
		about.addActionListener(this);
		
		MenuBar bar = new MenuBar();
		bar.add(choice);
		bar.add(setMusic);
		bar.add(help);
		setMenuBar(bar);                                        

		nor.setEnabled(false);

		label = new JLabel("��������",SwingConstants.CENTER);
		add(label);
		label.setBounds(625,500,55,20);
		label.setForeground(Color.white);
		button_renew = new JButton("����");
		button_back = new JButton("��һ��");
		button_last = new JButton("��һ��");
		button_next = new JButton("��һ��");
		button_choose = new JButton("ѡ��");
		button_first = new JButton("�ڣ���");
		button_over = new JButton("���չ�");
		button_music = new JButton("���ֹ�");
		add(button_renew);
		add(button_last);
		add(button_next);
		add(button_choose);
		add(button_first);
		add(button_over);
		add(button_music);
		add(button_back);
		button_renew.setBounds(625, 100, 80, 30);
		button_renew.addActionListener(this);
		button_back.setBounds(625, 150, 80, 30);
		button_back.addActionListener(this);
		button_first.setBounds(625, 200, 80, 30);
		button_first.addActionListener(this);
		button_last.setBounds(625, 250, 80, 30);
		button_last.addActionListener(this);
		button_next.setBounds(625, 300, 80, 30);
		button_next.addActionListener(this);
		button_over.setBounds(625, 350, 80, 30);
		button_over.addActionListener(this);
		button_choose.setBounds(625, 400, 80, 30);
		button_choose.addActionListener(this);
		button_music.setBounds(625, 450, 80, 30);
		button_music.addActionListener(this);
		comBoBox.setBounds(625, 530, 80, 20);
		comBoBox.addItem("Ĭ��");
		comBoBox.addItem("��������");
		comBoBox.addItem("������");
		comBoBox.addItem("��������");
		comBoBox.addItem("eyes on me");
		comBoBox.addItemListener(this);
		
		container.add(comBoBox);
		sound = new Sound();
		sound.loadSound();
		panel = new MainPanel();
		add(panel);
		panel.Tuixiangzi(panel.level);
		panel.requestFocus();
		validate();
	}
	


	@Override
	public void itemStateChanged(ItemEvent arg0)
	{
		// TODO Auto-generated method stub
		int no=comBoBox.getSelectedIndex();
		switch(no)
		{
			case 0:sound.setMusic("nor.mid");
					 if(sound.isplay())
					 sound.mystop();
					 sound.loadSound();
					 button_music.setLabel("���ֹ�");
					 nor.setEnabled(false);
					 qin.setEnabled(true);
					 guang.setEnabled(true);
					 eye.setEnabled(true);
					 po.setEnabled(true);panel.requestFocus();break;
			case 1:sound.setMusic("qin.mid");
					 if(sound.isplay())
					 sound.mystop();
					 sound.loadSound();
					 button_music.setLabel("���ֹ�");
					 nor.setEnabled(true);
					 qin.setEnabled(false);
					 guang.setEnabled(true);
					 eye.setEnabled(true);
					 po.setEnabled(true);panel.requestFocus();break;
			case 2:sound.setMusic("popo.mid");
					if(sound.isplay())
					sound.mystop();
					sound.loadSound();
					button_music.setLabel("���ֹ�");
					nor.setEnabled(true);
					qin.setEnabled(true);
					guang.setEnabled(true);
					eye.setEnabled(true);
					po.setEnabled(false);panel.requestFocus();break;
			case 3:sound.setMusic("guang.mid");
					if(sound.isplay())
					sound.mystop();
					sound.loadSound();
					button_music.setLabel("���ֹ�");
					nor.setEnabled(true);
					qin.setEnabled(true);
					guang.setEnabled(false);
					eye.setEnabled(true);
					po.setEnabled(true);panel.requestFocus();break;
			case 4:sound.setMusic("eyes on me.mid");
					if(sound.isplay())
					sound.mystop();
					sound.loadSound();
					button_music.setLabel("���ֹ�");
					nor.setEnabled(true);
					qin.setEnabled(true);
					guang.setEnabled(true);
					eye.setEnabled(false);
					po.setEnabled(true);panel.requestFocus();break;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		// TODO Auto-generated method stub
		if(e.getSource()==button_renew||e.getSource()==renew)
		{
			panel.Tuixiangzi(panel.level);
			panel.requestFocus();
			panel.remove();
		}
		else if(e.getSource()==button_last||e.getSource()==last)
		{
			panel.level--;
			if(panel.level<1)
			{panel.level++;JOptionPane.showMessageDialog(this,"�����ǵ�һ��");panel.requestFocus();}
			else 
			{
				panel.Tuixiangzi(panel.level);
				panel.requestFocus();
			}
			panel.remove();
		}
		else if(e.getSource()==button_next||e.getSource()==next)
		{
			panel.level++;
			if(panel.level>panel.maxlevel())
			{panel.level--;JOptionPane.showMessageDialog(this,"�����������һ��");panel.requestFocus();}
			else 
			{
				panel.Tuixiangzi(panel.level);
				panel.requestFocus();
			}
			panel.remove();
		}
		else if(e.getSource()==exit)System.exit(0);
		else if(e.getSource()==about)
		{
			JOptionPane.showMessageDialog(this, "JAVA������v2.0��\n�����ߣ�ʩ��\nEmail:   shichaoling1@126.com\nQQ:   450400704");
		}
		else if(e.getSource()==button_choose||e.getSource()==choose)
		{
			String lel=JOptionPane.showInputDialog(this,"��������Ҫת���Ĺؿ��ţ�(1~50)");
			panel.level=Integer.parseInt(lel);
			panel.remove();
			if(panel.level>panel.maxlevel()||panel.level<1)
			{JOptionPane.showMessageDialog(this, "û����һ�أ�����");panel.requestFocus();}
			else
				{
				panel.Tuixiangzi(panel.level);
				panel.requestFocus();
				}
		}
		
		else if(e.getSource()==button_first)
		{
			panel.level=1;
			panel.Tuixiangzi(panel.level);
			panel.requestFocus();
			panel.remove();
		}
		else if(e.getSource()==button_over)
		{
			panel.level=panel.maxlevel();
			panel.Tuixiangzi(panel.level);
			panel.requestFocus();
			panel.remove();
		}
		else if(e.getSource()==button_music)
		{
			if(sound.isplay())
			{
				sound.mystop();button_music.setLabel("���ֿ�");
			}
			else 
			{
				sound.loadSound();button_music.setLabel("���ֹ�");
			}
			panel.requestFocus();
		}
		else if(e.getSource()==button_back||e.getSource()==back)
		{
			if(panel.isMystackEmpty())JOptionPane.showMessageDialog(this, "����δ�ƶ�������");
			else
			{
				switch(panel.back())
				{
					case 10:panel.backup(10);break;
					case 11:panel.backup(11);break;
					case 20:panel.backdown(20);break;
					case 21:panel.backdown(21);break;
					case 30:panel.backleft(30);break;
					case 31:panel.backleft(31);break;
					case 40:panel.backright(40);break;
					case 41:panel.backright(41);break;
				}
			}
			panel.requestFocus();
		}
		else if(e.getSource()==nor)
		{
			comBoBox.setSelectedIndex(0);
		}
		
		else if(e.getSource()==qin)
		{
			comBoBox.setSelectedIndex(1);
		}
		else if(e.getSource()==guang)
		{
			
			comBoBox.setSelectedIndex(3);
			
		}
		else if(e.getSource()==eye)
		{
			comBoBox.setSelectedIndex(4);
		}
		else if(e.getSource()==po)
		{
			comBoBox.setSelectedIndex(2);
		}
	}
}
