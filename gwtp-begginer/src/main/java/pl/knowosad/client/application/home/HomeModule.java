package pl.knowosad.client.application.home;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;
import pl.knowosad.client.application.home.widget.ContactsWidgetModule;

public class HomeModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        install(new ContactsWidgetModule());

        bindPresenter(HomePresenter.class, HomePresenter.MyView.class, HomeView.class,
                HomePresenter.MyProxy.class);
    }
}
