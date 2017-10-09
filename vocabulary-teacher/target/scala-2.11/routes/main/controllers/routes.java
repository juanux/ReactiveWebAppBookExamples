
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/juanjosemorales/ReactiveWebAppBookExamples/vocabulary-teacher/conf/routes
// @DATE:Sun Oct 08 22:52:13 COT 2017

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseImport Import = new controllers.ReverseImport(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseQuiz Quiz = new controllers.ReverseQuiz(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseImport Import = new controllers.javascript.ReverseImport(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseQuiz Quiz = new controllers.javascript.ReverseQuiz(RoutesPrefix.byNamePrefix());
  }

}
