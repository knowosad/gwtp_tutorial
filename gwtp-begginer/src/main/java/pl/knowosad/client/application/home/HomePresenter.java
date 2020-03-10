package pl.knowosad.client.application.home;

import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.presenter.slots.Slot;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import pl.knowosad.client.application.ApplicationPresenter;
import pl.knowosad.client.application.home.widget.ContactsWidgetPresenter;
import pl.knowosad.client.place.NameTokens;

public class HomePresenter extends Presenter<HomePresenter.MyView, HomePresenter.MyProxy> implements HomeUiHandlers {

    interface MyView extends View, HasUiHandlers<HomePresenter> {
        void setResultValue(String text);
    }

    @ProxyStandard
    @NameToken(NameTokens.HOME)
    interface MyProxy extends ProxyPlace<HomePresenter> {
    }

    public static final Slot SLOT_CONTACTS = new Slot(); // The new slot

    private ContactsWidgetPresenter contactsWidgetPresenter;

    @Inject
    HomePresenter(
        EventBus eventBus,
        MyView view,
        MyProxy proxy,
        ContactsWidgetPresenter contactsWidgetPresenter) {
        super(eventBus, view, proxy, ApplicationPresenter.SLOT_MAIN);

        this.contactsWidgetPresenter = contactsWidgetPresenter;
        getView().setUiHandlers(this);
        setInSlot(SLOT_CONTACTS, contactsWidgetPresenter); // Setting the PresenterWidget into the slot
    }

    @Override
    public void onSend(String name) {
        getView().setResultValue(name);
    }
}
