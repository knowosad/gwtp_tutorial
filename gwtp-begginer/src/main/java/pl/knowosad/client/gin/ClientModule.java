package pl.knowosad.client.gin;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;
import com.gwtplatform.mvp.client.gin.DefaultModule;
import pl.knowosad.client.RestDispatchModule;
import pl.knowosad.client.application.ApplicationModule;
import pl.knowosad.client.place.NameTokens;
import pl.knowosad.client.resources.ResourceLoader;

public class ClientModule extends AbstractPresenterModule {
  @Override
  protected void configure() {
    install(new DefaultModule
        .Builder()
        .defaultPlace(NameTokens.LOGIN)
        .errorPlace(NameTokens.LOGIN)
        .unauthorizedPlace(NameTokens.LOGIN)
        .build());
    //        install(new DefaultModule
    //                .Builder()
    //                .defaultPlace(NameTokens.HOME)
    //                .errorPlace(NameTokens.HOME)
    //                .unauthorizedPlace(NameTokens.HOME)
    //                .build());

    install(new ApplicationModule());
    install(new RestDispatchModule());

    bind(ResourceLoader.class).asEagerSingleton();
  }
}
