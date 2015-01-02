package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;

import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import model.TipCalcModel;

import java.awt.*;


import controller.TipTailorController;
import controller.Main;


public class TipTailorView extends JPanel implements FactoryView{
//JPanel panel;
JButton btnDone;
JLabel lblNewLabel_5;
JLabel labels[];
private static TipTailorView tipCalculatorSecondScreen;

	
	public static TipTailorView getInstance()
	{
		if (tipCalculatorSecondScreen == null)  
		{
			tipCalculatorSecondScreen=new TipTailorView();
		}
		return tipCalculatorSecondScreen;
	}
	
	
	public TipTailorView() {
	
		labels=new JLabel[Integer.parseInt(TipCalcView.getInstance().noOfGuest.getText())];
		JSlider sliders[]=new JSlider[Integer.parseInt(TipCalcView.getInstance().noOfGuest.getText())];
		JTextField textfields[]=new JTextField[Integer.parseInt(TipCalcView.getInstance().noOfGuest.getText())];
		
		setLayout(null);
		setBackground(Color.gray);
		setBounds(22, 11, 625, 431);
		setLayout(null);
		
		
		btnDone = new JButton("Done");
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Main.getInstance().afterTipTailoring();
				
				for (int j=0;j<Integer.parseInt(TipCalcView.getInstance().noOfGuest.getText());j++)
				{
					
					TipTailorController.getInstance().setvalues(Float.valueOf(labels[j].getText()).floatValue());
					
				}
				TipCalcModel.getInstance().CalculateTip("TailorTip");
				
			}
		});
		
		add(btnDone);
		
		int xslider=168;
		int yslider=37;
		int widthslider=200;
		int heightslider=23;
		
		int xdollar=406;
		int ydollar=37;
		int widthdollar=18;
		int heightdollar=14;
		
		int xlabel=434;
		int ylabel=37;
		int widthlabel=46;
		int heigthlabel=14;
		
		int xname=10;
		int yname=40;
		int widthname=123;
		int heightname=20;
		
		if (!(TipCalcView.getInstance().noOfGuest.getText().equals("")))
		{
		
			for (int number=0;number<Integer.parseInt(TipCalcView.getInstance().noOfGuest.getText());number++)
		{
			
				
		sliders[number]=new JSlider();		
		sliders[number].setBounds(xslider, yslider, widthslider, heightslider);
		add(sliders[number]);
		yslider=yslider+40;
		
		
		sliders[number].setMaximum(100);
		sliders[number].setMinimum(0);
		int percentage=(int)(((Float.valueOf(TipCalcView.getInstance().perPersonTip.getText()).floatValue())/(Float.valueOf(TipCalcView.getInstance().totalTip.getText()).floatValue()))*100);
		sliders[number].setValue(percentage);
		
		final int no=number;
		sliders[number].addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				int perPersonTipPercentage=((JSlider) e.getSource()).getValue();
				float perPersonNewTip=(((float)perPersonTipPercentage)/100)*(Float.valueOf(TipCalcView.getInstance().totalTip.getText()).floatValue());
		
				DecimalFormat decimalFormat=new DecimalFormat("#.##");
				TipTailorView.getInstance().labels[no].setText(String.valueOf(decimalFormat.format(perPersonNewTip)));
				TipCalcView.getInstance().perPersonTip.setText("Not Applicable");
				TipCalcView.getInstance().perPersonTip.setEditable(false);
				
				
			}
		});
		
		JLabel label_number = new JLabel("$");
		label_number.setBounds(xdollar, ydollar, widthdollar, heightdollar);
		add(label_number);
		ydollar=ydollar+40;
		
		
		labels[number]=new JLabel();
	    labels[number].setBounds(xlabel, ylabel, widthlabel, heigthlabel);
	    add(labels[number]);
		labels[number].setText(TipCalcView.getInstance().perPersonTip.getText());
		
		ylabel=ylabel+40;
		
		
		textfields[number]=new JTextField();
		textfields[number].setBounds(xname, yname, widthname, heightname);
		add(textfields[number]);
		textfields[number].setColumns(10);
		yname=yname+40;
		
		}
	
		}
		
		btnDone.setBounds(10, yslider+20, 89, 23);
	}
		
	@Override
	public Dimension getPreferredSize() {
		int maxX = 0;
		int maxY = 0;
		Component[] components = this.getComponents();
		for (int i = 0; i < components.length; i++) {
			Rectangle bounds = components[i].getBounds();
			maxX = Math.max(maxX, (int) bounds.getMaxX());
			maxY = Math.max(maxY, (int) bounds.getMaxY());
		}
		return new Dimension(maxX, maxY);
	}


	@Override
	public void modifyView(TipCalcModel tipCalcModel) {
			// TODO Auto-generated method stub
			DecimalFormat dFormat=new DecimalFormat("#.##");
			TipCalcView.getInstance().totalTip.setText(String.valueOf(dFormat.format(tipCalcModel.getTotalTip())));
			TipCalcView.getInstance().totalBill.setText(String.valueOf(dFormat.format(tipCalcModel.getTotalBill())));
			
		
		
	}
	
}
