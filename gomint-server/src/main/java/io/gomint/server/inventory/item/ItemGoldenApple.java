package io.gomint.server.inventory.item;

import io.gomint.entity.potion.PotionEffect;
import io.gomint.server.entity.EntityPlayer;
import io.gomint.server.registry.RegisterInfo;
import io.gomint.taglib.NBTTagCompound;

import java.util.concurrent.TimeUnit;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo( id = 322 )
public class ItemGoldenApple extends ItemFood implements io.gomint.inventory.item.ItemGoldenApple {

    // CHECKSTYLE:OFF
    public ItemGoldenApple( short data, int amount ) {
        super( 322, data, amount );
    }

    public ItemGoldenApple( short data, int amount, NBTTagCompound nbt ) {
        super( 322, data, amount, nbt );
    }
    // CHECKSTYLE:ON

    @Override
    public float getSaturation() {
        return 1.2F;
    }

    @Override
    public float getHunger() {
        return 4;
    }

    @Override
    public void onConsume( EntityPlayer player ) {
        super.onConsume( player );

        // Apply effects
        player.addEffect( PotionEffect.ABSORPTION, 0, 2, TimeUnit.MINUTES );
        player.addEffect( PotionEffect.REGENERATION, 1, 5, TimeUnit.SECONDS );
    }

}
