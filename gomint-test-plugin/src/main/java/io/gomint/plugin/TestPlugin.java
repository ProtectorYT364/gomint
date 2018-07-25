package io.gomint.plugin;

import io.gomint.i18n.LocaleManager;
import io.gomint.plugin.listener.EntityDamageListener;
import io.gomint.plugin.listener.PlayerInteractListener;
import io.gomint.plugin.listener.PlayerJoinListener;

import java.util.Locale;

/**
 * @author geNAZt
 * @version 1.0
 */
@PluginName( "TestPlugin" )
@Version( major = 1, minor = 0 )
@Startup( StartupPriority.STARTUP )
public class TestPlugin extends Plugin {

    @Override
    public void onInstall() {
        // Register listener
        registerListener( new PlayerJoinListener( this ) );
        registerListener( new EntityDamageListener() );
        registerListener( new PlayerInteractListener() );

        LocaleManager localeManager = new LocaleManager( this );
        this.getLogger().info( localeManager.translate( Locale.GERMANY, "test" ) );
        this.getLogger().info( localeManager.translate( Locale.GERMANY, "test1.test" ) );
    }

    @Override
    public void onUninstall() {

    }

}
