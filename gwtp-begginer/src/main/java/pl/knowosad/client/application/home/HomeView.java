package pl.knowosad.client.application.home;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;

import javax.inject.Inject;

public class HomeView extends ViewWithUiHandlers<HomePresenter> implements HomePresenter.MyView {

    interface Binder extends UiBinder<Widget, HomeView> {
    }

    @UiField
    TextBox nameField;

    @UiField
    TextArea resultField;

    @UiField
    SimplePanel contactPanel;

    @Inject
    HomeView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));

        bindSlot(HomePresenter.SLOT_CONTACTS, contactPanel);
    }

    @UiHandler("sendButton")
    void onSend(ClickEvent event) {
        getUiHandlers().onSend(nameField.getText());
    }

    @Override
    public void setResultValue(String text) {
        resultField.setText(text);
    }
}
