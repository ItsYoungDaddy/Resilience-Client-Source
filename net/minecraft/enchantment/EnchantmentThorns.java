package net.minecraft.enchantment;

import java.util.Random;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;

public class EnchantmentThorns extends Enchantment
{
    private static final String __OBFID = "CL_00000122";

    public EnchantmentThorns(int par1, int par2)
    {
        super(par1, par2, EnumEnchantmentType.armor_torso);
        this.setName("thorns");
    }

    /**
     * Returns the minimal value of enchantability needed on the enchantment level passed.
     */
    public int getMinEnchantability(int par1)
    {
        return 10 + 20 * (par1 - 1);
    }

    /**
     * Returns the maximum value of enchantability nedded on the enchantment level passed.
     */
    public int getMaxEnchantability(int par1)
    {
        return super.getMinEnchantability(par1) + 50;
    }

    /**
     * Returns the maximum level that the enchantment can have.
     */
    public int getMaxLevel()
    {
        return 3;
    }

    public boolean canApply(ItemStack par1ItemStack)
    {
        return par1ItemStack.getItem() instanceof ItemArmor ? true : super.canApply(par1ItemStack);
    }

    public void func_151367_b(EntityLivingBase p_151367_1_, Entity p_151367_2_, int p_151367_3_)
    {
        Random var4 = p_151367_1_.getRNG();
        ItemStack var5 = EnchantmentHelper.func_92099_a(Enchantment.thorns, p_151367_1_);

        if (func_92094_a(p_151367_3_, var4))
        {
            p_151367_2_.attackEntityFrom(DamageSource.causeThornsDamage(p_151367_1_), (float)func_92095_b(p_151367_3_, var4));
            p_151367_2_.playSound("damage.thorns", 0.5F, 1.0F);

            if (var5 != null)
            {
                var5.damageItem(3, p_151367_1_);
            }
        }
        else if (var5 != null)
        {
            var5.damageItem(1, p_151367_1_);
        }
    }

    public static boolean func_92094_a(int par0, Random par1Random)
    {
        return par0 <= 0 ? false : par1Random.nextFloat() < 0.15F * (float)par0;
    }

    public static int func_92095_b(int par0, Random par1Random)
    {
        return par0 > 10 ? par0 - 10 : 1 + par1Random.nextInt(4);
    }
}
