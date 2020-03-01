package pl.knowosad.client;

//import com.google.gwt.event.shared.EventBus;
import com.google.web.bindery.event.shared.EventBus;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HasHandlers;

import javax.inject.Inject;
import java.util.List;

public class CurrentUser implements HasHandlers {

  private boolean loggedIn = false;

  private String username;

  private List<Integer> rights;

  private final EventBus eventBus;

  @Inject
  public CurrentUser(EventBus eventBus) {
    this.eventBus = eventBus;
  }

  public boolean isLoggedIn() {
    return loggedIn;
  }

  public void setLoggedIn(boolean loggedIn) {
    this.loggedIn = loggedIn;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }


  public List<Integer> getRights() {
    return rights;
  }

  public void setRights(List<Integer> rights) {
    this.rights = rights;
  }

  public boolean hasRight(int rightId){
    if (rights != null && rights.contains(rightId)){
      return true;
    }
    return false;
  }

  public void reset(){
    this.loggedIn = false;
    this.username = null;
    this.rights = null;
  }

  @Override
  public void fireEvent(GwtEvent<?> event) {
    eventBus.fireEvent(event);
  }
}