package com.example.model;

public abstract class IR {
    private static int[] _tranches={28000,40000,5000,6000,150000};
    private static float[] _tauxIR={0,.12f,.24f,.34f,.38f,.4f};

    public static float getIR(double salaire){
        for(int i=0;i<_tranches.length;i++)
            if(salaire<_tranches[i])
                return _tauxIR[i];
        return _tauxIR[_tauxIR.length-1];
    }
}
