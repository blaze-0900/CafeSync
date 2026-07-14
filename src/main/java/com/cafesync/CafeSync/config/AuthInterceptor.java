package com.cafesync.CafeSync.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.cafesync.CafeSync.entity.Role;
import com.cafesync.CafeSync.entity.User;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Component
public class AuthInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request,
	                         HttpServletResponse response,
	                         Object handler) throws Exception {

	    HttpSession session = request.getSession(false);

	    if (session == null) {
	        response.sendRedirect("/login");
	        return false;
	    }

	    User user = (User) session.getAttribute("loggedInUser");

	    if (user == null) {
	        response.sendRedirect("/login");
	        return false;
	    }

	    String uri = request.getRequestURI();
	    Role role = user.getRole();

	    // Dashboard Protection
	    if(uri.startsWith("/owner") && role != Role.OWNER){
	        response.sendRedirect("/login");
	        return false;
	    }

	    if(uri.startsWith("/manager") && role != Role.MANAGER){
	        response.sendRedirect("/login");
	        return false;
	    }

	    if(uri.startsWith("/admin") && role != Role.ADMIN){
	        response.sendRedirect("/login");
	        return false;
	    }

	    if(uri.startsWith("/employee") && role != Role.EMPLOYEE){
	        response.sendRedirect("/login");
	        return false;
	    }

	    // Franchises (Owner + Admin)
	    if(uri.startsWith("/franchises")){
	        if(role != Role.OWNER && role != Role.ADMIN){
	            response.sendRedirect("/login");
	            return false;
	        }
	    }

	    // Employees (Owner + Manager + Admin)
	    if(uri.startsWith("/employees")){
	        if(role != Role.OWNER &&
	           role != Role.MANAGER &&
	           role != Role.ADMIN){
	            response.sendRedirect("/login");
	            return false;
	        }
	    }

	    // Expenses (Owner + Manager)
	    if(uri.startsWith("/expenses")){
	        if(role != Role.OWNER &&
	           role != Role.MANAGER){
	            response.sendRedirect("/login");
	            return false;
	        }
	    }

	    // POS (Manager + Employee)
	    if(uri.startsWith("/pos")){
	        if(role != Role.MANAGER &&
	           role != Role.EMPLOYEE){
	            response.sendRedirect("/login");
	            return false;
	        }
	    }

	    return true;
	}}