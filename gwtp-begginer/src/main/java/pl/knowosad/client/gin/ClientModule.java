package pl.knowosad.client.gin;

import pl.knowosad.client.application.ApplicationModule;
import pl.knowosad.client.place.NameTokens;
import pl.knowosad.client.resources.ResourceLoader;
import com.gwtplatform.mvp.client.annotations.DefaultPlace;
import com.gwtplatform.mvp.client.annotations.ErrorPlace;
import com.gwtplatform.mvp.client.annotations.UnauthorizedPlace;
import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;
import com.gwtplatform.mvp.client.gin.DefaultModule;

public class ClientModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        install(new DefaultModule
                .Builder()
                .defaultPlace(NameTokens.HOME)
                .errorPlace(NameTokens.HOME)
                .unauthorizedPlace(NameTokens.HOME)
                .build());
        install(new ApplicationModule());

        bind(ResourceLoader.class).asEagerSingleton();
    }
}
