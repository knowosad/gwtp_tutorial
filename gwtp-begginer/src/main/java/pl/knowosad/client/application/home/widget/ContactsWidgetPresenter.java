package pl.knowosad.client.application.home.widget;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.dispatch.rest.client.RestDispatch;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.PresenterWidget;
import com.gwtplatform.mvp.client.View;
import pl.knowosad.client.Contact;
import pl.knowosad.client.ContactResource;

import javax.inject.Inject;
import java.util.List;

public class ContactsWidgetPresenter extends PresenterWidget<ContactsWidgetPresenter.MyView>
    implements ContactsWidgetUiHandlers {

  interface MyView extends View, HasUiHandlers<ContactsWidgetUiHandlers> {

    void setContactTable(List<Contact> contacts);

    void setContactsField(String text);
  }

  private ContactResource contactResource;
  private RestDispatch dispatch;

  @Inject
  public ContactsWidgetPresenter(EventBus eventBus, MyView view, RestDispatch dispatch, ContactResource contactResource) {
    super(eventBus, view);
    this.dispatch = dispatch;
    this.contactResource = contactResource;

    getView().setUiHandlers(this);
  }

  @Override
  public void fetchContacts() {
    dispatch.execute(contactResource.getContacts(), new AsyncCallback<List<Contact>>() {
      @Override
      public void onFailure(Throwable throwable) {
        getView().setContactsField("failure");
        GWT.log(throwable.getMessage());
      }

      @Override
      public void onSuccess(List<Contact> contacts) {
        getView().setContactsField("success");
//        getView().setContactTable(contacts);
      }
    });
  }

}
