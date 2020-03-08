package pl.knowosad.client.application.home.widget;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;
import pl.knowosad.client.Contact;

import javax.inject.Inject;
import java.util.List;

public class ContactsWidgetView extends ViewWithUiHandlers<ContactsWidgetUiHandlers> implements ContactsWidgetPresenter.MyView {

  @Override
  public void setContactTable(List<Contact> contacts) {

  }

  interface Binder extends UiBinder<Widget, ContactsWidgetView> {

  }

  @UiField
  TextArea contactsField;

  @Inject
  public ContactsWidgetView(Binder binder) {
    initWidget(binder.createAndBindUi(this));
  }

  @Override
  public void setContactsField(String text) {
    contactsField.setText(text);
  }

  @UiHandler("getContacts")
  void getContacts(ClickEvent event) {
    getUiHandlers().fetchContacts();
  }
}
