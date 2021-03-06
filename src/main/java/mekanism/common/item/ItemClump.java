package mekanism.common.item;

import mekanism.common.Resource;
import mekanism.common.base.IMetaItem;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

public class ItemClump extends ItemMekanism implements IMetaItem
{
	public ItemClump()
	{
		super();
		setHasSubtypes(true);
	}
	
	@Override
	public String getTexture(int meta)
	{
		return Resource.values()[meta].getName() + "Clump";
	}
	
	@Override
	public int getVariants()
	{
		return Resource.values().length;
	}

	@Override
	public void getSubItems(CreativeTabs tabs, NonNullList<ItemStack> itemList)
	{
		if(!isInCreativeTab(tabs)) return;
		for(int counter = 0; counter < Resource.values().length; counter++)
		{
			itemList.add(new ItemStack(this, 1, counter));
		}
	}

	@Override
	public String getUnlocalizedName(ItemStack item)
	{
		if(item.getItemDamage() <= Resource.values().length-1)
		{
			return "item." + Resource.values()[item.getItemDamage()].getName().toLowerCase() + "Clump";
		}
		
		return "Invalid";
	}
}
