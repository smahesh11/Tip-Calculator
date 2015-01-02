package Service;

import model.TipCalcModel;

public class TipConfigService {
	
	static TipConfigService tipConfigWorker;
	
	public static TipConfigService getInstance()
		{
			if (tipConfigWorker == null)
			{
				tipConfigWorker=new TipConfigService();
			}
			return tipConfigWorker;
		}
	
	public void  setIncludetax(boolean includeTax)
	{
		TipCalcModel.getInstance().setIncludeTax(includeTax);
		
	}
	public void  setIncludeDeduction(boolean includeDeduction)
	{
		
		TipCalcModel.getInstance().setIncludededuction(includeDeduction);
	}
	public void  setMaxPercent(int maxPercent)
	{
		TipCalcModel.getInstance().setMaxPercent(maxPercent);
	}
	public void  setMinPercent(int minPercent)
	{
		TipCalcModel.getInstance().setMinPercent(minPercent);
		
	}

}

