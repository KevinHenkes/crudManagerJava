package fr.imie.supcommerce.servlet;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import fr.imie.supcommerce.entity.Category;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/auth/addCategory")
public class AddCategoryServlet extends HttpServlet {

	@Override
	public void init() throws ServletException {
		EntityManagerFactory emf = null;
		emf = Persistence.createEntityManagerFactory("My-PU");
		EntityManager em = emf.createEntityManager();
		Category category = em.find(Category.class, 1);
		em.close();
		emf.close();
	}
}
