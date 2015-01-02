package Service;

import java.text.DecimalFormat;

public class TipCalcuService {
	static TipCalcuService tipCalcWorker;
	float totalBill, totalTip, perpersonTip, TotalBill;

public static TipCalcuService getInstance()
	{
		if (tipCalcWorker == null)
		{
			tipCalcWorker=new TipCalcuService();
		}
		return tipCalcWorker;
	}
	
	public float calculateTip(float qualityofservice,float billtotal,float deduction,float tax,boolean includetax,boolean incldueDeduction)
	{
		if (includetax == true && incldueDeduction ==true)
		{
		
		totalBill=billtotal+tax-deduction;
		totalTip=(qualityofservice/100)*totalBill;
		}
		else if(includetax==true && incldueDeduction== false)
		{
			totalBill=billtotal+tax;
			totalTip=(qualityofservice/100)*totalBill;
				
		}
		else
		{
			totalBill=billtotal-deduction;
			totalTip=(qualityofservice/100)*totalBill;
			
		}
		return totalTip;
	}
	
		public float calculatePerPersonTip(int numberofGuest,float totalTip)
		{
			DecimalFormat df = new DecimalFormat("#.##");
			perpersonTip=Float.parseFloat(df.format(totalTip/numberofGuest));
			return perpersonTip;
		}
	
		public float calculateTotalBill(float totalTip,float billtotal,float deduction,float tax)
		{
			TotalBill=totalTip+billtotal+tax-deduction;
			return TotalBill;
		}

}
