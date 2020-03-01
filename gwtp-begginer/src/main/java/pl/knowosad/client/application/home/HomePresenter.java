package pl.knowosad.client.application.home;

import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import pl.knowosad.client.application.ApplicationPresenter;
import pl.knowosad.client.place.NameTokens;

public class HomePresenter extends Presenter<HomePresenter.MyView, HomePresenter.MyProxy> implements HomeUiHandlers {

    interface MyView extends View, HasUiHandlers<HomePresenter> {
        void setResultValue(String text);
    }

    @ProxyStandard
    @NameToken(NameTokens.HOME)
    interface MyProxy extends ProxyPlace<HomePresenter> {
    }

    @Inject
    HomePresenter(
        EventBus eventBus,
        MyView view,
        MyProxy proxy) {
        super(eventBus, view, proxy, ApplicationPresenter.SLOT_MAIN);

        getView().setUiHandlers(this);
    }

    @Override
    public void onSend(String name) {
        getView().setResultValue(name);
    }
}
