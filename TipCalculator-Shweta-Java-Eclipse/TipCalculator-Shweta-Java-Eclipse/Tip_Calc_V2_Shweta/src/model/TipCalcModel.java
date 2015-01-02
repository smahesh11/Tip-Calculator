package model;

import Service.ServiceLocator;
import Service.TipCalcuService;
import Service.TipConfigService;
import Service.TipTailorService;
import view.TipCalcView;
import view.TipConfigView;
import view.TipTailorView;

public class TipCalcModel {

float QOS;
int noOfGuest; 
int maxPercent, minPercent;
float billTotal;
float tax,deduction;



public int getMaxPercent() {
	return maxPercent;
}



public void setMaxPercent(int maxPercent) {
	this.maxPercent = maxPercent;
}



public int getMinPercent() {
	return minPercent;
}



public void setMinPercent(int minPercent) {
	this.minPercent = minPercent;
}



float totalTip=0;
float perpersonTip=0;
float totalBill=0;


float perpersontip[]=new float[Integer.parseInt(TipCalcView.getInstance().noOfGuest.getText())];
public float[] getPerpersontip() {
	return perpersontip;
}

boolean includeTax=false;
int count=0;

public boolean isIncludeTax() {
	return includeTax;
}



public void setIncludeTax(boolean includeTax) {
	this.includeTax = includeTax;
}



public boolean isIncludededuction() {
	return includededuction;
}



public void setIncludededuction(boolean includededuction) {
	this.includededuction = includededuction;
}


boolean includededuction=true;

static TipCalcModel tipCalcModel;


public static TipCalcModel getInstance()
{
	if (tipCalcModel == null)
	{
		tipCalcModel=new TipCalcModel();
	}
	return tipCalcModel;
}



public int getNumberofGuest() {
	return noOfGuest;
}
public void setNumberofGuest(int numberofGuest) {
	this.noOfGuest = numberofGuest;
}
public float getQos() {
	return QOS;
}
public void setQos(float qos) {
	this.QOS = qos;
}
public float getBilltotal() {
	return billTotal;
}
public void setBilltotal(float billtotal) {
	this.billTotal = billtotal;
}
public float getTax() {
	return tax;
}
public void setTax(float tax) {
	this.tax = tax;
}
public float getDeduction() {
	return deduction;
}
public void setDeduction(float deduction) {
	this.deduction = deduction;
}
public float getTotalTip() {
	return totalTip;
}
public void setTotalTip(float totalTip) {
	this.totalTip = totalTip;
}
public float getPerpersonTip() {
	return perpersonTip;
}
public void setPerpersonTip(float perpersonTip) {
	this.perpersonTip = perpersonTip;
}
public float getTotalBill() {
	return totalBill;
}
public void setTotalBill(float totalBill) {
	this.totalBill = totalBill;
}

public void setPerPersonTip(float tip)
{
	perpersontip[count]=tip;
	count++;
}
public void CalculateTip(String workerID)
{
	
	Object worker=Service.ServiceLocator.getInstance().getWorker(workerID);
	if (worker instanceof Service.TipCalcuService)
	{
		TipCalcModel.getInstance().setTotalTip(((Service.TipCalcuService) worker).calculateTip(QOS,billTotal,deduction,tax,includeTax,includededuction));
		TipCalcModel.getInstance().setPerpersonTip(((Service.TipCalcuService) worker).calculatePerPersonTip(noOfGuest,TipCalcModel.getInstance().getTotalTip()));
		TipCalcModel.getInstance().setTotalBill(((Service.TipCalcuService) worker).calculateTotalBill(TipCalcModel.getInstance().getTotalTip(),TipCalcModel.getInstance().getBilltotal(),TipCalcModel.getInstance().getDeduction(),TipCalcModel.getInstance().getTax()));
		TipCalcView.getInstance().modifyView(TipCalcModel.getInstance());
	}

	else if (worker instanceof Service.TipConfigService)
	{
		((Service.TipConfigService) worker).setIncludetax(TipConfigView.getInstance().taxChkbox.isSelected());
		((Service.TipConfigService) worker).setIncludeDeduction(TipConfigView.getInstance().deductionChkbox.isSelected());
		((Service.TipConfigService) worker).setMaxPercent(Integer.parseInt(TipConfigView.getInstance().maxTip.getText()));
		((Service.TipConfigService) worker).setMinPercent(Integer.parseInt(TipConfigView.getInstance().minTip.getText()));
		TipConfigView.getInstance().modifyView(TipCalcModel.getInstance());
		
		
	}
	else if (worker instanceof Service.TipTailorService)
			{	
		float totalmodifiedtip=Service.TipTailorService.getInstance().calculateTotalModifiedTip(TipCalcModel.getInstance().getPerpersontip());
		TipCalcModel.getInstance().setTotalTip(totalmodifiedtip);
		TipCalcModel.getInstance().setTotalBill(Service.TipCalcuService.getInstance().calculateTotalBill(totalTip,TipCalcModel.getInstance().getBilltotal(),TipCalcModel.getInstance().getDeduction(),TipCalcModel.getInstance().getTax()));
		count=0;
		TipTailorView.getInstance().modifyView(TipCalcModel.getInstance());
		
	}
}




}
