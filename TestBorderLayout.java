package pers.test2;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class TestBorderLayout {
	
	//构造方法
	TestBorderLayout(){
		initComponents();
	}
	//内部组件
	public void initComponents() {
		
		//JFrame
		JFrame frm=new JFrame("My Test GUI");
		frm.setLayout(new BorderLayout());
		
		//中部显示区域
		JTextArea ta=new JTextArea();
		ta.setLineWrap(true);
		ta.setEditable(false);
		
		JScrollPane sp=new JScrollPane(ta);
		
		frm.add(sp,"Center");
		
		//下部提示区域
		JLabel jl=new JLabel("请输入运算数和运算符，并按\"计算\"按钮！",JLabel.CENTER);
				
		frm.add(jl,"South");
		
		//上部输入区域
		JPanel jp=new JPanel();
		jp.setLayout(new FlowLayout());
		jp.setSize(800, 100);
		
		JTextField[] t={
				new JTextField(5),
				new JTextField(1),
				new JTextField(5)
		};
		for(int i=0;i<3;i++){
			jp.add(t[i]);
		}
		
		JButton jb=new JButton("计算");
	   //按下按钮
		jb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double n1=Double.parseDouble(t[0].getText());
				double n2=Double.parseDouble(t[2].getText());
				double n3 = 0;
				
				
				//计算条件
				if(t[1].getText().equals("+"))
				{	n3=n1+n2;
                //输出数据
				String results=String.valueOf(n3);
				ta.setText((String)t[0].getText()+(String)t[1].getText()+(String)t[2].getText()+"="+results);}
				else if(t[1].getText().equals("-"))
				{	n3=n1-n2;				
				String results=String.valueOf(n3);
				ta.setText((String)t[0].getText()+(String)t[1].getText()+(String)t[2].getText()+"="+results);
				}
				else if(t[1].getText().equals("*"))
				{	n3=n1*n2;
				String results=String.valueOf(n3);
				ta.setText((String)t[0].getText()+(String)t[1].getText()+(String)t[2].getText()+"="+results);
				}
				else if(t[1].getText().equals("/"))
				{	n3=n1/n2;			
				String results=String.valueOf(n3);
				ta.setText((String)t[0].getText()+(String)t[1].getText()+(String)t[2].getText()+"="+results);
				}
				else  {
					jl.setText("输入错误，请重新输入!");
					ta.setText("");
				}
				
				//清空
				for(int i=0;i<3;i++){
					t[i].setText("");
				}
				
				//JLabel 提示更新
				jl.setText("请在显示区域查看运算结果，或者重新输入并计算");
				
				
			}
		});
		
		jp.add(jb);
		frm.add("North",jp);
		
		//frame设置
		frm.setSize(800, 500);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frm.setVisible(true);
	}
	
	//主函数
	public static void main(String args[]){
		TestBorderLayout tbl=new TestBorderLayout();
	}
	
	
}
	

