package view;

import model.TipCalcModel;

//Implemented by all the view 
//Factory Method Design Patter.
public interface FactoryView {
	
	public void modifyView(TipCalcModel tipCalcModel);

}
