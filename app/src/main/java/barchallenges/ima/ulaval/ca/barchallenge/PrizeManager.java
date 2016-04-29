package barchallenges.ima.ulaval.ca.barchallenge;

import java.util.ArrayList;

/**
 * Not a very good idea but correct for a prototype
 */
public class PrizeManager {
    private static PrizeManager Instance;

    public static PrizeManager getInstance()
    {
        if(Instance == null) {
            Instance = new PrizeManager();
        }
        return Instance;
    }

    private ArrayList<Prize> mPrizeList;

    private PrizeManager()
    {
        mPrizeList = new ArrayList<>();
        generateMockData();
    }

    private void generateMockData()
    {
        mPrizeList.add(new Prize("Free Beer", "You can drink a beer with you friend!"));
        mPrizeList.add(new Prize("10% on a drink", "Choose waht you want to get drunk"));
        mPrizeList.add(new Prize("Free Shooter", "1.. 2.. 3.. SHOT!"));
        mPrizeList.add(new Prize("25% on a poutine", "If you are hungry..."));
        mPrizeList.add(new Prize("Free fries", "Because everyone love fries"));
    }

    public void earnNextPrize()
    {
        for (int i = 0; i< mPrizeList.size();i++){
            if(!mPrizeList.get(i).getIsEarned())
            {
                mPrizeList.get(i).earn();
                break;
            }
        }
    }

    public Prize getPrizeAt(int pPosition)
    {
        if(pPosition < mPrizeList.size())
        {
            return mPrizeList.get(pPosition);
        }
        else
        {
            return null;
        }
    }

    public int getPrizeCount()
    {
        return mPrizeList.size();
    }

    public void usePrize(Prize pPrize)
    {
        for (int i = 0; i< mPrizeList.size();i++) {
            if(mPrizeList.get(i).getName().equals(pPrize.getName())) {
                mPrizeList.get(i).useIt();
                break;
            }
        }
    }
}
