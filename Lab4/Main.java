
import javax.swing.*;
import java.awt.*;

public class Main {

	public static void main(String[] args)
	{
		Form1 form1 = new Form1();
		form1.setSize(200, 200);
		form1.setTitle("Простая программа");
		form1.setVisible(true);
		form1.setLocation(0, 200);
		
		Form2 form2 = new Form2();
		form2.setSize(300, 150);
		form2.setTitle("Простая программа");
		form2.setVisible(true);
		form2.setLocation(250, 200);
		
		Form3 form3 = new Form3();
		form3.setSize(300, 150);
		form3.setTitle("Простая программа");
		form3.setVisible(true);
		form3.setLocation(600, 200);
		
		Form4 form4 = new Form4();
		form4.setSize(300, 75);
		form4.setTitle("Простая программа");
		form4.setVisible(true);
		form4.setLocation(950, 200);
	}
}

@SuppressWarnings("serial")
public class Form1 extends JFrame
{
	private JTextField tf1;
	private JTextField tf2;
	private JButton button;
	
	public Form1()
	{
		Container container = getContentPane();
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
		
		tf1 = new JTextField("Привет");
		tf1.setPreferredSize(new Dimension(200, 65));
		tf1.setAlignmentX(Component.LEFT_ALIGNMENT);
		container.add(tf1);
		container.add(Box.createVerticalStrut(2));
		
		tf2 = new JTextField("Мир!");
		tf2.setPreferredSize(new Dimension(200, 65));
		tf2.setAlignmentX(Component.LEFT_ALIGNMENT);
		container.add(tf2);
		container.add(Box.createVerticalStrut(2));
		
		button = new JButton("Нажмите");
		button.setMaximumSize(new Dimension(10000, 10000));
		button.setPreferredSize(new Dimension(200, 65));
		button.setAlignmentX(Component.LEFT_ALIGNMENT);
		container.add(button);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}

@SuppressWarnings("serial")
public class Form2 extends JFrame
{
	private JLabel label;
	private JTextField textField;
	private JButton button;
	private JCheckBox checkBox;
	
	public Form2()
	{
		Container container = getContentPane();
		container.setLayout(new GridLayout(2, 2, 5, 5));
		
		label = new JLabel("Введите имя:");
		container.add(label);
		
		textField = new JTextField("Джон Сноу");
		container.add(textField);
		
		button = new JButton("Все готово");
		container.add(button);
		
		checkBox = new JCheckBox("Согласны?");
		container.add(checkBox);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}

@SuppressWarnings("serial")
public class Form3 extends JFrame
{
	private JLabel label;
	private JTextArea text;
	private JButton button;
	
	public Form3()
	{
		Container container = getContentPane();
		container.setLayout(new GridLayout(2, 2, 5, 5));
		
		label = new JLabel("Введите число:");
		container.add(label);
		
		text = new JTextArea();
		text.setBackground(Color.RED);
		container.add(text);
		
		button = new JButton("Скрыть поле");
		button.addActionListener(new ButtonListiner());
		container.add(button);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	class ButtonListiner implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if (text.isVisible())
			{
				text.setVisible(false);
				button.setText("Показать поле");
			}
			else
			{
				text.setVisible(true);
				button.setText("Скрыть поле");
			}
		}
	}
}

@SuppressWarnings("serial")
public class Form4 extends JFrame
{
	private JTextArea text;
	private JButton button;
	
	public Form4()
	{
		Container container = getContentPane();
		container.setLayout(new GridLayout(1, 2, 5, 5));
		
		text = new JTextArea();
		container.add(text);
		
		button = new JButton("Отобразить");
		button.addActionListener(new ButtonListiner());
		container.add(button);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	class ButtonListiner implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String textStr = text.getText();
			if (!textStr.equals(""))
			{
				JOptionPane.showMessageDialog(
						new JFrame(),
						textStr,
						"Информация",
						JOptionPane.DEFAULT_OPTION
						);
			}
		}
	}
}