package pl.knowosad.client.application.home.widget;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;

import javax.inject.Inject;

public class ContactsWidgetView extends ViewWithUiHandlers<ContactsWidgetUiHandlers> implements ContactsWidgetPresenter.MyView {

  interface Binder extends UiBinder<Widget, ContactsWidgetView> {

  }

  @Inject
  public ContactsWidgetView(Binder binder) {
    initWidget(binder.createAndBindUi(this));
  }
}
