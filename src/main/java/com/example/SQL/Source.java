package com.example.SQL;

import java.util.List;

import org.apache.commons.lang.StringUtils;

public class Source {
	
	/**
	 * Get Users from DB with given username
	 * @param req HTTPRequest contain the needed attribute sql_usernames
	 */
	public void getUsers(final javax.servlet.http.HttpServletRequest req) {
		if (StringUtils.isBlank(req.getParameter("sql_usernames")) || req.getParameter("sql_usernames").startsWith("Test")){
			final List<String> usernames = SQLInjection.getUserNames(req.getParameter("sql_usernames"));
			for (final String username : usernames) {
				System.out.println("We got username from request: " + username);
			}
		}
	}

}
