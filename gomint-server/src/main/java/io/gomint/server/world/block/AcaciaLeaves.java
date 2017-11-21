package io.gomint.server.world.block;

import io.gomint.server.registry.RegisterInfo;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo( id = 161 )
public class AcaciaLeaves extends Block {

    @Override
    public int getBlockId() {
        return 161;
    }

    @Override
    public boolean isTransparent() {
        return true;
    }

    @Override
    public long getBreakTime() {
        return 350;
    }

    @Override
    public float getBlastResistance() {
        return 1.0f;
    }

}
