package view;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSlider;
import javax.swing.JButton;


import controller.Main;



import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.DecimalFormat;

import model.TipCalcModel;



import controller.TipCalcController;
import controller.Main;




@SuppressWarnings("serial")
public class TipCalcView extends JPanel implements FactoryView {

	public JTextField noOfGuest;
	public JTextField billTotal;
	public JTextField billDeduction;
	public JTextField tax;
	public JTextField totalTip;
	public JLabel tipRate;
	public JTextField perPersonTip;
	public JTextField totalBill;
	public JPanel panel;
	public JButton btnTipTailoring;
	public JButton btnConfigureTip;
	public JButton btnCalculateTip;
	public JSlider slider_1;
	public JLabel lblPptNa;
	public TipConfigView configView=new TipConfigView();
	public static TipCalcView homeScreen;

	
	public static TipCalcView getInstance()
	{
		if (homeScreen == null)
		{
			homeScreen=new TipCalcView();
		}
		return homeScreen;
	}
	
	
	public TipCalcView() {
		
		panel = new JPanel();
		panel.setBounds(22, 11, 625, 463);
		panel.setBackground(Color.gray);
		add(panel);
		panel.setLayout(null);
		
		JLabel noOfGuests = new JLabel("Number Of Guests");
		noOfGuests.setBounds(10, 25, 160, 34);
		panel.add(noOfGuests);
		
		noOfGuest = new JTextField();
		noOfGuest.setBounds(319, 32, 86, 20);
		panel.add(noOfGuest);
		noOfGuest.setText("1");
		noOfGuest.setColumns(10);
				
		JLabel qualityOfServiceLabel = new JLabel("Quality Of Service");
		qualityOfServiceLabel.setBounds(10, 67, 140, 25);
		panel.add(qualityOfServiceLabel);
		
		slider_1 = new JSlider(Integer.parseInt(configView.minTip.getText()),Integer.parseInt(configView.maxTip.getText()),Integer.parseInt(configView.maxTip.getText())/2);
		slider_1.setBounds(319, 69, 200, 23);
		slider_1.setMinorTickSpacing(2);
		slider_1.setMajorTickSpacing(10);
		slider_1.setBackground(Color.gray);
		panel.add(slider_1);
		
		JLabel lblBillTotal = new JLabel("Bill Total");
		lblBillTotal.setBounds(10, 105, 60, 14);
		panel.add(lblBillTotal);
		
		JLabel lblBillDeduction = new JLabel("Bill Deduction");
		lblBillDeduction.setBounds(10, 142, 93, 20);
		panel.add(lblBillDeduction);
		
		JLabel lblTax = new JLabel("Tax");
		lblTax.setBounds(10, 185, 76, 14);
		panel.add(lblTax);
		
		billTotal = new JTextField();
		billTotal.setBounds(319, 102, 86, 20);
		panel.add(billTotal);
		billTotal.setColumns(10);
		
		billDeduction = new JTextField();
		billDeduction.setBounds(319, 142, 86, 20);
		panel.add(billDeduction);
		billDeduction.setColumns(10);
		
		tax = new JTextField();
		tax.setBounds(319, 182, 86, 20);
		panel.add(tax);
		tax.setColumns(10);
		
		
		JLabel lblNewLabel = new JLabel("$");
		lblNewLabel.setBounds(288, 145, 21, 14);
		panel.add(lblNewLabel);
		
		JLabel label = new JLabel("$");
		label.setBounds(288, 105, 21, 14);
		panel.add(label);
		
		JLabel label_1 = new JLabel("$");
		label_1.setBounds(286, 185, 21, 14);
		panel.add(label_1);
		
		JLabel lblTipRate = new JLabel("Tip Rate");
		lblTipRate.setBounds(10, 247, 76, 14);
		panel.add(lblTipRate);
		
		JLabel lblTotalTip = new JLabel("Total Tip");
		lblTotalTip.setBounds(10, 282, 76, 14);
		panel.add(lblTotalTip);
		
		JLabel lblPerPersonTip = new JLabel("Per Person Tip");
		lblPerPersonTip.setBounds(10, 317, 140, 25);
		panel.add(lblPerPersonTip);
		
		JLabel lblTotalBill = new JLabel("Total Bill");
		lblTotalBill.setBounds(10, 353, 76, 14);
		panel.add(lblTotalBill);
		
		tipRate = new JLabel();
		
		tipRate.setText(String.valueOf(slider_1.getValue()));
		tipRate.setBounds(319, 247, 46, 14);
		panel.add(tipRate);
	
		
		JLabel lblNewLabel_1 = new JLabel("%");
		lblNewLabel_1.setBounds(385, 247, 46, 14);
		panel.add(lblNewLabel_1);
		
		totalTip = new JTextField();
		totalTip.setBounds(319, 279, 86, 20);
		panel.add(totalTip);
		totalTip.setEditable(false);
		totalTip.setBackground(Color.gray);
		totalTip.setColumns(10);
		
		perPersonTip = new JTextField();
		perPersonTip.setBounds(319, 319, 86, 20);
		panel.add(perPersonTip);
		perPersonTip.setEditable(false);
		perPersonTip.setBackground(Color.gray);
		perPersonTip.setColumns(10);
		
		
		lblPptNa=new JLabel();
		lblPptNa.setBounds(420, 319, 200, 20);
		panel.add(lblPptNa);
		
		totalBill = new JTextField();
		totalBill.setBounds(319, 350, 86, 20);
		totalBill.setEditable(false);
		totalBill.setBackground(Color.gray);
		panel.add(totalBill);
		
		totalBill.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("$");
		lblNewLabel_2.setBounds(288, 282, 27, 14);
		panel.add(lblNewLabel_2);
		
		JLabel label_2 = new JLabel("$");
		label_2.setBounds(288, 322, 27, 14);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("$");
		label_3.setBounds(288, 353, 27, 14);
		panel.add(label_3);
		
		
		btnTipTailoring = new JButton("Tip Tailoring");
		btnTipTailoring.setBounds(32, 397, 120, 23);
		panel.add(btnTipTailoring);
		
		btnConfigureTip = new JButton("Tip Configuration");
		btnConfigureTip.setBounds(450, 397, 150, 23);
		panel.add(btnConfigureTip);
		
		btnCalculateTip=new JButton("Calculate Tip");
		panel.add(btnCalculateTip);
		btnCalculateTip.setBounds(221, 397, 180, 23);
		
		JLabel label_4 = new JLabel("**Enter some value in Tax and BillDeduction fields");
		label_4.setBounds(25, 430, 337, 14);
		panel.add(label_4);
		
		
		btnTipTailoring.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Main.getInstance().setTipTailoringView();
				
			}
		});
		
		billTotal.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent arg0) {
					TipCalcController.getInstance().isBillAmount();		
			}
			
			@Override
			public void focusGained(FocusEvent arg0) {
				// TODO Auto-generated method stub
			}
		});
		
		billDeduction.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				TipCalcController.getInstance().isded();
			}
			
			@Override
			public void focusGained(FocusEvent arg0) {
				// TODO Auto-generated method stub
			}
		});
		
		tax.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				TipCalcController.getInstance().isTax();
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
			}
		});
		
		
		btnConfigureTip.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Main.getInstance().setTipConfigurationView();
			}
		});
		
		btnCalculateTip.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				TipCalcController.getInstance();
				TipCalcController.updateModel();
			}
		});

		noOfGuest.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent arg0) {
				if (( Integer.parseInt(TipCalcView.getInstance().noOfGuest.getText()) > 99 ) || (Integer.parseInt(TipCalcView.getInstance().noOfGuest.getText()) <= 0 ))
				{
					Main.getInstance().displayErrorMessage("The number of guest has to between 1-99");
				}
			}
	@Override
			public void focusGained(FocusEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
			slider_1.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				int tipvalue=((JSlider) e.getSource()).getValue();
				DecimalFormat dFormat=new DecimalFormat("#.##");
				tipRate.setText(String.valueOf(dFormat.format(tipvalue)));
				
			}
		});
		
		
		
	}


	@Override
	public void modifyView(TipCalcModel tipCalcModel) {
		TipCalcView.getInstance().totalTip.setText(String.valueOf(tipCalcModel.getTotalTip()));
		TipCalcView.getInstance().perPersonTip.setText(String.valueOf(tipCalcModel.getPerpersonTip()));
		TipCalcView.getInstance().totalBill.setText(String.valueOf(tipCalcModel.getTotalBill()));
		// TODO Auto-generated method stub
		
	}
}
