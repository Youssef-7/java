package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MatiereDAO;
import dao.UserDAO;
import model.Matiere;
import model.User;

@WebServlet("/")
public class UserServlet extends HttpServlet {
    private UserDAO userDAO;
    private MatiereDAO matiereDAO;

    public void init() {
        userDAO = new UserDAO();
        matiereDAO = new MatiereDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String action = request.getServletPath();
        try {
            switch (action) {
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/insert":
                    insertUser(request, response);
                    break;
                case "/delete":
                    deleteUser(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updateUser(request, response);
                    break;
                case "/newMatiere":
                    showNewMatiereForm(request, response);
                    break;
                case "/insertMatiere":
                    insertMatiere(request, response);
                    break;
                case "/editMatiere":
                    showEditMatiereForm(request, response);
                    break;
                case "/updateMatiere":
                    updateMatiere(request, response);
                    break;
                case "/deleteMatiere":
                    deleteMatiere(request, response);
                    break;
                case "/login":
                    loginUser(request, response);
                    break;
                case "/register":
                    registerUser(request, response);
                    break;
                case "/logout":
                    logoutUser(request, response);
                    break;
                default:
                    listUserAndMatiere(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
    private void listUserAndMatiere(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, ServletException {
        List<User> listUser = userDAO.selectAllUsers();
        List<Matiere> listMatiere = matiereDAO.selectAllMatieres();
        request.setAttribute("listUser", listUser);
        request.setAttribute("listMatiere", listMatiere);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
        dispatcher.forward(request, response);
    }
    private void listUser(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, ServletException {
        List < User > listUser = userDAO.selectAllUsers();
        request.setAttribute("listUser", listUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        User existingUser = userDAO.selectUser(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
        request.setAttribute("user", existingUser);
        dispatcher.forward(request, response);

    }

    private void insertUser(HttpServletRequest request, HttpServletResponse response)
    	    throws SQLException, IOException {
    	    String pseudo = request.getParameter("pseudo");
    	    String motDePasse = request.getParameter("mot_de_passe");
    	    User newUser = new User();
    	    newUser.setName(pseudo);
    	    newUser.setMotDePasse(motDePasse);
    	    userDAO.insertUser(newUser);
    	    response.sendRedirect("list");
    	}
    private void updateUser(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String pseudo = request.getParameter("pseudo");

        User book = new User(id, pseudo);
        userDAO.updateUser(book);
        response.sendRedirect("list");
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        userDAO.deleteUser(id);
        response.sendRedirect("list");

    }
    private void showNewMatiereForm(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("matiere-form.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditMatiereForm(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Matiere existingMatiere = matiereDAO.selectMatiere(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("matiere-form.jsp");
        request.setAttribute("matiere", existingMatiere);
        dispatcher.forward(request, response);
    }

    private void insertMatiere(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
        String nom = request.getParameter("nom");
        Matiere newMatiere = new Matiere();
        newMatiere.setNom(nom);
        matiereDAO.insertMatiere(newMatiere);
        response.sendRedirect("list");
    }

    private void updateMatiere(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nom = request.getParameter("nom");

        Matiere matiere = new Matiere(id, nom);
        matiereDAO.updateMatiere(matiere);
        response.sendRedirect("list");
    }

    private void deleteMatiere(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        matiereDAO.deleteMatiere(id);
        response.sendRedirect("list");
    }
    private void loginUser(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, ServletException {
        String pseudo = request.getParameter("pseudo");
        String motDePasse = request.getParameter("motDePasse");
        User user = userDAO.selectUserByCredentials(pseudo, motDePasse);
        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            response.sendRedirect("list");
        } else {
            request.setAttribute("errorMessage", "Invalid username or password");
            RequestDispatcher dispatcher = request.getRequestDispatcher("login-register.jsp");
            dispatcher.forward(request, response);
        }
    }

    private void registerUser(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
        String pseudo = request.getParameter("pseudo");
        String motDePasse = request.getParameter("motDePasse");
        User newUser = new User();
        newUser.setName(pseudo);
        newUser.setMotDePasse(motDePasse);
        userDAO.insertUser(newUser);
        response.sendRedirect("login-register.jsp");
    }

    private void logoutUser(HttpServletRequest request, HttpServletResponse response)
    throws IOException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        response.sendRedirect("login-register.jsp");
    }
}