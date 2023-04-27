package ma.ensa;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ma.ensa.dao.TransactionDao;
import ma.ensa.dao.impl.TransactionDaoImpl;
import java.io.IOException;
import java.io.Writer;
import org.keycloak.adapters.*;
import org.keycloak.KeycloakPrincipal;
import org.keycloak.representations.AccessToken;

//@RolesAllowed("user")

@WebServlet("/ajout")
public class AddTransactionServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//		   KeycloakPrincipal<RefreshableKeycloakSecurityContext> principal = (KeycloakPrincipal<RefreshableKeycloakSecurityContext>) req.getUserPrincipal();
//	        
//	        // If the principal is null, the user is not authenticated, redirect to login
//	        if (principal == null) {
//	            resp.sendRedirect(req.getContextPath() + "/login.jsp");
//	            return;
//	        }
//
//	        // Get the access token from the security context
//	        AccessToken accessToken = principal.getKeycloakSecurityContext().getToken();
//
//	        // Check if the user has the required role
//	        if (!accessToken.getRealmAccess().isUserInRole("user")) {
//	            resp.sendError(HttpServletResponse.SC_FORBIDDEN);
//	            return;
//	        }
		
		TransactionDao dao=new TransactionDaoImpl();
		int r=dao.save(new Transaction(req.getParameter("ref"), req.getParameter("cptDeb"), req.getParameter("cptCred"), Double.parseDouble(req.getParameter("montant"))));
		
		Writer writer =resp.getWriter();
		if(r==0) {
			writer.write("<html>"
					+ "<body><h2> Error"
					+ "</h2></body></html>"
					+ ""
					+ "");
			
		}else {
			writer.write("<html>"
					+ "<body><h2> Transaction bien ajoutee"
					+ "</h2></body></html>"
					+ ""
					+ "");
		}
	}

}
