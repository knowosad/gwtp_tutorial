package pl.knowosad.client.application.home.widget;

import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.PresenterWidget;
import com.gwtplatform.mvp.client.View;

import javax.inject.Inject;

public class ContactsWidgetPresenter extends PresenterWidget<ContactsWidgetPresenter.MyView> implements ContactsWidgetUiHandlers {

  interface MyView extends View, HasUiHandlers<ContactsWidgetUiHandlers> {


  }

  @Inject
  public ContactsWidgetPresenter(EventBus eventBus, MyView view) {
    super(eventBus, view);

    getView().setUiHandlers(this);
  }

}
