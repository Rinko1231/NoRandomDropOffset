package com.rinko1231.norandomdropposition;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;

@Mod(NoRandomDropPosition.MODID)
public class NoRandomDropPosition
{
    public static final String MODID = "norandomdropposition";

    public NoRandomDropPosition()
    {
        MinecraftForge.EVENT_BUS.register(this);

    }


}
