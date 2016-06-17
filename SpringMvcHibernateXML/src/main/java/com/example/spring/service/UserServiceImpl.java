package com.example.spring.service;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.spring.model.User;

@Service("userService")
@Transactional
@Configuration
@PropertySource("classpath:ldap.properties")
public class UserServiceImpl implements UserService{

	@Autowired
	private Environment environment;
	
	private static Hashtable env=null;

	public User isValidUser(String userName) {
		
		String ldapURL=environment.getProperty("ldap.url");
		String userEmail=environment.getProperty("ldap.name");
		String password=environment.getProperty("ldap.password");
		
		if(env==null){
			env=new Hashtable();
			env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
			env.put(Context.PROVIDER_URL,ldapURL);
			env.put(Context.SECURITY_AUTHENTICATION, "simple");
			env.put(Context.SECURITY_PRINCIPAL, userEmail);
			env.put(Context.SECURITY_CREDENTIALS, password);
		}		
		
		User user = new User();

		

		DirContext ctx = null;
		NamingEnumeration results = null;
		Attributes attributes = null;
		try {
			ctx = new InitialDirContext(env);
			SearchControls controls = new SearchControls();
			controls.setSearchScope(SearchControls.SUBTREE_SCOPE);
			results = ctx.search("", "mail=" + userName + "", controls);
			while (results.hasMore()) {
				SearchResult searchResult = (SearchResult) results.next();
				attributes = searchResult.getAttributes();
				Attribute attr = attributes.get("cn");
				String cn = (String) attr.get();

				String[] managerName = (String[]) attributes.get("manager")
						.get().toString().split(",");
				String[] name = managerName[0].split("=");

				user.setName(attributes.get("displayName").get().toString());
				user.setManager(name[1]);
				user.setEmail(attributes.get("mail").get().toString());
				user.setProjectName(attributes.get("department").get()
						.toString());
				try {
					String[] directReports = (String[]) attributes
							.get("directreports").get().toString().split(",");
					String[] subOrdinateList = directReports[0].split("=");
					user.setSubOrdinateList(subOrdinateList);
				} catch (Exception e) {
				}
				results = ctx.search("", "name=" + name[1] + "", controls);
				while (results.hasMore()) {
					SearchResult searchResult1 = (SearchResult) results.next();
					attributes = searchResult1.getAttributes();
					Attribute attr1 = attributes.get("cn");
					String cn1 = (String) attr1.get();
					user.setManagerEmail(attributes.get("mail").get()
							.toString());
				}
			}
		} catch (Throwable e) {
			e.printStackTrace();
		} finally {
			if (results != null) {
				try {
					results.close();
				} catch (Exception e) {
				}
			}
			if (ctx != null) {
				try {
					ctx.close();
				} catch (Exception e) {
				}
			}
		}

		return user;
	}
}
