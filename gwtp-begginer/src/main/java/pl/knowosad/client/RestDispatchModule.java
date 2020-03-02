package pl.knowosad.client;

import com.google.gwt.inject.client.AbstractGinModule;
import com.gwtplatform.dispatch.rest.client.RestApplicationPath;
import com.gwtplatform.dispatch.rest.client.gin.RestDispatchAsyncModule;

public class RestDispatchModule extends AbstractGinModule {
  @Override
  protected void configure() {
    RestDispatchAsyncModule.Builder dispatchBuilder =
        new RestDispatchAsyncModule.Builder();
    install(dispatchBuilder.build());

    bindConstant().annotatedWith(RestApplicationPath.class).to("/");  //TODO
  }
}