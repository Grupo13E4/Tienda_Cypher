/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.52
 * Generated at: 2021-09-24 14:42:07 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class inicio_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("	<meta charset=\"ISO-8859-1\">\r\n");
      out.write("	\r\n");
      out.write("	<!-- Links para el funcionamiento del boton de ocultar contraseña(los primero 3) -->\r\n");
      out.write("	<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\r\n");
      out.write("	<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\">\r\n");
      out.write("	<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>\r\n");
      out.write("	<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css\" rel=\"stylesheet\" \r\n");
      out.write("	integrity=\"sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We\" crossorigin=\"anonymous\">\r\n");
      out.write("	 <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css\"/>\r\n");
      out.write("	<link rel=\"stylesheet\" href=\"CssIndex.css\">\r\n");
      out.write("	<link rel=\"icon\" href=\"img/icon.jpg\" type=\"image/x-icon\">\r\n");
      out.write("	<title>Login Cypher</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("		\r\n");
      out.write("	<!-- Inicio Login -->\r\n");
      out.write("	<div class = \"container col-lg-4\">\r\n");
      out.write("	\r\n");
      out.write("			<div class = \"card-body\">\r\n");
      out.write("				<form class=\"form-sign\" method=\"get\" action=\"./DemoServlet\">\r\n");
      out.write("					<div class = \"form-group text-center\">\r\n");
      out.write("						<h3 class=\"animated infinite bounce\">Inicie Sesión</h3>\r\n");
      out.write("						<img src=\"img/icon.jpg\" class=\"icon\" alt=\"70\" width=\"80\"/>\r\n");
      out.write("						<label>Bienvenidos al Sistema</label>\r\n");
      out.write("					</div>\r\n");
      out.write("					<div class = \"form-group\">\r\n");
      out.write("						\r\n");
      out.write("						<input type=\"text\" name=\"txtusuario\" class=\"form form-control mt-4 text-light\" placeholder=\"Usuario\">					\r\n");
      out.write("					</div>\r\n");
      out.write("					\r\n");
      out.write("					<!-- <div class = \"form-group\">\r\n");
      out.write("						<input type=\"password\" name=\"txtpassword\" class=\"form form-control mt-4 text-light\" \r\n");
      out.write("						placeholder=\"Password\">	\r\n");
      out.write("						</div> -->\r\n");
      out.write("						\r\n");
      out.write("						<form id=\"form1\">\r\n");
      out.write("						<div class=\"form-group\">\r\n");
      out.write("						    <div class=\"row\">\r\n");
      out.write("						  <div>\r\n");
      out.write("\r\n");
      out.write("						     <div class=\"input-group\">\r\n");
      out.write("						      	<input ID=\"txtpassword\" name=\"txtpassword\" type=\"password\" \r\n");
      out.write("						     	 Class=\"form form-control mt-4 text-light\" placeholder=\"Password\" >\r\n");
      out.write("						      	<button style=\"color: #fff\" id=\"show_password\" \r\n");
      out.write("						     	class=\"btn btn-primary btn-lm mt-4 input-group-append\" type=\"button\"\r\n");
      out.write("						     	onclick=\"mostrarPassword()\"> <span class=\"fa fa-eye-slash icon\"></span> </button>\r\n");
      out.write("						    </div>\r\n");
      out.write("						    \r\n");
      out.write("						    	<!-- Funionamiento del Boton para mostrar u ocultar contraseña -->\r\n");
      out.write("						    	\r\n");
      out.write("							    	<script type=\"text/javascript\">\r\n");
      out.write("										function mostrarPassword(){\r\n");
      out.write("												var cambio = document.getElementById(\"txtpassword\");\r\n");
      out.write("												if(cambio.type == \"password\"){\r\n");
      out.write("													cambio.type = \"text\";\r\n");
      out.write("													$('.icon').removeClass('fa fa-eye-slash').addClass('fa fa-eye');\r\n");
      out.write("												}else{\r\n");
      out.write("													cambio.type = \"password\";\r\n");
      out.write("													$('.icon').removeClass('fa fa-eye').addClass('fa fa-eye-slash');\r\n");
      out.write("												}\r\n");
      out.write("											} \r\n");
      out.write("											\r\n");
      out.write("											$(document).ready(function () {\r\n");
      out.write("											//CheckBox mostrar contraseña\r\n");
      out.write("											$('#Showpassword').click(function () {\r\n");
      out.write("												$('#password').attr('type', $(this).is(':checked') ? 'text' : 'password');\r\n");
      out.write("											});\r\n");
      out.write("										});\r\n");
      out.write("										</script>										\r\n");
      out.write("						\r\n");
      out.write("					<div>\r\n");
      out.write("						<input type=\"submit\" name=\"accion\" value=\"Ingresar\" class=\"btn btn-primary btn-lm mt-4\">\r\n");
      out.write("						<a class=\"btn btn-primary btn-lm mt-4\" href=\"Home.jsp\" role=\"button\">Cancelar</a>\r\n");
      out.write("					</div>\r\n");
      out.write("				</form>\r\n");
      out.write("			</div>\r\n");
      out.write("	</div>\r\n");
      out.write("	<!-- Fin Login -->\r\n");
      out.write("	\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
