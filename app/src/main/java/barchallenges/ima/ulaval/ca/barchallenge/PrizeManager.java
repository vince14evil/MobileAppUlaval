package barchallenges.ima.ulaval.ca.barchallenge;

import android.content.Context;
import android.content.SharedPreferences;

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

    public void updateData(Context pContext)
    {
        SharedPreferences pref = pContext.getSharedPreferences("IMA_PREF", pContext.MODE_PRIVATE);

        for (int i = 0; i< mPrizeList.size();i++) {
            Prize prize = mPrizeList.get(i);
            prize.setEarned(pref.getBoolean("Prize" + prize.getId() + "Earned", prize.getIsEarned()));
            prize.setIsUsed(pref.getBoolean("Prize" + prize.getId() + "Used", prize.getIsUsed()));
        }

    }

    private void generateMockData()
    {
        mPrizeList.add(new Prize(1, "Free Beer", "You can drink a beer with you friend!"));
        mPrizeList.add(new Prize(2, "10% on a drink", "Choose waht you want to get drunk"));
        mPrizeList.add(new Prize(3, "Free Shooter", "1.. 2.. 3.. SHOT!"));
        mPrizeList.add(new Prize(4, "25% on a poutine", "If you are hungry..."));
        mPrizeList.add(new Prize(5, "Free fries", "Because everyone love fries"));
    }

    public void earnNextPrize(Context pContext)
    {
        for (int i = 0; i< mPrizeList.size();i++){
            if(!mPrizeList.get(i).getIsEarned())
            {
                mPrizeList.get(i).earn();
                break;
            }
        }
        savePrizes(pContext);
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

    public void usePrize(Prize pPrize, Context pContext)
    {
        for (int i = 0; i< mPrizeList.size();i++) {
            if(mPrizeList.get(i).getName().equals(pPrize.getName())) {
                mPrizeList.get(i).useIt();
                break;
            }
        }

        savePrizes(pContext);
    }

    public void savePrizes(Context pContext)
    {
        SharedPreferences.Editor editor = pContext.getSharedPreferences("IMA_PREF", pContext.MODE_PRIVATE).edit();

        for (int i = 0; i< mPrizeList.size();i++) {
            Prize prize = mPrizeList.get(i);
            editor.putBoolean("Prize" + prize.getId() + "Earned", prize.getIsEarned());
            editor.putBoolean("Prize" + prize.getId() + "Used", prize.getIsUsed());
        }

        editor.apply();
    }
}
