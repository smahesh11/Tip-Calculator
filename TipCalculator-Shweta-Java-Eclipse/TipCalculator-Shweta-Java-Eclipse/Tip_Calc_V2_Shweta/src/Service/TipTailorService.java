package Service;

public class TipTailorService {
static TipTailorService tipTailorWorker;
	
	public static TipTailorService getInstance()
		{
			if (tipTailorWorker == null)
			{
				tipTailorWorker=new TipTailorService();
			}
			return tipTailorWorker;
		}
	
	//calculate Total Modified Tip and return that value to the model.
	public float calculateTotalModifiedTip(float[] perpersonTip)
	{
		float totalTip=0;
		for (int i=0;i<perpersonTip.length;i++)
		{
			totalTip=totalTip+perpersonTip[i];
		}
		return totalTip;
	}

}
