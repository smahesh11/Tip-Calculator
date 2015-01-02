package controller;

import view.TipConfigView;
import model.TipCalcModel;

public class TipConfigController {
	
static TipConfigController tipConfigController;
	
	
	public static TipConfigController getInstance()
	{
		if (tipConfigController == null)
		{
			tipConfigController=new TipConfigController();
		}
		return tipConfigController;
	}
	public void checkMaxPerValue()
	{
		if (Float.parseFloat(TipConfigView.getInstance().maxTip.getText()) <  0)
		{
			Main.getInstance().displayWarningMessage("The Maximum percentage tip cant be less than 0");
			TipConfigView.getInstance().minTip.setText("0");
		}
		else if (Float.parseFloat(TipConfigView.getInstance().maxTip.getText()) <  Float.parseFloat(TipConfigView.getInstance().minTip.getText()))
				{
			Main.getInstance().displayWarningMessage("The Minimum percentage tip cant be more than the maximum percentage");
			TipConfigView.getInstance().minTip.setText("0");
				}
	}

	public void checkMinPerValue()
	{
		if (Float.parseFloat(TipConfigView.getInstance().minTip.getText()) <  0)
		{
			Main.getInstance().displayWarningMessage("The Minimum percentage tip cant be less than 0");
			TipConfigView.getInstance().minTip.setText("0");
		}
		else if (Float.parseFloat(TipConfigView.getInstance().minTip.getText()) >  Float.parseFloat(TipConfigView.getInstance().maxTip.getText()))
				{
			Main.getInstance().displayWarningMessage("The Minimum percentage tip cant be more than the maximum percentage");
			TipConfigView.getInstance().minTip.setText("0");
				}
	}
	public void update()
	{
		TipCalcModel.getInstance().CalculateTip("setConfiguration");
	}


}
