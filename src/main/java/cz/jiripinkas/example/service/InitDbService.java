package cz.jiripinkas.example.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cz.jiripinkas.example.entity.Email;
import cz.jiripinkas.example.entity.EmailBatch;
import cz.jiripinkas.example.entity.Role;
import cz.jiripinkas.example.entity.Role.ROLE_TYPE;
import cz.jiripinkas.example.entity.User;

@Service
@Transactional
public class InitDbService {

	@Autowired
	private EmailBatchService emailBatchService;

	@Autowired
	private RoleService roleService;

	@Autowired
	private UserService userService;

	@PostConstruct
	public void init() {
		System.out.println("*** start create test database ***");
		{
			EmailBatch emailBatch = new EmailBatch();
			emailBatch.setFrom("from@email.com");
			emailBatch.setSubject("hello");
			emailBatch.setBody("yo, wassup?");
			List<Email> emails = new ArrayList<Email>();
			emails.add(new Email("to1@email.com"));
			emailBatch = emailBatchService.save(emailBatch, emails);
			emailBatch = emailBatchService.findOne(emailBatch.getEmailBatchId());
		}
		{
			EmailBatch emailBatch = new EmailBatch();
			emailBatch.setFrom("from@email.com");
			emailBatch.setSubject("hello again");
			emailBatch.setBody("yo, wassup?");
			List<Email> emails = new ArrayList<Email>();
			emails.add(new Email("to2@email.com"));
			emailBatch = emailBatchService.save(emailBatch, emails);
			emailBatch = emailBatchService.findOne(emailBatch.getEmailBatchId());
		}
		{
			EmailBatch emailBatch = new EmailBatch();
			emailBatch.setFrom("from@email.com");
			emailBatch.setSubject("hello yet again");
			emailBatch.setBody("yo, wassup?");
			List<Email> emails = new ArrayList<Email>();
			emails.add(new Email("to2@email.com"));
			emailBatch = emailBatchService.save(emailBatch, emails);
			emailBatch = emailBatchService.findOne(emailBatch.getEmailBatchId());
		}
		Role roleAdmin = new Role();
		roleAdmin.setName(ROLE_TYPE.ROLE_ADMIN);
		roleAdmin = roleService.save(roleAdmin);

		Role roleUser = new Role();
		roleUser.setName(ROLE_TYPE.ROLE_USER);
		roleUser = roleService.save(roleUser);

		Role rolePremium = new Role();
		rolePremium.setName(ROLE_TYPE.ROLE_PREMIUM);
		rolePremium = roleService.save(rolePremium);

		User userAdmin = new User();
		userAdmin.setName("admin");
		userAdmin.setPassword("admin");
		userAdmin.setEmail("admin@email.com");
		userAdmin = userService.create(userAdmin);
		userService.assignRole(userAdmin.getUserId(), roleAdmin.getRoleId());
		userService.assignRole(userAdmin.getUserId(), roleUser.getRoleId());
		userService.assignRole(userAdmin.getUserId(), rolePremium.getRoleId());

		System.out.println("*** finish create test database ***");

	}
}
