package view;


import model.TipCalcModel;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JToggleButton;
import javax.swing.JCheckBox;

import controller.TipConfigController;
import controller.Main;

@SuppressWarnings("serial")
public class TipConfigView extends JPanel implements FactoryView {
	public JTextField minTip;
	public JTextField maxTip;
	public JButton btnDone;
	public JCheckBox taxChkbox;
	public JCheckBox deductionChkbox;
	
	private static TipConfigView thirdScreen;

	
	
	public static TipConfigView getInstance()
	{
		if (thirdScreen == null)
		{
			thirdScreen=new TipConfigView();
		}
		return thirdScreen;
	}
	public TipConfigView() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(22, 11, 625, 431);
		panel.setBackground(Color.gray);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblMessage = new JLabel("The tip range is the percentage for selecting the tip. You can adjust the range if u wish.");
		lblMessage.setBounds(10, 11, 605, 100);
		panel.add(lblMessage);
		
		JLabel lblMinimumTipPercentage = new JLabel("Minimum Tip Percentage");
		lblMinimumTipPercentage.setBounds(10, 77, 152, 21);
		panel.add(lblMinimumTipPercentage);
		
		minTip = new JTextField();
		minTip.setText("0");
		minTip.setBounds(296, 77, 86, 20);
		panel.add(minTip);
		minTip.setColumns(10);
		minTip.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent arg0) {
				// TODO Auto-generated method stub
				TipConfigController.getInstance().checkMinPerValue();
			}
			
			@Override
			public void focusGained(FocusEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		JLabel lblMaximumTipPercentage = new JLabel("Maximum Tip Percentage");
		lblMaximumTipPercentage.setBounds(10, 122, 152, 21);
		panel.add(lblMaximumTipPercentage);
		
		maxTip = new JTextField();
		maxTip.setText("40");
		maxTip.setBounds(296, 122, 86, 20);
		panel.add(maxTip);
		maxTip.setColumns(10);
		maxTip.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				TipConfigController.getInstance().checkMaxPerValue();
				}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}
		});	
		JLabel lblNewLabel = new JLabel("IncludeTax");
		lblNewLabel.setBounds(10, 285, 160, 21);
		panel.add(lblNewLabel);
		
		JLabel lblIncludebilldeduction = new JLabel("IncludeBillDeduction");
		lblIncludebilldeduction.setBounds(10, 333, 180, 21);
		panel.add(lblIncludebilldeduction);
		
		btnDone = new JButton("Back");
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Main.getInstance().afterTipConfiguration();
				TipConfigController.getInstance().update();
			}
		});
		
		btnDone.setBounds(10, 381, 89, 23);
		panel.add(btnDone);
		
		taxChkbox = new JCheckBox("IncludeTax");
		taxChkbox.setSelected(false);
		taxChkbox.setBounds(285, 284, 136, 23);
		panel.add(taxChkbox);
		
		deductionChkbox = new JCheckBox("Include Deduction");
		deductionChkbox.setSelected(true);
		deductionChkbox.setBounds(285, 332, 152, 23);
		panel.add(deductionChkbox);
		
		JLabel lblNewLabel_1 = new JLabel("check/Uncheck for calculation of total Bill");
		lblNewLabel_1.setBounds(10, 231, 297, 30);
		panel.add(lblNewLabel_1);

	}
	@Override
	public void modifyView(TipCalcModel tipCalcModel) {
		// TODO Auto-generated method stub
		
		TipCalcView.getInstance().slider_1.setMaximum(tipCalcModel.getMaxPercent());
		TipCalcView.getInstance().slider_1.setMinimum(tipCalcModel.getMinPercent());
	}
	
}
