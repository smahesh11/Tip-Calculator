package controller;

import model.TipCalcModel;

public class TipTailorController {
	
static TipTailorController tipTailorController;
	
	
	public static TipTailorController getInstance()
	{
		
		if (tipTailorController == null)
		{
			tipTailorController=new TipTailorController();
		}
		return tipTailorController;
	}
	
	
	public void setvalues(float ppt)
	{
		TipCalcModel.getInstance().setPerPersonTip(ppt);
	}
	

}
