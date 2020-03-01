package pl.knowosad.client.application.login;

import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.NoGatekeeper;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import pl.knowosad.client.CurrentUser;
import pl.knowosad.client.application.ApplicationPresenter;
import pl.knowosad.client.place.NameTokens;

public class LoginPresenter extends Presenter<LoginPresenter.MyView, LoginPresenter.MyProxy> implements LoginUiHandlers {

  interface MyView extends View, HasUiHandlers<LoginPresenter> {

  }

  @ProxyStandard
  @NameToken(NameTokens.LOGIN)
  @NoGatekeeper
  interface MyProxy extends ProxyPlace<LoginPresenter> {
  }

  // Credentials are stored here for demo purpose only.
  private static final String USERNAME = "admin";
  private static final String PASSWORD = "admin123";

  private CurrentUser currentUser;

  @Inject
  LoginPresenter(
      EventBus eventBus,
      MyView view,
      MyProxy proxy,
      CurrentUser currentUser) {
    super(eventBus, view, proxy, ApplicationPresenter.SLOT_MAIN);

    getView().setUiHandlers(this);
  }

  @Override
  public void confirm(String username, String password) {
    if (validateCredentials(username, password)) {
      currentUser.setLoggedIn(true);

      // TODO: Navigate to the HomePresenter
    }
  }

  private boolean validateCredentials(String username, String password) {
    return username.equals(USERNAME) && password.equals(PASSWORD);
  }
}
