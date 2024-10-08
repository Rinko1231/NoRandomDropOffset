package com.rinko1231.norandomdropoffset;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;

@Mod(NoRandomDropOffset.MODID)
public class NoRandomDropOffset
{
    public static final String MODID = "norandomdropoffset";

    public NoRandomDropOffset()
    {
        MinecraftForge.EVENT_BUS.register(this);

    }


}
