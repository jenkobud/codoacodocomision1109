package com.example.tomcatserverexample;

import DataBaseHandler.DataBase;

import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "showParcipantes", value = "/show-participantes")
public class ShowParticipantes extends HttpServlet {
    private String message;

    public void init() {
        message = "Acá tenemos a los participantes";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        DataBase db = new DataBase();

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        //out.println("<html><body>");
        //out.println("<h1>" + message + "</h1>");
        //out.println("</body></html>");
        out.println("<head>");
        out.println("  <meta charset=\"utf-8\">");
        out.println("  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");
        out.println("  <meta name=\"description\" content=\"\">");
        out.println("  <meta name=\"author\" content=\"Mark Otto, Jacob Thornton, and Bootstrap contributors\">");
        out.println("  <meta name=\"generator\" content=\"Hugo 0.88.1\">");
        out.println("  <title>Dashboard Template · Bootstrap v5.1</title>");

        out.println("  <!-- <link rel=\"canonical\" href=\"https://getbootstrap.com/docs/5.1/examples/dashboard/\"> -->");

        out.println("  <!-- Bootstrap core CSS -->");
        out.println("  <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC\" crossorigin=\"anonymous\">");

        out.println("  <!-- Fontawesome -->");
        out.println("  <link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.15.4/css/all.css\" integrity=\"sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm\" crossorigin=\"anonymous\">");
        out.println("  <!-- Favicons -->");
        out.println("  <!-- <link rel=\"apple-touch-icon\" href=\"/docs/5.1/assets/img/favicons/apple-touch-icon.png\" sizes=\"180x180\">");
        out.println("  <link rel=\"icon\" href=\"/docs/5.1/assets/img/favicons/favicon-32x32.png\" sizes=\"32x32\" type=\"image/png\">");
        out.println("  <link rel=\"icon\" href=\"/docs/5.1/assets/img/favicons/favicon-16x16.png\" sizes=\"16x16\" type=\"image/png\">");
        out.println("  <link rel=\"manifest\" href=\"/docs/5.1/assets/img/favicons/manifest.json\">");
        out.println("  <link rel=\"mask-icon\" href=\"/docs/5.1/assets/img/favicons/safari-pinned-tab.svg\" color=\"#7952b3\">");
        out.println("  <link rel=\"icon\" href=\"/docs/5.1/assets/img/favicons/favicon.ico\"> -->");
        out.println("  <meta name=\"theme-color\" content=\"#7952b3\">");


        out.println("  <style>");
        out.println("    .bd-placeholder-img {");
        out.println("      font-size: 1.125rem;");
        out.println("      text-anchor: middle;");
        out.println("      -webkit-user-select: none;");
        out.println("      -moz-user-select: none;");
        out.println("      user-select: none;");
        out.println("    }");

        out.println("    @media (min-width: 768px) {");
        out.println("      .bd-placeholder-img-lg {");
        out.println("        font-size: 3.5rem;");
        out.println("      }");
        out.println("    }");
        out.println("  </style>");


        out.println("  <!-- Custom styles for this template -->");
        out.println("  <link href=\"dashboard.css\" rel=\"stylesheet\">");
        out.println("  <style type=\"text/css\">");
        out.println("    /* Chart.js */");
        out.println("    @keyframes chartjs-render-animation {");
        out.println("      from {");
        out.println("        opacity: .99");
        out.println("      }");

        out.println("      to {");
        out.println("        opacity: 1");
        out.println("      }");
        out.println("    }");

        out.println("    .chartjs-render-monitor {");
        out.println("      animation: chartjs-render-animation 1ms");
        out.println("    }");

        out.println("    .chartjs-size-monitor,");
        out.println("    .chartjs-size-monitor-expand,");
        out.println("    .chartjs-size-monitor-shrink {");
        out.println("      position: absolute;");
        out.println("      direction: ltr;");
        out.println("      left: 0;");
        out.println("      top: 0;");
        out.println("      right: 0;");
        out.println("      bottom: 0;");
        out.println("      overflow: hidden;");
        out.println("      pointer-events: none;");
        out.println("      visibility: hidden;");
        out.println("      z-index: -1");
        out.println("    }");

        out.println("    .chartjs-size-monitor-expand>div {");
        out.println("      position: absolute;");
        out.println("      width: 1000000px;");
        out.println("      height: 1000000px;");
        out.println("      left: 0;");
        out.println("      top: 0");
        out.println("    }");

        out.println("    .chartjs-size-monitor-shrink>div {");
        out.println("      position: absolute;");
        out.println("      width: 200%;");
        out.println("      height: 200%;");
        out.println("      left: 0;");
        out.println("      top: 0");
        out.println("    }");
        out.println("  </style>");
        out.println("</head>");

        out.println("<body cz-shortcut-listen=\"true\">");

        out.println("  <header class=\"navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0 shadow\">");
        out.println("    <a class=\"navbar-brand col-md-3 col-lg-2 me-0 px-3\" href=\"#\">Company name</a>");
        out.println("    <button class=\"navbar-toggler position-absolute d-md-none collapsed\" type=\"button\" data-bs-toggle=\"collapse\"");
        out.println("      data-bs-target=\"#sidebarMenu\" aria-controls=\"sidebarMenu\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">");
        out.println("      <span class=\"navbar-toggler-icon\"></span>");
        out.println("    </button>");
        out.println("    <input class=\"form-control form-control-dark w-100\" type=\"text\" placeholder=\"Search\" aria-label=\"Search\">");
        out.println("    <div class=\"navbar-nav\">");
        out.println("      <div class=\"nav-item text-nowrap\">");
        out.println("        <a class=\"nav-link px-3\" href=\"#\">Sign out</a>");
        out.println("      </div>");
        out.println("    </div>");
        out.println("  </header>");

        out.println("  <div class=\"container-fluid\">");
        out.println("    <div class=\"row\">");
        out.println("      <nav id=\"sidebarMenu\" class=\"col-md-3 col-lg-2 d-md-block bg-light sidebar collapse\">");
        out.println("        <div class=\"position-sticky pt-3\">");
        out.println("          <ul class=\"nav flex-column\">");
        out.println("            <li class=\"nav-item\">");
        out.println("              <a class=\"nav-link active\" aria-current=\"page\" href=\"#\">");
        out.println("                <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"24\" height=\"24\" viewBox=\"0 0 24 24\" fill=\"none\"");
        out.println("                  stroke=\"currentColor\" stroke-width=\"2\" stroke-linecap=\"round\" stroke-linejoin=\"round\"");
        out.println("                  class=\"feather feather-home\" aria-hidden=\"true\">");
        out.println("                  <path d=\"M3 9l9-7 9 7v11a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2z\"></path>");
        out.println("                  <polyline points=\"9 22 9 12 15 12 15 22\"></polyline>");
        out.println("                </svg>");
        out.println("                Dashboard");
        out.println("              </a>");
        out.println("            </li>");
        out.println("            <li class=\"nav-item\">");
        out.println("              <a class=\"nav-link\" href=\"#\">");
        out.println("                <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"24\" height=\"24\" viewBox=\"0 0 24 24\" fill=\"none\"");
        out.println("                  stroke=\"currentColor\" stroke-width=\"2\" stroke-linecap=\"round\" stroke-linejoin=\"round\"");
        out.println("                  class=\"feather feather-file\" aria-hidden=\"true\">");
        out.println("                  <path d=\"M13 2H6a2 2 0 0 0-2 2v16a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V9z\"></path>");
        out.println("                  <polyline points=\"13 2 13 9 20 9\"></polyline>");
        out.println("                </svg>");
        out.println("                Orders");
        out.println("              </a>");
        out.println("            </li>");
        out.println("            <li class=\"nav-item\">");
        out.println("              <a class=\"nav-link\" href=\"#\">");
        out.println("                <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"24\" height=\"24\" viewBox=\"0 0 24 24\" fill=\"none\"");
        out.println("                  stroke=\"currentColor\" stroke-width=\"2\" stroke-linecap=\"round\" stroke-linejoin=\"round\"");
        out.println("                  class=\"feather feather-shopping-cart\" aria-hidden=\"true\">");
        out.println("                  <circle cx=\"9\" cy=\"21\" r=\"1\"></circle>");
        out.println("                  <circle cx=\"20\" cy=\"21\" r=\"1\"></circle>");
        out.println("                  <path d=\"M1 1h4l2.68 13.39a2 2 0 0 0 2 1.61h9.72a2 2 0 0 0 2-1.61L23 6H6\"></path>");
        out.println("                </svg>");
        out.println("                Products");
        out.println("              </a>");
        out.println("            </li>");
        out.println("            <li class=\"nav-item\">");
        out.println("              <a class=\"nav-link\" href=\"#\">");
        out.println("                <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"24\" height=\"24\" viewBox=\"0 0 24 24\" fill=\"none\"");
        out.println("                  stroke=\"currentColor\" stroke-width=\"2\" stroke-linecap=\"round\" stroke-linejoin=\"round\"");
        out.println("                  class=\"feather feather-users\" aria-hidden=\"true\">");
        out.println("                  <path d=\"M17 21v-2a4 4 0 0 0-4-4H5a4 4 0 0 0-4 4v2\"></path>");
        out.println("                  <circle cx=\"9\" cy=\"7\" r=\"4\"></circle>");
        out.println("                  <path d=\"M23 21v-2a4 4 0 0 0-3-3.87\"></path>");
        out.println("                  <path d=\"M16 3.13a4 4 0 0 1 0 7.75\"></path>");
        out.println("                </svg>");
        out.println("                Customers");
        out.println("              </a>");
        out.println("            </li>");
        out.println("            <li class=\"nav-item\">");
        out.println("              <a class=\"nav-link\" href=\"#\">");
        out.println("                <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"24\" height=\"24\" viewBox=\"0 0 24 24\" fill=\"none\"");
        out.println("                  stroke=\"currentColor\" stroke-width=\"2\" stroke-linecap=\"round\" stroke-linejoin=\"round\"");
        out.println("                  class=\"feather feather-bar-chart-2\" aria-hidden=\"true\">");
        out.println("                  <line x1=\"18\" y1=\"20\" x2=\"18\" y2=\"10\"></line>");
        out.println("                  <line x1=\"12\" y1=\"20\" x2=\"12\" y2=\"4\"></line>");
        out.println("                  <line x1=\"6\" y1=\"20\" x2=\"6\" y2=\"14\"></line>");
        out.println("                </svg>");
        out.println("                Reports");
        out.println("              </a>");
        out.println("            </li>");
        out.println("            <li class=\"nav-item\">");
        out.println("              <a class=\"nav-link\" href=\"#\">");
        out.println("                <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"24\" height=\"24\" viewBox=\"0 0 24 24\" fill=\"none\"");
        out.println("                  stroke=\"currentColor\" stroke-width=\"2\" stroke-linecap=\"round\" stroke-linejoin=\"round\"");
        out.println("                  class=\"feather feather-layers\" aria-hidden=\"true\">");
        out.println("                  <polygon points=\"12 2 2 7 12 12 22 7 12 2\"></polygon>");
        out.println("                  <polyline points=\"2 17 12 22 22 17\"></polyline>");
        out.println("                  <polyline points=\"2 12 12 17 22 12\"></polyline>");
        out.println("                </svg>");
        out.println("                Integrations");
        out.println("              </a>");
        out.println("            </li>");
        out.println("          </ul>");

        out.println("          <h6 class=\"sidebar-heading d-flex justify-content-between align-items-center px-3 mt-4 mb-1 text-muted\">");
        out.println("            <span>Saved reports</span>");
        out.println("            <a class=\"link-secondary\" href=\"#\" aria-label=\"Add a new report\">");
        out.println("              <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"24\" height=\"24\" viewBox=\"0 0 24 24\" fill=\"none\"");
        out.println("                stroke=\"currentColor\" stroke-width=\"2\" stroke-linecap=\"round\" stroke-linejoin=\"round\"");
        out.println("                class=\"feather feather-plus-circle\" aria-hidden=\"true\">");
        out.println("                <circle cx=\"12\" cy=\"12\" r=\"10\"></circle>");
        out.println("                <line x1=\"12\" y1=\"8\" x2=\"12\" y2=\"16\"></line>");
        out.println("                <line x1=\"8\" y1=\"12\" x2=\"16\" y2=\"12\"></line>");
        out.println("              </svg>");
        out.println("            </a>");
        out.println("          </h6>");
        out.println("          <ul class=\"nav flex-column mb-2\">");
        out.println("            <li class=\"nav-item\">");
        out.println("              <a class=\"nav-link\" href=\"#\">");
        out.println("                <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"24\" height=\"24\" viewBox=\"0 0 24 24\" fill=\"none\"");
        out.println("                  stroke=\"currentColor\" stroke-width=\"2\" stroke-linecap=\"round\" stroke-linejoin=\"round\"");
        out.println("                  class=\"feather feather-file-text\" aria-hidden=\"true\">");
        out.println("                  <path d=\"M14 2H6a2 2 0 0 0-2 2v16a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V8z\"></path>");
        out.println("                  <polyline points=\"14 2 14 8 20 8\"></polyline>");
        out.println("                  <line x1=\"16\" y1=\"13\" x2=\"8\" y2=\"13\"></line>");
        out.println("                  <line x1=\"16\" y1=\"17\" x2=\"8\" y2=\"17\"></line>");
        out.println("                  <polyline points=\"10 9 9 9 8 9\"></polyline>");
        out.println("                </svg>");
        out.println("                Current month");
        out.println("              </a>");
        out.println("            </li>");
        out.println("            <li class=\"nav-item\">");
        out.println("              <a class=\"nav-link\" href=\"#\">");
        out.println("                <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"24\" height=\"24\" viewBox=\"0 0 24 24\" fill=\"none\"");
        out.println("                  stroke=\"currentColor\" stroke-width=\"2\" stroke-linecap=\"round\" stroke-linejoin=\"round\"");
        out.println("                  class=\"feather feather-file-text\" aria-hidden=\"true\">");
        out.println("                  <path d=\"M14 2H6a2 2 0 0 0-2 2v16a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V8z\"></path>");
        out.println("                  <polyline points=\"14 2 14 8 20 8\"></polyline>");
        out.println("                  <line x1=\"16\" y1=\"13\" x2=\"8\" y2=\"13\"></line>");
        out.println("                  <line x1=\"16\" y1=\"17\" x2=\"8\" y2=\"17\"></line>");
        out.println("                  <polyline points=\"10 9 9 9 8 9\"></polyline>");
        out.println("                </svg>");
        out.println("                Last quarter");
        out.println("              </a>");
        out.println("            </li>");
        out.println("            <li class=\"nav-item\">");
        out.println("              <a class=\"nav-link\" href=\"#\">");
        out.println("                <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"24\" height=\"24\" viewBox=\"0 0 24 24\" fill=\"none\"");
        out.println("                  stroke=\"currentColor\" stroke-width=\"2\" stroke-linecap=\"round\" stroke-linejoin=\"round\"");
        out.println("                  class=\"feather feather-file-text\" aria-hidden=\"true\">");
        out.println("                  <path d=\"M14 2H6a2 2 0 0 0-2 2v16a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V8z\"></path>");
        out.println("                  <polyline points=\"14 2 14 8 20 8\"></polyline>");
        out.println("                  <line x1=\"16\" y1=\"13\" x2=\"8\" y2=\"13\"></line>");
        out.println("                  <line x1=\"16\" y1=\"17\" x2=\"8\" y2=\"17\"></line>");
        out.println("                  <polyline points=\"10 9 9 9 8 9\"></polyline>");
        out.println("                </svg>");
        out.println("                Social engagement");
        out.println("              </a>");
        out.println("            </li>");
        out.println("            <li class=\"nav-item\">");
        out.println("              <a class=\"nav-link\" href=\"#\">");
        out.println("                <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"24\" height=\"24\" viewBox=\"0 0 24 24\" fill=\"none\"");
        out.println("                  stroke=\"currentColor\" stroke-width=\"2\" stroke-linecap=\"round\" stroke-linejoin=\"round\"");
        out.println("                  class=\"feather feather-file-text\" aria-hidden=\"true\">");
        out.println("                  <path d=\"M14 2H6a2 2 0 0 0-2 2v16a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V8z\"></path>");
        out.println("                  <polyline points=\"14 2 14 8 20 8\"></polyline>");
        out.println("                  <line x1=\"16\" y1=\"13\" x2=\"8\" y2=\"13\"></line>");
        out.println("                  <line x1=\"16\" y1=\"17\" x2=\"8\" y2=\"17\"></line>");
        out.println("                  <polyline points=\"10 9 9 9 8 9\"></polyline>");
        out.println("                </svg>");
        out.println("                Year-end sale");
        out.println("              </a>");
        out.println("            </li>");
        out.println("          </ul>");
        out.println("        </div>");
        out.println("      </nav>");

        out.println("      <main class=\"col-md-9 ms-sm-auto col-lg-10 px-md-4\">");

        out.println("        <h2>Clientes</h2>");
        out.println("        <div class=\"table-responsive\">");
        out.println("          <table class=\"table table-striped table-sm\">");
        out.println("            <thead>");
        out.println("              <tr>");
        out.println("                <th scope=\"col\">#</th>");
        out.println("                <th scope=\"col\">Apellido</th>");
        out.println("                <th scope=\"col\">Nombre</th>");
        out.println("                <th scope=\"col\">e-mail</th>");
        out.println("                <th scope=\"col\">telefono</th>");
        out.println("                <th scope=\"col\">ABM</th>");
        out.println("              </tr>");
        out.println("            </thead>");
        out.println("            <tbody id=\"tBodyContent\">");
        out.println("            <!-- Insert values from here -->");
        try {
            ResultSet participantesRs = db.doDQLCommand("SELECT * FROM participantes ORDER BY `id`");
            while(participantesRs.next()){
                int id = participantesRs.getInt("id");
                String nombre = participantesRs.getString("nombre");
                String apellido = participantesRs.getString("apellido");
                String email = participantesRs.getString("email");
                int telefono = participantesRs.getInt("telefono");
                out.println("              <tr>");
                out.println("                <td>"+id+"</td>");
                out.println("                <td>"+apellido+"</td>");
                out.println("                <td>"+nombre+"</td>");
                out.println("                <td>"+email+"</td>");
                out.println("                <td>"+telefono+"</td>");
                out.println("              </tr>");
            }
        } catch (SQLException e) {
            //e.printStackTrace();
            out.println("<span>Error en la comunicación con la base de datos.</span>");
        }
        out.println("            <!-- Insert values upto here -->");
        out.println("            </tbody>");
        out.println("          </table>");
        out.println("        </div>");
        out.println("      </main>");
        out.println("    </div>");
        out.println("  </div>");

        out.println("  <script src=\"https://cdn.jsdelivr.net/npm/feather-icons@4.28.0/dist/feather.min.js\"");
        out.println("    integrity=\"sha384-uO3SXW5IuS1ZpFPKugNNWqTZRRglnUJK6UAZ/gxOX80nxEkN9NcGZTftn6RzhGWE\"");
        out.println("    crossorigin=\"anonymous\"></script>");
        out.println("  <script src=\"https://cdn.jsdelivr.net/npm/chart.js@2.9.4/dist/Chart.min.js\"");
        out.println("    integrity=\"sha384-zNy6FEbO50N+Cg5wap8IKA4M/ZnLJgzc6w2NqACZaK0u0FXfOWRRJOnQtpZun8ha\"");
        out.println("    crossorigin=\"anonymous\"></script>");
        out.println("  <script src=\"dashboard.js\"></script>");


        out.println("</body>");
        out.println("</html>");
    }

    public void destroy() {
    }
}