package Service;



public class ServiceLocator {
	
	static ServiceLocator Locator;


	public static ServiceLocator getInstance()
	{
		if (Locator == null)
		{
			Locator=new ServiceLocator();
		}
		return Locator;
	}

	
	public Object getWorker(String workerID)
	{
		if (workerID.equals("calculateTip"))
		{
			return TipCalcuService.getInstance();
		}
		else if (workerID.equalsIgnoreCase("setConfiguration"))
		{
			return TipConfigService.getInstance();
		}
		else if (workerID.equalsIgnoreCase("TailorTip"))
		{
			return TipTailorService.getInstance();
		}
		else
		{
			return null;
		}
		
	}

}



