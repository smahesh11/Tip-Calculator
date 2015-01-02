package controller;

import view.TipCalcView;
import model.TipCalcModel;

public class TipCalcController {
	
	static TipCalcController tipCalcController;
	
	
	public static TipCalcController getInstance()
	{
		
		if (tipCalcController == null)
		{
			tipCalcController=new TipCalcController();
		}
		return tipCalcController;
	}	

	public boolean validate()
	{
		if(!TipCalcController.getInstance().isded())
		{
			return false;
		}
		else if (!TipCalcController.getInstance().isTax())
		{
			return false;
		}
		else if (!TipCalcController.getInstance().isBillAmount())
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	
	public static void  updateModel()
	{
		if (TipCalcController.getInstance().validate())
		{
			TipCalcModel.getInstance().setNumberofGuest(Integer.parseInt(TipCalcView.getInstance().noOfGuest.getText()));
			TipCalcModel.getInstance().setQos(Float.parseFloat(TipCalcView.getInstance().tipRate.getText()));
			TipCalcModel.getInstance().setBilltotal(Float.parseFloat(TipCalcView.getInstance().billTotal.getText()));
			TipCalcModel.getInstance().setDeduction(Float.parseFloat(TipCalcView.getInstance().billDeduction.getText()));
			TipCalcModel.getInstance().setTax(Float.parseFloat(TipCalcView.getInstance().tax.getText()));
			TipCalcModel.getInstance().CalculateTip("calculateTip");
		}
		
	}
	
	public boolean isded()
	{
	
		if(!(TipCalcView.getInstance().billDeduction.getText().equals("")))
		{
			if (Float.valueOf(TipCalcView.getInstance().billDeduction.getText()).floatValue() < 0 )
			{
				Main.getInstance().displayErrorMessage("Deduction > 0 and Deduction < billTotal");
				TipCalcView.getInstance().btnCalculateTip.setEnabled(false);
				return false;
			}
			else if (Float.valueOf(TipCalcView.getInstance().billDeduction.getText()).floatValue() > Float.valueOf(TipCalcView.getInstance().billTotal.getText()).floatValue())
			{
				Main.getInstance().displayErrorMessage("Deduction > 0 and Deduction < billTotal");
				TipCalcView.getInstance().btnCalculateTip.setEnabled(false);
				
			return false;
			}
			else
			{
				TipCalcView.getInstance().btnCalculateTip.setEnabled(true);
				return true;
			}
		}
		TipCalcView.getInstance().btnCalculateTip.setEnabled(false);
		return false;
		
	}
	
	public boolean isTax()
	{
		if(!(TipCalcView.getInstance().tax.getText().equals("")))
		{
			if (TipCalcView.getInstance().tax.getText().contains("-"))
			{
				Main.getInstance().displayErrorMessage("Tax > 0");
				TipCalcView.getInstance().btnCalculateTip.setEnabled(false);
				return false;
			}
			else if (Float.valueOf(TipCalcView.getInstance().tax.getText()).floatValue() > Float.valueOf(TipCalcView.getInstance().billTotal.getText()).floatValue())
			{
				Main.getInstance().displayWarningMessage("Tax < Bill Amount");
				TipCalcView.getInstance().btnCalculateTip.setEnabled(false);
				return false;
			}
			else
			{
				TipCalcView.getInstance().btnCalculateTip.setEnabled(true);
				return true;
			}
		}
		TipCalcView.getInstance().btnCalculateTip.setEnabled(false);
		return false;
	}
	
	public boolean isBillAmount()
	{
		if (TipCalcView.getInstance().billTotal.getText().equals(""))
		{
			Main.getInstance().displayErrorMessage("Enter Bill Total");
			TipCalcView.getInstance().btnCalculateTip.setEnabled(false);
			return false;
		}
		else if (Float.valueOf(TipCalcView.getInstance().billTotal.getText()).floatValue() < 0)
		{
			Main.getInstance().displayErrorMessage("Bill Value > 0");
			TipCalcView.getInstance().btnCalculateTip.setEnabled(false);
			return false;
		}
		else
		{
			TipCalcView.getInstance().btnCalculateTip.setEnabled(true);
			return true;
		}
		
	}

}
