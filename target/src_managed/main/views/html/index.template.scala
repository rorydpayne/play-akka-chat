
package views.html

import play.templates._
import play.templates.TemplateMagic._

import play.api.templates._
import play.api.templates.PlayMagic._
import models._
import controllers._
import play.api.i18n._
import play.api.mvc._
import play.api.data._
import views.html._
/**/
object index extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply():play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.1*/("""<!DOCTYPE html>

<html ng-app="myApp">
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.2/angular.min.js"></script>
    <script src='https://ajax.googleapis.com/ajax/libs/angularjs/1.2.2/angular-route.js'></script>
    <script src='https://ajax.googleapis.com/ajax/libs/angularjs/1.2.2/angular-resource.js'></script>
    <script src=""""),_display_(Seq[Any](/*8.19*/routes/*8.25*/.Assets.at("javascripts/ui-bootstrap-tpls-0.11.0.min.js"))),format.raw/*8.82*/(""""></script>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">

    <script src='"""),_display_(Seq[Any](/*14.19*/routes/*14.25*/.Assets.at("javascripts/app.js"))),format.raw/*14.57*/("""' type="text/javascript"></script>
    <script src='"""),_display_(Seq[Any](/*15.19*/routes/*15.25*/.Assets.at("javascripts/time/TimeCtrl.js"))),format.raw/*15.67*/("""' type="text/javascript"></script>
    <script src='"""),_display_(Seq[Any](/*16.19*/routes/*16.25*/.Assets.at("javascripts/time/TimeService.js"))),format.raw/*16.70*/("""' type="text/javascript"></script>

</head>
<body>
<div class="container">
    <div class="row" ng-controller="TimeCtrl as uc">
        <div class="btn-group">
            <button type="button" class="btn btn-default" ng-click="uc.login('user')">login</button>
        </div>
    </div>
</div>

</body>
</html>"""))}
    }
    
    def render(): play.api.templates.HtmlFormat.Appendable = apply()
    
    def f:(() => play.api.templates.HtmlFormat.Appendable) = () => apply()
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Aug 26 16:24:49 BST 2014
                    SOURCE: C:/Code/play-akka-chat/app/views/index.scala.html
                    HASH: 13278a3e4271d16505bd38681d1cb5e5ae1d9e95
                    MATRIX: 637->0|1034->362|1048->368|1126->425|1483->746|1498->752|1552->784|1641->837|1656->843|1720->885|1809->938|1824->944|1891->989
                    LINES: 22->1|29->8|29->8|29->8|35->14|35->14|35->14|36->15|36->15|36->15|37->16|37->16|37->16
                    -- GENERATED --
                */
            