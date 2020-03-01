package pl.knowosad.client.application;

import com.gwtplatform.mvp.client.proxy.Gatekeeper;
import pl.knowosad.client.CurrentUser;

import javax.inject.Inject;

public class LoggedInGatekeeper implements Gatekeeper {

  private CurrentUser currentUser;

  @Inject
  public LoggedInGatekeeper(CurrentUser currentUser) {
    this.currentUser = currentUser;
  }

  @Override
  public boolean canReveal() {
    return currentUser.isLoggedIn();
  }
}
