package controller;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import view.TipCalcView;
import view.TipConfigView;
import view.TipTailorView;

@SuppressWarnings("serial")
public class Main extends JFrame {
	float totalBillAmount=0;
	static JScrollPane jScrollPane;
	private static Main frame; 

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Main();
					frame.setVisible(true);
					frame.setTitle("TIP CALCULATOR");
				
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public static Main getInstance()
	{
		if (frame == null)
		{
			frame=new Main();
		}
		return frame;
	}
	
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(80, 80, 673, 528);
		TipCalcView.getInstance().setBorder(new EmptyBorder(1, 1, 1, 1));
		setContentPane(TipCalcView.getInstance());
		TipCalcView.getInstance().setLayout(null);
	}
	
	
	public  void setTipTailoringView() {
		frame.remove(TipCalcView.getInstance());
		jScrollPane=new JScrollPane();
		jScrollPane.setViewportView(TipTailorView.getInstance());
		frame.setContentPane(jScrollPane);
		frame.setVisible(true);
		frame.validate();
		//frame.repaint();
		
	}
	public void afterTipTailoring(){
		frame.remove(TipTailorView.getInstance());
		frame.setContentPane(TipCalcView.getInstance());
		frame.validate();
	}
	public  void setTipConfigurationView() {
		frame.remove(TipCalcView.getInstance());
		frame.setContentPane(TipConfigView.getInstance());
		frame.validate();
	
	}
	public  void afterTipConfiguration() {
			frame.remove(TipConfigView.getInstance());
			frame.setContentPane(TipCalcView.getInstance());
			frame.validate();
			
		}
public void displayErrorMessage(String errorMsg)
	{
		JOptionPane.showMessageDialog(frame,errorMsg,"error",JOptionPane.ERROR_MESSAGE);	
	}
	
	public void displayWarningMessage(String warningMsg)
	{
		JOptionPane.showMessageDialog(frame,warningMsg,"warning",JOptionPane.WARNING_MESSAGE);	
	}
	
}
