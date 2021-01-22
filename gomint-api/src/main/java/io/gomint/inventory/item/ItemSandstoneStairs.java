package io.gomint.inventory.item;

import io.gomint.GoMint;
import io.gomint.world.block.data.RoughnessType;
import io.gomint.world.block.data.Sandcolor;

/**
 * @author geNAZt
 * @version 1.0
 * @stability 3
 */
public interface ItemSandstoneStairs extends ItemStack<ItemSandstoneStairs> {

    /**
     * Create a new item stack with given class and amount
     *
     * @param amount which is used for the creation
	 * @return freshly generated item
     */
    static ItemSandstoneStairs create( int amount ) {	
        return GoMint.instance().createItemStack( ItemSandstoneStairs.class, amount );
    }

    /**
     * Set the color of this item
     *
     * @param color of this item
     * @return item for chaining
     */
    ItemSandstoneStairs color(Sandcolor color);

    /**
     * Get the color of this item
     *
     * @return color of this item
     */
    Sandcolor color();

    /**
     * Set the type of this item
     *
     * @param type of this item
     * @return item for chaining
     */
    ItemSandstoneStairs type(RoughnessType type);

    /**
     * Get the type of this item
     *
     * @return type of this item
     */
    RoughnessType type();

}
