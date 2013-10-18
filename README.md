<h1>Just a simple email sender</h1>

<p>This project is to showcase Spring, Spring Data JPA, Spring Security, JSPs and JSTL. Based on
	Maven, Hibernate, HSQLDB, JavaMail, Twitter Bootstrap and JQuery</p>

<p>This project contains embedded HSQL database, which destroys all
	data at shutdown. If you want different database, add JDBC driver to
	pom.xml and change WEB-INF/spring/db.xml</p>

<p>
	To send emails you must set SMTP server configuration (in
	email.properties). At training we use <a
		href="http://www.mandrillapp.com">http://www.mandrillapp.com</a>,
	which offers free SMTP server, but you can provide your own. Also set
	preview = false (also in email.properties).
</p>

<p>If set preview = true in email.properties, preview database with
	test data will be created upon application deployment. Preview database
	will be re-initialized once per day.</p>

<p>
	How to run:
	<code>mvn jetty:run</code>
</p>

<p>
	How to build WAR file:
	<code>mvn package</code>
</p>

<p>
	You can deploy this web application to <a href="http://www.heroku.com"
		target="_blank">Heroku</a>. Live preview is here: <a
		href="http://example-mailer-spring.jiripinkas.cz" target="_blank">http://example-mailer-spring.jiripinkas.cz</a>
</p>

<h2>My other projects:</h2>

<ul>
	<li><a href="http://www.javavids.com" target="_blank"
		title="Java video tutorials">Java video tutorials</a> (free online
		tutorials)</li>
	<li><a href="http://www.dipgen.com" target="_blank"
		title="Diploma Generator">Diploma Generator</a> (free OSS software)</li>
	<li><a href="http://sitemonitoring.sourceforge.net/"
		target="_blank" title="Website monitoring software">Website
			monitoring software</a> (free OSS software)</li>
	<li><a href="http://www.java-skoleni.cz" target="_blank"
		title="Java školení">Java školení</a> (in Czech)</li>
	<li><a href="http://www.sql-skoleni.cz" target="_blank"
		title="SQL školení">SQL školení</a> (in Czech)</li>
</ul>
